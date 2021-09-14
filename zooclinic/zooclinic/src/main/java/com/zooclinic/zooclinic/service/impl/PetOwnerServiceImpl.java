package com.zooclinic.zooclinic.service.impl;

import com.zooclinic.zooclinic.dto.PetOwnerDto;
import com.zooclinic.zooclinic.model.PetOwner;
import com.zooclinic.zooclinic.repo.PetOwnerRepository;
import com.zooclinic.zooclinic.service.PetOwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PetOwnerServiceImpl implements PetOwnerService {

    private final PetOwnerRepository petOwnerRepository;
    private ModelMapper modelMapper;

    @PostConstruct
    void init() {
        modelMapper = new ModelMapper();
    }

    @Override
    public PetOwnerDto save(PetOwnerDto dto) {
        if (dto != null) {
            PetOwner savedPetOwner = petOwnerRepository.save(modelMapper.map(dto, PetOwner.class));
            return modelMapper.map(savedPetOwner, PetOwnerDto.class);
        } else {
            log.error("Тело сущности равно null");
            return null;
        }

    }

    @Override
    public PetOwnerDto update(PetOwnerDto dto) {
        if (dto.getId() != null && getById(dto.getId()) != null) {
            PetOwner savedPetOwner = petOwnerRepository.save(modelMapper.map(dto, PetOwner.class));
            return modelMapper.map(savedPetOwner, PetOwnerDto.class);
        } else {
            if (dto.getId() != null) {
                log.error(String.format("Сущность PetOwner с id = %s , не найдена", dto.getId()));
            }
            return null;
        }
    }

    @Override
    public PetOwnerDto getById(Long id) {
        PetOwner receivedPetOwner = petOwnerRepository.findById(id).orElse(null);
        if (receivedPetOwner != null) {
            return modelMapper.map(receivedPetOwner, PetOwnerDto.class);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        petOwnerRepository.deleteById(id);
    }

    @Override
    public List<PetOwnerDto> getList() {
        return null;
    }
}
