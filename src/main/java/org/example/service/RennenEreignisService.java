package org.example.service;

import org.example.model.EreignisTyp;
import org.example.model.RennenEreignis;
import org.example.repo.RennenEreignisRepo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RennenEreignisService {
    private RennenEreignisRepo rennenEreignisRepo;

    public RennenEreignisService(RennenEreignisRepo rennenEreignisRepo) {
        this.rennenEreignisRepo = rennenEreignisRepo;
    }

    public List<RennenEreignis> getRennenEreignis() {
        return rennenEreignisRepo.getEvents();
    }

    public Map<Integer, Integer> getTop5ComputedPoints(){
        Map<Integer, Integer> map = new HashMap<>();
        rennenEreignisRepo.getEvents().stream()
                .limit(5)
                .forEach(e -> {
                    int calculatedPoints = e.getComputedPoints();
                    map.put(e.getBasePoints(), calculatedPoints);
                });

        return map;
    }

    public void saveRennenEreignis() {
        Map<EreignisTyp, Long> map = rennenEreignisRepo.getEvents().stream()
                .collect(Collectors.groupingBy(RennenEreignis::getTyp,  Collectors.counting()));

        List<String> lines = map.entrySet().stream()
                .map(entry -> entry.getKey() + " -> " + entry.getValue())
                .collect(Collectors.toList());

        try{
            Files.write(Paths.get("race_report.txt"), lines);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
