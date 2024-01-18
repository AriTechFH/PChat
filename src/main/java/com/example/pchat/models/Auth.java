package com.example.pchat.models;

import java.io.IOException;

public class Auth {
    public static User Login(String username, String password) throws IOException, Exception {
        if (username == null || password == null) {
            throw new IOException("No username or password provided.");
        }

        User user = User.GetByUsername(username);
        if (user == null) {
            throw new Exception("User does not exist.");
        }

        if (! password.equals(user.Password)) {
            throw new Exception("The given password is incorrect.");
        }

        return user;
    }

    public static void Register(String username, String password) throws Exception {
        if (username == null || password == null) {
            throw new IOException("No username or password provided.");
        }

        User user = User.GetByUsername(username);
        if (user != null) {
            throw new Exception("User already exists.");
        }

        User.Create(username, password);

        user = User.GetByUsername(username);

    }
}
