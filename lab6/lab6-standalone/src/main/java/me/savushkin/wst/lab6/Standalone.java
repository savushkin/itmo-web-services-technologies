package me.savushkin.wst.lab6;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import liquibase.exception.LiquibaseException;
import me.savushkin.wst.common.ConnectionUtil;
import me.savushkin.wst.common.InitializeHelper;
import org.glassfish.grizzly.http.server.HttpServer;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class Standalone {
    private static final URI BASE_URI = URI.create("http://localhost:8080/rest/");

    public static void main(String[] args) throws SQLException, LiquibaseException {
        InitializeHelper.populateDatabase(ConnectionUtil.getConnection());
        HttpServer server = null;
        try {
            ResourceConfig resourceConfig = new ClassNamesResourceConfig(MusicAlbumResource.class);
            server = GrizzlyServerFactory.createHttpServer(BASE_URI, resourceConfig);
            server.start();
            System.in.read();
            stopServer(server);
        } catch (IOException e) {
            e.printStackTrace();
            stopServer(server);
        }
    }

    private static void stopServer(HttpServer server) {
        if (server != null)
            server.stop();
    }
}
