package com.corvusinfo.registrationapi.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Registration {

    @Id
    @NotNull
    private String registration;

    @Column
    private LocalDate date;
}
