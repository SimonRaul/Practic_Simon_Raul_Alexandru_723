package org.example.controller;

import org.example.model.Fahrer;
import org.example.service.FahrerService;

public class FahrerController {
    private FahrerService fahrerService;

    public FahrerController(FahrerService fahrerService) {
        this.fahrerService = fahrerService;
    }

    public void printNrOfDrivers(){
        System.out.println("Drivers loaded: " + fahrerService.getFahrers().size());
    }

    public void printAllDrivers(){
        for (Fahrer fahrer : fahrerService.getFahrers()) {
            System.out.println(fahrer);
        }
        System.out.println("--------------------------------");
    }
}
