package com.banks.doggo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/** Represents a Reservation entity
 * @author Bankole Abawonse
 */

@Entity
@Table(name = "reservations")
@NoArgsConstructor
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startTime;
    private String endTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String petName;


}
