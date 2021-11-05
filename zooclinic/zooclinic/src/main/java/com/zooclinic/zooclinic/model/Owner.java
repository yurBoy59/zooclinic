package com.zooclinic.zooclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "client", name = "pet_owner")
public class Owner extends Person {

    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Set<Pet> pets;
}
