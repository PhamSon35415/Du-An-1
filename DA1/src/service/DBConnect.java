/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DBConnect {

    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456789";
    private static final String SERVER = "localhost";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "DA1_NUOCHOA";
    private static final boolean USING_SSL = true;

    private static String CONNECT_STRING;

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            StringBuilder connectStringBuilder = new StringBuilder();
            connectStringBuilder.append("jdbc:sqlserver://")
                    .append(SERVER).append(":").append(PORT).append(";")
                    .append("databaseName=").append(DATABASE_NAME).append(";")
                    .append("user=").append(USERNAME).append(";")
                    .append("password=").append(PASSWORD).append(";");
            if (USING_SSL) {
                connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
            }
            CONNECT_STRING = connectStringBuilder.toString();
            System.out.println("Connect String có dạng: " + CONNECT_STRING);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(CONNECT_STRING);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {           //goi thủ tục lưu trữ
            pstmt = connection.prepareCall(sql);  //(store procedure)
        } else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]); // ps.setString(1, hv.gẹtHoTen());
        }
        return pstmt;
    }

    public static void update(String sql, Object... args) { //insert, update, delete
        try {
            PreparedStatement stmt = DBConnect.getStmt(sql, args);
            try {
                stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Connection conn = getConnection();
        DatabaseMetaData dbmt = conn.getMetaData();
        System.out.println(dbmt.getDriverName());
        System.out.println(dbmt.getDatabaseProductName());
        System.out.println(dbmt.getDatabaseProductVersion());
    }
}
