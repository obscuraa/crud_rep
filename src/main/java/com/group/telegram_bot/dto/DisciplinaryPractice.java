package com.group.telegram_bot.dto;

import com.group.telegram_bot.model.projection.DisciplinaryPracticeProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaryPractice implements DisciplinaryPracticeProjection {
    public String promotionType;
    public String collectionType;
}
