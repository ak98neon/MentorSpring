package com.ak98neon.dao;

import com.ak98neon.model.Department;

import java.util.List;

public interface IDepartmentWorker {
    /**
     * Create table Department
     *
     * @return true or false
     */
    boolean createTable();

    /**
     * Insert Department in data base
     *
     * @param name String name Name Department
     * @return true or false
     */
    boolean insertDepartment(final String name);

    /**
     * Update department
     *
     * @param id      Long id Department
     * @param newName String new name is Department
     * @return true or false
     */
    boolean updateDepartment(final Long id, final String newName);

    /**
     * Delete department
     *
     * @param id Long id department
     * @return true or false
     */
    boolean deleteDepartment(final long id);

    /**
     * Select Department by id
     *
     * @param id Long id department
     * @return Department object
     */
    Department selectById(final long id);

    /**
     * Select All Departments
     *
     * @return List Departments
     */
    List selectAllDepartments();

    /**
     * Drop table department
     *
     * @return true or false
     */
    boolean dropTable();
}