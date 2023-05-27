package com.group.telegram_bot.dto.professor;

import com.group.telegram_bot.dto.group.FullGroupDto;
import com.group.telegram_bot.model.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FullProfessorDto {
    private UUID id;
    private String fullName;
    private List<FullGroupDto> groups;
}
