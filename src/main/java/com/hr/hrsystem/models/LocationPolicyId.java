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
public class LocationPolicyId implements Serializable {
    private static final long serialVersionUID = 8719214086923053997L;
    @Column(name = "locationid", nullable = false)
    private Integer locationid;

    @Column(name = "policyid", nullable = false)
    private Integer policyid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LocationPolicyId entity = (LocationPolicyId) o;
        return Objects.equals(this.policyid, entity.policyid) &&
                Objects.equals(this.locationid, entity.locationid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyid, locationid);
    }

}