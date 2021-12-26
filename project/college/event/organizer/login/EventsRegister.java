package project.college.event.organizer.login;

import project.college.event.organizer.display.eventmanage.finearts.FineArtsClass;
import project.college.event.organizer.events.*;

import javax.swing.*;
import java.awt.*;

public class EventsRegister
{
    public EventsRegister() {
        JFrame f = new JFrame("Register for Events");
        f.getContentPane().setBackground(new Color(255,182,193));
        JLabel title = new JLabel("Welcome to the Registration Page", JLabel.CENTER);
        title.setForeground(new Color(138,43,226));
        title.setBounds(350, 10, 600, 110);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        f.add(title);


        JButton culturals = new JButton("Register for Culturals Event");
        culturals.setBackground(new Color(95,158,160));
        culturals.setForeground(new Color(255,255,255));
        culturals.setBounds(400, 118, 500, 60);
        culturals.addActionListener(e ->
        {
            f.dispose();
            CulturalsRegistration ob = new CulturalsRegistration();
            ob.main(null);
        });
        f.add(culturals);

        JButton extracurricular = new JButton("Register for Extra Curricular Event");
        extracurricular.setBounds(400,220,500,60);
        extracurricular.setBackground(new Color(95,158,160));
        extracurricular.setForeground(new Color(255,255,255));
        extracurricular.addActionListener(e ->
        {
            f.dispose();
            ExtraCurricularEventReg ob = new ExtraCurricularEventReg();
            ob.main(null);
        });
        f.add(extracurricular);

        JButton finearts = new JButton("Register for FineArts Event");
        finearts.setBackground(new Color(95,158,160));
        finearts.setForeground(new Color(255,255,255));
        finearts.setBounds(400,320,500,60);
        finearts.addActionListener( e ->
        {
            f.dispose();
            FineArtsReg ob = new FineArtsReg();
            ob.main(null);
        });
        f.add(finearts);

        JButton meeting = new JButton("Register for Meeting Event");
        meeting.setBounds(400,420,500,60);
        meeting.setBackground(new Color(95,158,160));
        meeting.setForeground(new Color(255,255,255));
        meeting.addActionListener( e ->
        {
             f.dispose();
             MeetingRegistration ob = new MeetingRegistration();
             ob.main(null);
        });
        f.add(meeting);

        JButton workshop = new JButton("Register for Workshop Event");
        workshop.setBounds(400,520,500,60);
        workshop.setBackground(new Color(95,158,160));
        workshop.setForeground(new Color(255,255,255));
        workshop.addActionListener( e ->
        {
            f.dispose();
            WorkshopReg ob = new WorkshopReg();
            ob.main(null);
        });
        f.add(workshop);

        JButton Exit = new JButton("Exit Application");
        Exit.setBounds(400,620,500,60);
        Exit.setBackground(new Color(95,158,160));
        Exit.setForeground(new Color(255,255,255));
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
        new EventsRegister();
    }

}

