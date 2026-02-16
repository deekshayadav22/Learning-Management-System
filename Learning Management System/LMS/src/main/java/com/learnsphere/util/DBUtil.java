package com.learnsphere.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DBUtil {

    private static String url;
    private static String user;
    private static String password;

    static {
        try (InputStream in =
                     DBUtil.class.getClassLoader().getResourceAsStream("application.properties")) {

            if (in == null) {
                throw new RuntimeException("application.properties not found");
            }

            Properties props = new Properties();
            props.load(in);

            url = props.getProperty("jdbc.url");
            user = props.getProperty("jdbc.user");
            password = props.getProperty("jdbc.password");

            Class.forName(props.getProperty(
                    "jdbc.driver", "com.mysql.cj.jdbc.Driver"));

        } catch (Exception e) {
            throw new RuntimeException("Database configuration error", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
