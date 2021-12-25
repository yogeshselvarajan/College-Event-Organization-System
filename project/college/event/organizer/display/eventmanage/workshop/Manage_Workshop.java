package project.college.event.organizer.display.eventmanage.workshop;

import net.proteanit.sql.DbUtils;
import project.college.event.organizer.display.eventmanage.culturals.CulturalsClass;
import project.college.event.organizer.display.eventmanage.culturals.Manage_Culturals;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ArrayList;

public class Manage_Workshop {
    private JTable TableWork;
    private JButton btnDelete;
    private JButton btnExit;
    private JTextField tfUserID;
    private JTextField NameSearch;
    private JPanel panel;

    final String DB_URL = "jdbc:mysql://localhost:3306/projectdb";
    final String USERNAME = "root";
    final String PASSWORD = "root";

    ResultSet rs;

    Manage_Workshop()
    {
        createTable();
        show_user();
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String UserID=tfUserID.getText();
                try
                {
                    Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                    PreparedStatement pst;

                    pst = conn.prepareStatement("delete from workshop where id=?");
                    pst.setString(1,UserID);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Deleted Successfully !!");
                    load_table();
                }
                catch (SQLException exception)
                {
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
        tfUserID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String id = tfUserID.getText();

                try {
                    Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                    PreparedStatement pst;

                    pst = conn.prepareStatement("select workshop_title from workshop where id = ?");
                    pst.setString(1,id);
                    ResultSet rs = pst.executeQuery();

                    if(rs.next() == true)
                    {
                        String name = rs.getString(1);
                        NameSearch.setText(name);
                    }
                    else
                    {
                        NameSearch.setText("");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }
    private void load_table(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            PreparedStatement pst;

            pst = conn.prepareStatement("select * from workshop");
            rs = pst.executeQuery();
            TableWork.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private ArrayList<WorkshopClass> workshopList()
    {
        ArrayList<WorkshopClass> workshopList = new ArrayList<WorkshopClass>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM workshop";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(query);
            WorkshopClass workshops;

            while (rs.next()) {
                workshops = new WorkshopClass(rs.getInt("id"),
                        rs.getString("workshop_title"),
                        rs.getString("description"),
                        rs.getString("conducted_by"),
                        rs.getString("duration"),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getString("department"),
                        rs.getString("slots_allocated"),
                        rs.getString("conducted_for"),
                        rs.getString("eligibility_criteria"),
                        rs.getString("mode_of_workshop"));
                workshopList.add(workshops);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  workshopList;
    }

    private void show_user()
    {
        ArrayList<WorkshopClass> list = workshopList();
        DefaultTableModel model = (DefaultTableModel) TableWork.getModel();
        Object[] row  = new Object[11];

        for(int i=0 ; i<list.size() ; i++)
        {
            row[0]=list.get(i).getSNo();
           row[1]=list.get(i).getWorkshop_Title();
           row[2]=list.get(i).getDescription();
           row[3]=list.get(i).getConducted_By();
           row[4]=list.get(i).getDuration();
           row[5]=list.get(i).getStartDate();
           row[6]=list.get(i).getEndDate();
           row[7]=list.get(i).getDepartment();
           row[8]=list.get(i).getSlots_allocated();
           row[9]=list.get(i).getEligibilityCriteria();
           row[10]=list.get(i).getMode_of_workshop();
            model.addRow(row);
        }
    }

    private void createTable() {
        TableWork.setModel(new DefaultTableModel(
                null,
                new String[]{"ID","Workshop Title", "Description", "Conducted By", "Duration", "Start Date", "End Date",
                        "Department", "Slots Allocated", "Conducted For", "Eligibility Criteria", "Mode of Workshop"}
        ));

        TableColumnModel columns = TableWork.getColumnModel();
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

        Manage_Workshop ui = new Manage_Workshop();
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}