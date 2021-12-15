package project.college.event.organizer.display;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Update {

    public static void main(String[] args){

        // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable();

        // create a table model and set a Column Identifiers to this model
        Object[] columns = {"Id","First Name","Last Name","Age"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        // set the model to the table
        table.setModel(model);

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);

        // create JTextFields
        JTextField textId = new JTextField();
        JTextField textFname = new JTextField();
        JTextField textLname = new JTextField();
        JTextField textAge = new JTextField();

        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");

        textId.setBounds(20, 220, 100, 25);
        textFname.setBounds(20, 250, 100, 25);
        textLname.setBounds(20, 280, 100, 25);
        textAge.setBounds(20, 310, 100, 25);

        btnAdd.setBounds(150, 220, 100, 25);
        btnUpdate.setBounds(150, 265, 100, 25);
        btnDelete.setBounds(150, 310, 100, 25);

        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);

        frame.setLayout(null);

        frame.add(pane);

        // add JTextFields to the jframe
        frame.add(textId);
        frame.add(textFname);
        frame.add(textLname);
        frame.add(textAge);

        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);

        // create an array of objects to set the row data
        Object[] row = new Object[4];

        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                row[0] = textId.getText();
                row[1] = textFname.getText();
                row[2] = textLname.getText();
                row[3] = textAge.getText();

                // add row to the model
                model.addRow(row);
            }
        });

        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });

        // get selected row data From table to textfields
        table.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e){

                // i = the index of the selected row
                int i = table.getSelectedRow();

                textId.setText(model.getValueAt(i, 0).toString());
                textFname.setText(model.getValueAt(i, 1).toString());
                textLname.setText(model.getValueAt(i, 2).toString());
                textAge.setText(model.getValueAt(i, 3).toString());
            }
        });

        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();

                if(i >= 0)
                {
                    model.setValueAt(textId.getText(), i, 0);
                    model.setValueAt(textFname.getText(), i, 1);
                    model.setValueAt(textLname.getText(), i, 2);
                    model.setValueAt(textAge.getText(), i, 3);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });

        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}