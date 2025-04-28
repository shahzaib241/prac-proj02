package org.example.app;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.example.app.db.Db;
import org.example.app.entities.Buss;
import org.example.app.entities.Seat;
import org.example.app.entities.Ticket;
import org.example.app.entities.User;
import org.example.app.services.AuthService;
import org.example.app.services.TrainService;
import org.example.app.services.UserService;
import org.example.app.utility.Day;

public class App {
    public static void main(String[] args) {
        Db.addBuss(new Buss("multan","lahore", 300, Day.MONDAY));
        Db.addBuss(new Buss("multan","karachi", 300, Day.TUESDAY));
        Db.addBuss(new Buss("islamabad","multan", 300, Day.MONDAY));
        Db.addBuss(new Buss("karachi", "multan", 300, Day.FRIDAY));
        System.out.println("Welcome to Book-It");
        System.out.println("------------------------------");
        Scanner scanner = new Scanner(System.in);
        
        Integer option = 0;
        Buss buss = null;
        while(option != 7) {
            System.out.println("------------------------------");
            System.out.println("1. Sign up"); //done
            System.out.println("2. Login");  //done
            System.out.println("3. Fetch Bookings"); //done
            System.out.println("4. Search Trains"); //done
            System.out.println("5. Book a Seat"); //done
            System.out.println("6. Cancel my Booking"); 
            System.out.println("7. Exit the App");
            option = scanner.nextInt();
            
            switch (option) {
                case 1: 
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Email: ");
                    String email = scanner.next();
                    System.out.print("Enter Password: ");
                    String password = scanner.next();
                    AuthService.signUp(name, email, password);
                    break;
                case 2:                     
                    System.out.print("Enter Email: ");
                    String email2 = scanner.next();
                    System.out.print("Enter Password: ");
                    String password2 = scanner.next();
                    try {
                        AuthService.logIn(email2, password2);
                        System.out.println("login successful!!!");
                    } catch (Exception e) {
                        System.out.println("Invalid Credentials");
                    }
                    break;
                case 3:
                    System.out.println("Bookings");
                    Optional<Ticket> userTicket = UserService.getBookings();
                    if (userTicket.isPresent()) {
                        System.out.println(userTicket.get());
                    } else {
                        System.out.println("No tickets booked");
                    }
                    break;
                case 4:
                    System.out.print("Select Arrival: ");
                    String arrival = scanner.next();
                    System.out.print("Select Destination: ");
                    String destination = scanner.next();
                    List<Buss> busses = TrainService.getBusses(arrival, destination);
                    if (busses.isEmpty()) {
                        System.out.println("No buss found");
                        break;
                    }
                    for(Buss bussP: busses) {
                        System.out.println(bussP);
                    }
                    System.out.println("Select 1,2,3 to select the buss to book");
                    Integer choice = scanner.nextInt();
                    buss = busses.get(choice - 1);
                    break;
                case 5:
                    if (buss == null) {
                        System.out.println("login and select a buss");
                        break;
                    }
                    System.out.println("Book a seat from the buss");
                    buss.getSeatsMap().forEach((seatNo, booked)-> System.out.println(String.format("Seat No: %s -- Booked: %s", seatNo, booked)));
                    System.out.println("Enter a Seat No");
                    Integer seatNo = scanner.nextInt();
                    try {
                        Seat seat = buss.getSeats().stream().filter(seatIns -> seatIns.getSeatNo().equals(seatNo)).findFirst().orElseThrow(Exception::new);
                        UserService.bookSeat(buss, seat);
                        buss.bookSeat(seatNo);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                    case 6:
                    System.out.println("Bookings");
                    Optional<Ticket> ticket = UserService.getBookings();
                    if (ticket.isPresent()) {
                        System.out.println(ticket.get());
                    } else {
                        System.out.println("No tickets booked");
                    }
                    System.out.println("Are you sure you want to cancel the booking? y/n");
                    String deleteBooking = scanner.next();
                    if (deleteBooking.equals("y")) {
                        UserService.deleteBooking();
                        buss.deleteBooking(ticket.get().getSeat().getSeatNo());
                    }
                    break;
                }
                }
            scanner.close();
            }
    }

