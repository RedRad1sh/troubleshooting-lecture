package dev.nkucherenko.troubleshooting.dto;

/**
 * @author nkucherenko
 */
public record EmployeeDto(String id, String name, String position, String department) {
    @Override
    public String toString() {
        return "EmployeeDto{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", position='" + position + '\'' +
               ", department='" + department + '\'' +
               '}';
    }
}

