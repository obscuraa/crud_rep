package com.group.telegram_bot.dto.studentFamily;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateStudentFamilyDto {
    private String fullName;
    private String telephone;
    private String address;
    private String workplace;
    private String relativeRole;
}
