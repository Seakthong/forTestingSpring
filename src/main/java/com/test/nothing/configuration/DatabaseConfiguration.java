package com.test.nothing.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {
    @Bean
    @Profile("local")
    public DataSource localDb(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/testjava");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("123");
        return driverManagerDataSource;
    }

    @Bean
    @Profile("server")
    public DataSource serverDb(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/testjava");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("123");
        return driverManagerDataSource;
    }

    @Bean
    @Profile("memory")
    public DataSource memory(){
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
        embeddedDatabaseBuilder.addScript("classPath:/static/sql/createTable.sql");
        //classPth is from resource
        return embeddedDatabaseBuilder.build();
    }

}
