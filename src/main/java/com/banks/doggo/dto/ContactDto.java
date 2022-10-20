package com.banks.doggo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    @NotEmpty
    private String street;
    @NotEmpty
    private String city;

    private String phoneNumber;
}
