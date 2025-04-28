package org.example.app.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.example.app.db.Db;
import org.example.app.entities.User;

public class AuthService {

    public static User signUp(String name, String email, String password) {
        User user = new User(name, email, password);
        Db.addUser(user);
        UserService.user = user;
        return user;
    }

    public static User logIn(String email, String password) throws NoSuchElementException {
        List<User> users = Db.users;
        Optional<User> foundUser = users.stream().filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password)).findFirst();
        UserService.user = foundUser.get();
        return foundUser.get();
    }
}
