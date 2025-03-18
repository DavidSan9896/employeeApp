package edu.uptc.swii.employeeapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import edu.uptc.swii.employeeapp.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ArrayList<Employee> employeeList = new ArrayList<>();

    public UpdateEmployeeServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("emp_id");
        String name = req.getParameter("emp_name");
        String email = req.getParameter("emp_email");
        String phone = req.getParameter("emp_phone");

        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                emp.setName(name);
                emp.setEmail(email);
                emp.setPhone(phone);
                req.getSession().setAttribute("oper", "update_success");
                break;
            }
        }
    }
}

