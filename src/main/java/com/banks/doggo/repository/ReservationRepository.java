package com.banks.doggo.repository;

import com.banks.doggo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/** provides mechanism for CRUD operations on Reservation class
 * @author Bankole Abawonse
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    /** Abstract method for finding reservations by member Email.
     * @param petName the email of the member.
     * @return returns a reservation for a member.
     */
    @Query(value = "FROM Reservation r WHERE r.petName =? 1")
    List<Reservation> findReservation(String petName);

}
