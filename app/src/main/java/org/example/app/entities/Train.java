package org.example.app.entities;

import java.util.List;
import java.util.UUID;

import org.example.app.services.UserService;
import org.example.app.utility.Station;


public class Train {
    private UUID id;
    private Station from;
    private Station to;
    private UserService user;
    private List<Station> path;
    
}
