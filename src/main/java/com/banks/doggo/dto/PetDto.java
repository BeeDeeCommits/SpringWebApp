package com.banks.doggo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/** Represents data from form used to model/create Pet object.
 * @author Bankole Abawonse
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String age;
    @NotEmpty
    private String breed;
}
