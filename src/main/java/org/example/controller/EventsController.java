package org.example.controller;

import org.example.service.RennenEreignisService;

public class EventsController {
    private RennenEreignisService rennenEreignisService;

    public EventsController(RennenEreignisService rennenEreignisService) {
        this.rennenEreignisService = rennenEreignisService;
    }

    public void printNrOfEvents(){
        System.out.println("Events loaded: " + rennenEreignisService.getRennenEreignis().size());
    }
}
