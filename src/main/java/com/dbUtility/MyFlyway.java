package com.dbUtility;


import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;

@WebListener
public class MyFlyway implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        Flyway flyway = new Flyway();
        Properties p=null;
        try {
			p = PropertyUtil.readPropertyFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        BasicDataSource ds= new BasicDataSource();
        ds.setDriverClassName(p.getProperty("DB_Driver"));
		ds.setUrl(p.getProperty("DB_URL"));
		ds.setPassword(p.getProperty("DB_Password"));
		ds.setUsername(p.getProperty("DB_User"));
		ds.setMaxTotal(200);
		ds.setMaxIdle(20);
		ds.setMaxOpenPreparedStatements(180);
		ds.setMinIdle(20);
		ds.setMaxWaitMillis(2000);
		ds.setDefaultAutoCommit(false);
		flyway.setDataSource(ds);
		flyway.setBaselineOnMigrate(true);
		flyway.setLocations("classpath:migration");
//        flyway.configure().dataSource(ds).load();
//        flyway.configure().baselineOnMigrate(true);
//        flyway.configure().locations("classpath:migration");
        flyway.migrate();
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}