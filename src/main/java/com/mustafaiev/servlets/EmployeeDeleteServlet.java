package com.mustafaiev.servlets;

import com.mustafaiev.store.EmployeeCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeDeleteServlet extends HttpServlet {
    private static final EmployeeCache EMPLOYEE_CACHE = EmployeeCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EMPLOYEE_CACHE.delete(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/employee/view"));
    }
}
