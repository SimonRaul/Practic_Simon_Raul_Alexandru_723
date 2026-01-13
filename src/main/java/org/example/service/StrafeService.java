package org.example.service;

import org.example.model.Strafe;
import org.example.repo.StrafeRepo;

import java.util.List;

public class StrafeService {
    private StrafeRepo strafeRepo;

    public StrafeService(StrafeRepo strafeRepo) {
        this.strafeRepo = strafeRepo;
    }

    public List<Strafe> getStrafes() {
        return strafeRepo.getPenalties();
    }
}
