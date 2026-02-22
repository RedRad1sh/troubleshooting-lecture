package dev.nkucherenko.troubleshooting.controller;

import dev.nkucherenko.troubleshooting.dto.EmployeeDto;
import dev.nkucherenko.troubleshooting.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * @author nkucherenko
 */
@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto);
        return ResponseEntity.created(URI.create(employeeDto.id())).body(createdEmployee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> editEmployee(@PathVariable String id, @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.editEmployee(id, employeeDto));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
