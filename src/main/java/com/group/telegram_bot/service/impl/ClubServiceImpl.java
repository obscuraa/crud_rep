package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.Repository.ClubRepository;
import com.group.telegram_bot.dto.club.CreateClubDto;
import com.group.telegram_bot.dto.club.UpdateClubDto;
import com.group.telegram_bot.mapper.ClubMapper;
import com.group.telegram_bot.model.Club;
import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.service.ClubService;
import com.group.telegram_bot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;
    private final StudentService studentService;

    public List<Club> getClubs() {
        return clubRepository.findAll();
    }

    public Club findClubById(UUID clubId) {
        return clubRepository.findById(clubId).orElse(null);
    }

    public Club addNewClub(CreateClubDto createClubDto) {
        Club club = clubMapper.createDtoToEntity(createClubDto);

        var result = clubRepository.save(club);
        return result;
    }

    public Boolean deleteClub(UUID clubId) {
        if (!clubRepository.existsById(clubId)) {
            throw new IllegalStateException("club id " + clubId + "does not exist");
        }
        clubRepository.deleteById(clubId);
        return true;
    }

    public Club updateClub(UUID clubId, UpdateClubDto updateClubDto) {
        var optionalClub = clubRepository.findById(clubId);
        if (optionalClub.isEmpty()) {
            return null;
        }
        var club = optionalClub.get();
        club.setName(updateClubDto.getName() == null ? club.getName() : updateClubDto.getName());
        var result = clubRepository.save(club);
        return result;
    }

    @Override
    public Club addMembers(UUID clubId, Set<UUID> memberIds) {
        var optionalClub = clubRepository.findById(clubId);

        if(optionalClub.isPresent()){
            Club club = optionalClub.get();

            var members = new ArrayList<Student>();
            for (UUID memberId : memberIds) {
                Student member = studentService.findStudentById(memberId);
                members.add(member);
            }
            club.addMembers(members);
            return clubRepository.save(club);
        }
        throw new IllegalArgumentException("club id " + clubId + " not found");
    }
}
