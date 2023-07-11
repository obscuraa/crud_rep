package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.dto.platoon.CreatePlatoonDto;
import com.group.telegram_bot.dto.platoon.UpdatePlatoonDto;
import com.group.telegram_bot.exceptions.NotFoundDbObject;
import com.group.telegram_bot.mapper.PlatoonMapper;
import com.group.telegram_bot.model.Group;
import com.group.telegram_bot.model.Platoon;
import com.group.telegram_bot.repository.PlatoonRepository;
import com.group.telegram_bot.service.PlatoonService;
import com.group.telegram_bot.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@Component
public class PlatoonServiceImpl implements PlatoonService {
    private final PlatoonRepository platoonRepository;
    private final PlatoonMapper platoonMapper;
    private final StudentService studentService;
    @Override
    public List<Platoon> getPlatoons() {
        return platoonRepository.findAll();
    }

    @Override
    public Platoon findPlatoonById(UUID id) {
        return platoonRepository.findById(id).orElseThrow(() -> new IllegalStateException("id not found"));
    }

    @Override
    public void deletedPlatoon(UUID id) {
        platoonRepository.deleteById(id);
    }

    @Override
    public void addGroupToPlatoon(UUID platoonId, Group group) {
        var platoon = platoonRepository.findById(platoonId).orElseThrow(() -> new RuntimeException("I'm faggot"));
        platoon.getGroups().add(group);
        platoonRepository.save(platoon);
    }

    @Override
    public Platoon addPlatoon(CreatePlatoonDto createPlatoonDto) {
        Platoon platoon = platoonMapper.createDtoToEntity(createPlatoonDto);
        return platoonRepository.save(platoon);
    }

    @Override
    public Platoon updatePlatoon(UUID id, UpdatePlatoonDto updatePlatoonDto) {
        var platoon = platoonRepository.findById(id).orElseThrow(() -> new RuntimeException("Mega faggot robo bit"));
        platoonMapper.updateEntityFromDto(platoon, updatePlatoonDto);
        return platoonRepository.save(platoon);
    }

    @Override
    public Platoon updateCommander(UUID platoonId, UUID studentId) {
        var platoon = platoonRepository.findById(platoonId)
                .orElseThrow(() -> new NotFoundDbObject("ADDSTUDENT: platoon not found"));
        var student = studentService.findStudentById(studentId);
        platoon.setCommander(student);
        return platoonRepository.save(platoon);
    }
}
