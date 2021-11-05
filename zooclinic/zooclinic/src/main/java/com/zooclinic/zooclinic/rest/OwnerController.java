package com.zooclinic.zooclinic.rest;

import com.zooclinic.zooclinic.dto.OwnerDto;
import com.zooclinic.zooclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/petowner")
public class OwnerController {

    private final OwnerService service;

    @PostMapping
    public ResponseEntity<OwnerDto> save(@RequestBody OwnerDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping
    public ResponseEntity<OwnerDto> update(@RequestBody OwnerDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
