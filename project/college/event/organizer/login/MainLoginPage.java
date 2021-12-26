package project.college.event.organizer.login;

import project.college.event.organizer.display.AdminDashBoard;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainLoginPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;
    private JButton btnForgetPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainLoginPage frame = new MainLoginPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainLoginPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100,600);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground((new Color(26, 238, 118)));

        JLabel lblNewLabel = new JLabel("Please Login To Proceed ");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 32));
        lblNewLabel.setBounds(423, 13, 500, 93);
        lblNewLabel.setForeground(new Color(148,0,211));
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Segoe Print", Font.BOLD, 20));
        textField.setBounds(481, 170, 281, 40);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Sogoe Print", Font.BOLD, 20));
        passwordField.setBounds(481, 286, 281, 40);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Email ID :");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblUsername.setBounds(250, 166, 193, 52);
        lblUsername.setForeground(new Color(178,34,34));
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblPassword.setBounds(250, 286, 193, 52);
        lblPassword.setForeground(new Color(178,34,34));
        contentPane.add(lblPassword);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setForeground(new Color(174,34,34));
        btnNewButton.setBackground(new Color(0,191,255));
        btnNewButton.setBounds(545, 392, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = String.valueOf(passwordField.getPassword());
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb",
                            "root", "root");

                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select Email, Password from userdb where Email=? and Password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        UserDashBoard ah = new UserDashBoard(userName);
                        ah.setTitle("Welcome");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                    }
                    else if (userName.trim().equals("") || password.trim().equals(""))
                        JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty", "Empty Fields", 2);
                    else
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        contentPane.add(btnNewButton);

        btnForgetPassword = new JButton("Forget Password");
        btnForgetPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnForgetPassword.setBounds(320, 392, 190, 73);
        btnForgetPassword.setForeground(new Color(174,34,34));
        btnForgetPassword.setBackground(new Color(0,191,255));
        btnForgetPassword.addActionListener( e ->
            {
                dispose();
                ForgetPassword ob = new ForgetPassword();
                ob.main(null);
            });
        contentPane.add(btnForgetPassword);

        JButton btnAdminLogin = new JButton("Admin Login");
        btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAdminLogin.setBounds(40, 392, 250, 73);
        btnAdminLogin.setForeground(new Color(174,34,34));
        btnAdminLogin.setBackground(new Color(0,191,255));
        btnAdminLogin.addActionListener(e ->
        {
            String userName = textField.getText();
            String password = String.valueOf(passwordField.getPassword());
            try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb",
                        "root", "root");

                PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select Email, Password from admindb where Email=? and Password=?");

                st.setString(1, userName);
                st.setString(2, password);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    dispose();
                    AdminDashBoard ah = new AdminDashBoard();
                    ah.main(null);
                    JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                }
                else if (userName.trim().equals("") || password.trim().equals(""))
                    JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty", "Empty Fields", 2);
                else
                    JOptionPane.showMessageDialog(btnNewButton, "Wrong Admin Credentials !");
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        });
        contentPane.add(btnAdminLogin);

        JButton btnRegister = new JButton("New Account");
        btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnRegister.setBounds(750, 392, 250, 73);
        btnRegister.setForeground(new Color(174,34,34));
        btnRegister.setBackground(new Color(0,191,255));
        btnRegister.addActionListener(e ->
        {
            dispose();
            UsernameAvailablility obj = new UsernameAvailablility();
            obj.main();
        });
        contentPane.add(btnRegister);
        label = new JLabel("");
        label.setBounds(0, 0, 1608, 562);
        contentPane.add(label);
    }
}
