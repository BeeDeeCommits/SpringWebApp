package com.banks.doggo.repository;

import com.banks.doggo.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** provides mechanism for CRUD operations on Pet class
 * @author Bankole Abawonse
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query(value = "FROM Pet p where p.breed =?1")
    Pet findByBreed(String breed);

}
