package org.example.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.example.app.db.Db;
import org.example.app.entities.Buss;

public class TrainService {
    public static List<Buss> getBusses (String arrival, String destination) {
        return Db.busses.stream().filter(buss -> buss.getDestination().equals(destination)).filter(buss-> buss.getArrival().equals(arrival)).collect(Collectors.toList());
    }
}
