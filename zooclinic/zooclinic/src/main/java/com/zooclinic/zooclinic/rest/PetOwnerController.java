package com.zooclinic.zooclinic.rest;

import com.zooclinic.zooclinic.dto.PetOwnerDto;
import com.zooclinic.zooclinic.service.PetOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/petowner")
public class PetOwnerController {

    private final PetOwnerService service;

    @PostMapping
    public ResponseEntity<PetOwnerDto> save(@RequestBody PetOwnerDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping
    public ResponseEntity<PetOwnerDto> update(@RequestBody PetOwnerDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetOwnerDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
