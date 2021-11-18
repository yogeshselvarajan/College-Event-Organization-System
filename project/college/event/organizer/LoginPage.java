package project.college.event.organizer;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class LoginPage extends JFrame implements ActionListener
{
    Container container = getContentPane();
    JLabel userlabel, passwordlabel;
    JTextField usertext, passwordtext;
    JButton login, reset;
    JCheckBox showpass;


    public LoginPage()
    {
        container.setBackground(Color.green);
        container.setLayout(null);
        container.setForeground(Color.BLACK);
        userlabel.setBounds(50, 150, 100, 30);
        passwordlabel.setBounds(50, 220, 100, 30);
        usertext.setBounds(150, 150, 150, 30);
        passwordtext.setBounds(150, 220, 150, 30);
        showpass.setBounds(150, 250, 150, 30);
        login.setBounds(50, 300, 100, 30);
        reset.setBounds(200, 300, 100, 30);
        container.add(userlabel);
        container.add(passwordlabel);
        container.add(usertext);
        container.add(passwordtext);
        container.add(showpass);
        container.add(login);
        container.add(reset);
        login.addActionListener(this);
        reset.addActionListener(this);
        showpass.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String user, password;
            user = usertext.getText();
            password = passwordtext.getText();
            JOptionPane.showMessageDialog(this, "Login successful!");

        }

        if (e.getSource() == reset) {
            usertext.setText(" ");
            passwordtext.setText(" ");
        }

    }

    public static void main(String[] args) {
        LoginPage l = new LoginPage();
        l.setTitle("Login");
        l.setVisible(true);
        l.setBounds(10, 10, 370, 600);
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l.setResizable(false);
    }
}
          
         
