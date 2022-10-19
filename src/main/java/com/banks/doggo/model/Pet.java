package com.banks.doggo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/** Represents a pet belonging to a Member.
 * @author Bankole Abawonse
 */

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
public class Pet {

    private String name;
    private String age;
    private String breed;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Creates a pet with the specified name, age and breed.
     * @param name The name of the pet.
     * @param age The age of the pet.
     * @param breed The breed of the pet.
     */
    public Pet(String name, String age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }
}
