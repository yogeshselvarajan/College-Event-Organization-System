package project.college.event.organizer;

import java.io.*;
import java.awt.*;
import javax.swing.*;

 public class ChangePasswordForm
{
    public ChangePasswordForm()
    {
        JFrame f =new JFrame("FORGET PASSWORD ");
        JLabel title = new JLabel("FORGET PASSWORD",JLabel.CENTER);
        title.setBounds(500,10,400,110);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);

        JLabel username, password, re_password;

        username = new JLabel(" Username :");
        username.setBounds(400,150,130,80);
        username.setFont(new Font("Calibri", Font.ITALIC, 24));

        password = new JLabel("Password :");
        password.setBounds(400,200,130,80);
        password.setFont(new Font("Calibri", Font.ITALIC, 24));

        re_password = new JLabel("Password (again) :");
        re_password.setBounds(400,250,200,80);
        re_password.setFont(new Font("Calibri", Font.ITALIC, 24));

        f.add(username); f.add(password); f.add(re_password);

        /** DECLARATION OF THE TEXT BOXES*/
        JTextField username1,password1,repass;

        username1 = new JTextField();
        username.setBounds(600,163,300,30);

        password1 = new JTextField();
        password1.setBounds(600,218,180,30);

        repass= new JTextField();
        repass.setBounds(600,270,210,30);

        f.add(username1); f.add(password1);f.add(repass);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    public  static void  main(String[] args)
    {
        new ChangePasswordForm();
    }

}

