package project.college.event.organizer.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class LoginPage extends JDialog
{
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btnOK;
    private JButton btnCancel;
    private JPanel loginPanel;
    private JButton registerButton;
    private JButton forgetPasswordButton;
    private JPanel btnForgetPassword;
    private JButton createNewAccountButton;
    private JLabel forgetPass;

    public LoginPage(JFrame parent)
    {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                user = getAuthenticatedUser(email, password);

                if(user != null)
                    dispose();
                    // Checking Blank Fields
                else if (email.trim().equals("") || password.trim().equals(""))
                    JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty", "Empty Fields", 2);
                else
                {
                    JOptionPane.showMessageDialog(LoginPage.this,
                            "Email or Password Invalid",
                            "Try again",
                            ERROR_MESSAGE);
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

        createNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsernameAvailablility obj = new UsernameAvailablility();
                obj.main();
            }
        });

        forgetPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ForgetPassword ob = new ForgetPassword();
                ob.main(null);
            }
        });
    }

    public User user;
    private User getAuthenticatedUser(String email, String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/projectdb";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        try
        {
            {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                //Connected to the database successfully....

                Statement stml = conn.createStatement();
                String sql = " SELECT * FROM userdb WHERE Email=? AND Password=?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next())
                {
                    user = new User();
                    user.email = resultSet.getString("email");
                    user.password = resultSet.getString("password");
                    user.name = resultSet.getString("name");
                }

                stml.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args)
    {
        LoginPage loginPage = new LoginPage(null);
        User user = loginPage.user;
        if(user != null)
            JOptionPane.showMessageDialog(null, "You have successfully logged in");
        else
            JOptionPane.showMessageDialog(null, "Authentication cancelled!","Login Failed",ERROR_MESSAGE);
    }
}