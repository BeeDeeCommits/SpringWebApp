package com.banks.doggo.repository;

import com.banks.doggo.model.Reservation;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@NoArgsConstructor
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;
    @Test
    public void reservationRepository() {
        reservationRepository.save(new  Reservation(Long.valueOf(3), "13:00", "14:30", new Date(), "Bruno" ));
        reservationRepository.findReservation("Bruno");
        Reservation reservation = reservationRepository.findById(Long.valueOf(3)).get();
        assertThat(reservation.getPetName()).isEqualTo("Bruno");
    }
}
