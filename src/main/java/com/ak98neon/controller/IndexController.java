package com.ak98neon.controller;

import com.ak98neon.dao.IDepartmentWorker;
import com.ak98neon.dao.IEmployeeWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @Autowired
    private IDepartmentWorker departmentWorker;
    @Autowired
    private IEmployeeWorker employeeWorker;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
//        departmentWorker.createTable();
//        employeeWorker.createTable();
//        employeeWorker.insertEmployee("Artem", "Kudria", 20, "mail@mail.com", 161);
        return "index";
    }
}