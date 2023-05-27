package com.group.telegram_bot.controller;

import com.group.telegram_bot.dto.club.CreateClubDto;
import com.group.telegram_bot.dto.club.FullClubDto;
import com.group.telegram_bot.dto.club.UpdateClubDto;
import com.group.telegram_bot.mapper.ClubMapper;
import com.group.telegram_bot.service.ClubService;
import java.util.List;
import java.util.Set;
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
@RequestMapping(path = "/club")
@RequiredArgsConstructor
public class ClubController {
    private final ClubService clubService;
    private final ClubMapper clubMapper;

    @GetMapping
    public List<FullClubDto> getClubs() {
        return clubMapper.toListClubDto(clubService.getClubs());
    }

    @GetMapping(path = "/{clubId}")
    public FullClubDto findByApplicationId(@PathVariable("clubId") UUID clubId) {
        return clubMapper.toFullDto(clubService.findClubById(clubId));
    }

    @PutMapping(path = "/{clubId}/members")
    public FullClubDto addMembers(@PathVariable("clubId") UUID clubId, @RequestBody Set<UUID> memberIds) {
        return clubMapper.toFullDto(clubService.addMembers(clubId, memberIds));
    }

    @PutMapping(path = "/{clubId}/member/{memberId}")
    public FullClubDto addMember(@PathVariable("clubId") UUID clubId, @PathVariable("memberId") UUID memberId) {
        return clubMapper.toFullDto(clubService.addMember(clubId, memberId));
    }

    @DeleteMapping(path = "/{clubId}/member/{memberId}")
    public void deleteMember(@PathVariable("clubId") UUID clubId, @PathVariable("memberId") UUID memberId) {
        clubService.deleteMember(clubId, memberId);
    }

    @PostMapping
    public FullClubDto addNewClub(@RequestBody CreateClubDto club) {
        return clubMapper.toFullDto(clubService.addNewClub(club));
    }

    @DeleteMapping(path = "/{clubId}")
    public Boolean deleteClub(@PathVariable("clubId") UUID clubId) {
        return clubService.deleteClub(clubId);
    }

    @PutMapping(path = "/{clubId}")
    public FullClubDto updateClub(
        @PathVariable("clubId") UUID clubId,
        @RequestBody UpdateClubDto updateClubDto) {
        return clubMapper.toFullDto(clubService.updateClub(clubId, updateClubDto));
    }
}
