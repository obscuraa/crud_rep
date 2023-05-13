package com.group.telegram_bot.dto;

import com.group.telegram_bot.model.projection.SisterInfoProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SisterInfo implements SisterInfoProjection {
    public String name;
    public String telephoneNumber;
    public String address;
    public String jobAddress;
}
