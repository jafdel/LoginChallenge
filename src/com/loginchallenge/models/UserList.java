package com.loginchallenge.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserList {
    private ArrayList<User> users;

    public UserList(Path file) {
        this.users = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(file);
            String name = "", password = "";
            for (String line : lines) {
                if (!line.isBlank()) {
                    if (line.startsWith("Username: "))
                        name = line.replace("Username: ", "").trim();
                    else if (line.startsWith("Password: "))
                        password = line.replace("Password: ", "").trim();
                    if (!name.isBlank() && !password.isBlank() && !this.isMatch(name, password)) {
                        this.users.add(new User(name, password));
                        IO.println("User " + name + " added.");
                        name = "";
                        password = "";
                    }
                }
            }
        } catch (IOException e) {
            IO.println("File error");
        }
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean isMatch(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password))
                return true;
        }
        return false;
    }

    public int getSize() {
        return this.users.size();
    }
}
