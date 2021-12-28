package project.college.event.organizer;

import project.college.event.organizer.login.MainLoginPage;

import java.awt.*;
import javax.swing.*;

public class welcome
{
    public welcome()
    {
        JFrame f =new JFrame("Welcome");
        f.getContentPane().setBackground(new Color(255,222,173));
        JLabel title = new JLabel("WELCOME TO COLLEGE EVENT ORGANIZATION SYSTEM",JLabel.CENTER);
        title.setBounds(200,230,1200,100);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        title.setForeground(Color.red);
        f.add(title);
        f.setForeground(Color.black);

        JButton submit = new JButton("PROCEED TO LOGIN PAGE");
        submit.setBounds(650,400,350,50);
        submit.setFont(new Font("Arial Black", Font.BOLD, 15));
        submit.addActionListener(e ->
        {
            f.dispose();
            MainLoginPage obj = new MainLoginPage();
            obj.main(null);
        });
        submit.setFocusable(false);
        f.add(submit);

        JButton reset = new JButton("QUIT");
        reset.setBounds(700,500,160,50);
        reset.setFont(new Font("Arial Black", Font.BOLD, 15));
        reset.addActionListener(e ->
        {
           System.exit(0);
        });
        reset.setFocusable(false);
        f.add(reset);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    public  static void  main(String[] args)
    {
        new welcome();
    }

}

