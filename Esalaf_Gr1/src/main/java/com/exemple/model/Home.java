package com.exemple.model;

import com.example.esalaf.HelloApplication;
import com.example.esalaf.HelloApplicationCredit;
import com.example.esalaf.HelloApplicatonProduit;
import javafx.scene.Node;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {
    private JLabel txtHome;
    private JButton clientButton;
    private JButton productButton;
    private JButton creditButton;

    public Home() {
        setTitle("Home");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);

        // Création des boutons
        txtHome = new JLabel("Home");
        clientButton = new JButton("Gestion des clients");
        productButton = new JButton("Gestion des produits");
        creditButton = new JButton("Gestion de crédit");

        // Ajout des boutons à la fenêtre
        JPanel panel = new JPanel();
        panel.add(clientButton);
        panel.add(productButton);
        panel.add(creditButton);
        add(panel);

        // Ajout des actions aux boutons
        clientButton.addActionListener(e -> {
            // Action à effectuer lors du clic sur le bouton de gestion des clients
            // Ici, ouvrir une nouvelle fenêtre pour la gestion des clients

            // Fermer la fenêtre actuelle (Home)

            dispose();
            // Ouvrir une nouvelle instance de Test
            new HelloApplication();
        });

        productButton.addActionListener(e -> {
            // Action à effectuer lors du clic sur le bouton de gestion des produits
            // Ici, ouvrir une nouvelle fenêtre pour la gestion des produits
            dispose();
            new HelloApplicatonProduit();
        });

        creditButton.addActionListener(e -> {
            // Action à effectuer lors du clic sur le bouton de gestion de crédit
            // Ici, ouvrir une nouvelle fenêtre pour la gestion de crédit
            dispose();
            new HelloApplicationCredit();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }
}
