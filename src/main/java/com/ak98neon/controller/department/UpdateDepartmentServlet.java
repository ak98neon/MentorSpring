package com.ak98neon.controller.department;

import com.ak98neon.configure.AnnotationConfig;
import com.ak98neon.dao.IDepartmentWorker;
import com.ak98neon.model.Department;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateDepartmentServlet", urlPatterns = "/updateDepartment")
@Slf4j
public class UpdateDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            IDepartmentWorker departmentWorker = AnnotationConfig.getAnnotationConfig().getBean(IDepartmentWorker.class);
            req.setCharacterEncoding("UTF-8");
            String id = req.getParameter("id");
            Department department = departmentWorker.selectById(Long.parseLong(id));
            assert department != null;
            req.setAttribute("id", id);
            req.setAttribute("name", department.getName());
            req.getRequestDispatcher("/jsp/updateDepartment.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.info("Update Department error: {}", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            IDepartmentWorker departmentWorker = AnnotationConfig.getAnnotationConfig().getBean(IDepartmentWorker.class);
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            String id = req.getParameter("id");
            departmentWorker.updateDepartment(Long.parseLong(id), name);
            resp.sendRedirect("/listDepartment");
        } catch (NumberFormatException | IOException e) {
            log.info("Update Department error: {}", e);
        }
    }
}