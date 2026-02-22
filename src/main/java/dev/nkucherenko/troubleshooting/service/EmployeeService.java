package dev.nkucherenko.troubleshooting.service;

import dev.nkucherenko.troubleshooting.dto.EmployeeDto;

/**
 * @author nkucherenko
 */
public interface EmployeeService {
    EmployeeDto getEmployee(String id);
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto editEmployee(String id, EmployeeDto employeeDto);
    void deleteEmployee(String id);
    void clear();
}
