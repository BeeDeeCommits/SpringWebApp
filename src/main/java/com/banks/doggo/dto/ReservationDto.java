package com.banks.doggo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * Represents model from form used to create a Reservation object.
 * @author Bankole Abawonse
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String endTime;
    @NotEmpty
    private String petName;
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
