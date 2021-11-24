package project.college.event.organizer;

import java.awt.*;
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

        JButton submit ;

        submit = new JButton("Submit");
        submit.setBounds(625,200,80,50);

        f.add(submit);
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

