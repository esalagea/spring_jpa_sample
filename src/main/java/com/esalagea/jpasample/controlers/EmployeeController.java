package com.esalagea.jpasample.controlers;


import com.esalagea.jpasample.data.EmployeeRepository;
import com.esalagea.jpasample.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeData;

    @RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
    public String newEmployee(@RequestBody Employee employee) {
        employeeData.save(employee);
        return ("Saved Employee: " + employee);
    }

    @RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
    public String employees() {
        List<Employee> allEmployees = employeeData.findAll();
        return allEmployees.toString();
    }

    @RequestMapping(value = "/listEmployeesByDept", method = RequestMethod.GET)
    public String employeesByDept(@RequestParam("dept") String dept) {
        List<Employee> employees = employeeData.findByDept(dept);
        return employees.toString();
    }


}