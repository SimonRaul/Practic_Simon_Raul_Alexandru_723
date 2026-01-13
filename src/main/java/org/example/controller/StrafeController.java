package org.example.controller;

import org.example.service.StrafeService;

public class StrafeController {
    private StrafeService strafeService;

    public StrafeController(StrafeService strafeService){
        this.strafeService = strafeService;
    }

    public void printNrOfPenalties(){
        System.out.println("Penalties loaded: " + strafeService.getStrafes().size());
    }
}
