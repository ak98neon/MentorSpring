package com.ak98neon.database;

import com.ak98neon.model.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getLong(Department.ID_COLUMN));
        department.setName(resultSet.getString(Department.NAME_COLUMN));
        return department;
    }
}
