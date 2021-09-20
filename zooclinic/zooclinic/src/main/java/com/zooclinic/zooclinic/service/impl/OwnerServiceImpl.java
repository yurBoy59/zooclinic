package com.zooclinic.zooclinic.service.impl;

import com.zooclinic.zooclinic.dto.OwnerDto;
import com.zooclinic.zooclinic.model.Owner;
import com.zooclinic.zooclinic.repo.OwnerRepository;
import com.zooclinic.zooclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private ModelMapper modelMapper;

    @PostConstruct
    void init() {
        modelMapper = new ModelMapper();
    }

    @Override
    public OwnerDto save(OwnerDto dto) {
        if (dto != null) {
            Owner savedOwner = ownerRepository.save(modelMapper.map(dto, Owner.class));
            return modelMapper.map(savedOwner, OwnerDto.class);
        } else {
            log.error("Тело сущности равно null");
            return null;
        }

    }

    @Override
    public OwnerDto update(OwnerDto dto) {
        if (dto.getId() != null && getById(dto.getId()) != null) {
            Owner savedOwner = ownerRepository.save(modelMapper.map(dto, Owner.class));
            return modelMapper.map(savedOwner, OwnerDto.class);
        } else {
            if (dto.getId() != null) {
                log.error(String.format("Сущность PetOwner с id = %s , не найдена", dto.getId()));
            }
            return null;
        }
    }

    @Override
    public OwnerDto getById(Long id) {
        Owner receivedOwner = ownerRepository.findById(id).orElse(null);
        if (receivedOwner != null) {
            return modelMapper.map(receivedOwner, OwnerDto.class);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public List<OwnerDto> getList() {
        return null;
    }
}
