package me.savushkin.wst.lab4;

import liquibase.exception.LiquibaseException;
import me.savushkin.wst.common.InitializeHelper;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Startup
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class InitializerBean {

    @Resource(lookup = "jdbc/__default")
    private DataSource dataSource;

    @PostConstruct
    protected void bootstrap() {
        try (Connection connection = dataSource.getConnection()) {
            InitializeHelper.populateDatabase(connection);
        } catch (SQLException | LiquibaseException e) {
            Logger.getLogger(InitializerBean.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        System.out.println("Hello World!");
    }
}
