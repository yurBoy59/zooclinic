package com.zooclinic.zooclinic.model;

import com.zooclinic.zooclinic.constants.TypePet;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "pet_clinic")
public class Pet extends BaseEntity<Long> {

    private String name;

    @Enumerated(EnumType.STRING)
    private TypePet typePet;
}
