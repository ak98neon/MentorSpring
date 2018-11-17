package com.ak98neon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    @RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
    public String listEmployee(ModelMap modelMap) {

        return "listEmployee";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(ModelMap modelMap) {

        return "addEmployee";
    }
}
