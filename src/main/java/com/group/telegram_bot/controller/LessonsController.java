package com.group.telegram_bot.controller;

import com.group.telegram_bot.dto.lessons.CreateLessonsDto;
import com.group.telegram_bot.dto.lessons.FullLessonsDto;
import com.group.telegram_bot.dto.lessons.UpdateLessonsDto;
import com.group.telegram_bot.mapper.LessonsMapper;
import com.group.telegram_bot.service.LessonService;
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
@RequiredArgsConstructor
@RequestMapping(path = "lessons")
public class LessonsController {
    private final LessonService lessonService;
    private final LessonsMapper lessonsMapper;
    @GetMapping
    public List<FullLessonsDto> getLessons() {
        return lessonsMapper.toListLessonsDto(lessonService.getLessons());
    }

    @GetMapping(path = "/{lessonsId}")
    public FullLessonsDto findByLessonsId(@PathVariable("lessonsId") UUID lessonsId) {
        return lessonsMapper.toFullDto(lessonService.findLessonsById(lessonsId));
    }

    @PostMapping
    public FullLessonsDto addNewLessons(@RequestBody CreateLessonsDto lessons) {
        return lessonsMapper.toFullDto(lessonService.addNewLessons(lessons));
    }

    @DeleteMapping(path = "/{lessonsId}")
    public Boolean deleteLessons(@PathVariable("lessonsId") UUID lessonsId) {
        return lessonService.deleteLessons(lessonsId);
    }

    @PutMapping(path = "/{lessonsId}")
    public FullLessonsDto updateLessons(@PathVariable("lessonsId") UUID lessonsId,
                                        @RequestBody UpdateLessonsDto updateLessonsDto) {
        return lessonsMapper.toFullDto(lessonService.updateLessons(lessonsId, updateLessonsDto));
    }
}
