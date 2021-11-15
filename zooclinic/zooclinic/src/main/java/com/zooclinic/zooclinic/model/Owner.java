package com.zooclinic.zooclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "pet_clinic", name = "pet_owner")
public class Owner extends BaseEntity<Long> {

    private Person person;

    private Address address;

    @JsonIgnore
    private String login;
    @JsonIgnore
    private String pass;
    @JsonIgnore
    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Set<Pet> pets;
}
