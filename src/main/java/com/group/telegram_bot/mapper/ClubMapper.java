package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.club.CreateClubDto;
import com.group.telegram_bot.dto.club.FullClubDto;
import com.group.telegram_bot.model.Club;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public interface ClubMapper {
    FullClubDto toFullDto(Club club);

    Club createDtoToEntity(CreateClubDto createClubDto);

    List<FullClubDto> toListClubDto(List<Club> clubs);
}
