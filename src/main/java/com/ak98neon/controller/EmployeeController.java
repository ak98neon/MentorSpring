package com.ak98neon.controller;

import com.ak98neon.dao.IEmployeeWorker;
import com.ak98neon.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EmployeeController {
    private IEmployeeWorker employeeWorker;
    @Value("redirect:/listEmployee?id=")
    private String redirectListEmployee;
    @Value("depId")
    private String strDepId;

    @Autowired
    private EmployeeController(IEmployeeWorker employeeWorker) {
        this.employeeWorker = employeeWorker;
    }

    @GetMapping(value = "/listEmployee")
    public String listEmployee(HttpServletRequest request, ModelMap modelMap) {
        String depId = request.getParameter("id");
        List<Employee> employees = employeeWorker.selectAllEmployeesByDepartment(Long.parseLong(depId));
        modelMap.addAttribute("employees", employees);
        modelMap.addAttribute(strDepId, depId);
        return "listEmployee";
    }

    @PostMapping(value = "/addEmployee")
    public String addEmployee(HttpServletRequest request) {
        String depId = request.getParameter(strDepId);
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String age = request.getParameter("age");
        int intAge = Integer.parseInt(age);
        String mail = request.getParameter("mail");
        long longDepId = Long.parseLong(depId);
        employeeWorker.insertEmployee(firstName, lastName, intAge, mail, longDepId);
        return redirectListEmployee + depId;
    }

    @GetMapping(value = "/addEmployee")
    public String addEmployeeGet(HttpServletRequest request, ModelMap modelMap) {
        String depId = request.getParameter("id");
        modelMap.addAttribute("id", depId);
        return "addEmployee";
    }

    @GetMapping(value = "/updateEmployee")
    public String updateEmployeeGet(HttpServletRequest request, ModelMap modelMap) {
        long id = Long.parseLong(request.getParameter("id"));
        Employee employee = employeeWorker.selectByIdEmployee(id);
        if (employee != null) {
            modelMap.addAttribute("firstName", employee.getFirstName());
            modelMap.addAttribute("lastName", employee.getLastName());
            modelMap.addAttribute("age", employee.getAge());
            modelMap.addAttribute("mail", employee.getMail());
            modelMap.addAttribute("department_id", employee.getDepartmentId());
        }
        modelMap.addAttribute("id", id);
        return "updateEmployee";
    }

    @PostMapping(value = "/updateEmployee")
    public String updateEmployee(HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String age = request.getParameter("age");
        int intAge = Integer.parseInt(age);
        String mail = request.getParameter("mail");
        String departmentID = request.getParameter("department_id");
        employeeWorker.updateEmployee(id, firstName, lastName, intAge, mail);
        return redirectListEmployee + departmentID;
    }

    @GetMapping(value = "/deleteEmployee")
    public String deleteEmployee(HttpServletRequest request) {
        final String parameterDepId = "id";
        String id = request.getParameter(parameterDepId);
        employeeWorker.deleteEmployee(Long.parseLong(id));
        String depId = request.getParameter(strDepId);
        return redirectListEmployee + depId;
    }
}