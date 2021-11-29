package com.zooclinic.zooclinic.service.impl;

import com.zooclinic.zooclinic.dto.VisitDto;
import com.zooclinic.zooclinic.model.Visit;
import com.zooclinic.zooclinic.repo.OwnerRepository;
import com.zooclinic.zooclinic.repo.VisitRepository;
import com.zooclinic.zooclinic.service.IncidentHandler;
import com.zooclinic.zooclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final OwnerRepository ownerRepository;
    private ModelMapper modelMapper;
    private final IncidentHandler incidentHandler;

    @PostConstruct
    void init() {
        modelMapper = new ModelMapper();
    }

    @Override
    public VisitDto save(VisitDto dto) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        dto.getClient().setFirstName(ownerRepository.findByLogin(principal.getUsername()).getPerson().getFirstName());
        dto.getClient().setLastName(ownerRepository.findByLogin(principal.getUsername()).getPerson().getLastName());
        Visit savedVisit = visitRepository.save(modelMapper.map(dto, Visit.class));
        incidentHandler.createReport(savedVisit.toString());
        return modelMapper.map(savedVisit, VisitDto.class);
    }

    @Override
    public VisitDto update(VisitDto dto) {
        if (dto.getId() == null)
            throw new RuntimeException("Не указан индификатор визита или клиента");
        return modelMapper.map(visitRepository.save(modelMapper.map(dto, Visit.class)), VisitDto.class);
    }

    @Override
    public VisitDto getById(Long id) {
        Visit visit = visitRepository.findById(id).orElse(null);
        if (visit != null) {
            return modelMapper.map(visit, VisitDto.class);
        } else {
            return null;
        }
    }

    @Override
    public List<VisitDto> getList(PageRequest pageRequest) {
        visitRepository.findAll(pageRequest);
        return visitRepository.findAll(pageRequest).stream()
                .map(entity ->modelMapper.map(entity, VisitDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        visitRepository.deleteById(id);
    }
}
