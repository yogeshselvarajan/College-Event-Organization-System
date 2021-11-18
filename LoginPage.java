/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loginpage;


import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class LoginPage extends JFrame implements ActionListener
{
      Container container = getContentPane();
      JLabel userlabel,passwordlabel;
      JTextField usertext,passwordtext;
      JButton login,reset;
      JCheckBox showpass;
      
      
      LoginPage()
      {
         container.setBackground(Color.green);
         container.setLayout(null);
         container.setForeground(Color.BLACK);
         userlabel.setBounds(50, 150, 100, 30);
         passwordlabel.setBounds(50, 220, 100, 30);
         usertext.setBounds(150, 150, 150, 30);
         passwordtext.setBounds(150, 220, 150, 30);
         showpass.setBounds(150, 250, 150, 30);
         login.setBounds(50, 300, 100, 30);
         reset.setBounds(200, 300, 100, 30);
         container.add(userlabel);
         container.add(passwordlabel);
         container.add(usertext);
         container.add(passwordtext);
         container.add(showpass);
         container.add(login);
         container.add(reset);
         login.addActionListener(this);
         reset.addActionListener(this);
         showpass.addActionListener(this);
         
      }
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
          if(e.getSource() == login)
          {
              String user,password;
              user = usertext.getText();
              password = passwordtext.getText();
              JOptionPane.showMessageDialog(this,"Loin successful!");
              
          }
          
          if(e.getSource() == reset)
          {
              usertext.setText(" ");
              passwordtext.setText(" ");
          }
          
  //       if(e.getSource() == showpass)
          {
    //          if(showpass.isSelected())
              
      //            passwordtext.setEchoChar((char) 0);
     //         else
     //             passwordtext.setEchoChar('*');
          }       
                  
          }
      }  
          
         
