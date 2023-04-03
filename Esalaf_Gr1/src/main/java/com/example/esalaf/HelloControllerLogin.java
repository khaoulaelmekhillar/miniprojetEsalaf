package com.example.esalaf;

import com.exemple.model.Client;
import com.exemple.model.ClientDAO;
import com.exemple.model.Home;
import com.exemple.model.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloControllerLogin implements Initializable {
    @FXML
    private TextField UserName;

    @FXML
    private TextField Password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onLoginButtonClick(ActionEvent e) {
        String userText = UserName.getText();
        String passwordText = Password.getText();
            if (userText.equalsIgnoreCase("admin") && passwordText.equals("admin")) {
                JOptionPane.showMessageDialog(null, "Connexion réussie");

                // Fermer la fenêtre de connexion
                ((Stage)(((Node)e.getSource()).getScene().getWindow())).close();

                // Ouvrir la fenêtre Home
                new Home().setVisible(true);
            } else {
                // Afficher un message d'erreur de connexion
                 JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect");
            }
        }



}
