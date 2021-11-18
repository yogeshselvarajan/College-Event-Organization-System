/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import javax.swing.JFrame;

/**
 *
 * @author shial
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginPage l = new LoginPage();
        l.setTitle("Login");
        l.setVisible(true);
        l.setBounds(10, 10, 370, 600);
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l.setResizable(false);
    }
    
}
