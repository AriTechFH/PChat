package com.example.pchat.models;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
    public String Username;
    public String Password;

    public User(String username, String password) {
        this.Username = username;
        this.Password = password;
    }

    public void Message(User user, String content) {
        Message message = new Message(this, user, content);
        // message.Save();
        // ToDo: Message soll in DB gespeichert werden
    }

    public static List<User> GetAll()
    {
        List<User> users = new ArrayList<User>();

        String query = "SELECT * FROM users";

        try {
            Connection connection = Database.connect();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                users.add(
                    new User(
                        rs.getString("username"),
                        rs.getString("password")
                    )
                );
                statement.close();
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not load users from database ");
        }

        return users;
    }

    public static User GetByUsername(String username)
    {
        User user = null;

        //String query = "SELECT * FROM users WHERE username = '" + username + "' LIMIT 1";
        String sql="Select Distinct * From users Where username=?";

        try {
            Connection connection = Database.connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new User(
                    rs.getString("username"),
                    rs.getString("password")
                );
                statement.close();
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not load users from database ");
        }

        return user;
    }

    public static void Create(String username, String password)
    {
        //String query = "INSERT INTO users (id, username, password) VALUES (null, '" + username + "', '" + password + "')";
        String sql ="INSERT INTO users VALUES(?,?)";


        try {
            Connection connection = Database.connect();
            assert connection != null;
            try  {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,username);
                statement.setString(2,password);
                System.out.println(statement.toString());
                statement.executeUpdate();
                statement.close();
            } catch (Exception ex) {
                //System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": " + e.getMessage());
        }
    }
}