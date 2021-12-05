package project.college.event.organizer.login;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UsernameAvailablility
{
    public UsernameAvailablility()
    {
        JFrame f = new JFrame("Check Username Availability");
        JLabel title = new JLabel("Username Availability", JLabel.CENTER);
        title.setBounds(500, 10, 400, 110);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);

        JLabel username, password, password_confirm;
        JTextField username_field;
        JPasswordField passwordField, passwordField1;

        username = new JLabel("Enter Username");
        username.setBounds(400, 150, 150, 80);
        username.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(username);
        username_field = new JTextField();
        username_field.setBounds(600, 165, 200, 25);
        f.add(username_field);

        password = new JLabel("Enter Password ");
        password.setBounds(400, 200, 200, 80);
        password.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(password);
        passwordField = new JPasswordField();
        passwordField.setBounds(600, 220, 200, 25);
        f.add(passwordField);

        password_confirm= new JLabel("Confirm Password ");
        password_confirm.setBounds(400,250,200,80);
        password_confirm.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(password_confirm);
        passwordField1 = new JPasswordField();
        passwordField1.setBounds(600,270,200,25);
        f.add(passwordField1);

        JButton Check = new JButton("Check Availability");
        Check.setBounds(850,165,170,25);
        f.add(Check);
        Check.addActionListener(e ->
        {
            String userName = username_field.getText();
            String DB_URL = "jdbc:mysql://localhost:3306/projectdb";
            String PASS = "localhost";
            String USER = "root";
            try {
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement preparedStatement = connection.prepareStatement("select * from userdb");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String username_col = resultSet.getString("User_name");
                    if (userName.equals(username_col) == true) {
                        JOptionPane.showMessageDialog(Check, "Username Not Available!");
                    } else {
                        JOptionPane.showMessageDialog(Check, "Username Available . You can proceed the Registration Process");
                    }
                    resultSet.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } ;
        });

        JButton Register = new JButton("Proceed to Registration");
        Register.setBounds(500,350,200,25);
        f.add(Register);
        Register.addActionListener(e ->
        {
            String DB_URL = "jdbc:mysql://localhost:3306/projectdb";
            String PASS = "localhost";
            String USER = "root";
            String Username= username_field.getText();
            String passText = new String(passwordField.getPassword());
            String passText_confirm = new String(passwordField1.getPassword());
            if(passText.equals(passText_confirm)) {
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    String final_pass = passText_confirm;
                    String query = "INSERT INTO userdb values('" + Username + "','" + final_pass + "')";

                    Statement sta = conn.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0)
                        JOptionPane.showMessageDialog(Register, "Error in storing at Database !");
                    else
                        JOptionPane.showMessageDialog(Register, "Your Basic Login Details are stored...");
                    conn.close();

                    // Calling The NewRegisterForm if it exists
                    NewUserRegister obj = new NewUserRegister();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(Register, "Passwords Dont Match! Retry Again");
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600, 800);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main() {
        new UsernameAvailablility();
    }
}
