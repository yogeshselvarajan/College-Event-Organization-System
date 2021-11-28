package project.college.event.organizer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPageDesign  extends JFrame
{

    JLabel userNameLabel, passwordLabel;
    JTextField userNameTextField;
    JPasswordField passwordField;
    JButton loginButton;
    Container container;

    public LoginPageDesign () {
        userNameLabel = new JLabel("User Name");
        userNameTextField = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        container = getContentPane();
        container.setLayout(null);
        userNameLabel.setBounds(10, 10, 100, 30);
        userNameTextField.setBounds(100, 10, 200, 30);
        passwordLabel.setBounds(10, 50, 100, 30);
        passwordField.setBounds(100, 50, 200, 30);
        loginButton.setBounds(100, 100, 200, 30);
        addComponents();
    }

    public void addComponents() {
        container.add(userNameLabel);
        container.add(userNameTextField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(loginButton);
    }

    public static void main(String[] args) {
        LoginPageDesign frame = new LoginPageDesign();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(250, 250, 370, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}

