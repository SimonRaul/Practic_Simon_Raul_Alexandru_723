package org.example.service;

import org.example.model.Fahrer;
import org.example.model.FahrerStatus;
import org.example.model.RennenEreignis;
import org.example.model.Strafe;
import org.example.repo.FahrerRepo;
import org.example.repo.RennenEreignisRepo;
import org.example.repo.StrafeRepo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FahrerService {
    private FahrerRepo fahrerRepo;
    private RennenEreignisRepo rennenEreignisRepo;
    private StrafeRepo strafeRepo;

    public FahrerService(FahrerRepo fahrerRepo,  RennenEreignisRepo rennenEreignisRepo,  StrafeRepo strafeRepo) {
        this.fahrerRepo = fahrerRepo;
        this.rennenEreignisRepo = rennenEreignisRepo;
        this.strafeRepo = strafeRepo;
    }

    public List<Fahrer> getFahrers() {
        return fahrerRepo.getFahrers();
    }

    public List<Fahrer> filterByTeamAndStatus(String team) {
        FahrerStatus statusForFilter = FahrerStatus.ACTIVE;
        return fahrerRepo.getFahrers().stream()
                .filter(f -> f.getTeam().equals(team) && f.getStatus() == statusForFilter).toList();
    }

    public List<Fahrer> sortFahrers() {
        return fahrerRepo.getFahrers().stream()
                .sorted(Comparator.comparing(Fahrer::getSkillLevel).reversed()
                        .thenComparing(Fahrer::getName)).toList();
    }

    public void saveSortedFahrers(){
        List<String> lines = sortFahrers().stream()
                .map(t -> t.toString())
                .toList();

        try{
            Files.write(Paths.get("drivers_sorted.txt"), lines);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public int calculateTotalScore(int fahrerId){
        List<Strafe> penalties = strafeRepo.getPenalties().stream()
                .filter(s -> s.getFahrerId() == fahrerId)
                .toList();

        List<RennenEreignis> events = rennenEreignisRepo.getEvents().stream()
                .filter(e -> e.getFahrerId() == fahrerId).toList();
        int computedPointsSum = 0;
        for (RennenEreignis e : events) {
            computedPointsSum += e.getComputedPoints();
        }

        int penaltiesSum = 0;
        for (Strafe s : penalties) {
            penaltiesSum += s.getSeconds();
        }
        return computedPointsSum - penaltiesSum;
    }

    //merge dar nu sorteaza si dupa nume
    public List<Fahrer> getTop5Scores(){
        return fahrerRepo.getFahrers().stream()
                .sorted(Comparator.comparing(f -> calculateTotalScore(f.getId())))
                .limit(5)
                .toList().reversed();
    }
}
