package com.group.telegram_bot.dto.group;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateGroupDto {
    private String name;
    private int number;
}
