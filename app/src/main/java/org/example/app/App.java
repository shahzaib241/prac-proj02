package org.example.app;

import java.util.Scanner;

import org.example.app.services.AuthService;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Book-It");
        System.out.println("------------------------------");
        Scanner scanner = new Scanner(System.in);
        
        Integer option = 0;
        while(option != 7) {
            System.out.println("1: Sign Up");
            System.out.println("2: Login");
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
                }
                }
            scanner.close();
            }
    }

