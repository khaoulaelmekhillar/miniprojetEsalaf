package com.exemple.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.exemple.model.Home;

public class Login extends JFrame implements ActionListener {

    private JTextField txtUserNme;
    private JTextField txtPassword;
    private JLabel lblusername ;
    private  JLabel lblPassword ;
    private JButton btnLogin;



    Login() {

        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(3, 1));
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 400);

        lblusername = new JLabel("UserName");
        lblPassword = new JLabel("Password");
        txtUserNme = new JTextField();
        txtPassword = new JPasswordField();
        btnLogin= new JButton("Login");


        panel.add(txtUserNme);
        panel.add(lblusername);
        panel.add(txtPassword);
        panel.add(lblPassword);
        panel.add(btnLogin);

        add(panel, BorderLayout.CENTER);
        btnLogin.addActionListener(this);


    }



    public void actionPerformed(ActionEvent e) {
        String userText = txtUserNme.getText();
        String passwordText = txtPassword.getText();
        if (userText.equalsIgnoreCase("admin") && passwordText.equals("admin")) {
            JOptionPane.showMessageDialog(this, "Connexion réussie");
        } else {

            JOptionPane.showMessageDialog(this, "Connexion réussie");
        }
    }


}

