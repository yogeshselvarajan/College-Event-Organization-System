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

        username = new JLabel("Username :");
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
                PreparedStatement preparedStatement = connection.prepareStatement("select * from userdb");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String username_col = resultSet.getString("User_name");
                    if (get_username.equals(username_col))
                    {
                        JOptionPane.showMessageDialog(submit, "Username exists in the DB . You can proceed further to Authenticate your Identity");
                        UserAuthenticationCheck.main();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(submit, "Username not found in the DB. Proceed to create a new acount");
                        UsernameAvailablility.main();
                    }
                    resultSet.close();
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

