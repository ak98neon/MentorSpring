package com.ak98neon.controller;

import com.ak98neon.dao.IDepartmentWorker;
import com.ak98neon.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DepartmentController {
    private IDepartmentWorker departmentWorker;
    @Value("redirect:/listDepartment")
    private String redirectListDepartment;

    @Autowired
    private DepartmentController(IDepartmentWorker departmentWorker) {
        this.departmentWorker = departmentWorker;
    }

    @GetMapping(value = "/listDepartment")
    public String listEmployee(ModelMap modelMap) {
        List listDepartments = departmentWorker.selectAllDepartments();
        modelMap.addAttribute("departments", listDepartments);
        return "listDepartment";
    }

    @PostMapping(value = "/addDepartment")
    public String addEmployee(HttpServletRequest request) {
        departmentWorker.insertDepartment(request.getParameter("name"));
        return redirectListDepartment;
    }

    @GetMapping(value = "/addDepartment")
    public String addEmployeeGet(ModelMap modelMap) {
        return "addDepartment";
    }

    @GetMapping(value = "/updateDepartment")
    public String updateDepartmentGet(HttpServletRequest request, ModelMap modelMap) {
        String id = request.getParameter("id");
        Department department = departmentWorker.selectById(Long.parseLong(id));
        assert department != null;
        modelMap.addAttribute("id", id);
        modelMap.addAttribute("name", department.getName());
        return "updateDepartment";
    }

    @PostMapping(value = "/updateDepartment")
    public String updateDepartment(HttpServletRequest request) {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        departmentWorker.updateDepartment(Long.parseLong(id), name);
        return redirectListDepartment;
    }

    @GetMapping(value = "/deleteDepartment")
    public String deleteDepartment(HttpServletRequest request) {
        String id = request.getParameter("id");
        departmentWorker.deleteDepartment(Long.parseLong(id));
        return redirectListDepartment;
    }
}