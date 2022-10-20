package com.banks.doggo.service;


import com.banks.doggo.dto.PetDto;
import com.banks.doggo.model.Member;
import com.banks.doggo.model.Pet;
import com.banks.doggo.repository.MemberRepository;
import com.banks.doggo.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/** Implements logic related to the Pet class
 * @author Bankole Abawonse
 */
@Service
@AllArgsConstructor
public class PetService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PetRepository petRepository;

    /**
     * Creates a new pet entity
     * @param petDto retrieves pet model used to populate the Pet object
     */
    public void addPet(PetDto petDto) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        String memberEmail = principal.getName();
        Member member = memberRepository.findByEmail(memberEmail);
        Set<Pet> pets = member.getPets();
        Pet pet = new Pet();
        pet.setName(petDto.getName());
        pet.setAge(petDto.getAge());
        pet.setBreed(petDto.getBreed());
        pets.add(pet);
        member.setPets(pets);
        memberRepository.save(member);
    }

    /**
     * Finds a pet based off the breed
     * @param breed breed information to be queried against the database
     * @return returns pet by breed
     */
    public Pet findPetByBreed(String breed) {
          return petRepository.findByBreed(breed);
    }



}
