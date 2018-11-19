package com.ak98neon.dao;

import com.ak98neon.model.Employee;

import java.util.List;

public interface IEmployeeWorker {
    /**
     * Create table Employee
     *
     * @return true or false
     */
    boolean createTable();

    /**
     * Insert Employee
     *
     * @param firstName    String First name employee
     * @param lastName     String Last name employee
     * @param age          int age emplpyee
     * @param mail         String mail employee
     * @param departmentId Long ID Department
     * @return true or false
     */
    boolean insertEmployee(final String firstName, final String lastName, final int age, final String mail,
                           final long departmentId);

    /**
     * Update Employee
     *
     * @param firstName String First name employee
     * @param lastName  String Last name employee
     * @param age       int age emplpyee
     * @param mail      String mail employee
     * @return true or false
     */
    boolean updateEmployee(final Long id, final String firstName, final String lastName, final int age, final String mail);

    /**
     * Delete Employee
     *
     * @param id Long id employee
     * @return true or false
     */
    boolean deleteEmployee(final long id);

    /**
     * Select by id employee
     *
     * @param id Long id employee
     * @return Employee
     */
    Employee selectByIdEmployee(final long id);

    /**
     * Select all employees
     *
     * @return List Employee
     */
    List<Employee> selectAllEmployees();

    /**
     * Select all employee from by department to id Department
     *
     * @param idDepartment Long id department
     * @return List Employee
     */
    List<Employee> selectAllEmployeesByDepartment(final long idDepartment);

    /**
     * Drop table
     *
     * @return true or false
     */
    boolean dropTable();
}