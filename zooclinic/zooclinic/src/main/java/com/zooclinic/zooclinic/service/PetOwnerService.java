package com.zooclinic.zooclinic.service;

import com.zooclinic.zooclinic.dto.PetOwnerDto;
import com.zooclinic.zooclinic.model.PetOwner;

import java.util.List;

public interface PetOwnerService {

    PetOwnerDto save(PetOwnerDto dto);

    PetOwnerDto update(PetOwnerDto dto);

    PetOwnerDto getById(Long id);

    void delete(Long id);

    List<PetOwnerDto> getList();
}
