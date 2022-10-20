package com.banks.doggo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/** Represents Member/User entity of the application
 * @author Bankole Abawonse
 */
@Entity
@Table(name = "members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Set<Pet> pets;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservation;

    @OneToOne
    private Contact contact;

    public Member(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
