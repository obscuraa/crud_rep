package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.platoon.CreatePlatoonDto;
import com.group.telegram_bot.dto.platoon.FullPlatoonDto;
import com.group.telegram_bot.dto.platoon.UpdatePlatoonDto;
import com.group.telegram_bot.model.Platoon;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PlatoonMapper {
    FullPlatoonDto toFullDto(Platoon platoon);

    Platoon createDtoToEntity(CreatePlatoonDto createPlatoonDto);

    Platoon updateEntityFromDto(@MappingTarget Platoon platoon, UpdatePlatoonDto updatePlatoonDto);
}
