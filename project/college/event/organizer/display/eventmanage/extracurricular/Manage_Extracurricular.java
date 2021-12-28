package project.college.event.organizer.display.eventmanage.extracurricular;

import net.proteanit.sql.DbUtils;
import project.college.event.organizer.display.eventmanage.extracurricular.ExtraCurricularClass;
import project.college.event.organizer.display.eventmanage.extracurricular.Manage_Extracurricular;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ArrayList;

public class Manage_Extracurricular {
    private JTable TableExtra;
    private JPanel panel;
    private JButton btnDelete;
    private JButton btnExit;
    private JTextField tfUserID;
    private JTextField NameSearch;

    final String DB_URL = "jdbc:mysql://localhost:3306/projectdb";
    final String USERNAME = "root";
    final String PASSWORD = "root";

    ResultSet rs;

    Manage_Extracurricular() {
        createTable();
        show_user();
        tfUserID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String id = tfUserID.getText();

                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    PreparedStatement pst;

                    pst = conn.prepareStatement("select event_name from extracurricular where id = ?");
                    pst.setString(1, id);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next() == true) {
                        String name = rs.getString(1);
                        NameSearch.setText(name);
                    } else {
                        NameSearch.setText("");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String UserID = tfUserID.getText();
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    PreparedStatement pst;

                    pst = conn.prepareStatement("delete from extracurricular where id=?");
                    pst.setString(1, UserID);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleted Successfully !!");
                    load_table();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    private void load_table()
    {
        try {
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            PreparedStatement pst;

            pst = conn.prepareStatement("select * from extracurricular");
            rs = pst.executeQuery();
            TableExtra.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private ArrayList<ExtraCurricularClass> ExtraList()
    {
        ArrayList<ExtraCurricularClass> ExtraList = new ArrayList<ExtraCurricularClass>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM extracurricular";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(query);
            ExtraCurricularClass extracurricular;

            while (rs.next()) {
                extracurricular = new ExtraCurricularClass(rs.getInt("id"),
                        rs.getString("event_name"),
                        rs.getString("description"),
                        rs.getString("start_time"),
                        rs.getString("duration"),
                        rs.getString("start_date"),
                        rs.getString("event_options"),
                        rs.getInt("number_of_participants"),
                        rs.getString("event_id"),
                        rs.getString("college_id"),
                        rs.getString("email_id"));
                ExtraList.add(extracurricular);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  ExtraList;
    }

    private void show_user()
    {
        ArrayList<ExtraCurricularClass> list = ExtraList();
        DefaultTableModel model = (DefaultTableModel) TableExtra.getModel();
        Object[] row  = new Object[11];

        for(int i=0 ; i<list.size() ; i++)
        {
            row[0]=list.get(i).getSNo();
            row[1]=list.get(i).getEvent_name();
            row[2]=list.get(i).getEvent_description();
            row[3]=list.get(i).getStart_time();
            row[4]=list.get(i).getDuration();
            row[5]=list.get(i).getStart_date();
            row[6]=list.get(i).getEvent_Options();
            row[7]=list.get(i).getNumber_of_Participants();
            row[8]=list.get(i).getEvent_id();
            row[9]=list.get(i).getCollege_id();
            row[10]=list.get(i).getEmail_id();
            model.addRow(row);
        }
    }

    private void createTable() {
        TableExtra.setModel(new DefaultTableModel(
                null,
                new String[]{"ID","Event Name", "Description", "Start Time", "Duration", "Start Date", "Event Options",
                        "Number of Participants", "Event ID", "College ID", "Email ID"}
        ));

        TableColumnModel columns = TableExtra.getColumnModel();
        columns.getColumn(0).setMinWidth(5);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(1).setCellRenderer(cellRenderer);
        columns.getColumn(2).setCellRenderer(cellRenderer);
        columns.getColumn(3).setCellRenderer(cellRenderer);
        columns.getColumn(4).setCellRenderer(cellRenderer);
        columns.getColumn(5).setCellRenderer(cellRenderer);
        columns.getColumn(6).setCellRenderer(cellRenderer);
        columns.getColumn(7).setCellRenderer(cellRenderer);
        columns.getColumn(8).setCellRenderer(cellRenderer);
        columns.getColumn(9).setCellRenderer(cellRenderer);
        columns.getColumn(10).setCellRenderer(cellRenderer);
    }
    private JPanel getRootPanel()
    {
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createGUI();
            }
        });
    }

    private static void createGUI()
    {

        Manage_Extracurricular ui = new Manage_Extracurricular();
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}