package project.college.event.organizer;

import java.awt.*;
import javax.swing.*;

public class LoginPageDesign  extends JFrame
{
    JLabel userNameLabel, passwordLabel,registerLabel;
    JTextField userNameTextField;
    JPasswordField passwordField;
    JButton loginButton,registerButton,forgetPassword;
    Container container;

    public LoginPageDesign () {
        userNameLabel = new JLabel("User Name");
        userNameLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        userNameLabel.setForeground(Color.red);
        userNameTextField = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        passwordLabel.setForeground(Color.red);
        passwordField = new JPasswordField();
        loginButton = new JButton("Sign In");
        registerButton = new JButton("Sign Up for a New Account");
        registerLabel = new JLabel("Don't have an account? Dont Worry!");
        registerLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
        registerLabel.setForeground(Color.red);
        forgetPassword = new JButton("Forget Password ");
        container = getContentPane();
        container.setLayout(null);
        userNameLabel.setBounds(10, 10, 100, 30);
        userNameTextField.setBounds(100, 10, 200, 30);
        passwordLabel.setBounds(10, 50, 100, 30);
        passwordField.setBounds(100, 50, 200, 30);
        loginButton.setBounds(100, 100, 100, 30);
        forgetPassword.setBounds(85,135,135,30);
        registerLabel.setBounds(45,165,300,30);
        registerButton.setBounds(60,190,200,30);
        addComponents();
    }

    public void addComponents() {
        container.add(userNameLabel);
        container.add(userNameTextField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(loginButton);
        container.add(registerButton);
        container.add(forgetPassword);
        container.add(registerLabel);
        setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("E:\\College-Event-Organization-System\\2805308.png"));
        add(background);
        background.setLayout(new FlowLayout());
        registerButton.addActionListener(e->
        {
            //Calling Registration UsernameChecker
            UsernameAvailablility obj = new UsernameAvailablility();
        });
    }

    public void connectDB()
    {

    }

    public static void main(String[] args)
    {
        LoginPageDesign frame = new LoginPageDesign();
        frame.setTitle("Login Page");
        frame.setVisible(true);
        frame.setBounds(250, 250, 370, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);


    }
}

