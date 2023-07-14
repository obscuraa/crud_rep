package com.group.telegram_bot.controller;

import com.group.telegram_bot.dto.platoon.CreatePlatoonDto;
import com.group.telegram_bot.dto.platoon.FullPlatoonDto;
import com.group.telegram_bot.dto.platoon.UpdatePlatoonDto;
import com.group.telegram_bot.mapper.PlatoonMapper;
import com.group.telegram_bot.model.Group;
import com.group.telegram_bot.service.PlatoonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/platoon")
@RequiredArgsConstructor
public class PlatoonController {
    private final PlatoonService platoonService;
    private final PlatoonMapper platoonMapper;

    @GetMapping
    public List<FullPlatoonDto> getGroups() {
        return platoonMapper.toListPlatoonDto(platoonService.getPlatoons());
    }

    @GetMapping(path = "/{platoonId}")
    public FullPlatoonDto findByGroupId(@PathVariable("platoonId") UUID platoonID) {
        return platoonMapper.toFullDto(platoonService.findPlatoonById(platoonID));
    }

    @PostMapping
    public FullPlatoonDto addPlatoon(@RequestBody CreatePlatoonDto platoonDto) {
        return platoonMapper.toFullDto(platoonService.addPlatoon(platoonDto));
    }

    @DeleteMapping(path = "/{platoonId}")
    public void deletePlatoon(@PathVariable("platoonId") UUID platoonId) {
        platoonService.deletedPlatoon(platoonId);
    }

    @PutMapping(path = "/{platoonId}")
    public FullPlatoonDto updatePlatoon(
            @PathVariable("platoonId") UUID platoonId,
            @RequestBody UpdatePlatoonDto updatePlatoonDto) {
        return platoonMapper.toFullDto(platoonService.updatePlatoon(platoonId, updatePlatoonDto));
    }

    @PutMapping(path = "/{platoonId}/addCommander/{studentId}")
    public FullPlatoonDto updateCommander( @PathVariable("platoonId") UUID platoonId, @PathVariable("studentId") UUID studentId){
        return platoonMapper.toFullDto(platoonService.updateCommander(platoonId, studentId));
    }

    @PutMapping(path = "/addGroup/{platoonId}")
    public void addGroupToPlatoon( @PathVariable("platoonId") UUID platoonId, @RequestBody Group group){
        platoonService.addGroupToPlatoon(platoonId, group);
    }
}
