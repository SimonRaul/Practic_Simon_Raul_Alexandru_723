package org.example.service;

import org.example.model.Fahrer;
import org.example.model.FahrerStatus;
import org.example.repo.FahrerRepo;

import java.util.List;

public class FahrerService {
    private FahrerRepo fahrerRepo;

    public FahrerService(FahrerRepo fahrerRepo) {
        this.fahrerRepo = fahrerRepo;
    }

    public List<Fahrer> getFahrers() {
        return fahrerRepo.getFahrers();
    }

    public List<Fahrer> filterByTeamAndStatus(String team) {
        FahrerStatus statusForFilter = FahrerStatus.ACTIVE;
        return fahrerRepo.getFahrers().stream()
                .filter(f -> f.getTeam().equals(team) && f.getStatus() == statusForFilter).toList();
    }
}
