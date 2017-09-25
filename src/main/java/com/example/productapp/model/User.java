package com.example.productapp.model;

/**
 * Created by ykoer on 9/25/17.
 */
public class User {

    private String login;
    private String firstName;
    private String lastName;


    public User(String userName) {
        this.login = userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
