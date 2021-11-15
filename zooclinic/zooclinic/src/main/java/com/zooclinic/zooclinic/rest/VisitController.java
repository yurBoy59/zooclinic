package com.zooclinic.zooclinic.rest;

import com.zooclinic.zooclinic.dto.VisitDto;
import com.zooclinic.zooclinic.service.VisitService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "VisitController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/visit")
public class VisitController {

    private final VisitService service;

    @Operation(
            summary = "Создание визита в клинику",
            description = "Позволяет зарегистрировать визит в клинику"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Запрос выполнен успешно"),
            @ApiResponse(code = 400, message = "Неправильный запрос"),
            @ApiResponse(code = 500, message = "Ошибка во время выполнения запроса")
    })
    @PostMapping
    public ResponseEntity<VisitDto> save(@RequestBody VisitDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Operation(
            summary = "Обновление визита в клинику",
            description = "Позволяет обновить визит в клинику"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Запрос выполнен успешно"),
            @ApiResponse(code = 400, message = "Неправильный запрос"),
            @ApiResponse(code = 500, message = "Ошибка во время выполнения запроса")
    })
    @PutMapping
    public ResponseEntity<VisitDto> update(@RequestBody VisitDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @Operation(
            summary = "Получить визит по индификатору",
            description = "Позволяет получить визит по индификатору"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Запрос выполнен успешно"),
            @ApiResponse(code = 400, message = "Неправильный запрос"),
            @ApiResponse(code = 500, message = "Ошибка во время выполнения запроса")
    })
    @GetMapping("/{id}")
    public ResponseEntity<VisitDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(
            summary = "Удалить визит по индификатору",
            description = "Позволяет удалить визит по индификатору"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Запрос выполнен успешно"),
            @ApiResponse(code = 400, message = "Неправильный запрос"),
            @ApiResponse(code = 500, message = "Ошибка во время выполнения запроса")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(
            summary = "Получить список всех визитов",
            description = "Позволяет получить список всех визитов"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Запрос выполнен успешно"),
            @ApiResponse(code = 400, message = "Неправильный запрос"),
            @ApiResponse(code = 500, message = "Ошибка во время выполнения запроса")
    })
    @GetMapping("/list")
    public ResponseEntity<List<VisitDto>> getList(@RequestParam(name = "page") Integer page,
                                                  @RequestParam(name = "size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(service.getList(pageRequest));
    }
}
