package com.zooclinic.zooclinic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class Address {
    private String city;
    private String street;
    private Long index;
}