package com.ak98neon.controller.department;

import com.ak98neon.configure.AnnotationConfig;
import com.ak98neon.dao.IDepartmentWorker;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteDepartmentServlet", urlPatterns = "/deleteDepartment")
@Slf4j
public class DeleteDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        try {
            IDepartmentWorker departmentWorker = AnnotationConfig.getAnnotationConfig().getBean(IDepartmentWorker.class);
            departmentWorker.deleteDepartment(Long.parseLong(id));
            resp.sendRedirect("/listDepartment");
        } catch (Exception e) {
            log.info("[GET]DeleteDepartmentServlet error: {}", e);
        }
    }
}