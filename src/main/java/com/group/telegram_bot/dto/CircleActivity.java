package com.group.telegram_bot.dto;

import com.group.telegram_bot.model.projection.CircleActivityProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CircleActivity implements CircleActivityProjection {
    public String supervisorName;
    public String circleName;
    public String members;
}
