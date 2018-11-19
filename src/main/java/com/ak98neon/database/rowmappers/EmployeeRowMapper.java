package com.ak98neon.database.rowmappers;

import com.ak98neon.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong(Employee.ID_COLUMN));
        employee.setFirstName(resultSet.getString(Employee.NAME_COLUMN));
        employee.setLastName(resultSet.getString(Employee.LAST_NAME_COLUMN));
        employee.setAge(resultSet.getInt(Employee.AGE_COLUMN));
        employee.setMail(resultSet.getString(Employee.MAIL_COLUMN));
        employee.setDateOfCreation(resultSet.getDate(Employee.DATE_OF_CREATE_COLUMN));
        employee.setDepartmentId(resultSet.getLong(Employee.DEPARTMENT_ID));
        return employee;
    }
}