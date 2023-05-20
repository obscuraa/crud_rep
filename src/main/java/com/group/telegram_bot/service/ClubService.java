package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.club.CreateClubDto;
import com.group.telegram_bot.dto.club.UpdateClubDto;
import com.group.telegram_bot.model.Club;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ClubService {
    List<Club> getClubs();

    Club findClubById(UUID clubId);

    Club addNewClub(CreateClubDto createClubDto);

    Boolean deleteClub(UUID clientId);

    Club updateClub(UUID clubId, UpdateClubDto updateClubDto);

    Club addMembers(UUID clubId, Set<UUID> memberIds);
}
