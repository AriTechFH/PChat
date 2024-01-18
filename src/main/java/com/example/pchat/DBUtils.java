/*package com.example.pchat;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DBUtils {

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username){
        Parent root = null;

        if (username != null)  {
            try{
                FXMLLoader loader= new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                LoggedInController loggedInController = loader.getController();
                loggedInController.setUserInformation(username);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }
    public static void registerUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psRegisteredUser = null;
        ResultSet resultSet = null;

        PreparedStatement psCheckUserExists;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:plantchat.db", "root", "toor");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            psCheckUserExists.setString(1, username);
            resultSet = psCheckUserExists.executeQuery();

            if(resultSet.isBeforeFirst()){
                System.out.println("User existiert bereits!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Bitte wähle einen anderen.");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
                psInsert.setString(1, username);
                psInsert.setString(2, password);
                psInsert.executeUpdate();

                changeScene(event, "logged-in.fxml", "Welcome!", username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logInUser(ActionEvent event, String username, String password) {
        Connection connetion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connetion = DriverManager.getConnection("jdbc:sqlite:plantchat.db", "root", "toor");
            preparedStatement = connetion.prepareStatement("SELECT * FROM users WHERE username = " + username + " AND password = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User existiert nicht!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Bitte versuche es erneut.");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String dbUsername = resultSet.getString("username");
                    String dbPassword = resultSet.getString("password");
                    if (dbUsername.equals(username) && dbPassword.equals(password)) {
                        changeScene(event, "logged-in.fxml", "Welcome!", username);
                    } else {
                        System.out.println("Falsches Passwort!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Bitte versuche es erneut.");
                        alert.show();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connetion != null) {
                try {
                    connetion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean loginUser() {
        return false;
    }
}
*/