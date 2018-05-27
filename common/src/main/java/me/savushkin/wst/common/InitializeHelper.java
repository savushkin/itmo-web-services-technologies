package me.savushkin.wst.common;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;

public class InitializeHelper {
    public static void populateDatabase(Connection connection) throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));

        Liquibase liquibase = new liquibase.Liquibase("./db/changelog/db.changelog-master.yaml", new ClassLoaderResourceAccessor(), database);
        liquibase.update(new Contexts(), new LabelExpression());
    }
}
