package project.college.event.organizer;

import java.awt.*;
import javax.swing.*;

public class CollegeForm
{
    public CollegeForm()
    {
        JFrame f =new JFrame("College Registration Form");
        JLabel title = new JLabel("Enter the details",JLabel.CENTER);
        title.setBounds(500,10,400,110);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        f.add(title);

        JLabel name,mobile,email,address,password,confirm,id,degree,org;

        name = new JLabel("College Name :");
        name.setBounds(400,155,170,80);
        name.setFont(new Font("Calibri", Font.ITALIC, 24));

        email = new JLabel("E-Mail ID :");
        email.setBounds(400,205,120,80);
        email.setFont(new Font("Calibri", Font.ITALIC, 24));

        mobile = new JLabel("Mobile Number :");
        mobile.setBounds(400,255,200,80);
        mobile.setFont(new Font("Calibri", Font.ITALIC, 24));

        address = new JLabel("Address :");
        address.setBounds(400,305,120,80);
        address.setFont(new Font("Calibri", Font.ITALIC, 24));

        id = new JLabel("College ID :");
        id.setBounds(400,425,120,80);
        id.setFont(new Font("Calibri", Font.ITALIC, 24));

        password = new JLabel("Password :");
        password.setBounds(400,475,120,80);
        password.setFont(new Font("Calibri", Font.ITALIC, 24));

        confirm = new JLabel("Confirm password");
        confirm.setBounds(400,525,200,80);
        confirm.setFont(new Font("Calibri",Font.ITALIC,24));

        degree = new JLabel("Degree :");
        degree.setBounds(400,600,150,80);
        degree.setFont(new Font("Calibri", Font.ITALIC, 24));

        org = new JLabel("Organization :");
        org.setBounds(400,650,150,80);
        org.setFont(new Font("Calibri", Font.ITALIC, 24));


        f.add(name);f.add(mobile);f.add(email);f.add(address);
        f.add(degree);f.add(password);
        f.add(org);f.add(id);f.add(confirm);

        JTextField name1,mobile1,email1,password1,id1,confirm1;

        name1 = new JTextField();
        name1.setBounds(600,174,300,30);

        mobile1 = new JTextField();
        mobile1.setBounds(600,225,180,30);

        email1 = new JTextField();
        email1.setBounds(600,275,210,30);

        TextArea address1 = new TextArea("",180,90,TextArea.SCROLLBARS_VERTICAL_ONLY);
        address1.setBounds(600,335,400,90);

        id1 = new JTextField();
        id1.setBounds(600,445,180,30);

        password1 = new JTextField();
        password1.setBounds(600,495,180,30);

        confirm1 = new JTextField();
        confirm1.setBounds(600,545,180,30);

        Choice c = new Choice();
        c.setBounds(600,625,300,30);


        c.add("Select option");
        c.add("Engineering");
        c.add("Arts and science");
        f.add(c);

        CheckboxGroup cbg=new CheckboxGroup();
        Checkbox c1=new Checkbox("Private",false,cbg);
        c1.setBounds(600,675,70,30);
        Checkbox c2=new Checkbox("Government",false,cbg);
        c2.setBounds(670,675,90,30);


        f.add(name1);f.add(mobile1);f.add(email1);
        f.add(address1);f.add(id1);f.add(password1);
        f.add(confirm1);f.add(c1);f.add(c2);

        JButton submit = new JButton("Submit");
        submit.setBounds(520,117,100,30);
        submit.addActionListener(e -> {
            int input = JOptionPane.showConfirmDialog(null,
                    "Are you sure to create a ID with the given details?", "Confirmation tab",JOptionPane.YES_NO_CANCEL_OPTION);
        });
        f.add(submit);

        JButton reset = new JButton("Reset");
        reset.setBounds(720,117,100,30);
        reset.addActionListener(e -> {
            name1.setText("");
            mobile1.setText("");
            email1.setText("");
            password1.setText("");
            id1.setText("");
            confirm1.setText("");
            address1.setText("");
        });
        f.add(reset);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,800);
        f.setLayout(null);
        f.setVisible(true);
        reset.setFocusable(false);
        submit.setFocusable(false);
        c.setFocusable(false);
        c1.setFocusable(false);
        c2.setFocusable(false);
    }
    public  static void  main(String[] args)
    {
        new CollegeForm();
    }

}

