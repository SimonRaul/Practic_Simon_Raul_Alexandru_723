package org.example.service;

import org.example.model.RennenEreignis;
import org.example.repo.RennenEreignisRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
