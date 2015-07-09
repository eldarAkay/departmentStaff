package com.mustafaiev.servlets;

import com.mustafaiev.models.Employee;
import com.mustafaiev.store.EmployeeCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 08.07.2015.
 */
public class EmployeeEditServlet extends HttpServlet {

   // final AtomicInteger ids = new AtomicInteger();

    private static final EmployeeCache EMPLOYEE_CACHE = EmployeeCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employee", this.EMPLOYEE_CACHE.get(Integer.valueOf(req.getParameter("id"))));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/employee/EditEmployee.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.EMPLOYEE_CACHE.edit(new Employee(Integer.valueOf(req.getParameter("id")), req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("email"), req.getParameter("phone")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/employee/view"));
    }
}
