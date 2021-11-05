package com.zooclinic.zooclinic.model;

import lombok.Data;

@Data
public class Person extends BaseEntity<Long> {

    private String firstName;

    private String lastName;
}
