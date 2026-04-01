package com.loginchallenge.models;

public class User {
    private final String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getUsername() {
        return this.name;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
