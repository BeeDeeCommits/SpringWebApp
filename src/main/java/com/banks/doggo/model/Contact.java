package com.banks.doggo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/** Represents contact entity for members
 * @author Bankole Abawonse
 */
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String phoneNumber;
    @OneToOne
    private Member member;


}
