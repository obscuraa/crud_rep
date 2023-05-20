package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.club.CreateClubDto;
import com.group.telegram_bot.dto.club.FullClubDto;
import com.group.telegram_bot.model.Club;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClubMapper {
    //Club updateDtoToEntity(UpdateClubDto updateClubDto);

    FullClubDto toFullDto(Club club);

    Club createDtoToEntity(CreateClubDto createClubDto);

    List<FullClubDto> toListClubDto(List<Club> clubs);
}
