package project.college.event.organizer.login;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

 public class GetUserNameForReset
{
    public GetUserNameForReset()
    {
        JFrame f =new JFrame("Enter Your Username ");
        JLabel title = new JLabel("FORGET PASSWORD",JLabel.CENTER);
        title.setBounds(500,10,400,110);
        title.setFont(new Font("Comic Sans MS", Font.BOLD,30));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);

        JLabel username;

        username = new JLabel("Enter Email ID :");
        username.setBounds(600,133,130,30);
        username.setFont(new Font("Calibri", Font.ITALIC, 24));

        f.add(username);

        /** DECLARATION OF THE TEXT BOXES*/
        JTextField username1;

        username1 = new JTextField();
        username1.setBounds(750,131,200,30);

        f.add(username1);
        String get_username = username1.getText();

        JButton submit ;

        submit = new JButton("Submit");
        submit.setBounds(625,200,80,50);

        f.add(submit);

        submit.addActionListener(e ->
        {
            String DB_URL = "jdbc:mysql://localhost:3306/projectdb";
            String PASS = "root";
            String USER = "root";

            try {
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement preparedStatement = (PreparedStatement) connection
                        .prepareStatement("Select Email from userdb where Email=? ");
                preparedStatement.setString(1, get_username);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(submit, "Username exists in the DB... Proceed to confirm your identity");
                    f.dispose();
                    UserAuthenticationCheck obj = new UserAuthenticationCheck();
                }
                else{
                    JOptionPane.showMessageDialog(submit, "An Account with the specified not found!!");
                    f.dispose();
                    RedirectToLogin obj = new RedirectToLogin();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } ;
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    public  static void  main(String[] args)
    {
        new GetUserNameForReset();
    }

}

