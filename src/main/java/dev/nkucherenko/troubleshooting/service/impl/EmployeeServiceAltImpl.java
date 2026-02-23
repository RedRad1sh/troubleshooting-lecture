package dev.nkucherenko.troubleshooting.service.impl;

import dev.nkucherenko.troubleshooting.dto.EmployeeDto;
import dev.nkucherenko.troubleshooting.mapper.EmployeeMapper;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

/**
 * @author nkucherenko
 */
@Service
public class EmployeeServiceAltImpl extends EmployeeServiceImpl {
    public EmployeeServiceAltImpl(EmployeeMapper employeeMapper) {
        super(employeeMapper);
    }

    @Override
    public EmployeeDto getEmployee(String id) {
        throw new NotImplementedException();
    }

    @Override
    public EmployeeDto editEmployee(String id, EmployeeDto employeeDto) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteEmployee(String id) {
        throw new NotImplementedException();
    }

    @Override
    public void clear() {
        throw new NotImplementedException();
    }
}
