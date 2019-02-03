/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vipin
 */
public class DBUtils {
    private static String driver="org.hsqldb.jdbc.JDBCDriver";
    private static String dbUrl = "jdbc:hsqldb:hsql://localhost/timetabledb";
    private static String username = "SA";
    private static String password = "";
    public static Vector<Vector> teacherData = new Vector<Vector>();
    private static Connection connection=null;
    public static Connection getConnection(){
        try { 
            if( null== connection || connection.isClosed()){
            Class.forName(driver);
            return DriverManager.getConnection(dbUrl,username,password); 
            }else{
                return connection;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void loadTeacherDetails(){
        connection= getConnection();
        PreparedStatement statement=null;
        ResultSet rs=null;
        try {
            statement=connection.prepareStatement("select  * from staff");
            rs=statement.executeQuery();
            while(rs.next()){
                 Vector<String> row = new Vector<String>();
                  row.addElement(rs.getString(2));
                  row.addElement(rs.getString(1));
                  row.addElement(rs.getString(3));
                  row.addElement(rs.getString(4));
            teacherData.add(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
          closeStatementAndResultSet(statement,rs); 
        }
    }
    
    public static void closeStatementAndResultSet(Statement statement,ResultSet rs){
     try{
            if(null !=  statement)
                statement.close();
            if(null !=  rs)
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void closeConnection(){
    try{
            if(null !=  connection)
                connection.close();
             } catch (SQLException ex) {
                Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
