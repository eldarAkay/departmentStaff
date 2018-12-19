package com.mustafaiev.servlets;

import com.mustafaiev.store.EmployeeCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 08.07.2015.
 */
public class EmployeeViewServlet extends HttpServlet {
    private final EmployeeCache EMPLOYEE_CACHE = EmployeeCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employees", this.EMPLOYEE_CACHE.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/employee/EmployeeView.jsp");
        dispatcher.forward(req, resp);
    }
}
