package com.zooclinic.zooclinic.dto;

import com.zooclinic.zooclinic.model.Pet;
import lombok.Data;

import java.util.Set;

@Data
public class OwnerDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Set<Pet> pets;
}
