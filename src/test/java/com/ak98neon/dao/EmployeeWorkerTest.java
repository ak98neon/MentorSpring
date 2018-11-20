package com.ak98neon.dao;

import com.ak98neon.configure.SpringConfig;
import com.ak98neon.database.EmployeeWorker;
import com.ak98neon.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringConfig.class})
public class EmployeeWorkerTest {
    private static Employee employee;
    @Autowired
    private EmployeeWorker employeeWorker;

    @Before
    public void initAndInsertEmployee() {
        Long id = 1L;
        employee = new Employee(id, "test", "test", 20, "test@mail.ru", id);
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
        Assert.assertFalse(list.isEmpty());
        assertTrue(employeeWorker.deleteEmployee(list.get(0).getId()));
    }

    @Test
    public void update_NameAndLNameAndAgeAndMail_True() {
        List<Employee> list = employeeWorker.selectAllEmployees();
        Assert.assertFalse(list.isEmpty());
        assertTrue(employeeWorker.updateEmployee(list.get(0).getId(), employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getMail()));
    }

    @Test
    public void select_EpmployeeName_ObjectEmployee() {
        List<Employee> list = employeeWorker.selectAllEmployees();
        Assert.assertFalse(list.isEmpty());
        Employee s = employeeWorker.selectByIdEmployee(list.get(0).getId());
        Assert.assertNotNull(s);
        assertNotNull(s.getFirstName());
    }

    @Test
    public void select_RequestToSelectAll_True() {
        List<Employee> list = employeeWorker.selectAllEmployees();
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void drop_RequestToDropTable_True() {
        assertTrue(employeeWorker.dropTable());
    }
}