package com.zooclinic.zooclinic.rest;

import com.zooclinic.zooclinic.dto.VisitDto;
import com.zooclinic.zooclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/visit")
public class VisitController {

    private final VisitService service;

    @PostMapping
    public ResponseEntity<VisitDto> save(@RequestBody VisitDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping
    public ResponseEntity<VisitDto> update(@RequestBody VisitDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
