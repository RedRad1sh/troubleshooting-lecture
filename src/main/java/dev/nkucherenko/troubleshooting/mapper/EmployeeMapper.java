package dev.nkucherenko.troubleshooting.mapper;

import dev.nkucherenko.troubleshooting.dto.Employee;
import dev.nkucherenko.troubleshooting.dto.EmployeeDto;
import org.mapstruct.Mapper;

/**
 * @author nkucherenko
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEmployee(EmployeeDto employeeDto);
    EmployeeDto toEmployeeDto(Employee employeeDto);
}
