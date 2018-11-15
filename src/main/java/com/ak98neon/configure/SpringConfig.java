package com.ak98neon.configure;

import com.ak98neon.database.DepartmentWorker;
import com.ak98neon.database.EmployeeWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.ak98neon")
public class SpringConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/test?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcOperations() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DepartmentWorker departmentWorker() {
        return new DepartmentWorker();
    }

    @Bean
    EmployeeWorker employeeWorker() {
        return new EmployeeWorker();
    }
}