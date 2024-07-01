package com.pcm.api.dto;

import com.pcm.api.entity.AbstractPersistent;

import com.pcm.api.entity.PmsUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class PmsPatientVitalsDto extends AbstractPersistent {
    private int bpU;
    private int bpLw;
    private int temperature;
    private PmsUser pid; //pid is defined as object of entity
}
