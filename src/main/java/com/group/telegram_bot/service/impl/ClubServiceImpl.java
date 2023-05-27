package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.repository.ClubRepository;
import com.group.telegram_bot.dto.club.CreateClubDto;
import com.group.telegram_bot.dto.club.UpdateClubDto;
import com.group.telegram_bot.exceptions.NotFoundDbObject;
import com.group.telegram_bot.mapper.ClubMapper;
import com.group.telegram_bot.model.Club;
import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.service.ClubService;
import com.group.telegram_bot.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;
    private final StudentService studentService;

    private final static String NOT_FOUND_MESSAGE = "Клуб [id = %s] не был обнаружен в базе данных";

    public List<Club> getClubs() {
        return clubRepository.findAll();
    }

    public Club findClubById(UUID clubId) {
        return clubRepository.findById(clubId)
            .orElseThrow(() -> new NotFoundDbObject(String.format(NOT_FOUND_MESSAGE, clubId)));
    }

    public Club addNewClub(CreateClubDto createClubDto) {
        Club club = clubMapper.createDtoToEntity(createClubDto);
        return clubRepository.save(club);
    }

    public Boolean deleteClub(UUID clubId) {
        if (!clubRepository.existsById(clubId)) {
            throw new NotFoundDbObject(String.format(NOT_FOUND_MESSAGE, clubId));
        }
        clubRepository.deleteById(clubId);
        return true;
    }

    public Club updateClub(UUID clubId, UpdateClubDto updateClubDto) {
        var optionalClub = clubRepository.findById(clubId);
        if (optionalClub.isEmpty()) {
            throw new NotFoundDbObject(String.format(NOT_FOUND_MESSAGE, clubId));
        }
        var club = optionalClub.get();
        club.setName(updateClubDto.getName() == null ? club.getName() : updateClubDto.getName());
        var result = clubRepository.save(club);
        return result;
    }

    @Override
    public Club addMembers(UUID clubId, Set<UUID> memberIds) {
        var optionalClub = clubRepository.findById(clubId);

        if (optionalClub.isPresent()) {
            Club club = optionalClub.get();

            var members = new ArrayList<Student>();
            for (UUID memberId : memberIds) {
                Student member = studentService.findStudentById(memberId);
                members.add(member);
            }
            club.addMembers(members);
            return clubRepository.save(club);
        }
        throw new NotFoundDbObject(String.format(NOT_FOUND_MESSAGE, clubId));
    }

    @Override
    public Club addMember(UUID clubId, UUID memberId) {
        AtomicReference<Club> result = null;
        clubRepository.findById(clubId).ifPresent(club -> {
            var student = studentService.findStudentById(memberId);
            //TODO: почему это не правильно?
            club.getMembers().add(student);
            result.set(clubRepository.save(club));
        });
        throw new NotFoundDbObject(String.format(NOT_FOUND_MESSAGE, clubId));
    }

    @Override
    public void deleteMember(UUID clubId, UUID memberId) {
        clubRepository.findById(clubId).ifPresent(club -> {
            var student = studentService.findStudentById(memberId);
            //TODO: почему это не правильно?
            club.getMembers().remove(student);
        });
        throw new NotFoundDbObject(String.format(NOT_FOUND_MESSAGE, clubId));
    }
}
