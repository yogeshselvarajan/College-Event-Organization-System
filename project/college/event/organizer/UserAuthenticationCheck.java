package project.college.event.organizer;

import java.awt.*;
import javax.swing.*;

public class UserAuthenticationCheck
{
    public UserAuthenticationCheck()
    {
        JFrame f = new JFrame("Confirm your Identity");
        JLabel title = new JLabel("Verify your account identity", JLabel.CENTER);
        title.setBounds(500, 10, 500, 110);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        f.add(title);
        f.setBackground(Color.cyan);
        f.setForeground(Color.black);


        JLabel choice;
        choice = new JLabel("Security Question : ");
        choice.setBounds(400, 133, 300, 30);
        choice.setFont(new Font("Calibri", Font.ITALIC, 24));
        f.add(choice);

        Choice choices;
        choices = new Choice();
        choices.setBounds(500,170,400,30);
        choices.add("Please Select");
        choices.add("What is the name of your first pet ?");
        choices.add("What was the first thing you learned to cook ?");
        choices.add("What was the first film you saw in the theatre ?");
        choices.add("Where did you go the first time when you flew in a plane ?");
        choices.add("What is the last name of your favourite elementary school teacher ?");
        f.add(choices);

        JLabel choice2;
        choice2 = new JLabel("Security Question : ");
        choice2.setBounds(400,210, 300, 30);
        choice2.setFont(new Font("Calibri", Font.ITALIC, 24));
        f.add(choice2);

        Choice choices2;
        choices2 = new Choice();
        choices2.setBounds(500,250,400,30);
        choices2.add("Please Select");
        choices2.add("What is your favourite movie ?");
        choices2.add("What was your child-hood nickname ?");
        choices2.add("What city or town was your first job in ?");
        choices2.add("What is the name of the first school you attended ?");
        choices2.add("What is the name of your favourite childhood friend ?");
        f.add(choices2);

        JLabel answer1,answer2;
        JTextField answer_field1,answer_field2;
        answer1 = new JLabel("Your Answer - 1 : ");
        answer1.setBounds(400,280, 300, 30);
        answer1.setFont(new Font("Calibri", Font.ITALIC, 24));
        answer_field1= new JTextField();
        answer_field1.setBounds(580,280,400,30);

        answer2 = new JLabel("Your Answer - 2 : ");
        answer2.setBounds(400,320, 300, 30);
        answer2.setFont(new Font("Calibri", Font.ITALIC, 24));
        answer_field2= new JTextField();
        answer_field2.setBounds(580,320,400,30);
        f.add(answer1);f.add(answer2);
        f.add(answer_field1);f.add(answer_field2);

        JButton submit ;
        submit = new JButton("Submit");
        submit.setBounds(600,370,80,50);
        f.add(submit);

        JButton reset = new JButton("Reset");
        reset.setBounds(700,370,80,50);
        reset.addActionListener(e -> {
              answer_field1.setText("");
              answer_field2.setText("");
        });
        f.add(reset);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1600,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    public  static void  main(String[] args)
    {
        new UserAuthenticationCheck();
    }
}

