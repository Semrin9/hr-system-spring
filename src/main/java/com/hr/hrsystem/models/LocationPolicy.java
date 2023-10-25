package com.hr.hrsystem.models;

import jakarta.persistence.*;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location_policy", schema = "hr_system_database")
public class LocationPolicy {
    @EmbeddedId
    private LocationPolicyId id;

    @MapsId("locationid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locationid", nullable = false)
    private Location locationid;

    @MapsId("policyid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "policyid", nullable = false)
    private Policy policyid;

}