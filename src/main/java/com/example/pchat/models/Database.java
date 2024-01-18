package com.example.pchat.models;

import com.example.pchat.Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static final String location = Objects.requireNonNull(Application.class.getResource("database.db")).toExternalForm();
    private static Connection connection;


    public static Connection connect()
    {
        String dbPrefix = "jdbc:sqlite:";

       try
       {
           if(connection!=null&&!connection.isClosed())
               return connection;

           connection = DriverManager.getConnection(dbPrefix + Database.location);
           return connection;
       }
       catch (SQLException e)
       {
           Logger.getAnonymousLogger().log(Level.SEVERE,
                   LocalDateTime.now() + ": Could not connect to SQLite DB at " +
                           Database.location);
           return null;
       }


    }
}
