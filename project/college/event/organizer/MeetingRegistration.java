package project.college.event.organizer;

import java.awt.*;
import javax.swing.*;

public class MeetingRegistration
{
    public MeetingRegistration()
    {
        JFrame f =new JFrame("SCHEDULE A MEETING FORM");
        JLabel title = new JLabel("SCHEDULE A MEETING",JLabel.CENTER);
        title.setBounds(500,05,400,30);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);

        JLabel meeting_name,meeting_description,meeting_type;
        JLabel start_time,duration,start_date,meeting_options,num_of_participants;
        JLabel schedule_meeting_id,meeting_password,college_id,email_id;

        JTextField meetingname;

        meeting_name = new JLabel("Meeting Name ",JLabel.LEFT);
        meeting_name.setBounds(250,50,200,30);
        meeting_name.setFont(new Font("Calibri", Font.ITALIC, 22));

        meetingname = new JTextField();
        meetingname.setBounds(600,45,300,30);
        f.add(meeting_name);f.add(meetingname);

        meeting_description = new JLabel("Meeting Description ",JLabel.LEFT);
        meeting_description.setBounds(250,90,200,30);
        meeting_description.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(meeting_description);

        TextArea meetingdescrip = new TextArea("",180,90,TextArea.SCROLLBARS_BOTH);
        meetingdescrip.setBounds(600,90,300,70);
        f.add(meetingdescrip);

        start_time = new JLabel("Start Time");
        start_time.setBounds(250,165,200,30);
        start_time.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(start_time);

        Choice HH = new Choice();
        HH.setBounds(600,165,45,30);
        Choice MM = new Choice();
        MM.setBounds(655,165,45,30);
        Choice AM_PM = new Choice();
        AM_PM.setBounds(705,165,45,30);
        f.add(HH);f.add(MM);f.add(AM_PM);

        HH.add("01"); HH.add("02"); HH.add("03"); HH.add("04"); HH.add("05");
        HH.add("06"); HH.add("07"); HH.add("08"); HH.add("09"); HH.add("10");
        HH.add("11"); HH.add("12");
        f.add(HH);

        MM.add("00");
        MM.add("01"); MM.add("02"); MM.add("03"); MM.add("04"); MM.add("05");
        MM.add("06"); MM.add("07"); MM.add("08"); MM.add("09"); MM.add("10");
        MM.add("11"); MM.add("12"); MM.add("13"); MM.add("14"); MM.add("15");
        MM.add("16");MM.add("17");MM.add("18");MM.add("19");MM.add("20");
        MM.add("21");MM.add("22");MM.add("23");MM.add("24");MM.add("25");
        MM.add("26");MM.add("27");MM.add("28");MM.add("29");MM.add("30");
        MM.add("31");MM.add("32");MM.add("33");MM.add("34");MM.add("35");
        MM.add("36");MM.add("37");MM.add("38");MM.add("39");MM.add("40");
        MM.add("41");MM.add("42");MM.add("43");MM.add("44");MM.add("45");
        MM.add("46");MM.add("47");MM.add("48");MM.add("49");MM.add("50");
        MM.add("51");MM.add("52");MM.add("53");MM.add("54");MM.add("55");
        MM.add("56");MM.add("57");MM.add("58");MM.add("59");
        f.add(MM);
        AM_PM.add("AM");AM_PM.add("PM");
        f.add(AM_PM);

        meeting_type= new JLabel("Meeting Type");
        meeting_type.setBounds(250,200,200,30);
        meeting_type.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(meeting_type);

        duration = new JLabel("Duration");
        duration.setBounds(250,250,200,30);
        duration.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(duration);

        JTextField duration1;
        duration1 = new JTextField();
        duration1.setBounds(600,250,100,30);
        f.add(duration1);

        Choice dur = new Choice();
        dur.setBounds(725,250,70,30);
        dur.add("MINS"); dur.add("HOURS");
        f.add(dur);

        start_date = new JLabel("Start Date");
        start_date.setBounds(250,300,200,30);
        start_date.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(start_date);

        Choice start_Month = new Choice();
        start_Month.setBounds(600,300,90,30);
        start_Month.add("January");
        start_Month.add("February");start_Month.add("March");start_Month.add("April");start_Month.add("May");
        start_Month.add("June");start_Month.add("July");start_Month.add("August");start_Month.add("September");
        start_Month.add("October");start_Month.add("November");start_Month.add("December");
        f.add(start_Month);

        Choice start_Date = new Choice();
        start_Date.setBounds(700,300,45,30);
        start_Date.add("01"); start_Date.add("02"); start_Date.add("03"); start_Date.add("04"); start_Date.add("05");
        start_Date.add("06"); start_Date.add("07"); start_Date.add("08"); start_Date.add("09"); start_Date.add("10");
        start_Date.add("11"); start_Date.add("12"); start_Date.add("13"); start_Date.add("14"); start_Date.add("15");
        start_Date.add("16");start_Date.add("17");start_Date.add("18");start_Date.add("19");start_Date.add("20");
        start_Date.add("21");start_Date.add("22");start_Date.add("23");start_Date.add("24");start_Date.add("25");
        start_Date.add("26");start_Date.add("27");start_Date.add("28");start_Date.add("29");start_Date.add("30");
        start_Date.add("31");
        f.add(start_Date);

        Choice start_Year = new Choice();
        start_Year.setBounds(750,300,100,30);
        start_Year.add("2021");start_Year.add("2022");start_Year.add("2023");start_Year.add("2024");
        start_Year.add("2025");
        f.add(start_Year);

        meeting_options = new JLabel("Meeting Options ");
       // meeting_options.setBounds(250,);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    public  static void  main(String[] args)
    {
        new MeetingRegistration();
    }

}

