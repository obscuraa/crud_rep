package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.platoon.CreatePlatoonDto;
import com.group.telegram_bot.model.Platoon;
import com.group.telegram_bot.model.Student;

import java.util.List;
import java.util.UUID;

public interface PlatoonService {
    Platoon createPlatoon(CreatePlatoonDto createPlatoonDto);
    void deletePlatoonById(UUID platoonId);

    List<Platoon> getPlatoons();

    Platoon getPlatoonById(UUID platoonId);

    List<Student> getPlatoonStudents(UUID platoonId);
}
