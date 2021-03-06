package com.zooclinic.zooclinic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class Person {
    private String firstName;
    private String lastName;
}
