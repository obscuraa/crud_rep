package com.group.telegram_bot.dto;

import com.group.telegram_bot.model.projection.RelativeInfoProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RelativeInfo implements RelativeInfoProjection {
    public String name;
    public String telephoneNumber;
    public String address;
    public String jobAddress;
}
