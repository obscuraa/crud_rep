package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.group.CreateGroupDto;
import com.group.telegram_bot.dto.group.FullGroupDto;
import com.group.telegram_bot.model.Group;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    //Group updateDtoToEntity(UpdateGroupDto updateGroupDto);

    FullGroupDto toFullDto(Group group);

    Group createDtoToEntity(CreateGroupDto createGroupDto);

    List<FullGroupDto> toListGroupDto(List<Group> groups);
}
