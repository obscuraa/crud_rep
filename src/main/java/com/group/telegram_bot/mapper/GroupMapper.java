package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.group.CreateGroupDto;
import com.group.telegram_bot.dto.group.FullGroupDto;
import com.group.telegram_bot.model.Group;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public interface GroupMapper {

    FullGroupDto toFullDto(Group group);

    Group createDtoToEntity(CreateGroupDto createGroupDto);

    List<FullGroupDto> toListGroupDto(List<Group> groups);
}
