package com.gcfr.dh;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    
    private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
    private static final String USER = "dh";
    private static final String PASSWORD = "1";
    private static Connection conn=null;
    static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            // TODO: handle exception
        }
       
    }
    
    public static Connection getConnection() {
        return conn;
    }
    /**
     * @throws Exception 
     * @param args
     * @throws
     */

}
