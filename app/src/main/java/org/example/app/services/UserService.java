package org.example.app.services;

import org.example.app.entities.Ticket;
import org.example.app.entities.User;

import java.util.Optional;

public class UserService {
    public static User user;
    public static Optional<Ticket> getBookings() {
        Optional<Ticket> userTicket = Optional.ofNullable(user.getTicket());
        return userTicket;
     }
}
