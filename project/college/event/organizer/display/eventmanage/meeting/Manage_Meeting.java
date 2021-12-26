package project.college.event.organizer.display.eventmanage.meeting;

import net.proteanit.sql.DbUtils;
import project.college.event.organizer.display.eventmanage.meeting.Manage_Meeting;
import project.college.event.organizer.display.eventmanage.meeting.MeetingClass;
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

public class Manage_Meeting {
    private JPanel mainpanel;
    private JTable TableMeeting;
    private JButton btnDelete;
    private JButton btnExit;
    private JTextField tfUserID;
    private JTextField NameSearch;

    final String DB_URL = "jdbc:mysql://localhost:3306/project_db";
    final String USERNAME = "root";
    final String PASSWORD = "root";

    ResultSet rs;

    Manage_Meeting() {
        createTable();
        show_user();
        tfUserID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String id = tfUserID.getText();

                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    PreparedStatement pst;

                    pst = conn.prepareStatement("select meeting_name from meeting where id = ?");
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

                    pst = conn.prepareStatement("delete from meeting where id=?");
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

            pst = conn.prepareStatement("select * from meeting");
            rs = pst.executeQuery();
            TableMeeting.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private ArrayList<MeetingClass> meetingList()
    {
        ArrayList<MeetingClass> meetingList = new ArrayList<MeetingClass>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM meeting";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(query);
            MeetingClass meeting;

            while (rs.next()) {
                meeting = new MeetingClass(rs.getInt("id"),
                        rs.getString("meeting_name"),
                        rs.getString("description"),
                        rs.getString("start_time"),
                        rs.getString("meeting_type"),
                        rs.getString("duration"),
                        rs.getString("start_date"),
                        rs.getString("meeting_options"),
                        rs.getString("number_of_participants"),
                        rs.getString("meeting_id"),
                        rs.getString("meeting_password"),
                        rs.getString("college_id"),
                        rs.getString("email_id"));

                        meetingList.add(meeting);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  meetingList;
    }

    private void show_user()
    {
        ArrayList<MeetingClass> list = meetingList();
        DefaultTableModel model = (DefaultTableModel) TableMeeting.getModel();
        Object[] row  = new Object[12];

        for(int i=0 ; i<list.size() ; i++)
        {
            row[0]=list.get(i).getSNo();
            row[1]=list.get(i).getMeeting_name();
            row[2]=list.get(i).getMeeting_description();
            row[3]=list.get(i).getStart_time();
            row[4]=list.get(i).getMeeting_Type();
            row[5]=list.get(i).getDuration();
            row[6]=list.get(i).getStart_date();
            row[7]=list.get(i).getMeeting_options();
            row[8]=list.get(i).getNumber_of_Participants();
            row[9]=list.get(i).getMeeting_id();
            row[10]=list.get(i).getMeeting_pass();
            row[11]=list.get(i).getCollege_id();
            row[12]=list.get(i).getEmail_id();
            model.addRow(row);
        }
    }

    private void createTable() {
        TableMeeting.setModel(new DefaultTableModel(
                null,
                new String[]{"ID","Meeting Name", "Description", "Start Time", "Meeting Type", "Duration", "Start Date",
                        "Meeting Options", "Number of Participants", "Meeting ID", "Meeting Password", "College ID", "Email ID"}
        ));

        TableColumnModel columns = TableMeeting.getColumnModel();
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
        columns.getColumn(11).setCellRenderer(cellRenderer);
        columns.getColumn(12).setCellRenderer(cellRenderer);
        columns.getColumn(13).setCellRenderer(cellRenderer);
    }
    private JPanel getRootPanel()
    {
        return mainpanel;
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

        Manage_Meeting ui = new Manage_Meeting();
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}


