package org.example.app.entities;

import java.util.UUID;

public class Seat {
    private UUID id;
    private Boolean booked;
    private Integer seatNo;
    private User user;
    private Integer price;

    public Seat(Integer seatNo, Integer price) {
        this.id = UUID.randomUUID();
        this.booked = false;
        this.seatNo = seatNo;
        this.price = price;
    }

    public void setUser (User user) {
        this.user = user;
    }
}
