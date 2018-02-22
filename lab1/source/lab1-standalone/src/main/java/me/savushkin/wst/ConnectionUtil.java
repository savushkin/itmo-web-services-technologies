package me.savushkin.wst;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtil {
    private static final Properties props = new Properties();

    static {
        try (InputStream inputStream = ConnectionUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            props.load(inputStream);
            Class.forName(props.getProperty("jdbc.driver-class-name"));
        } catch (ClassNotFoundException | IOException e) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(props.getProperty("jdbc.url"), props);
        } catch (SQLException e) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, e);
        }

        return connection;
    }
}
