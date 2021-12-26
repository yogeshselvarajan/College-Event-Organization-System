package project.college.event.organizer.display;

import project.college.event.organizer.display.eventmanage.EventsDashBoard;
import project.college.event.organizer.display.usersmanage.Admin_Manage_Users;

import javax.swing.*;
import java.awt.*;

public class AdminDashBoard
{
    public AdminDashBoard()
    {
        JFrame f = new JFrame("Manage Admin");
        JLabel title = new JLabel("Welcome Admin :-) ", JLabel.CENTER);
        title.setBounds(350, 10, 600, 110);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);

        JButton culturals = new JButton("Manage Users DataBase");
        culturals.setBounds(400, 118, 500, 60);
        culturals.addActionListener(e ->
        {
            f.dispose();
            Admin_Manage_Users ob = new Admin_Manage_Users();
            ob.main(null);
        });
        f.add(culturals);

        JButton manage_events = new JButton("Manage Various Events DataBase");
        manage_events.setBounds(400,220,500,60);
        manage_events.addActionListener(e ->
        {
            f.dispose();
            EventsDashBoard ob = new EventsDashBoard();
            ob.main(null);
        });
        f.add(manage_events);

        JButton Exit = new JButton("Exit Application");
        Exit.setBounds(400,620,500,60);
        Exit.addActionListener( e ->
        {
            System.exit(0);
        });
        f.add(Exit);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    public  static void  main(String[] args)
    {
        new AdminDashBoard();
    }
    }
