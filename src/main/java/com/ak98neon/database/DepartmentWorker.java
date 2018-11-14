package com.ak98neon.database;

import com.ak98neon.dao.IDepartmentWorker;
import com.ak98neon.model.Department;
import com.ak98neon.util.Queries;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public final class DepartmentWorker implements IDepartmentWorker {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private DepartmentWorker() {
    }

    public synchronized boolean createTable() {
        jdbcTemplate.execute(Queries.CREATE_TABLE);
        return true;
    }

    public synchronized boolean insertDepartment(final String name) {
        jdbcTemplate.update(Queries.INSERT_DEPARTMENT, name);
        return true;
    }

    public synchronized boolean updateDepartment(final Long id, final String newName) {
        jdbcTemplate.update(Queries.UPDATE_DEPARTMENT, newName, id);
        return true;
    }

    public synchronized boolean deleteDepartment(final long id) {
        jdbcTemplate.update(Queries.DELETE_DEPARTMENT, id);
        return true;
    }

    public synchronized Department selectById(final long id) {
        Department department = (Department) jdbcTemplate.queryForObject(Queries.SELECT_DEPARTMENT, new Object[]{id}, new DepartmentRowMapper());
        return department;
    }

    public synchronized List<Department> selectAllDepartments() {
        List list = jdbcTemplate.query(Queries.SELECT_ALL_DEPARTMENT, new BeanPropertyRowMapper(Department.class));
        return list;
    }

    public synchronized boolean dropTable() {
        jdbcTemplate.update(Queries.DROP_TABLE);
        return true;
    }
}