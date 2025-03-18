package edu.uptc.swii.employeeapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.uptc.swii.employeeapp.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ArrayList<Employee> employeeList = new ArrayList<>();

    public DeleteEmployeeServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("emp_id");

        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getId().equals(id)) {
                iterator.remove();
                req.getSession().setAttribute("oper", "delete_success");
                break;
            }
        }
    }
}
