package com.ak98neon.dao;

import com.ak98neon.database.EmployeeWorker;
import com.ak98neon.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class EmployeeWorkerTest {
    private IEmployeeWorker employeeWorker = new EmployeeWorker();
    private static Long id = 1L;
    private static Employee employee = new Employee(id, "test", "test", 20, "test@mail.ru", id);

    @Before
    public void initAndInsertEmployee() {
        employeeWorker.createTable();
        employeeWorker.insertEmployee(employee.getFirstName(), employee.getLastName(), employee.getAge(),
                employee.getMail(), employee.getDepartmentId());
    }

    @Test
    public void create_RequestToCreate_True() {
        assertTrue(employeeWorker.createTable());
    }

    @Test
    public void insert_Employee_True() {
        final boolean res = employeeWorker.insertEmployee(employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getMail(),
                employee.getDepartmentId());
        assertTrue(res);
    }

    @Test
    public void delete_RequestToDeleteEmployee_True() {
        List<Employee> list = employeeWorker.selectAllEmployees();
        assert list != null;
        assertTrue(employeeWorker.deleteEmployee(list.get(0).getId()));
    }

    @Test
    public void update_NameAndLNameAndAgeAndMail_True() {
        List<Employee> list = employeeWorker.selectAllEmployees();
        assert list != null;
        assertTrue(employeeWorker.updateEmployee(list.get(0).getId(), employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getMail()));
    }

    @Test
    public void select_EpmployeeName_ObjectEmployee() {
        List<Employee> list = employeeWorker.selectAllEmployees();
        assert list != null;
        Employee s = employeeWorker.selectByIdEmployee(list.get(0).getId());
        assert s != null;
        assertNotNull(s.getFirstName());
    }

    @Test
    public void select_RequestToSelectAll_True() {
        List<Employee> list = employeeWorker.selectAllEmployees();
        assert list != null;
        assertTrue(!list.isEmpty());
    }

    @Test
    public void drop_RequestToDropTable_True() {
        assertTrue(employeeWorker.dropTable());
    }
}