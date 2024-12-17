package com.Project.EmployeeDetails.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Project.EmployeeDetails.Model.Employee;
import com.Project.EmployeeDetails.Service.EmployeeService;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        service.addEmployee(employee);
        return ResponseEntity.ok("Student added successfully");
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee existingEmployee = service.getEmployeeById(id);
        if (existingEmployee.getId() == id) {
            service.updateEmployee(employee);
            return "Updated Successfully";
        } else {
            return "No such employee";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable int id) {
        service.deleteEmployeeById(id);
        return "Deleted successfully";
    }
}
