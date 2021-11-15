package com.zooclinic.zooclinic.dto;

import com.zooclinic.zooclinic.constants.VisitStatus;
import com.zooclinic.zooclinic.model.Person;
import com.zooclinic.zooclinic.model.Vet;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class VisitDto {

    private Long id;

    /**
     * Время визита
     */
    private LocalDate date;

    /**
     * Описание визита
     */
    private String description;

    private Person client;

    private Vet vet;

    /**
     * Статус визита
     */
    private VisitStatus status;

    /**
     * Дата и время создания
     */
    private LocalDate createdVisit;

    /**
     * Дата и время обновления
     */
    private Date updatedVisit;
}
