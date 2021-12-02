
package project.college.event.organizer.events;

import javax.swing.*;
import java.awt.*;

public class FineArtsReg
{
    public FineArtsReg()
    {
        // Creating the Frame and then setting the Title
        JFrame f =new JFrame("FINE ARTS REGISTRATION");
        JLabel title = new JLabel("FINE ARTS EVENT REGISTRATION",JLabel.CENTER);
        title.setBounds(400,05,600,25);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);

        /** Declaring the initial variables of the type JLabel for all the necessary labels */
        JLabel event_name,event_description,start_time;
        JLabel duration,event_ty,event_per,event_type,num_of_participants;
        JLabel schedule_event_id,college_id,email_id;

        /** "Event Name" Label and TextField Definition */
        event_name = new JLabel("Event Name ",JLabel.LEFT);
        event_name.setBounds(250,50,200,25);
        event_name.setFont(new Font("Calibri", Font.ITALIC, 22));
        JTextField event_name_field = new JTextField();
        event_name_field.setBounds(600,45,250,25);
        f.add(event_name);f.add(event_name_field);

        /** "Event Description" Label and TextArea Definition */
        event_description = new JLabel("Event Description ",JLabel.LEFT);
        event_description.setBounds(250,90,200,25);
        event_description.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(event_description);
        TextArea eventdescrip = new TextArea("",180,90,TextArea.SCROLLBARS_BOTH);
        eventdescrip.setBounds(600,90,250,70);
        f.add(eventdescrip);

        /** "Start Time" Label and HH , MM , AM/PM Choice List Declaration */

        start_time = new JLabel("Start Time");
        start_time.setBounds(250,165,200,30);
        start_time.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(start_time);

        /** declaration of event type */

        event_type = new JLabel("Start Time");
        event_type.setBounds(250,493,200,30);
        event_type.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(event_type);

        Choice event_ty = new Choice();
        event_ty.setBounds(700,300,45,25);
        event_ty.add("01"); event_ty.add("02"); event_ty.add("03"); event_ty.add("04"); event_ty.add("05");
        event_ty.add("06"); event_ty.add("07"); event_ty.add("08"); event_ty.add("09"); event_ty.add("10");

        f.add(event_ty);

        /** Choice List Declaration for Hours, Minutes and AM/PM */
        Choice HH = new Choice();
        Choice MM = new Choice();
        Choice AM_PM = new Choice();
        HH.setBounds(600,165,45,30);
        MM.setBounds(655,165,45,30);
        AM_PM.setBounds(705,165,45,30);
        f.add(HH);f.add(MM);f.add(AM_PM);

        /** Choice List Options for Hours */
        HH.add("01"); HH.add("02"); HH.add("03"); HH.add("04"); HH.add("05");
        HH.add("06"); HH.add("07"); HH.add("08"); HH.add("09"); HH.add("10");
        HH.add("11"); HH.add("12");
        f.add(HH);

        /** Choice List Options for Minutes */
        MM.add("00");
        MM.add("01"); MM.add("02"); MM.add("03"); MM.add("04"); MM.add("05");
        MM.add("06"); MM.add("07"); MM.add("08"); MM.add("09"); MM.add("10");
        MM.add("11"); MM.add("12"); MM.add("13"); MM.add("14"); MM.add("15");
        MM.add("16");MM.add("17");MM.add("18");MM.add("19");MM.add("20");
        MM.add("21");MM.add("22");MM.add("23");MM.add("24");MM.add("25");
        MM.add("26");MM.add("27");MM.add("28");MM.add("29");MM.add("25");
        MM.add("31");MM.add("32");MM.add("33");MM.add("34");MM.add("35");
        MM.add("36");MM.add("37");MM.add("38");MM.add("39");MM.add("40");
        MM.add("41");MM.add("42");MM.add("43");MM.add("44");MM.add("45");
        MM.add("46");MM.add("47");MM.add("48");MM.add("49");MM.add("50");
        MM.add("51");MM.add("52");MM.add("53");MM.add("54");MM.add("55");
        MM.add("56");MM.add("57");MM.add("58");MM.add("59");
        f.add(MM);

        /** Choice List Options for AM / PM */
        AM_PM.add("AM");AM_PM.add("PM");
        f.add(AM_PM);

        /** "Duration" Label and Text Field and Mins/Hours ChoiceList Declaration */
        duration = new JLabel("Duration");
        duration.setBounds(250,250,200,25);
        duration.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(duration);
        // TextField that takes the input (Hours or Mins)
        JTextField duration_field;
        duration_field = new JTextField();
        duration_field.setBounds(600,250,100,25);
        f.add(duration_field);
        // Choice List Declaration that shows Mins / Hours Options
        Choice dur = new Choice();
        dur.setBounds(725,250,70,25);
        dur.add("MINS"); dur.add("HOURS");
        f.add(dur);

        /** "Start Date" Label and Month, Date and Year Choice Declaration */
        event = new JLabel("Start Date");
        event_t.setBounds(250,300,200,25);
        event_t.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(event_t);

        /** Choice List Options for Month */
        Choice start_Month = new Choice();
        start_Month.setBounds(600,300,90,25);
        start_Month.add("January");
        start_Month.add("February");start_Month.add("March");start_Month.add("April");start_Month.add("May");
        start_Month.add("June");start_Month.add("July");start_Month.add("August");start_Month.add("September");
        start_Month.add("October");start_Month.add("November");start_Month.add("December");
        f.add(start_Month);

        /** Choice List Options for Date */
        Choice event_t = new Choice();
        event_t.setBounds(700,300,45,25);
        event_t.add("01"); event_ty.add("02"); event_ty.add("03"); event_ty.add("04"); event_ty.add("05");
        event_t.add("06"); event_ty.add("07"); event_ty.add("08"); event_ty.add("09"); event_ty.add("10");
        event_t.add("11"); event_ty.add("12"); event_ty.add("13"); event_ty.add("14"); event_ty.add("15");
        event_t.add("16");event_ty.add("17");event_ty.add("18");event_ty.add("19");event_ty.add("20");
        event_t.add("21");event_ty.add("22");event_ty.add("23");event_ty.add("24");event_ty.add("25");
        event_t.add("26");event_ty.add("27");event_ty.add("28");event_ty.add("29");event_ty.add("25");
        event_t.add("31");
        f.add(event_t);

        /** Choice List Options for Year */
        Choice start_Year = new Choice();
        start_Year.setBounds(750,300,100,25);
        start_Year.add("2021");start_Year.add("2022");start_Year.add("2023");start_Year.add("2024");
        start_Year.add("2025");
        f.add(start_Year);

        /** "Meeting Options" Label and Radio-Button Declaration */
        event_per = new JLabel("Event Type ");
        event_per.setBounds(250,345,200,25);
        event_per.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(event_per);

        /** Radio Button Declarations for Meeting Options */
        JRadioButton single,weekly,month;
        single = new JRadioButton("Solo");
        single.setBounds(600,345,100,25);

        weekly = new JRadioButton("Duo");
        weekly.setBounds(700,345,100,25);

        month = new JRadioButton("Group");
        month.setBounds(800,345,100,25);

        ButtonGroup bg=new ButtonGroup();
        bg.add(single);bg.add(weekly);bg.add(month);
        f.add(single);f.add(weekly);f.add(month);

        /** "Number of Participants" Label and TextField Declaration */
        num_of_participants=new JLabel("Number of Participants(If Group)");
        num_of_participants.setBounds(250,395,350,25);
        JTextField participants_field =new JTextField();
        participants_field.setBounds(600,395,90,25);
        num_of_participants.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(num_of_participants);f.add(participants_field);

        /** "Schedule Meeting with ID" Label and TextField Declaration */
        schedule_event_id = new JLabel("Schedule Event with ID");
        schedule_event_id.setBounds(250,445,400,25);
        schedule_event_id.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(schedule_event_id);
        JTextField meeting_id_field =new JTextField();
        meeting_id_field.setBounds(600,445,90,25);
        f.add(meeting_id_field);

        /** "College ID" Label and TextField Declaration */
        college_id = new JLabel("College ID");
        college_id.setBounds(250,545,200,25);
        college_id.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(college_id);
        JTextField id = new JTextField();
        id.setBounds(600,545,150,25);
        f.add(id);

        /** "Email ID" Label and TextField Declaration */
        email_id = new JLabel("Email ID");
        email_id.setBounds(250,595,200,25);
        email_id.setFont(new Font("Calibri", Font.ITALIC, 22));
        f.add(email_id);
        JTextField email = new JTextField();
        email.setBounds(600,595,200,25);
        f.add(email);

        /** Reset Button and its Listener Declaration */
        JButton reset = new JButton("Reset");
        reset.setBounds(500,670,100,30);
        reset.addActionListener(e -> {
            event_name_field.setText("");
            eventdescrip.setText("");
            duration_field.setText("");
            participants_field.setText("");
            meeting_id_field.setText("");
            id.setText("");
            email.setText("");
        });
        f.add(reset);

        /** Submit Button Declaration */
        JButton submit = new JButton("Schedule Event");
        submit.setBounds(650,670,170,30);
        f.add(submit);

        /**  Frame Properties Declarations  */
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,775);
        f.setLayout(null);
        f.setVisible(true);
    }
    public  static void main(String argv[])
    {
        new FineArtsReg();
    }
}
