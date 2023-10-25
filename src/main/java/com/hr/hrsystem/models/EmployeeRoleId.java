package com.hr.hrsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class EmployeeRoleId implements Serializable {
    private static final long serialVersionUID = -8481125290195052437L;
    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmployeeRoleId entity = (EmployeeRoleId) o;
        return Objects.equals(this.roleId, entity.roleId) &&
                Objects.equals(this.employeeId, entity.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, employeeId);
    }

}