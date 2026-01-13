package org.example.service;

import org.example.model.Fahrer;
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
}
