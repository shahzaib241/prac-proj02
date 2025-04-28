package org.example.app.entities;

public class Ticket {
    private Buss buss;
    private Seat seat;

    public Ticket(Buss buss, Seat seat) {
        this.buss = buss;
        this.seat = seat;
    }

    public Seat getSeat() {
        return this.seat;
    }
    
    @Override
    public String toString() {
        return String.format("Arrival: %s | Destination: %s | Day: %s | SeatNo: %s", buss.getArrival(), buss.getDestination(), buss.getDay(), seat.getSeatNo());
    }
}
