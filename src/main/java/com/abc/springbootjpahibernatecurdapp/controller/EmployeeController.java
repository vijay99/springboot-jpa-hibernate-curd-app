package com.abc.springbootjpahibernatecurdapp.controller;

import com.abc.springbootjpahibernatecurdapp.entity.Employee;
import com.abc.springbootjpahibernatecurdapp.exception.ResourceNotFoundException;
import com.abc.springbootjpahibernatecurdapp.repo.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {

        Employee employee=employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found of this id:"+employeeId));
        return employee;
    }

    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employee/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    //getting list of employees (by path variable)
    /*@GetMapping("employee/fn/{firstName}")
    public ResponseEntity<List<Employee>> getEmployeeByFirstName( @PathVariable(value = "firstName") String firstName) {
        List<Employee> allEmployee = employeeRepository.findByFirstName(firstName);

        return ResponseEntity.ok(allEmployee);

    }*/

    //getting employee by query parameter
    @GetMapping("/getByFirstName")
    public ResponseEntity<List<Employee>> getEmployeesByFirstName(@RequestParam("first_name") String firstName) {
        List<Employee> allEmployee = employeeRepository.findByFirstName(firstName);

        return ResponseEntity.ok(allEmployee);
    }
}
