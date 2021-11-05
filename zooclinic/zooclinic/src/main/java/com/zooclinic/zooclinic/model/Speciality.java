package com.zooclinic.zooclinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(schema = "client")
public class Speciality extends BaseEntity<Long> {
    private Long typeId;
}
