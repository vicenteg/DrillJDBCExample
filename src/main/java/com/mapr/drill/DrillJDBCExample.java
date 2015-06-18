/**
 * Created by vince on 6/12/15.
 */
package com.mapr.drill;

import java.sql.*;

public class DrillJDBCExample {
    static final String JDBC_DRIVER = "org.apache.drill.jdbc.Driver";
    static final String DB_URL = "jdbc:drill:zk=localhost:2181";

    static final String USER = "admin";
    static final String PASS = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();
            /* Perform a select on data in the classpath storage plugin. */
            String sql = "select employee_id,first_name,last_name from cp.`employee.json`";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                int id  = rs.getInt("employee_id");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");

                System.out.print("ID: " + id);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            } catch(SQLException se2) {
            }
            try {
                if(conn!=null)
                    conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
