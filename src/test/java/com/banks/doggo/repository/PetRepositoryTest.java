package com.banks.doggo.repository;

import com.banks.doggo.model.Pet;
import lombok.NoArgsConstructor;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@NoArgsConstructor
public class PetRepositoryTest {
    @Autowired
    private PetRepository petRepository;


    @Test
    public void myRepoTest() {
        petRepository.deleteAll();
        petRepository.save(new Pet("Milo", "7", "Husky"));
        Pet pet = petRepository.findByBreed("Husky");
        assertThat(pet.getBreed()).isEqualTo("Husky");
    }
}
