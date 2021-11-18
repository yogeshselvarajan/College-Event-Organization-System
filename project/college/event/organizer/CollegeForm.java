package project.college.event.organizer;

import javax.swing.*;
import java.awt.*;

public class CollegeForm
{
    public CollegeForm()
    {
        JFrame f = new JFrame("College Form");

        JLabel title = new JLabel("REGISTER COLLEGE DETAILS",JLabel.CENTER);
        title.setBounds(500,10,400,110);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);

        JLabel name,id,description;

        name = new JLabel("Name :");
        name.setBounds(400,150,80,80);
        name.setFont(new Font("Calibri", Font.ITALIC, 24));

        id = new JLabel("College ID :");
        id.setBounds(400,200,200,80);
        id.setFont(new Font("Calibri", Font.ITALIC, 24));

        description = new JLabel("Description:");
        description.setBounds(400,250,120,80);
        description.setFont(new Font("Calibri", Font.ITALIC, 24));

        f.add(name);f.add(id);f.add(description);

        JButton submit = new JButton("Submit");
        submit.setBounds(520,117,100,30);
        submit.addActionListener(e -> {
            int input = JOptionPane.showConfirmDialog(null,
                    "Do you want to update your details ?", "Select an Option...",JOptionPane.YES_NO_CANCEL_OPTION);
            // 0=yes, 1=no, 2=cancel
            System.out.println(input);
        });
        f.add(submit);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    public  static void  main(String[] args)
    {
        new CollegeForm();
    }
}


