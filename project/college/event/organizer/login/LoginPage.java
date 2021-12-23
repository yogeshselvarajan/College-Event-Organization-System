package project.college.event.organizer.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginPage extends JDialog
{
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btnOK;
    private JButton btnCancel;
    private JPanel loginPanel;

    public LoginPage(JFrame parent)
    {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                user = getAuthenticatedUser(email, password);

                if(user != null)
                    dispose();
                else
                {
                    JOptionPane.showMessageDialog(LoginPage.this,
                            "Email or Password Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });

        setVisible(true);
    }

    public User user;
    private User getAuthenticatedUser(String email, String password)
    {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/projectdb";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        try
        {
            {
                Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                //Connected to the database successfully....

                Statement stml = conn.createStatement();
                String sql = " SELECT * FROM userdb WHERE Email=? AND Password=?";
                PreparedStatement preparedStatement =conn.prepareStatement(sql);
                preparedStatement.setString(1,email);
                preparedStatement.setString(2,password);

                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next())
                {
                    user = new User();
                    user.email = resultSet.getString("email");
                    user.password = resultSet.getString("password");
                    user.name = resultSet.getString("name");
                }

                stml.close();
                conn.close();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return user;
    }

    public static void main(String[] args)
    {
        LoginPage loginPage = new LoginPage(null);
        User user = loginPage.user;
        if(user != null)
        {
            JOptionPane.showMessageDialog(null,
                    "Successful Authentication of :" +user.name,
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Successful Authentication of : " +user.name);
            System.out.println("            Email: " + user.email);
        }
        else
            System.out.println("Authentication cancelled!");
    }
}
