package com.ak98neon.dao;

import com.ak98neon.model.Department;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
@Component
public class DepartmentWorkerTest {
    @Mock
    private IDepartmentWorker departmentWorker;
    @Value("test")
    private static String nameTestDep;

    @Before
    public void initAndInsertDepartment() {
        departmentWorker.createTable();
        departmentWorker.insertDepartment(nameTestDep);
    }

    @Test
    public void create_RequestToCreate_True() {
        assertTrue(departmentWorker.createTable());
    }

    @Test
    public void insert_Department_True() {
        final boolean res = departmentWorker.insertDepartment(nameTestDep);
        assertTrue(res);
    }

    @Test
    public void delete_RequestToDeleteDepartment_True() {
        List<Department> list = departmentWorker.selectAllDepartments();
        assert list != null;
        assertTrue(departmentWorker.deleteDepartment(list.get(0).getId()));
    }

    @Test
    public void update_Name_True() {
        long id = 1;
        assertTrue(departmentWorker.updateDepartment(id, "newTEST"));
    }

    @Test
    public void select_DepartmentName_ObjectDepartment() {
        List<Department> list = departmentWorker.selectAllDepartments();
        assert list != null;
        assertNotNull(list.get(0).getId());
    }

    @Test
    public void select_RequestToSelectAll_True() {
        List<Department> list = departmentWorker.selectAllDepartments();
        assertTrue(!list.isEmpty());
    }

    @Test
    public void drop_RequestToDropTable_True() {
        assertTrue(departmentWorker.dropTable());
    }
}