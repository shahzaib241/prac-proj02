package org.example.app.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.example.app.utility.Day;

public class Buss {
    private UUID id;
    private String arrival;
    private String destination;
    private Integer price;
    private List<Seat> seats;
    private Day day;

    public Buss(String arrival, String destination, Integer price, Day day) {
        this.id = UUID.randomUUID();
        this.destination = destination;
        this.arrival = arrival;
        seats = new ArrayList<>();
        for (int i = 0; i<= 30; i++){
            seats.add(new Seat(i));
        }
        this.day = day;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Map<Integer, Boolean> getSeatsMap() {
        return  seats.stream().collect(Collectors.toMap(seat -> seat.getSeatNo(), seat -> seat.getBooked()));
    }
    public List<Seat> getSeats() {
        return this.seats;
    }
    public Day getDay() {
        return this.day;
    }

    public void bookSeat(Integer seatNo) {
        try {
            for (Seat seat: seats) {
                if (seat.getSeatNo().equals(seatNo)) {
                    seat.setBooked();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteBooking(Integer seatNo) {
        try {
            for (Seat seat: seats) {
                if (seat.getSeatNo().equals(seatNo)) {
                    seat.setUnBooked();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("Arrival: %s Destination: %s Day: %s Price: %s", this.arrival, this.destination, this.day, this.price);
    }
}
