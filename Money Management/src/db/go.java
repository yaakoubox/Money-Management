package db;

import com.sun.corba.se.impl.protocol.BootstrapServerRequestDispatcher;
import howmuchwehave.Tolls;
import howmuchwehave.Tolls.Table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class go {

    private static String url = "";
    private static Connection con;

    public static void setURL() {
         url = "jdbc:mysql://localhost:3306/howmuchwehave"
                + "?useUnicode=true&characterEncoding=UTF-8";
    }

    public static void setConnection() {

        setURL();
        try {
        con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            Tolls.MsgBox(ex.getMessage());
        }
    }

    public static boolean checkUserAndPass(String username, String password) {
        try {
            setConnection();
            Statement stmt = con.createStatement();
            String strCheck = "select * from users where username = '" + username + "' and pass='" + password + "'";
            stmt.executeQuery(strCheck);
            while (stmt.getResultSet().next()) {
                con.close();
                return true;
            }
            con.close();
        } catch (SQLException ex) {
            Tolls.MsgBox(ex.getMessage());
        }
        return false;
    }

    public static boolean runNonQuery(String sqlStatement) {
        try {
            setConnection();
            Statement stmt = con.createStatement();
            stmt.execute(sqlStatement);
            con.close();
            return true;

        } catch (SQLException ex) {
            Tolls.MsgBox(ex.getMessage());

            return false;
        }
    }

    public static String getAoutoNumber(String tableName, String columName) {

        try {
            setConnection();
            Statement stmt = con.createStatement();
            String strAuto = "select max(" + columName + ")+1 as autonum from " + tableName;
            stmt.execute(strAuto);
            String num = "";
            while (stmt.getResultSet().next()) {
                num = stmt.getResultSet().getString("autonum");
            }
            con.close();
            if (num == null || "".endsWith(num)) {
                return "1";

            } else {
                return num;
            }
        } catch (SQLException ex) {
            Tolls.MsgBox(ex.getMessage());
        }
        return "0";
    }

    public static Table getTableData(String statement) {
        Tolls t = new Tolls();
        try {
            setConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(statement);
            ResultSetMetaData rsmd = rs.getMetaData();
            int c = rsmd.getColumnCount();

            Table table = t.new Table(c);
            while (rs.next()) {
                Object row[] = new Object[c];
                for (int i = 0; i < c; i++) {
                    row[i] = rs.getString(i + 1);
                }
                table.AddNewRow(row);
            }
            con.close();
            return table; 
        } catch (SQLException ex) {
            Tolls.MsgBox(ex.getMessage());
            return t.new Table(0);
        }
    }

    public static void fillCombo(String tableName, String coulumName, JComboBox Combo) {
        try {
            setConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            String strSelect = "select " + coulumName + " from " + tableName;
            rs = stmt.executeQuery(strSelect);
            rs.last();
            int c = rs.getRow();
            rs.beforeFirst();
            String Value[] = new String[c];
            int i = 0;
            while (rs.next()) {
                Value[i] = rs.getString(1);
                i++;
            }
            con.close();
            Combo.setModel(new DefaultComboBoxModel(Value));

        } catch (SQLException ex) {
            Tolls.MsgBox(ex.getMessage());
        }
    }

    public static void fillToJTable(String tableNameOrSlectStatement, JTable table) {
        try {
            setConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            String SPart = tableNameOrSlectStatement.substring(0, 7).toLowerCase();
            String StrSelect;
            if ("select ".equals(SPart)) {
                StrSelect = tableNameOrSlectStatement;
            } else {
                 StrSelect = "select * from " + tableNameOrSlectStatement;
            }
            
            rs = stmt.executeQuery(StrSelect);
            ResultSetMetaData rsmd = rs.getMetaData();
            int c = rsmd.getColumnCount();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
          
            Vector row = new Vector();
            model.setRowCount(0);
            while (rs.next()) {
                row = new Vector(c);
                for (int i = 1; i <= c; i++) {
                    row.add(rs.getString(i));
                }
                model.addRow(row);
            }
            if (table.getColumnCount() != c) {
            Tolls.MsgBox("JTable Columns Count Not Equal TO Query Columns Count\n JTable Columns Count Is :" + table.getColumnCount() + "\n Query Columns Count is :" + c );
            }
            con.close();
        } catch (SQLException ex) {
            Tolls.MsgBox(ex.getMessage());
        }

    }

}
