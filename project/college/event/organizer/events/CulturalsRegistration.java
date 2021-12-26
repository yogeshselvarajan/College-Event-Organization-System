package project.college.event.organizer.events;

import project.college.event.organizer.login.RedirectToLogin;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Objects;

public class CulturalsRegistration
{
    public CulturalsRegistration()
    {
        // Creating the Frame and then setting the Title
        JFrame f =new JFrame("SCHEDULE AN EVENT");
        f.getContentPane().setBackground(new Color(95,158,160));
        JLabel title = new JLabel("CULTURALS FEST REGISTRATION FORM",JLabel.CENTER);
        title.setBounds(400,05,600,25);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);

        /** Declaring the initial variables of the type JLabel for all the necessary labels */
        JLabel student_name,year,department,age,college_name;
        JLabel contact_num,name_of_faculty,email_id;
        JLabel events_available;

        /** "Student Name" Label and TextField Definition */
        student_name = new JLabel("Student Name ",JLabel.LEFT);
        student_name.setBounds(250,50,200,25);
        student_name.setFont(new Font("Calibri", Font.ITALIC, 18));
        JTextField student_name_field = new JTextField();
        student_name_field.setBounds(400,45,250,25);
        f.add(student_name);f.add(student_name_field);

        /** "Department" Label and ChoiceBox Definition */
        department = new JLabel(" Department ",JLabel.LEFT);
        department.setBounds(250,90,120,25);
        department.setFont(new Font("Calibri", Font.ITALIC, 18));
        f.add(department);
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
        JComboBox department_box = new JComboBox(question_course_stream);
        department_box.setBounds(400,90,300,30);
        f.add(department_box);

        /** "Year and Section" Label and TextField Definition */
        year = new JLabel("Year & Section ");
        year.setBounds(250,130,120,25);
        year.setFont(new Font("Calibri", Font.ITALIC, 18));
        f.add(year);
        JTextField year_field = new JTextField();
        year_field.setBounds(400,130,250,25);
        f.add(year_field);

        /** "Age" Label and TextField Definition */
        age = new JLabel("Age ");
        age.setBounds(250,170,120,25);
        age.setFont(new Font("Calibri", Font.ITALIC, 18));
        f.add(age);
        JTextField age_field = new JTextField();
        age_field.setBounds(400,170,50,25);
        f.add(age_field);

        /** "College Name" Label and TextField Definition */
        college_name = new JLabel("College Name ");
        college_name.setBounds(250,210,120,25);
        college_name.setFont(new Font("Calibri", Font.ITALIC, 18));
        f.add(college_name);
        JTextField college_name_field = new JTextField();
        college_name_field.setBounds(400,210,250,25);
        f.add(college_name_field);

         /** "Contact Number" Label and TextField Definition */
        contact_num = new JLabel("Contact Number ");
        contact_num.setBounds(250,250,150,25);
        contact_num.setFont(new Font("Calibri", Font.ITALIC, 17));
        f.add(contact_num);
        JTextField contact_num_field = new JTextField();
        contact_num_field.setBounds(400,250,250,25);
        f.add(contact_num_field);

        /** "Name of Faculty" Label and TextField Definition */
        name_of_faculty = new JLabel("Name of Faculty ");
        name_of_faculty.setBounds(250,290,150,25);
        name_of_faculty.setFont(new Font("Calibri", Font.ITALIC, 17));
        f.add(name_of_faculty);
        JTextField name_of_faculty_field = new JTextField();
        name_of_faculty_field.setBounds(400,290,250,25);
        f.add(name_of_faculty_field);

        /** "Email ID" Label and TextField Definition */
        email_id = new JLabel("Email ID ");
        email_id.setBounds(250,330,150,25);
        email_id.setFont(new Font("Calibri", Font.ITALIC, 17));
        f.add(email_id);
        JTextField email_id_field = new JTextField();
        email_id_field.setBounds(400,330,250,25);
        f.add(email_id_field);

        /** "Events Available" Label and ChoiceBox Definition */
        events_available = new JLabel("Events Available");
        events_available.setBounds(250,370,150,25);
        events_available.setFont(new Font("Calibri", Font.ITALIC, 17));
        f.add(events_available);

        CheckboxGroup check_box_group = new CheckboxGroup();
        final Checkbox ck1=new Checkbox("Solo Singing",false);
        ck1.setBounds(400,370,200,30);
        final Checkbox ck2=new Checkbox("Jam",false);
        ck2.setBounds(400,395,80,30);
        final Checkbox ck3 = new Checkbox("Classical Bhajan",false);
        ck3.setBounds(400,420,200,30);
        final Checkbox ck4 = new Checkbox("Rock Band",false);
        ck4.setBounds(400,455,200,30);
        final Checkbox ck5 = new Checkbox("Debate",false);
        ck5.setBounds(400,480,200,30);
        final Checkbox ck6 = new Checkbox("Group Dance",false);
        ck6.setBounds(400,505,200,30);
        final Checkbox ck7 = new Checkbox("Bharathanatyam",false);
        ck7.setBounds(400,530,200,30);
        final Checkbox ck8 = new Checkbox("Instrumental Fashion",false);
        ck8.setBounds(400,555,200,30);
        final Checkbox ck9 = new Checkbox("Brass Band",false);
        ck9.setBounds(400,580,200,30);
        final Checkbox ck10 = new Checkbox("Battle of Bands",false);
        ck10.setBounds(400,605,200,30);
        final Checkbox ck11 = new Checkbox("Folk arts and Music",false);
        ck11.setBounds(400,630,200,30);
        final Checkbox ck12 = new Checkbox("Quiz",false);
        ck12.setBounds(400,655,200,30);
        f.add(ck1);f.add(ck2);f.add(ck3);f.add(ck4);f.add(ck5);
        f.add(ck6);f.add(ck7);f.add(ck8);f.add(ck9);f.add(ck10);
        f.add(ck11);f.add(ck12);

        JButton submit = new JButton("Submit");
        submit.setBounds(500,690,100,30);

        submit.addActionListener( e ->
        {
            String Name = student_name_field.getText();
            String Department = Objects.requireNonNull(department_box.getSelectedItem()).toString();
            String Year_Section = year_field.getText();
            String Age = age_field.getText();
            String College_Name = college_name_field.getText();
            String Contact_Number = contact_num_field.getText();
            String Name_of_Faculty = name_of_faculty_field.getText();
            String Email = email_id_field.getText();
            String Event_Choosen = "";
            if (ck1.getState())
                Event_Choosen +=ck1.getLabel()+ ",";
            if (ck2.getState())
                Event_Choosen += ck2.getLabel() + ",";
            if (ck3.getState())
                Event_Choosen += ck3.getLabel() + ",";
            if (ck4.getState())
                Event_Choosen += ck4.getLabel() + ",";
            if (ck5.getState())
                Event_Choosen += ck5.getLabel() + ",";
            if (ck6.getState())
                Event_Choosen += ck6.getLabel() + ",";
            if (ck7.getState())
                Event_Choosen += ck7.getLabel() + ",";
            if (ck8.getState())
                Event_Choosen += ck8.getLabel() + ",";
            if (ck9.getState())
                Event_Choosen += ck9.getLabel() + ",";
            if (ck10.getState())
                Event_Choosen += ck10.getLabel() + ",";
            if (ck11.getState())
                Event_Choosen += ck11.getLabel() + ",";
            if (ck12.getState())
                Event_Choosen += ck12.getLabel() + ",";

            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");
                PreparedStatement pst;
                pst = conn.prepareStatement("insert into culturals(StudentName,Department,Year_Section,Age,CollegeName,ContactNumber,NameofFaculty,EmailID,EventsRegistered)values(?,?,?,?,?,?,?,?,?)");
                pst.setString(1,Name);
                pst.setString(2,Department);
                pst.setString(3,Year_Section);
                pst.setString(4,Age);
                pst.setString(5,College_Name);
                pst.setString(6,Contact_Number);
                pst.setString(7,Name_of_Faculty);
                pst.setString(8,Email);
                pst.setString(9,Event_Choosen);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(submit,"You have been successfully registered for the Cultural Programme...  !!");
                conn.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });

        f.add(submit);

        /**  Frame Properties Declarations  */
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,775);
        f.setLayout(null);
        f.setVisible(true);
    }
    public  static void main(String argv[])
    {
        new CulturalsRegistration();
    }

    }

