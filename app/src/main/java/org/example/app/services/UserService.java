package org.example.app.services;

import org.example.app.entities.Buss;
import org.example.app.entities.Seat;
import org.example.app.entities.Ticket;
import org.example.app.entities.User;

import java.util.Optional;

public class UserService {

    public static User user;

    public static Optional<Ticket> getBookings() {
      if (user == null) {
        System.out.println("User not authenticated");
        return Optional.ofNullable(null);
      }
        Optional<Ticket> userTicket = Optional.ofNullable(user.getTicket());
        return userTicket;
     }

     public static void deleteBooking() {
        if (user == null) {
            System.out.println("User not authenticated");
          }
        user.setTicket(null);
        // user.

     }

     public static void bookSeat(Buss buss, Seat seat) throws Exception {
        if (user == null) {
          System.out.println("User not authenticated");
        }
        if (user.getTicket() != null){
            throw new Exception("User already booked a ticket");
        }
          user.setTicket(new Ticket(buss, seat));
       }
}
