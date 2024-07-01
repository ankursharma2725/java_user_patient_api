package com.pcm.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pms_user")
@Entity
public class PmsUser extends AbstractPersistent {

    @Column(name = "user_id")
    private String userId;
    @Column(name = "first_name")
    private String fname;
    @Column(name = "last_name")
    private String lname;
    //type is defined as enum
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UserType type;


}
