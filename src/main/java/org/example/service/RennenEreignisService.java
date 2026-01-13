package org.example.service;

import org.example.model.RennenEreignis;
import org.example.repo.RennenEreignisRepo;

import java.util.List;

public class RennenEreignisService {
    private RennenEreignisRepo rennenEreignisRepo;

    public RennenEreignisService(RennenEreignisRepo rennenEreignisRepo) {
        this.rennenEreignisRepo = rennenEreignisRepo;
    }

    public List<RennenEreignis> getRennenEreignis() {
        return rennenEreignisRepo.getEvents();
    }
}
