package org.launchcode.models;

import java.time.LocalDate;

public class User {

    private String username;
    private String email;
    private String password;

    private static int nextId = 1; // static so it is accessible with the class not object
    private final int id;
    private final LocalDate dateRegistered;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

        this.id = nextId;
        nextId++;

        this.dateRegistered = LocalDate.now();
    }

    // GETTERS AND SETTERS
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }
}
