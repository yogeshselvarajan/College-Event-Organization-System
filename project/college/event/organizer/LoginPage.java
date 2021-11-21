package project.college.event.organizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class LoginPage implements ActionListener {

    HashMap<String,String> logininfo = new HashMap<>();
    protected HashMap<String,String> getLoginInfo()
    {
        logininfo.put("Krish","123456");
        logininfo.put("Sree","234567");
        logininfo.put("TSK","34567");

        return logininfo;
    }

    JFrame frame = new JFrame();
    JButton login = new JButton("Login");
    JButton reset = new JButton("Reset");
    JTextField id = new JTextField();
    JPasswordField pass = new JPasswordField();
    JLabel username = new JLabel("Username");
    JLabel passlabel = new JLabel("Password");
    JLabel message = new JLabel();





    LoginPage()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setBackground(Color.CYAN);
        frame.setVisible(true);
        frame.setResizable(false);
        passlabel.setBounds(75,160,75,25);
        username.setBounds(75,110,75,25);
        message.setBounds(300,200,100,100);

        message.setFont(new Font(null, Font.ITALIC,20));
        id.setBounds(150,110,200,25);
        pass.setBounds(150,160,200,25);
        login.setBounds(150,210,100,25);
        login.addActionListener(this);
        reset.setBounds(250,210,100,25);
        reset.addActionListener(this);
        login.setFocusable(false);
        reset.setFocusable(false);
        frame.add(id);
        frame.add(pass);
        frame.add(login);
        frame.add(reset);
        frame.add(username);
        frame.add(passlabel);
        frame.add(message);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == reset)
        {
            id.setText("");
            pass.setText("");
        }
        if(e.getSource() == login)
        {
             String userid = id.getText();
             String p = String.valueOf(pass.getPassword());

             if(getLoginInfo().containsKey(userid)) {
                 if (getLoginInfo().get(userid).equals(p)) {
                     message.setForeground(Color.GREEN);
                     message.setText("Login Successful!");

                 } else {
                     message.setForeground(Color.RED);
                     message.setText("Incorrect password,Please try again!");
                 }
             }
             else{
                 message.setForeground(Color.RED);
                 message.setText("Id does not exist!");
             }


        }
    }


    public static void main(String [] args)
    {
        LoginPage l = new LoginPage();
    }
}
