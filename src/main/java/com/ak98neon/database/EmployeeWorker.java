package com.ak98neon.database;

import com.ak98neon.dao.IEmployeeWorker;
import com.ak98neon.database.rowmappers.EmployeeRowMapper;
import com.ak98neon.model.Employee;
import com.ak98neon.util.Queries;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
@Service
public final class EmployeeWorker implements IEmployeeWorker {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeWorker(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public synchronized boolean createTable() {
        jdbcTemplate.execute(Queries.CREATE_TABLE_EMPLOYEE);
        log.info("table employee has been is created");
        return true;
    }

    public synchronized boolean insertEmployee(final String firstName, final String lastName, final int age, final String mail,
                                               final long departmentId) {
        java.util.Date d = new java.util.Date();
        jdbcTemplate.update(Queries.INSERT_EMPLOYEE, firstName, lastName, age, mail, new Date(d.getTime()), departmentId);
        log.info("Employee is inserted into table!");
        return true;
    }

    public synchronized boolean updateEmployee(final Long id, final String firstName, final String lastName, final int age, final String mail) {
        jdbcTemplate.update(Queries.UPDATE_EMPLOYEE, firstName, lastName, age, mail, id);
        log.info("Record employee is updated to table!");
        return true;
    }

    public synchronized boolean deleteEmployee(final long id) {
        jdbcTemplate.update(Queries.DELETE_EMPLOYEE, id);
        log.info("Record employee is delete to table");
        return true;
    }

    public synchronized Employee selectByIdEmployee(final long id) {
        Employee employee = jdbcTemplate.queryForObject(Queries.SELECT_EMPLOYEE, new Object[]{id}, new EmployeeRowMapper());
        log.info("employee is select for id");
        return employee;
    }

    public synchronized List<Employee> selectAllEmployees() {
        return selectAll(Queries.SELECT_ALL_EMPLOYEE, -1);
    }

    public synchronized List<Employee> selectAllEmployeesByDepartment(final long idDepartment) {
        return selectAll(Queries.SELECT_ALL_EMPLOYEE_BY_DEPARTMENTS, idDepartment);
    }

    private synchronized List<Employee> selectAll(final String query, final long idDepartment) {
        List<Employee> list;
        if (idDepartment > 0) {
            list = jdbcTemplate.query(query, new EmployeeRowMapper(), idDepartment);
        } else {
            list = jdbcTemplate.query(query, new EmployeeRowMapper());
        }
        log.info("Select all employee");
        return list;
    }

    public synchronized boolean dropTable() {
        jdbcTemplate.update(Queries.DROP_TABLE_EMPLOYEE);
        log.info("table employee is drop");
        return true;
    }
}