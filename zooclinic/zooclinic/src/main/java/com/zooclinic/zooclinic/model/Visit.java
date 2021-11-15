package com.zooclinic.zooclinic.model;

import com.zooclinic.zooclinic.constants.VisitStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Data
@Table(schema = "pet_clinic")
@Entity
public class Visit extends BaseEntity<Long> {

    /**
     * Время визита
     */
    private LocalDate date;

    /**
     * Описание визита
     */
    private String description;

    private Person client;

    @OneToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;

    /**
     * Статус визита
     */
    @Enumerated(EnumType.STRING)
    private VisitStatus status;

    /**
     * Дата и время создания
     */
    @CreatedDate
    @Column(updatable = false)
    private LocalDate createdVisit;

    /**
     * Дата и время обновления
     */
    @LastModifiedDate
    private Date updatedVisit;
}
