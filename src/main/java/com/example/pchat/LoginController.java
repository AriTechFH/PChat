package com.example.pchat;

import com.example.pchat.models.Auth;

import com.example.pchat.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    protected void onRegisterClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("register.fxml"));
        Parent parent = fxmlLoader.load();
        Stage stage = (Stage) registerButton.getScene().getWindow();
        stage.setScene(new Scene(parent, 500, 500));
        stage.show();
    }

    @FXML
    protected void onLoginClick() throws Exception {
        Auth.Login(this.username.getText(), this.password.getText());
    }
}