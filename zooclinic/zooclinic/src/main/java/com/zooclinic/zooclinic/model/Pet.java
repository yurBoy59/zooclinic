package com.zooclinic.zooclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "client", name = "pet")
public class Pet extends BaseModel<Long> {

    private String name;
}
