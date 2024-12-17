package com.Project.EmployeeDetails.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.EmployeeDetails.Model.Employee;
import com.Project.EmployeeDetails.Repository.EmployeeRepository;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public void addEmployee(Employee employee) {
        repo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repo.findById(id).orElse(new Employee());
    }

    public void updateEmployee(Employee employee) {
        repo.save(employee);
    }

    public void deleteEmployeeById(int id) {
        repo.deleteById(id);
    }
}
