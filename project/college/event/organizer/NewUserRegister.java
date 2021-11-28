package project.college.event.organizer;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class NewUserRegister
{
    public NewUserRegister()
    {
        JFrame f =new JFrame("Registration FORM");
        JLabel title = new JLabel("New User Register",JLabel.CENTER);
        title.setBounds(500,10,400,110);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);


        JLabel name,mobile,email,address,question_2 ,question_1 ,college_id,course,_class,section;

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

        question_1 = new JLabel("Security Question - 1  : ");
        question_1 .setBounds(400,420,200,80);
        question_1 .setFont(new Font("Calibri", Font.ITALIC, 20));
        String[] question_set_1 =
                {
                   "Please Select",
                   "What is the name of your first pet ?",
                    "What was the first thing you learned to cook ?",
                    "What was the first film you saw in the theatre ?",
                    "Where did you go the first time when you flew in a plane ?",
                    "What is the last name of your favourite elementary school teacher ?"
                };
        JComboBox qno1 = new JComboBox (question_set_1);
        qno1.setBounds(600,440,400,30);
        f.add(qno1);
        JTextField answer1 = new JTextField();
        answer1.setBounds(1040,440,300,30);
        f.add(answer1);

        question_2 = new JLabel("Security Question - 2 : ");
        question_2.setBounds(400,470,200,80);
        question_2.setFont(new Font("Calibri", Font.ITALIC, 20));
        String[] question_set_2 = {"Please Select",
                                   "What is your favourite movie ?",
                                   "What was your child-hood nickname ?",
                                   "What city or town was your first job in ?",
                                   "What is the name of the first school you attended ?",
                                   "What is the name of your favourite childhood friend ?"
                                  };
        JComboBox qno2 = new JComboBox(question_set_2);
        qno2.setBounds(600,490,400,30);
        f.add(qno2);
        JTextField answer2 = new JTextField();
        answer2.setBounds(1040,490,300,30);
        f.add(answer2);

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
        f.add(question_1);f.add(question_2);f.add(college_id);f.add(course);
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

        college_id1 = new JTextField();
        college_id1.setBounds(600,540,180,30);

        Choice birthday_Date = new Choice();
        birthday_Date.setBounds(600,595,45,30);
        Choice birthday_Month = new Choice();
        birthday_Month.setBounds(660,595,120,30);
        Choice birthday_Year = new Choice();
        birthday_Year.setBounds(800,595,100,30);


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

        String[] question_course_stream =
                {
                        "Select your Course",
                        "B.E. Computer Science and Engineering",
                        "B.E. Artificial Intelligence and Data Science",
                        "B.E. BioTechnology",
                        "B.E. BioMedical Engineering",
                        "B.E.Electronics and Communication Engineering",
                        "B.E. Information Technology",
                        "B.E. Mechanical Engineering",
                        "B.E. Civil Engineering",
                };
        JComboBox department = new JComboBox(question_course_stream);
        department.setBounds(600,647,300,30);
        f.add(department);

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
        f.add(address1);f.add(qno1);
        f.add(college_id1);f.add(ck1);f.add(ck2);f.add(ck3);f.add(ck4);

        JButton submit = new JButton("Submit");
        submit.setBounds(520,117,100,30);
        submit.addActionListener(e -> {
            String Name = name1.getText();
            String Mobile = mobile1.getText();
            String emailID = email.getText().toString();
            String Address = address1.getText();
            String Answer1 = answer1.getText();
            String Answer2 = answer2.getText();
            String CollegeID = college_id1.getText();
            int len = Mobile.length();
            String msg = "" + Name;
            msg += " \n";

            //Check the length of the Mobile Number
            if (len != 10) {
                JOptionPane.showMessageDialog(submit, "Enter a valid mobile number");
            }
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "localhost");

                        String query = "INSERT INTO students values('" + Name + "','" + Mobile + "','" + emailID + "','" +
                                Address + "','" + Answer1 + "','" + Answer2 + "','" + CollegeID + "')";

                        Statement sta = connection.createStatement();
                        int x = sta.executeUpdate(query);
                        if (x == 0) {
                            JOptionPane.showMessageDialog(submit, "This is already exist");
                        } else {
                            JOptionPane.showMessageDialog(submit,
                                    "Welcome, " + msg + "Your account is successfully created");
                        }
                        connection.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
        });
        f.add(submit);

        JButton reset = new JButton("Reset");
        reset.setBounds(720,117,100,30);
        reset.addActionListener(e -> {
            name1.setText("");
            mobile1.setText("");
            email1.setText("");
            address1.setText("");
            qno1.setSelectedItem("Please Select");
            qno2.setSelectedItem("Please Select");
            college_id1.setText("");
            department.setSelectedItem("Select your Course");
        });
        f.add(reset);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    public  static void  main(String[] args)
    {
        new NewUserRegister();
    }

 }

