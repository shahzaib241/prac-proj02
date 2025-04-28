package org.example.app.entities;

public class Ticket {
    private String date;
    private Buss buss;
    private Integer seatNo;
    private Integer price;
    private Boolean booked;

    @Override
    public String toString() {
        return String.format("Ticket: Arrival: %s | Destination: %s", buss.getArrival(), buss.getDestination());
    }
}
