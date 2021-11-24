package project.college.event.organizer;

import java.awt.*;
import javax.swing.*;

public class PasswordResetForm
{
    public  PasswordResetForm()
    {
        JFrame f = new JFrame("Reset your Pass3ord");
        JLabel title = new JLabel("Reset Password", JLabel.CENTER);
        title.setBounds(500, 10, 500, 110);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);


        JLabel password_first,password_second;
        password_first = new JLabel("New Password : ");
        password_first.setBounds(400, 133, 300, 30);
        password_first.setFont(new Font("Calibri", Font.ITALIC, 24));
        f.add(password_first);
        password_second = new JLabel("Retype New Password :");
        password_second.setBounds(400, 180, 300, 30);
        password_second.setFont(new Font("Calibri", Font.ITALIC, 24));
        f.add(password_second);

        JPasswordField password_enter,password_reenter;
        password_enter = new JPasswordField();
        password_enter.setBounds(650,130,150,30);
        password_reenter = new JPasswordField();
        password_reenter.setBounds(650,180,150,30);
        f.add(password_enter); f.add(password_reenter);

        JButton submit ;
        submit = new JButton("Submit");
        submit.setBounds(600,250,80,50);
        f.add(submit);

        JButton reset = new JButton("Reset");
        reset.setBounds(700,250,80,50);
        reset.addActionListener(e -> {
            password_enter.setText("");
            password_reenter.setText("");
        });
        f.add(reset);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    public  static void  main(String[] args)
    {
        new PasswordResetForm();
    }
}

