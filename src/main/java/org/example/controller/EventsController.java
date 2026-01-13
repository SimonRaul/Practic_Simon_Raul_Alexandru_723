package org.example.controller;

import org.example.service.RennenEreignisService;

import java.util.Map;

public class EventsController {
    private RennenEreignisService rennenEreignisService;

    public EventsController(RennenEreignisService rennenEreignisService) {
        this.rennenEreignisService = rennenEreignisService;
    }

    public void printNrOfEvents(){
        System.out.println("Events loaded: " + rennenEreignisService.getRennenEreignis().size());
    }

    public void printTop5Points(){
        System.out.println("Here are the first 5 events computed points: ");
        Map<Integer,Integer> map =rennenEreignisService.getTop5ComputedPoints();

        int eventNr = 1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("Event " + eventNr + " -> raw=" + entry.getKey()
            + ", computed=" + entry.getValue());
            eventNr++;
        }
        System.out.println("--------------------------------");

    }

    public void saveNrOfEvents(){
        rennenEreignisService.saveRennenEreignis();
        System.out.println("Events types saved.");
        System.out.println("--------------------------------");

    }
}
