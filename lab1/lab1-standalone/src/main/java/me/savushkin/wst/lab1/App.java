package me.savushkin.wst.lab1;

import liquibase.exception.LiquibaseException;
import me.savushkin.wst.common.ConnectionUtil;
import me.savushkin.wst.common.InitializeHelper;

import javax.xml.ws.Endpoint;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        try (Connection connection = ConnectionUtil.getConnection()) {
            InitializeHelper.populateDatabase(connection);
        } catch (LiquibaseException | SQLException e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return;
        }

        Endpoint.publish("http://0.0.0.0:8080/music-album-service", new MusicAlbumWebService());

        System.out.println("Hello World!");
    }
}
