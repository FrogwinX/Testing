package com.example;

import org.springframework.stereotype.Component;
import java.sql.*;


@Component
public class DatabaseHandler {

    private final String DB_URL = "jdbc:sqlserver://edwintest.database.windows.net:1433;database=Test;";
    private final String DB_USER = "edwin";
    private final String DB_PASSWORD = "1amts2k1t@";

    public String getNameById(String id) {

        String name = "Not Found";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement("SELECT name FROM T1 WHERE id = ?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                name = rs.getString("name");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Database Error";
        }
        return name;
    }
}
