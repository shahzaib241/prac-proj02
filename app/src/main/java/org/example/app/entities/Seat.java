package org.example.app.entities;

import java.util.UUID;

public class Seat {
    private UUID id;
    private Boolean booked;
    private Integer seatNo;

    public Seat(Integer seatNo) {
        this.id = UUID.randomUUID();
        this.booked = false;
        this.seatNo = seatNo;
    }

    public Integer getSeatNo() {
        return this.seatNo;
    }

    public Boolean getBooked() {
        return this.booked;
    }

    public void setBooked() throws Exception {
        if (this.booked == true) {
            throw new Exception("Seat is already booked");
        } else {
            this.booked = true;
        }
    }

    public void setUnBooked() throws Exception {
        if (this.booked == false) {
            throw new Exception("Seat is already un-booked");
        } else {
            this.booked = false;
        }
    }
}
