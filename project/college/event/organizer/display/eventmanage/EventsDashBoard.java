package project.college.event.organizer.display.eventmanage;

import project.college.event.organizer.display.eventmanage.culturals.Manage_Culturals;
import project.college.event.organizer.display.eventmanage.finearts.Manage_FineArts;
import project.college.event.organizer.display.eventmanage.workshop.Manage_Workshop;
import project.college.event.organizer.events.ExtraCurricularEventReg;
import project.college.event.organizer.events.MeetingRegistration;


import javax.swing.*;
import java.awt.*;

public class EventsDashBoard
{
    public EventsDashBoard()
    {
        JFrame f = new JFrame("Manage Events");
        f.getContentPane().setBackground(new Color(255,238,153));
        JLabel title = new JLabel("Welcome to the Management Page", JLabel.CENTER);
        title.setBounds(350, 10, 600, 110);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);

        JButton culturals = new JButton("Manage DB for Culturals Event");
        culturals.setBounds(400, 118, 500, 60);
        culturals.addActionListener(e ->
        {
            f.dispose();
            Manage_Culturals ob = new Manage_Culturals();
            ob.main(null);
        });
        f.add(culturals);

        JButton extracurricular = new JButton("Register for Extra Curricular Event");
        extracurricular.setBounds(400,220,500,60);
        extracurricular.addActionListener(e ->
        {
            f.dispose();
            ExtraCurricularEventReg ob = new ExtraCurricularEventReg();
            ob.main(null);
        });

        f.add(extracurricular);

        JButton finearts = new JButton("Register for FineArts Event");
        finearts.setBounds(400,320,500,60);
        finearts.addActionListener( e ->
        {
            f.dispose();
            Manage_FineArts ob = new Manage_FineArts();
            ob.main(null);
        });
        f.add(finearts);

        JButton meeting = new JButton("Register for Meeting Event");
        meeting.setBounds(400,420,500,60);
        meeting.addActionListener( e ->
        {
            f.dispose();
            MeetingRegistration ob = new MeetingRegistration();
            ob.main(null);
        });
        f.add(meeting);

        JButton workshop = new JButton("Register for Workshop Event");
        workshop.setBounds(400,520,500,60);
        workshop.addActionListener( e ->
        {
            f.dispose();
            Manage_Workshop ob = new Manage_Workshop();
            ob.main(null);
        });
        f.add(workshop);

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
        new EventsDashBoard();
    }
}
