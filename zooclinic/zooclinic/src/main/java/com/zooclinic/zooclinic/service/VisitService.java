package com.zooclinic.zooclinic.service;

import com.zooclinic.zooclinic.dto.VisitDto;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface VisitService {

    VisitDto save(VisitDto dto);

    VisitDto update(VisitDto dto);

    VisitDto getById(Long id);

    List<VisitDto> getList(PageRequest pageRequest);

    void delete(Long id);
}
