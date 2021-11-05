package com.zooclinic.zooclinic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(schema = "client")
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vet_speciality", joinColumns = @JoinColumn(name = "vet_id"),
    inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();
}
