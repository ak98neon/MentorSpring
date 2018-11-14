package com.ak98neon.controller.employee;

import com.ak98neon.configure.AnnotationConfig;
import com.ak98neon.dao.IEmployeeWorker;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteEmployeeServlet", urlPatterns = "/deleteEmployee")
@Slf4j
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            IEmployeeWorker employeeWorker = AnnotationConfig.getAnnotationConfig().getBean(IEmployeeWorker.class);
            final String parameterDepId = "id";
            String id = req.getParameter(parameterDepId);
            employeeWorker.deleteEmployee(Long.parseLong(id));
            String depId = req.getParameter("depId");
            resp.sendRedirect("/listEmployee?" + parameterDepId + "=" + depId);
        } catch (Exception e) {
            log.info("DeleteEmployeeServlet error: {}", e);
        }
    }
}
