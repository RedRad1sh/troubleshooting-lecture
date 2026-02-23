package dev.nkucherenko.troubleshooting.service.impl;

import dev.nkucherenko.troubleshooting.config.MaskingConfig;
import dev.nkucherenko.troubleshooting.dto.Employee;
import dev.nkucherenko.troubleshooting.dto.EmployeeDto;
import dev.nkucherenko.troubleshooting.mapper.EmployeeMapper;
import dev.nkucherenko.troubleshooting.masking.MaskingComponent;
import dev.nkucherenko.troubleshooting.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author nkucherenko
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    public static final String EMPLOYEE_NOT_EXISTS_ERROR = "Сотрудник отсутствует в базе данных, id: {}";
    private final Map<String, Employee> employeeMap = new HashMap<>();

    private final MaskingComponent maskingComponent;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto getEmployee(String id) {
        log.trace(">> getEmployee");
        if (!employeeMap.containsKey(id)) {
            log.error(EMPLOYEE_NOT_EXISTS_ERROR, id);
            throw new IllegalArgumentException();
        }
        Employee employee = employeeMap.get(id);
        log.trace("<< getEmployee");
        return employeeMapper.toEmployeeDto(employee);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        log.trace(">> createEmployee");
        String generatedId = UUID.randomUUID().toString();
        Employee employee = employeeMapper.toEmployee(employeeDto);
        employee.setId(generatedId);
        Employee createdEmployee = employeeMapper.toEmployee(employeeDto);
        employeeMap.put(generatedId, createdEmployee);
        log.info("Сотрудник был добавлен, employee: {}",
            maskingComponent.maskInfo(createdEmployee.toString()));
        log.trace("<< createEmployee");
        return employeeMapper.toEmployeeDto(employee);
    }

    @Override
    public EmployeeDto editEmployee(String id, EmployeeDto employeeDto) {
        log.trace(">> editEmployee");
        if (!employeeMap.containsKey(id)) {
            log.error(EMPLOYEE_NOT_EXISTS_ERROR, id);
            throw new IllegalArgumentException();
        }
        Employee updatedEmployee = employeeMap.put(id, employeeMapper.toEmployee(employeeDto));
        log.info("Информация была отредактирована, employee: {}",
            maskingComponent.maskInfo(updatedEmployee.toString()));
        log.trace("<< editEmployee");
        return employeeDto;
    }

    @Override
    public void deleteEmployee(String id) {
        log.trace(">> deleteEmployee");
        if (!employeeMap.containsKey(id)) {
            log.error(EMPLOYEE_NOT_EXISTS_ERROR, id);
            throw new IllegalArgumentException();
        }
        employeeMap.remove(id);
        log.info("Сотрудник был удален, id: {}", id);
        log.trace("<< deleteEmployee");
    }

    @Override
    public void clear() {
        log.trace(">> clear");
        employeeMap.clear();
        log.info("БД очищена");
        log.trace("<< clear");
    }
}
