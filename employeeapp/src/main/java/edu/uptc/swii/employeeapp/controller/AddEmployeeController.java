package edu.uptc.swii.employeeapp.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import edu.uptc.swii.employeeapp.model.Employee;
import edu.uptc.swii.employeeapp.service.EmployeeDAOImpl;
import edu.uptc.swii.employeeapp.service.IEmployeeDAO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

@RestController("/employee")
public class AddEmployeeController {
    private IEmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @PostMapping("/save")
    public RedirectView addEmployee(Employee employee){
        boolean res=this.employeeDAO.save(employee);
        if(!res)
            return new RedirectView("./error.html");
        else
            return new RedirectView("./confirm.html");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteEmployee(@PathVariable("id") String id) {
        boolean res = this.employeeDAO.deleteEmployeeById(id);
        System.out.println("Antes delet res:" + res);
        if (!res)
            return new RedirectView("/error.html");
        else
            return new RedirectView("/confirm.html");
    }

    @GetMapping("/findbyid/{id}")
    public Employee findByID(@PathVariable("id") String id){
        return this.employeeDAO.findById(id);
    }

    @GetMapping("/findall")
    public ModelAndView findAll() {
        List<Employee> employees = this.employeeDAO.findAll();
        ModelAndView mav = new ModelAndView("viewAllEmployees");
        mav.addObject("employees", employees);
        return mav;
    }
}