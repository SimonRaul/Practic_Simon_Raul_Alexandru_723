package org.example;

import org.example.controller.EventsController;
import org.example.controller.FahrerController;
import org.example.controller.StrafeController;
import org.example.repo.FahrerRepo;
import org.example.repo.RennenEreignisRepo;
import org.example.repo.StrafeRepo;
import org.example.service.FahrerService;
import org.example.service.RennenEreignisService;
import org.example.service.StrafeService;

public class Main  {
    public static void main(String[] args) {
        FahrerRepo fahrerRepo = new FahrerRepo("C:\\Users\\Simon Raul\\IdeaProjects\\Seminar MAP\\practic map\\Practic_Simon_Raul_Alexandru_723\\src\\main\\resources\\drivers.json");
        RennenEreignisRepo ereignisRepo = new RennenEreignisRepo("C:\\Users\\Simon Raul\\IdeaProjects\\Seminar MAP\\practic map\\Practic_Simon_Raul_Alexandru_723\\src\\main\\resources\\events.json");
        StrafeRepo strafeRepo = new StrafeRepo("C:\\Users\\Simon Raul\\IdeaProjects\\Seminar MAP\\practic map\\Practic_Simon_Raul_Alexandru_723\\src\\main\\resources\\penalties.json");
        FahrerService fahrerService = new FahrerService(fahrerRepo);
        RennenEreignisService ereignisService = new RennenEreignisService(ereignisRepo);
        StrafeService strafeService = new StrafeService(strafeRepo);
        FahrerController fahrerController = new FahrerController(fahrerService);
        StrafeController strafeController = new StrafeController(strafeService);
        EventsController eventsController = new EventsController(ereignisService);

        fahrerController.printNrOfDrivers();
        eventsController.printNrOfEvents();
        strafeController.printNrOfPenalties();
        fahrerController.printAllDrivers();

    }
}