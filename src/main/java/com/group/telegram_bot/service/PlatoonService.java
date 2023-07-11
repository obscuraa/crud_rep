package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.platoon.CreatePlatoonDto;
import com.group.telegram_bot.dto.platoon.UpdatePlatoonDto;
import com.group.telegram_bot.model.Group;
import com.group.telegram_bot.model.Platoon;

import java.util.List;
import java.util.UUID;

public interface PlatoonService {
    List<Platoon> getPlatoons();

    Platoon findPlatoonById(UUID id);

    void deletedPlatoon(UUID id);

    void addGroupToPlatoon(UUID platoonId, Group group);

    Platoon addPlatoon(CreatePlatoonDto createPlatoonDto);

    Platoon updatePlatoon(UUID id, UpdatePlatoonDto updatePlatoonDto);

    Platoon updateCommander(UUID platoonId, UUID studentId);
}
