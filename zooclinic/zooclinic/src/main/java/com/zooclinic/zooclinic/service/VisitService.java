package com.zooclinic.zooclinic.service;

import com.zooclinic.zooclinic.dto.VisitDto;

import java.util.List;

public interface VisitService {

    VisitDto save(VisitDto dto);

    VisitDto update(VisitDto dto);

    VisitDto getById(Long id);

    List<VisitDto> getList();

    void delete(Long id);
}
