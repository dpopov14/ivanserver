package com.ivan.server.services.impl;

import com.ivan.server.entities.ServerItem;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class JdbcService {
    static final String DB_URL = "jdbc:mysql://localhost/hui";
    static final String USER = "root";
    static final String PASS = "5403";
    static final String QUERY = "SELECT * FROM server_item";
    public List<ServerItem> getReportList() throws SQLException {
        List<ServerItem> serverItems = new ArrayList<>();
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_READ_ONLY)) {
            try (ResultSet rs = statement.executeQuery(QUERY)) {
                while (rs.next()) {
                    ServerItem serverItem = new ServerItem(rs.getInt("id"), rs.getString("description"));
                    serverItems.add(serverItem);
                }
            }
            return serverItems;
        }
    }
    public static Connection createConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
