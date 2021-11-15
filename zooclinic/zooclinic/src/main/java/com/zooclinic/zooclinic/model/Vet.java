package com.zooclinic.zooclinic.model;

import com.zooclinic.zooclinic.constants.VetSpeciality;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Entity
@Table(schema = "pet_clinic")
public class Vet extends BaseEntity<Long> {

    private Person person;

    @Enumerated(EnumType.STRING)
    private VetSpeciality speciality;
}
