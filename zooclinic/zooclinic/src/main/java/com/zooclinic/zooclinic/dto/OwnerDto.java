package com.zooclinic.zooclinic.dto;

import com.zooclinic.zooclinic.model.Pet;
import lombok.Data;

import java.util.Set;

@Data
public class OwnerDto {

    private Long id;

    private String initials;

    private String address;

    private Set<Pet> pets;
}
