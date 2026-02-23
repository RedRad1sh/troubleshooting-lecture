package dev.nkucherenko.troubleshooting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author nkucherenko
 */
@Slf4j
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String id;
    private String name;
    private String position;
    private String department;

    @Override
    public String toString() {
        return "Employee{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", position='" + position + '\'' +
               ", department='" + department + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee that = (Employee) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
