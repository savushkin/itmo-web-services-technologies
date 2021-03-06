package me.savushkin.wst.lab3;

import liquibase.exception.LiquibaseException;
import me.savushkin.wst.common.ConnectionUtil;
import me.savushkin.wst.common.InitializeHelper;

import javax.xml.ws.Endpoint;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, LiquibaseException {
        InitializeHelper.populateDatabase(ConnectionUtil.getConnection());
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace",
                "false");
        Endpoint.publish("http://0.0.0.0:8080/music-album-service", new MusicAlbumWebService());
    }
}
