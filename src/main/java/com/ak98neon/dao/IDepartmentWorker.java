package com.ak98neon.dao;

import com.ak98neon.model.Department;

import java.util.List;

public interface IDepartmentWorker {
    boolean createTable();

    boolean insertDepartment(final String name);

    boolean updateDepartment(final Long id, final String newName);

    boolean deleteDepartment(final long id);

    /**
     * Select Department by id
     *
     * @param id id department
     * @return Department object
     */
    Department selectById(final long id);

    List selectAllDepartments();

    boolean dropTable();
}