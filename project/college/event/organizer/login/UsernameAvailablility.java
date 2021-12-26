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

        JLabel Name = new JLabel("Name :  ");
        Name.setBounds(400,300,200,80);
        Name.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(Name);
        JTextField NameField1 = new JTextField();
        NameField1.setBounds(600,320,200,25);
        f.add(NameField1);

        JButton Check = new JButton("Check Availability");
        Check.setBounds(850,165,170,25);
        f.add(Check);
        Check.addActionListener(e ->
        {
            String userName = username_field.getText();
            String DB_URL = "jdbc:mysql://localhost:3306/projectdb";
            String PASS = "root";
            String USER = "root";
            try {
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement preparedStatement = (PreparedStatement) connection
                        .prepareStatement("Select Email from userdb where Email=?");
                //PreparedStatement preparedStatement = connection.prepareStatement("select * from userdb");
                preparedStatement.setString(1, userName);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "This Username(Email) is Already Registered with us ! , Choose Another One", "Username Failed", 2);}
                else
                    JOptionPane.showMessageDialog(null, "Username Available... Create a password for your account","Username Available",1);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } ;
        });

        JButton Register = new JButton("Proceed to Registration");
        Register.setBounds(500,390,200,25);
        f.add(Register);
        Register.addActionListener(e ->
        {
            String Username= username_field.getText();
            String passText = new String(passwordField.getPassword());
            String passText_confirm = new String(passwordField1.getPassword());
            String NameField = NameField1.getText();
            if(Username.trim().equals("") || passText.trim().equals("") || passText_confirm.trim().equals("") || NameField.trim().equals(""))
                JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty","Empty Fields",2);
            else if(!passText.equals(passText_confirm))
                JOptionPane.showMessageDialog(null, "Password Doesn't Match","Confirm Password",2);
            else
            {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");
                    PreparedStatement pst;
                    pst = connection.prepareStatement("insert into userdb(Email,Password,Name)values(?,?,?)");
                    pst.setString(1,Username);
                    pst.setString(2,passText);
                    pst.setString(3,NameField);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(Register, "Your Basic Login Details are stored...");
                    connection.close();

                    // Calling The NewRegisterForm if it exists
                    NewUserRegister obj = new NewUserRegister();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Users\\vikaa\\IdeaProjects\\College-Event-Organization-System\\project\\college\\event\\organizer\\wp7488244.png"));
        f.add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600, 800);
        f.setLayout(null);
        f.setVisible(true);
    }


    public static void main() {
        new UsernameAvailablility();
    }
}

