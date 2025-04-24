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
            option = scanner.hasNextInt() ? scanner.nextInt();
            // switch (option) {
            //     case 1: 
            //         System.out.println("Enter Name: ");
            //         String name = scanner.nextLine();
            //         System.out.println("Enter Email: ");
            //         String email = scanner.nextLine();
            //         System.out.println("Enter Password: ");
            //         String password = scanner.nextLine();
            //         AuthService.signUp(name, email, password);
            //         scanner.close();
            //         break;
            // }
        }
    }
}
