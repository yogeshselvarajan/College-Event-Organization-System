package project.college.event.organizer.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class UserDashBoard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserDashBoard frame = new UserDashBoard();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserDashBoard() {

    }

    /**
     * Create the frame.
     */
    public UserDashBoard(String userSes) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground((new Color(221,160,221)));
        JButton btnNewButton = new JButton("Logout");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground((new Color(255,127,80)));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    MainLoginPage obj = new MainLoginPage();
                    obj.setTitle("Student-Login");
                    obj.setVisible(true);
                }
                dispose();
                MainLoginPage obj = new MainLoginPage();

                obj.setTitle("Student-Login");
                obj.setVisible(true);

            }
        });

        JButton btnRegisterEvents = new JButton("Register Events ");
        btnRegisterEvents.setForeground(new Color(0, 0, 0));
        btnRegisterEvents.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnRegisterEvents.setBackground((new Color(255,127,80)));
        btnRegisterEvents.addActionListener(e ->
        {
            dispose();
            EventsRegister ob = new EventsRegister();
            ob.main(null);

        });
        btnRegisterEvents.setBounds(400,300,200,30);
        contentPane.add(btnRegisterEvents);
        btnNewButton.setBounds(400, 118, 200, 30);
        contentPane.add(btnNewButton);
        JButton button = new JButton("Change password\r\n");
        button.setBackground((new Color(255,127,80)));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassword bo = new ChangePassword(userSes);
                bo.setTitle("Change Password");
                bo.setVisible(true);
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 30));
        button.setBounds(270, 200, 400, 30);
        contentPane.add(button);
    }
}