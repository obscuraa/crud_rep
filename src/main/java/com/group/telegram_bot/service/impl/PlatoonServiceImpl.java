package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.dto.platoon.CreatePlatoonDto;
import com.group.telegram_bot.exceptions.NotFoundDbObject;
import com.group.telegram_bot.model.Group;
import com.group.telegram_bot.model.Platoon;
import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.repository.PlatoonRepository;
import com.group.telegram_bot.service.GroupService;
import com.group.telegram_bot.service.PlatoonService;
import com.group.telegram_bot.service.StudentService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlatoonServiceImpl implements PlatoonService {

    private final PlatoonRepository platoonRepository;
    private final GroupService groupService;
    private final StudentService studentService;

    @Override
    public Platoon createPlatoon(CreatePlatoonDto createPlatoonDto) {
        var platoon = new Platoon();
        platoon.setNumber(createPlatoonDto.getNumber());
        var commander = studentService.findStudentById(createPlatoonDto.getCommanderId());
        platoon.setCommander(commander);
        var groups = new ArrayList<Group>();
        for (UUID groupId : createPlatoonDto.getGroups()) {
            var group = groupService.findGroupById(groupId);
            groups.add(group);
        }
        platoon.setGroups(groups);
        return platoonRepository.save(platoon);
    }

    @Override
    public void deletePlatoonById(UUID platoonId) {
        platoonRepository.deleteById(platoonId);
    }

    @Override
    public List<Platoon> getPlatoons() {
        return platoonRepository.findAll();
    }

    @Override
    public Platoon getPlatoonById(UUID platoonId) {
        return platoonRepository.findById(platoonId).orElseThrow(() -> new NotFoundDbObject("Platoon not found. Id = " + platoonId));
    }

    @Override
    public List<Student> getPlatoonStudents(UUID platoonId) {
        Platoon platoon = getPlatoonById(platoonId);
        return platoon.getGroups()
                .stream()
                .map(Group::getStudents)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
