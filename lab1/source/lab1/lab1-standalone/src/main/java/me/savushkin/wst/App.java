package me.savushkin.wst;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import javax.xml.ws.Endpoint;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();

        try {
            Database database = null;
            database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
            Liquibase liquibase = new liquibase.Liquibase("./db/changelog/db.changelog-master.yaml", new ClassLoaderResourceAccessor(), database);
            liquibase.update(new Contexts(), new LabelExpression());
        } catch (LiquibaseException e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return;
        }

        Endpoint.publish("http://0.0.0.0:8080/music-album-service", new MusicAlbumWebService());

        System.out.println("Hello World!");
    }
}
