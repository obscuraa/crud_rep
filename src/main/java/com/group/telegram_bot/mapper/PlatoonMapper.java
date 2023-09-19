package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.platoon.FullPlatoonDto;
import com.group.telegram_bot.model.Platoon;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlatoonMapper {
    FullPlatoonDto toFullDto(Platoon platoon);

    List<FullPlatoonDto> toFullListDto(List<Platoon> platoons);
}
