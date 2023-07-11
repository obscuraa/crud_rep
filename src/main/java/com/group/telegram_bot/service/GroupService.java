package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.group.CreateGroupDto;
import com.group.telegram_bot.dto.group.UpdateGroupDto;
import com.group.telegram_bot.model.Group;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface GroupService {
    List<Group> getGroups();

    Group findGroupById(UUID groupId);

    Group addNewGroup(CreateGroupDto CreateGroupDto);

    Boolean deleteGroup(UUID groupId);

    Group updateGroup(UUID groupId, UpdateGroupDto updateGroupDto);

    Group addStudents(UUID groupId, Set<UUID> studentIds);

    void addStudent(UUID groupId, UUID studentId);

    Group findGroupByNumber(int groupNumber);

    Group updateCommander(UUID groupId, UUID studentId);
}
