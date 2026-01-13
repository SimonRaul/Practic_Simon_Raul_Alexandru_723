package org.example.controller;

import org.example.model.Fahrer;
import org.example.service.FahrerService;

import java.util.List;
import java.util.Scanner;

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

    public void printFilteredDrivers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the team: ");
        String team = sc.nextLine();
        List<Fahrer> filteredDrivers = fahrerService.filterByTeamAndStatus(team);

        for (Fahrer fahrer : filteredDrivers) {
            System.out.println(fahrer);
        }
        System.out.println("--------------------------------");

    }

    public void printSortedDrivers(){
        System.out.println("Here are the sorted drivers: ");
        for(Fahrer f : fahrerService.sortFahrers()) {
            System.out.println(f);
        }
        System.out.println("--------------------------------");

    }
}
