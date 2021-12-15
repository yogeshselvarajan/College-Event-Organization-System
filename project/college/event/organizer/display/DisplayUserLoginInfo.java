package project.college.event.organizer.display;
import java.awt.BorderLayout;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;

public class DisplayUserLoginInfo
{
    public DisplayUserLoginInfo()
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String s;

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "root", "root");
            st = con.createStatement();
            // MySQL Query to Connect with DB
            s = "select * from userdb";
            rs = st.executeQuery(s);
            ResultSetMetaData rsmt = rs.getMetaData();
            int c = rsmt.getColumnCount();
            Vector column = new Vector(c);

            for (int i = 1; i <= c; i++)
                column.add(rsmt.getColumnName(i));

            Vector data = new Vector();
            Vector row = new Vector();

            while (rs.next())
            {
                row = new Vector(c);
                for (int i = 1; i <= c; i++)
                    row.add(rs.getString(i));
                data.add(row);
            }

            JFrame frame = new JFrame();
            frame.setSize(500, 120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data, column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp, BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        } finally {
            try {
                st.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR CLOSE");
            }
        }
    }

    public static void main(String[] argv) {
        new DisplayUserLoginInfo();
    }
}
