package com.group.telegram_bot.dto.platoon;

import java.util.Set;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreatePlatoonDto {
    @NotNull
    private String number;
    @NotNull
    private UUID commanderId;
    @NotNull
    private Set<UUID> groups;
}
