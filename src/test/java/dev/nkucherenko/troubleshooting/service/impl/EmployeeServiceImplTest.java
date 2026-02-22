package dev.nkucherenko.troubleshooting.service.impl;

import dev.nkucherenko.troubleshooting.dto.EmployeeDto;
import dev.nkucherenko.troubleshooting.mapper.EmployeeMapper;
import dev.nkucherenko.troubleshooting.mapper.EmployeeMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @author nkucherenko
 */
class EmployeeServiceImplTest {

    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(new EmployeeMapperImpl());

    private EmployeeDto testEmployee;

    @BeforeEach
    void setUp() {
        employeeService.clear();
        testEmployee = new EmployeeDto(UUID.randomUUID().toString(), "John Doe", "Junior", "ARGO");
    }

    @Test
    @DisplayName("get employee")
    void getEmployeeTest() {
        EmployeeDto createdEmployee = employeeService.createEmployee(testEmployee);

        EmployeeDto result = employeeService.getEmployee(createdEmployee.id());

        Assertions.assertEquals("John Doe", result.name());
        Assertions.assertEquals("Junior", result.position());
        Assertions.assertEquals("ARGO", result.department());
    }

    @Test
    @DisplayName("employee not exists")
    void getEmployee_NotExists_ThrowsException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> employeeService.getEmployee("999"));
        Assertions.assertNotNull(exception);
    }

    @Test
    @DisplayName("add new employee")
    void createEmployeeTest() {
        EmployeeDto result = employeeService.createEmployee(testEmployee);
        Assertions.assertEquals(testEmployee.name(), employeeService.getEmployee(result.id()).name());
    }

    @Test
    @DisplayName("update employee")
    void editEmployeeTest() {
        EmployeeDto createdEmployee = employeeService.createEmployee(testEmployee);
        EmployeeDto updatedEmployee = new EmployeeDto(createdEmployee.id(), "Empty", "Junior", null);

        EmployeeDto result = employeeService.editEmployee(createdEmployee.id(), updatedEmployee);

        Assertions.assertEquals("Empty", result.name());
        Assertions.assertEquals("Junior", result.position());
        Assertions.assertNull(result.department());
        Assertions.assertEquals(updatedEmployee, employeeService.getEmployee(result.id()));
    }

    @Test
    @DisplayName("remove employee")
    void deleteEmployeeTest() {
        EmployeeDto employeeDto = employeeService.createEmployee(testEmployee);
        employeeService.deleteEmployee(employeeDto.id());
        Assertions.assertThrows(IllegalArgumentException.class, () -> employeeService.getEmployee(employeeDto.id()));
    }

    @Test
    @DisplayName("remove not existing employee")
    void deleteEmployeeNotExistsTest() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> employeeService.deleteEmployee("999"));
        Assertions.assertNotNull(exception);
    }
}