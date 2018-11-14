package com.ak98neon.controller.dep_servlets;

import com.ak98neon.configure.AnnotationConfig;
import com.ak98neon.dao.IDepartmentWorker;
import com.ak98neon.model.Department;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "ListDepartmentServlet", urlPatterns = "/listDepartment")
@Slf4j
public class ListDepartmentServlet extends HttpServlet {
    private IDepartmentWorker departmentWorker = AnnotationConfig.getAnnotationConfig().getBean(IDepartmentWorker.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setCharacterEncoding("utf-8");
        List<Department> departmentList = departmentWorker.selectAllDepartments();
        req.setAttribute("departments", departmentList);

        try {
            req.getRequestDispatcher("/jsp/listDepartment.jsp").forward(req, resp);
        } catch (Exception e) {
            log.info("Error forward: {} ", e.getMessage());
        }
    }
}