package com.banks.doggo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "members")
@Getter
@Setter
@NoArgsConstructor
public class Member {

    private String firstName;
    private String lastName;
    private String password;
    @Id
    private String email;

    @OneToMany(mappedBy = "member")
    private Set<Pet> pets;

    @OneToMany(mappedBy = "member")
    private Set<Reservation> reservation;
}
