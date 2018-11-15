package com.ak98neon.dao;

import com.ak98neon.model.Employee;

import java.util.List;

public interface IEmployeeWorker {
    boolean createTable();

    boolean insertEmployee(final String firstName, final String lastName, final int age, final String mail,
                           final long departmentId);

    boolean updateEmployee(final Long id, final String firstName, final String lastName, final int age, final String mail);

    boolean deleteEmployee(final long id);

    Employee selectByIdEmployee(final long id);

    List<Employee> selectAllEmployees();

    List<Employee> selectAllEmployeesByDepartment(final long idDepartment);

    boolean dropTable();
}
