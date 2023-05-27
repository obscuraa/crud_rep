package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.exceptions.NotFoundDbObject;
import com.group.telegram_bot.repository.GroupRepository;
import com.group.telegram_bot.dto.group.CreateGroupDto;
import com.group.telegram_bot.dto.group.UpdateGroupDto;
import com.group.telegram_bot.mapper.GroupMapper;
import com.group.telegram_bot.model.Group;
import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.service.GroupService;
import com.group.telegram_bot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final StudentService studentService;

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public Group findGroupById(UUID groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }

    public Group addNewGroup(CreateGroupDto createGroupDto) {
        Group group = groupMapper.createDtoToEntity(createGroupDto);

        var result = groupRepository.save(group);
        return result;
    }

    public Boolean deleteGroup(UUID groupId) {
        if (!groupRepository.existsById(groupId)) {
            throw new IllegalStateException("group id " + groupId + "does not exist");
        }
        groupRepository.deleteById(groupId);
        return true;
    }

    public Group updateGroup(UUID groupId, UpdateGroupDto updateGroupDto) {
        var optionalGroup = groupRepository.findById(groupId);
        if (optionalGroup.isEmpty()) {
            return null;
        }
        var group = optionalGroup.get();
        group.setName(updateGroupDto.getName() == null ? group.getName() : updateGroupDto.getName());
        var result = groupRepository.save(group);
        return result;
    }

    @Override
    public Group addStudents(UUID groupId, Set<UUID> studentIds) {
        var optionalGroup = groupRepository.findById(groupId);

        if(optionalGroup.isPresent()){
            Group group = optionalGroup.get();

            var groups = new ArrayList<Student>();
            for (UUID groupIds : studentIds) {
                Student member = studentService.findStudentById(groupId);
                groups.add(member);
            }
            group.addStudents(groups);
            return groupRepository.save(group);
        }
        throw new IllegalArgumentException("group id " + groupId + " not found");
    }

    @Override
    public void addStudent(UUID groupId, UUID studentId) {
        var group = groupRepository.findById(groupId)
            .orElseThrow(() -> new NotFoundDbObject("ADDSTUDENT: group not found"));
        var student = studentService.findStudentById(studentId);
        group.addStudents(List.of(student));
    }

    @Override
    public Group findGroupByNumber(int groupNumber) {
        return groupRepository.findByNumber(groupNumber)
            .orElseThrow(() -> new NotFoundDbObject("Group with number " + groupNumber + " not found"));
    }
}
