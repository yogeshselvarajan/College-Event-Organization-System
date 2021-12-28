package project.college.event.organizer.login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ForgetPassword extends JFrame {
    private JTextField tfUserName;
    private JTextField tfQues_Sec;
    private JTextField tfAnswer;
    private JPasswordField pfPassword;
    private JButton saveButton;
    private JButton resetButton;
    private JButton searchButton;
    private JPanel root;
    private JButton btnConfirm;

    final String DB_URL = "jdbc:mysql://localhost:3306/projectdb";
    final String USERNAME = "root";
    final String PASSWORD = "root";

    public ForgetPassword() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUserName.getText();
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    PreparedStatement pst;

                    pst = conn.prepareStatement("select Security_Question from students where Email = ?");
                    pst.setString(1, username);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next() == true) {
                        String SecurityQuestion = rs.getString(1);
                        tfQues_Sec.setText(SecurityQuestion);
                    }
                    else if (username.trim().equals(""))
                        JOptionPane.showMessageDialog(null, "User Name Field is Empty! ", "Empty Fields", 2);
                    else
                        JOptionPane.showMessageDialog(null, "Username doesn't match with our records ! ", " Retry Again",2);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


        saveButton.addActionListener(e ->
        {
            String email = tfUserName.getText();
            String NewPassword = String.valueOf(pfPassword.getPassword());
             if (NewPassword.trim().equals(""))
                JOptionPane.showMessageDialog(null, "Password Field is Empty ! ", "Empty Fields", 2);
            else {
                try
                 {
                     Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                     PreparedStatement pst;
                     pst = conn.prepareStatement("update userdb set Password=? where Email=?");
                     pst.setString(1, NewPassword);
                     pst.setString(2,email);
                     pst.executeUpdate();
                     JOptionPane.showMessageDialog(null,"Password Reset Successfully !!");
                     dispose();
                     MainLoginPage ob = new MainLoginPage();
                     ob.main(null);
                 } catch(SQLException throwables)
                 {
                     throwables.printStackTrace();
                 }
             }

        });
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = tfAnswer.getText();
                if (answer.trim().equals(""))
                    JOptionPane.showMessageDialog(null, "Security Answer Field is Empty ! ", "Empty Fields", 2);
                else
                {
                    try {
                        Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                        PreparedStatement preparedStatement = (PreparedStatement) connection
                                .prepareStatement("Select Q_Answer1 from students where Q_Answer1=?");
                        preparedStatement.setString(1, answer);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next())
                            JOptionPane.showMessageDialog(null, "You have confirmed your account identity... Enter the new Password","Authentication Successful",1);
                        else
                            JOptionPane.showMessageDialog(null, "You have entered Incorrect Answer.... Your Account Identity Confirmation Failed !! ", "Authentication Failed",2);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfUserName.setText("");
                tfAnswer.setText("");
                tfQues_Sec.setText("");
                pfPassword.setText("");
            }
        });
    }

    private JPanel getRootPanel()
    {
        return root;
    }

    public static void main(String[] args)
    {
            ForgetPassword ui = new ForgetPassword();
            JPanel root = ui.getRootPanel();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(root);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
    }

}
