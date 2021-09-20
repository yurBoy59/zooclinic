package com.zooclinic.zooclinic.service;

import com.zooclinic.zooclinic.dto.OwnerDto;

import java.util.List;

public interface OwnerService {

    OwnerDto save(OwnerDto dto);

    OwnerDto update(OwnerDto dto);

    OwnerDto getById(Long id);

    void delete(Long id);

    List<OwnerDto> getList();
}
