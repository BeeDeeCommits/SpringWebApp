package com.banks.doggo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.time.LocalDate;

/** Represents a Reservation
 * @author Bankole Abawonse
 */

@Entity
@Table(name = "reservations")
@NoArgsConstructor
@Getter
@Setter
public class Reservation {

    @Id
    private Long id;
    private Time startTime;
    private Time endTime;
    private LocalDate date;

}
