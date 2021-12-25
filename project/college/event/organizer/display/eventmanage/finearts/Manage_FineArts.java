package project.college.event.organizer.display.eventmanage.finearts;

import net.proteanit.sql.DbUtils;
import project.college.event.organizer.display.eventmanage.culturals.CulturalsClass;
import project.college.event.organizer.display.eventmanage.culturals.Manage_Culturals;
import project.college.event.organizer.display.eventmanage.workshop.Manage_Workshop;
import project.college.event.organizer.display.eventmanage.workshop.WorkshopClass;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ArrayList;

public class Manage_FineArts {
    private JPanel mainpanel;
    private JTable TableFineArts;
    private JButton btnDelete;
    private JButton btnExit;
    private JTextField tfUserID;
    private JTextField NameSearch;

    final String DB_URL = "jdbc:mysql://localhost:3306/projectdb";
    final String USERNAME = "root";
    final String PASSWORD = "root";

    ResultSet rs;

    Manage_FineArts() {
        createTable();
        show_user();
        tfUserID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String id = tfUserID.getText();

                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    PreparedStatement pst;

                    pst = conn.prepareStatement("select event_name from finearts where id = ?");
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

                    pst = conn.prepareStatement("delete from finearts where id=?");
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

            pst = conn.prepareStatement("select * from finearts");
            rs = pst.executeQuery();
            TableFineArts.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private ArrayList<FineArtsClass> fineartsList()
    {
        ArrayList<FineArtsClass> fineartsList = new ArrayList<FineArtsClass>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM finearts";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(query);
            FineArtsClass finearts;

            while (rs.next()) {
                finearts = new FineArtsClass(rs.getInt("id"),
                      rs.getString("event_name"),
                rs.getString("description"),
                rs.getString("start_time"),
                rs.getString("duration"),
                rs.getString("start_date"),
                rs.getString("event_type"),
                rs.getString("category"),
                rs.getString("number_of_participants"),
                rs.getString("event_id"),
                rs.getString("college_id"),
                rs.getString("email_id"));
                fineartsList.add(finearts);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  fineartsList;
    }

    private void show_user()
    {
        ArrayList<FineArtsClass> list = fineartsList();
        DefaultTableModel model = (DefaultTableModel) TableFineArts.getModel();
        Object[] row  = new Object[12];

        for(int i=0 ; i<list.size() ; i++)
        {
            row[0]=list.get(i).getSNo();
            row[1]=list.get(i).getEvent_name();
            row[2]=list.get(i).getEvent_description();
            row[3]=list.get(i).getStart_time();
            row[4]=list.get(i).getDuration();
            row[5]=list.get(i).getStart_time();
            row[6]=list.get(i).getEvent_Type();
            row[7]=list.get(i).getCategory();
            row[8]=list.get(i).getNumber_of_Participants();
            row[9]=list.get(i).getEvent_id();
            row[10]=list.get(i).getCollege_id();
            row[11]=list.get(i).getEmail_id();
            model.addRow(row);
        }
    }

    private void createTable() {
        TableFineArts.setModel(new DefaultTableModel(
                null,
                new String[]{"ID","Event Name", "Description", "Start Time", "Duration", "Start Date", "Event Type",
                        "Category", "Number of Participants", "Event ID", "College ID", "Email ID"}
        ));

        TableColumnModel columns = TableFineArts.getColumnModel();
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

        Manage_FineArts ui = new Manage_FineArts();
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
