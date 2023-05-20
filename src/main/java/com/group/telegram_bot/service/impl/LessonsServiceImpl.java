package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.Repository.LessonsRepository;
import com.group.telegram_bot.dto.lessons.CreateLessonsDto;
import com.group.telegram_bot.dto.lessons.UpdateLessonsDto;
import com.group.telegram_bot.mapper.LessonsMapper;
import com.group.telegram_bot.model.Lessons;
import com.group.telegram_bot.service.LessonsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonsServiceImpl implements LessonsService {
    private final LessonsMapper lessonsMapper;
    private final LessonsRepository lessonsRepository;

    @Override
    public List<Lessons> getLessons() {
        return lessonsRepository.findAll();
    }

    @Override
    public Lessons findLessonsById(UUID lessonsId) {
        return lessonsRepository.findById(lessonsId).orElse(null);
    }

    @Override
    public Lessons addNewLessons(CreateLessonsDto createLessonsDto) {
        Lessons lessons = lessonsMapper.createDtoToEntity(createLessonsDto);

        var result = lessonsRepository.save(lessons);
        return result;
    }

    @Override
    public Boolean deleteLessons(UUID lessonsId) {
        if (!lessonsRepository.existsById(lessonsId)) {
            throw new IllegalStateException("lessons id " + lessonsId + "does not exist");
        }
        lessonsRepository.deleteById(lessonsId);
        return true;
    }

    @Override
    public Lessons updateLessons(UUID lessonsId, UpdateLessonsDto updateLessonsDto) {
        var optionalLessons = lessonsRepository.findById(lessonsId);
        if (optionalLessons.isEmpty()) {
            return null;
        }
        var lessons = optionalLessons.get();
        lessons.setMark(updateLessonsDto.getMark() == null ? lessons.getMark() : updateLessonsDto.getMark());
        var result = lessonsRepository.save(lessons);
        return result;
    }
}
