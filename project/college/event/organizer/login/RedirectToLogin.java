package project.college.event.organizer.login;

import javax.swing.*;
import java.awt.*;

public class RedirectToLogin
    {
        public RedirectToLogin()
        {
            JFrame f =new JFrame("Redirecting....");
            JLabel title = new JLabel("You may now use the same credentials to sign in to the application",JLabel.CENTER);
            title.setBounds(300,10,1000,110);
            title.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
            f.add(title);
            f.setBackground(Color.cyan);
            f.setForeground(Color.black);

            JButton proceed = new JButton("Proceed to Login ");
            proceed.setBounds(625,200,300,50);
            f.add(proceed);
            proceed.addActionListener(e ->
            {
                //Calling Login Page again
                LoginPageDesign.main();
            });
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(1600,800);
            f.setLayout(null);
            f.setVisible(true);
        }

    public static  void main()
    {
        new RedirectToLogin();
    }
}
