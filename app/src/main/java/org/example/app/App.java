package org.example.app;

import java.util.Optional;
import java.util.Scanner;

import org.example.app.db.Db;
import org.example.app.entities.Buss;
import org.example.app.entities.Ticket;
import org.example.app.services.AuthService;
import org.example.app.services.UserService;

public class App {
    public static void main(String[] args) {

        Db.addBuss(new Buss());
        System.out.println("Welcome to Book-It");
        System.out.println("------------------------------");
        Scanner scanner = new Scanner(System.in);
        
        Integer option = 0;
        while(option != 6) {
            System.out.println("1. Sign up"); //done
            System.out.println("2. Login");  //done
            System.out.println("3. Fetch Bookings"); //done
            System.out.println("4. Book a Seat");
            System.out.println("5. Cancel my Booking");
            System.out.println("6. Exit the App");
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
                    System.out.print("Select Date: ");
                    String date = scanner.next();

                    break;
                }
                }
            scanner.close();
            }
    }

