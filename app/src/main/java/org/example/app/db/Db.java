package org.example.app.db;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.example.app.entities.User;

public class Db {
    public static List<User> users = new ArrayList<>();

    public static User addUser(User user) {
        users.add(user);
        return user;
    }

    public static Boolean removeUser(UUID id) {
        users =  users.stream().filter(user -> !user.getId().equals(id)).collect(Collectors.toList());
        return true;
    }

}
