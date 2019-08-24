package org.app.security.appsecure.controllers;

import org.app.security.appsecure.beans.Employee;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('USER')")
    public List<Employee> getEmployees() {
        List<Employee> employees = Arrays.asList(new Employee("User3", 101), new Employee("User4", 102));
        return employees;
    }
}
