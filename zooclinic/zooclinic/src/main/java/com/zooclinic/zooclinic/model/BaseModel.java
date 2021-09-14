package com.zooclinic.zooclinic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BaseModel<TYPE_ID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private TYPE_ID id;
}
