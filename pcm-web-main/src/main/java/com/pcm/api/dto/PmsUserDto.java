package com.pcm.api.dto;

import com.pcm.api.entity.AbstractPersistent;
import com.pcm.api.entity.UserType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class PmsUserDto extends AbstractPersistent {
    private String userId;
    private String fname;
    private String lname;
    private UserType type; //enum defined

}
