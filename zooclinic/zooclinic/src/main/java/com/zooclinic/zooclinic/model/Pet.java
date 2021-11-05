package com.zooclinic.zooclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "client", name = "pet")
public class Pet extends BaseEntity<Long> {

    private String name;
}
