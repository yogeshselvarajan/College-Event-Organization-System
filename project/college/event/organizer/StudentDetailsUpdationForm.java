package project.college.event.organizer;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StudentDetailsUpdationForm
{
    public StudentDetailsUpdationForm()
    {
        JFrame f =new JFrame("UPDATING FORM");
        JLabel title = new JLabel("UPDATE YOUR DETAILS",JLabel.CENTER);
        title.setBounds(500,10,400,110);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);


        JLabel name,mobile,email,address,password,username,college_id,course,_class,section;

        name = new JLabel("Name :");
        name.setBounds(400,150,80,80);
        name.setFont(new Font("Calibri", Font.ITALIC, 24));

        mobile = new JLabel("Mobile Number :");
        mobile.setBounds(400,200,200,80);
        mobile.setFont(new Font("Calibri", Font.ITALIC, 24));

        email = new JLabel("E-Mail ID :");
        email.setBounds(400,250,120,80);
        email.setFont(new Font("Calibri", Font.ITALIC, 24));

        address = new JLabel("Address :");
        address.setBounds(400,300,120,80);
        address.setFont(new Font("Calibri", Font.ITALIC, 24));

        username = new JLabel("Username :");
        username.setBounds(400,420,120,80);
        username.setFont(new Font("Calibri", Font.ITALIC, 24));

        password = new JLabel("Password :");
        password.setBounds(400,470,120,80);
        password.setFont(new Font("Calibri", Font.ITALIC, 24));

        college_id = new JLabel("College ID :");
        college_id.setBounds(400,520,120,80);
        college_id.setFont(new Font("Calibri", Font.ITALIC, 24));

        course = new JLabel("Birthday :");
        course.setBounds(400,570,200,80);
        course.setFont(new Font("Calibri", Font.ITALIC, 24));

        _class = new JLabel("Department :");
        _class.setBounds(400,620,150,80);
        _class.setFont(new Font("Calibri", Font.ITALIC, 24));

        section = new JLabel("Section :");
        section.setBounds(400,670,150,80);
        section.setFont(new Font("Calibri", Font.ITALIC, 24));


        /** ADDING COMPONENTS INTO THE FRAME CREATED */
        f.add(name);f.add(mobile);f.add(email);f.add(address);
        f.add(username);f.add(password);f.add(college_id);f.add(course);
        f.add(_class);f.add(section);
        /************** END OF THE LABEL PART **********************/

        /** DECLARATION OF THE TEXT BOXES*/
        JTextField name1,mobile1,email1,password1,username1,college_id1;

        name1 = new JTextField();
        name1.setBounds(600,163,300,30);

        mobile1 = new JTextField();
        mobile1.setBounds(600,218,180,30);

        email1 = new JTextField();
        email1.setBounds(600,270,210,30);

        TextArea address1 = new TextArea("",180,90,TextArea.SCROLLBARS_BOTH);
        address1.setBounds(600,327,400,90);

        username1 = new JTextField();
        username1.setBounds(600,440,180,30);

        password1 = new JTextField();
        password1.setBounds(600,490,180,30);

        college_id1 = new JTextField();
        college_id1.setBounds(600,540,180,30);

        Choice birthday_Date = new Choice();
        birthday_Date.setBounds(600,595,45,30);
        Choice birthday_Month = new Choice();
        birthday_Month.setBounds(660,595,120,30);
        Choice birthday_Year = new Choice();
        birthday_Year.setBounds(800,595,100,30);

        Choice education = new Choice();
        education.setBounds(600,647,300,30);


        birthday_Date.add("DD");
        birthday_Date.add("01"); birthday_Date.add("02"); birthday_Date.add("03"); birthday_Date.add("04"); birthday_Date.add("05");
        birthday_Date.add("06"); birthday_Date.add("07"); birthday_Date.add("08"); birthday_Date.add("09"); birthday_Date.add("10");
        birthday_Date.add("11"); birthday_Date.add("12"); birthday_Date.add("13"); birthday_Date.add("14"); birthday_Date.add("15");
        birthday_Date.add("16");birthday_Date.add("17");birthday_Date.add("18");birthday_Date.add("19");birthday_Date.add("20");
        birthday_Date.add("21");birthday_Date.add("22");birthday_Date.add("23");birthday_Date.add("24");birthday_Date.add("25");
        birthday_Date.add("26");birthday_Date.add("27");birthday_Date.add("28");birthday_Date.add("29");birthday_Date.add("30");
        birthday_Date.add("31");
        f.add(birthday_Date);


        birthday_Month.add("Month");birthday_Month.add("January");
        birthday_Month.add("February");birthday_Month.add("March");birthday_Month.add("April");birthday_Month.add("May");
        birthday_Month.add("June");birthday_Month.add("July");birthday_Month.add("August");birthday_Month.add("September");
        birthday_Month.add("October");birthday_Month.add("November");birthday_Month.add("December");
        f.add(birthday_Month);

        birthday_Year.add("YYYY");
        birthday_Year.add("1985");birthday_Year.add("1986");birthday_Year.add("1987");birthday_Year.add("1988");
        birthday_Year.add("1989");birthday_Year.add("1990");birthday_Year.add("1991");birthday_Year.add("1992");
        birthday_Year.add("1993");birthday_Year.add("1994");birthday_Year.add("1995");birthday_Year.add("1996");
        birthday_Year.add("1997");birthday_Year.add("1998");birthday_Year.add("1999");birthday_Year.add("2000");
        birthday_Year.add("2001");birthday_Year.add("2002");birthday_Year.add("2003");birthday_Year.add("2004");
        birthday_Year.add("2005");birthday_Year.add("2006");birthday_Year.add("2007");birthday_Year.add("2008");
        f.add(birthday_Year);

        education.add("Select your Course");
        education.add("B.E. Computer Science and Engineering");
        education.add("B.E. Artificial Intelligence and Data Science");
        education.add("B.E. BioTechnology");
        education.add("B.E. BioMedical Engineering");
        education.add("B.E.Electronics and Communication Engineering");
        education.add("B.E. Information Technology");
        education.add("B.E. Mechanical Engineering");
        education.add("B.E. Civil Engineering");
        f.add(education);

        CheckboxGroup cbg=new CheckboxGroup();
        Checkbox ck1=new Checkbox("A",false,cbg);
        ck1.setBounds(600,690,45,30);
        Checkbox ck2=new Checkbox("B",false,cbg);
        ck2.setBounds(670,690,45,30);
        Checkbox ck3 = new Checkbox("C",false,cbg);
        ck3.setBounds(740,690,45,30);
        Checkbox ck4 = new Checkbox("D",false,cbg);
        ck4.setBounds(810,690,45,30);

        f.add(name1);f.add(mobile1);f.add(email1);
        f.add(address1);f.add(username1);f.add(password1);
        f.add(college_id1);f.add(ck1);f.add(ck2);f.add(ck3);f.add(ck4);

        JButton submit = new JButton("Submit");
        submit.setBounds(520,117,100,30);
        submit.addActionListener(e -> {
            int input = JOptionPane.showConfirmDialog(null,
                    "Do you want to update your details ?", "Select an Option...",JOptionPane.YES_NO_CANCEL_OPTION);
            // 0=yes, 1=no, 2=cancel
            System.out.println(input);
        });
        f.add(submit);

        JButton reset = new JButton("Reset");
        reset.setBounds(720,117,100,30);
        reset.addActionListener(e -> {
            name1.setText("");
           /// name1,mobile1,email1,password1,username1,college_id1
            mobile1.setText("");
            email1.setText("");
            password1.setText("");
            username1.setText("");
            college_id1.setText("");
            address1.setText("");
        });
        f.add(reset);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    public  static void  main(String[] args)
    {
        new StudentDetailsUpdationForm();
    }

 }

