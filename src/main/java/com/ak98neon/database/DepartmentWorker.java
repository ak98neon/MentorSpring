package com.ak98neon.database;

import com.ak98neon.dao.IDepartmentWorker;
import com.ak98neon.model.Department;
import com.ak98neon.util.Queries;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
@Component
@Scope("singleton")
public final class DepartmentWorker implements IDepartmentWorker {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public synchronized boolean createTable() {
        jdbcTemplate.execute(Queries.CREATE_TABLE);
        log.info("Create table is department");
        return true;
    }

    public synchronized boolean insertDepartment(final String name) {
        jdbcTemplate.update(Queries.INSERT_DEPARTMENT, name);
        log.info("Insert is department");
        return true;
    }

    public synchronized boolean updateDepartment(final Long id, final String newName) {
        jdbcTemplate.update(Queries.UPDATE_DEPARTMENT, newName, id);
        log.info("Update Department");
        return true;
    }

    public synchronized boolean deleteDepartment(final long id) {
        jdbcTemplate.update(Queries.DELETE_DEPARTMENT, id);
        log.info("Delete department");
        return true;
    }

    public synchronized Department selectById(final long id) {
        return (Department) jdbcTemplate.queryForObject(Queries.SELECT_DEPARTMENT, new Object[]{id}, new DepartmentRowMapper());
    }

    public synchronized List<Department> selectAllDepartments() {
        return (List<Department>) jdbcTemplate.query(Queries.SELECT_ALL_DEPARTMENT, new BeanPropertyRowMapper(Department.class));
    }

    public synchronized boolean dropTable() {
        jdbcTemplate.update(Queries.DROP_TABLE);
        log.info("Drop table department");
        return true;
    }
}