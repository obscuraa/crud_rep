package com.group.telegram_bot.controller;

import com.group.telegram_bot.dto.group.CreateGroupDto;
import com.group.telegram_bot.dto.group.FullGroupDto;
import com.group.telegram_bot.dto.group.UpdateGroupDto;
import com.group.telegram_bot.mapper.GroupMapper;
import com.group.telegram_bot.service.GroupService;
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
@RequiredArgsConstructor
@RequestMapping(path = "/group")
public class GroupController {
    private final GroupService groupService;
    private final GroupMapper groupMapper;
    @GetMapping
    public List<FullGroupDto> getGroups() {
        return groupMapper.toListGroupDto(groupService.getGroups());
    }

    @GetMapping(path = "/{groupId}")
    public FullGroupDto findByGroupId(@PathVariable("groupId") UUID groupID) {
        return groupMapper.toFullDto(groupService.findGroupById(groupID));
    }

    @PostMapping
    public FullGroupDto addNewGroup(@RequestBody CreateGroupDto group) {
        return groupMapper.toFullDto(groupService.addNewGroup(group));
    }

    @DeleteMapping(path = "{groupId}")
    public Boolean deleteGroup(@PathVariable("groupId") UUID groupId) {
        return groupService.deleteGroup(groupId);
    }

    @PutMapping(path = "{groupId}")
    public FullGroupDto updateGroup(
            @PathVariable("groupId") UUID groupId,
            @RequestBody UpdateGroupDto updateGroupDto) {
        return groupMapper.toFullDto(groupService.updateGroup(groupId, updateGroupDto));
    }
    @PutMapping(path = "{groupId}/addStudent/{studentId}")
    public FullGroupDto addStudents( @PathVariable("groupId") UUID groupId, @PathVariable("studentId") Set<UUID> studentId){
        return groupMapper.toFullDto(groupService.addStudents(groupId, studentId));
    }
}
