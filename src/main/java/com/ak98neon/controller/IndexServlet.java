package com.ak98neon.controller;

import com.ak98neon.configure.AnnotationConfig;
import com.ak98neon.dao.IDepartmentWorker;
import com.ak98neon.dao.IEmployeeWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/index", urlPatterns = "/")
@Slf4j
@Component
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            IEmployeeWorker employeeWorker = AnnotationConfig.getAnnotationConfig().getBean(IEmployeeWorker.class);
            IDepartmentWorker departmentWorker = AnnotationConfig.getAnnotationConfig().getBean(IDepartmentWorker.class);
            req.setCharacterEncoding("UTF-8");
            departmentWorker.createTable();
            employeeWorker.createTable();
            employeeWorker.insertEmployee("Artem", "Kudria", 20, "mail@mail.com", 161);
            req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.info("index servlet error: {}", e);
        }
    }
}