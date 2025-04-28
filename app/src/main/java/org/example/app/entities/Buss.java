package org.example.app.entities;

import java.util.List;
import java.util.UUID;

import org.example.app.utility.Station;


public class Buss {
    private UUID id;
    private Station destination;
    private List<Seat> seats;
    private Station arrival;
    private List<Station> path;

    public Buss(Station destination, Station arrival, List<Station > ...paths) {
        this.id = UUID.randomUUID();
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    public Station getArrival() {
        return arrival;
    }

    public void setArrival(Station arrival) {
        this.arrival = arrival;
    }

    public List<Station> getPath() {
        return path;
    }

    public void setPath(List<Station> path) {
        this.path = path;
    }
}
