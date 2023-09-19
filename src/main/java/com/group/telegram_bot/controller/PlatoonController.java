package com.group.telegram_bot.controller;

import com.group.telegram_bot.dto.platoon.CreatePlatoonDto;
import com.group.telegram_bot.dto.platoon.FullPlatoonDto;
import com.group.telegram_bot.dto.student.ShortStudentDto;
import com.group.telegram_bot.mapper.PlatoonMapper;
import com.group.telegram_bot.mapper.StudentMapper;
import com.group.telegram_bot.service.PlatoonService;

import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "platoon")
@Tag(name = "Взвод", description = "API взвода")
public class PlatoonController {

    private final PlatoonService platoonService;
    private final PlatoonMapper platoonMapper;
    private final StudentMapper studentMapper;

    @PostMapping
    public FullPlatoonDto createPlatoon(@RequestBody CreatePlatoonDto createPlatoonDto) {
        return platoonMapper.toFullDto(platoonService.createPlatoon(createPlatoonDto));
    }

    @DeleteMapping(path = "/{platoonId}")
    public void deletePlatoon(@PathVariable(name = "platoonId") UUID platoonId) {
        platoonService.deletePlatoonById(platoonId);
    }

    @GetMapping
    @Operation(summary = "Получение списка взводов", description = "Получение списка взводов")
    public List<FullPlatoonDto> getPlatoons() {
        return platoonMapper.toFullListDto(platoonService.getPlatoons());
    }

    @GetMapping(path = "/{platoonId}/students")
    @Operation(summary = "Получение списка студентов взвода", description = "Получение списка студентов взвода")
    public List<ShortStudentDto> getPlatoonStudents(@PathVariable(name = "platoonId") UUID platoonId) {
        return studentMapper.toShortDtoList(platoonService.getPlatoonStudents(platoonId));
    }
}
