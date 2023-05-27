package com.group.telegram_bot.controller;

import com.group.telegram_bot.dto.disciplinaryPractice.CreateDisciplinaryPracticeDto;
import com.group.telegram_bot.dto.disciplinaryPractice.FullDisciplinaryPracticeDto;
import com.group.telegram_bot.dto.disciplinaryPractice.UpdateDisciplinaryPracticeDto;
import com.group.telegram_bot.mapper.DisciplinaryPracticeMapper;
import com.group.telegram_bot.service.DisciplinaryPracticeService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/disciplinaryPractice")
@RequiredArgsConstructor
public class DisciplinaryPracticeController {
    private final DisciplinaryPracticeService disciplinaryPracticeService;
    private final DisciplinaryPracticeMapper disciplinaryPracticeMapper;

    @GetMapping
    public List<FullDisciplinaryPracticeDto> getDisciplinaryPractices() {
        return disciplinaryPracticeMapper.toListDisciplinaryPracticeDto(disciplinaryPracticeService.getDisciplinaryPractices());
    }

    @GetMapping(path = "/{disciplinaryPracticeId}")
    public FullDisciplinaryPracticeDto findByDisciplinaryPracticeId(@PathVariable("disciplinaryPracticeId") UUID disciplinaryPractice) {
        return disciplinaryPracticeMapper.toFullDto(disciplinaryPracticeService.findDisciplinaryPracticeById(disciplinaryPractice));
    }

    @PostMapping
    public FullDisciplinaryPracticeDto addNewDisciplinaryPractice(@RequestBody CreateDisciplinaryPracticeDto disciplinaryPractice) {
        return disciplinaryPracticeMapper.toFullDto(disciplinaryPracticeService.addNewDisciplinaryPractice(disciplinaryPractice));
    }

    @DeleteMapping(path = "/{disciplinaryPracticeId}")
    public void deleteDisciplinaryPractice(@PathVariable("disciplinaryPracticeId") UUID disciplinaryPracticeId) {
        disciplinaryPracticeService.deleteDisciplinaryPractice(disciplinaryPracticeId);
    }

    @PutMapping(path = "/{disciplinaryPracticeId}")
    public FullDisciplinaryPracticeDto updateClub(
            @PathVariable("disciplinaryPracticeId") UUID disciplinaryPracticeId,
            @RequestBody UpdateDisciplinaryPracticeDto updateDisciplinaryPracticeDto) {
        return disciplinaryPracticeMapper.toFullDto(disciplinaryPracticeService.updateDisciplinaryPractice(disciplinaryPracticeId, updateDisciplinaryPracticeDto));
    }

    @PutMapping(path = "/{disciplinaryPracticeId}/addStudent/{studentId}")
    public FullDisciplinaryPracticeDto addStudent(@PathVariable("disciplinaryPracticeId") UUID disciplinaryPracticeId, @PathVariable("studentId") UUID studentId){
        return disciplinaryPracticeMapper.toFullDto(disciplinaryPracticeService.addStudent(disciplinaryPracticeId, studentId));
    }
}
