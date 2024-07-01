package com.pcm.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@Table(name = "pms_patient_vitals")
@Entity
public class PmsPatientVitals extends AbstractPersistent {

//    @Column(name = "pid")
//    private Long pid;
    @Column(name = "bp_u")
    private int bpU;
    @Column(name = "bp_lw")
    private int bpLw;
    private int temperature;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pid")  // Referencing the foreign key column in PmsUser
    private PmsUser pid;


}
