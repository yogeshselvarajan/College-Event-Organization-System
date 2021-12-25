package project.college.event.organizer.display.usersmanage;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class Admin_Manage_Users {

    private JTextField tfName;
    private JTextField tfEmail;
    private JPasswordField tfPassword;
    private JPasswordField tfConfirmPassword;
    private JButton btnAdd;
    private JButton btnClear;
    private JButton deleteButton;
    private JTable showTable;
    private JTextField tfUserID;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JPanel rootPanel;
    private JTextField tfSNO;
    private JButton btnExit;

    final String DB_URL = "jdbc:mysql://localhost:3306/projectdb";
    final String USERNAME = "root";
    final String PASSWORD = "root";


    ResultSet rs;

    public Admin_Manage_Users()
    {
        createTable();
        show_user();
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SNo = tfSNO.getText();
                String Email = tfEmail.getText();
                String Password = String.valueOf(tfPassword.getPassword());
                String Name = tfName.getText();

                if(SNo.isEmpty() || Name.isEmpty() || Email.isEmpty() || Password.isEmpty())
                {
                    JOptionPane.showMessageDialog(btnAdd,"Please  enter all fields","Empty Fields",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    try
                    {
                        Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                        PreparedStatement pst;

                        pst = conn.prepareStatement("insert into userdb(Email,Password,Name)values(?,?,?)");
                        pst.setString(1,Email);
                        pst.setString(2,Password);
                        pst.setString(3,Name);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Record Added Successfully !!");
                        load_table();
                        tfSNO.setText("");
                        tfEmail.setText("");
                        tfPassword.setText("");
                        tfName.setText("");
                        tfConfirmPassword.setText("");
                        tfSNO.requestFocus();
                    }
                    catch (SQLException exception)
                    {
                        exception.printStackTrace();
                    }
                    /**DefaultTableModel model = (DefaultTableModel) showTable.getModel();
                    model.addRow(new Object[]{SNo,Email, Password, Name});*/
                }
                }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfEmail.setText("");
                tfPassword.setText("");
                tfName.setText("");
                tfConfirmPassword.setText("");
            }
        });

        tfUserID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String id = tfUserID.getText();

                try {
                    Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                    PreparedStatement pst;

                    pst = conn.prepareStatement("select Email,Name,Password from userdb where id = ?");
                    pst.setString(1,id);
                    ResultSet rs = pst.executeQuery();

                    if(rs.next() == true)
                    {
                        String email = rs.getString(1);
                        String name = rs.getString(2);
                        String password = rs.getString(3);

                        tfEmail.setText(email);
                        tfName.setText(name);
                        tfPassword.setText(password);
                        tfConfirmPassword.setText(password);
                    }
                    else
                    {
                        tfEmail.setText("");
                        tfName.setText("");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Email = tfEmail.getText();
                String Password = String.valueOf(tfPassword.getPassword());
                String Name = tfName.getText();
                String UserID=tfUserID.getText();
                try
                {
                    Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                    PreparedStatement pst;

                    pst = conn.prepareStatement("update userdb  set Email=? ,Password=?,Name=? where id=?");
                    pst.setString(1,Email);
                    pst.setString(2,Password);
                    pst.setString(3,Name);
                    pst.setString(4,UserID);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Updated Successfully !!");
                    load_table();
                    tfSNO.setText("");
                    tfEmail.setText("");
                    tfPassword.setText("");
                    tfName.setText("");
                    tfConfirmPassword.setText("");
                    tfSNO.requestFocus();
                }
                catch (SQLException exception)
                {
                    exception.printStackTrace();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String UserID=tfUserID.getText();
                try
                {
                    Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                    PreparedStatement pst;

                    pst = conn.prepareStatement("delete from userdb where id=?");
                    pst.setString(1,UserID);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Deleted Successfully !!");
                    load_table();
                    tfSNO.setText("");
                    tfEmail.setText("");
                    tfPassword.setText("");
                    tfName.setText("");
                    tfConfirmPassword.setText("");
                    tfSNO.requestFocus();
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
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfSNO.setText("");
                tfEmail.setText("");
                tfPassword.setText("");
                tfName.setText("");
                tfConfirmPassword.setText("");
                tfSNO.requestFocus();
            }
        });
    }

    public JPanel getRootPanel()
    {
        return rootPanel;
    }

    public void load_table(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            PreparedStatement pst;

            pst = conn.prepareStatement("select * from userdb");
            rs = pst.executeQuery();
            showTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<UserClass> userList()
    {
        ArrayList<UserClass> usersList = new ArrayList<UserClass>();

        try {
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            String query = "SELECT * FROM userdb";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            UserClass user;

            while(rs.next())
            {
                user = new UserClass(rs.getInt("id"),
                        rs.getString("Email"),
                        rs.getString("Password"),
                        rs.getString("Name"));
                usersList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  usersList;
    }

    public void show_user()
    {
        ArrayList<UserClass> list = userList();
        DefaultTableModel model = (DefaultTableModel) showTable.getModel();
        Object[] row  = new Object[4];

        for(int i=0 ; i<list.size() ; i++)
        {
            row[0]=list.get(i).getSno();
            row[1]=list.get(i).getEmail();
            row[2]=list.get(i).getPassword();
            row[3]=list.get(i).getName();
            model.addRow(row);
        }

    }

    public void createTable()
    {
        showTable.setModel(new DefaultTableModel(
                null,
                new String[] {"S.No","Email","Password","Name"}
        ));

        TableColumnModel columns = showTable.getColumnModel();
        columns.getColumn(0).setMinWidth(05);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(1).setCellRenderer(cellRenderer);
        columns.getColumn(2).setCellRenderer(cellRenderer);
        columns.getColumn(3).setCellRenderer(cellRenderer);
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

        Admin_Manage_Users ui = new Admin_Manage_Users();
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
