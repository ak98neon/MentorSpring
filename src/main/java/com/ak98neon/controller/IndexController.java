package com.ak98neon.controller;

import com.ak98neon.dao.IDepartmentWorker;
import com.ak98neon.dao.IEmployeeWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private IDepartmentWorker departmentWorker;
    private IEmployeeWorker employeeWorker;

    @Autowired
    private IndexController(IDepartmentWorker departmentWorker, IEmployeeWorker employeeWorker) {
        this.departmentWorker = departmentWorker;
        this.employeeWorker = employeeWorker;
    }

    @GetMapping(value = "/")
    public String index() {
        departmentWorker.createTable();
        employeeWorker.createTable();
        return "index";
    }
}