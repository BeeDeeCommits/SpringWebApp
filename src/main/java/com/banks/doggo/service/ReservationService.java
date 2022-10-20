package com.banks.doggo.service;

import com.banks.doggo.dto.ReservationDto;
import com.banks.doggo.model.Member;
import com.banks.doggo.model.Pet;
import com.banks.doggo.model.Reservation;
import com.banks.doggo.repository.MemberRepository;
import com.banks.doggo.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/** Implements logic for Reservation class
 * @author Bankole Abawonse
 */
@Service
@AllArgsConstructor
public class ReservationService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Creates a reservation entity
     * @param reservationDto retrieves fields used to populate reservation object
     * @param email email for the member making the reservation
     */
    public void addReservation(ReservationDto reservationDto, String email) {
        Member member = memberRepository.findByEmail(email);
        Set<Reservation> reservations = member.getReservation();
        Reservation reservation = new Reservation();
        reservation.setStartTime(reservationDto.getStartTime());
        reservation.setEndTime(reservationDto.getEndTime());
        reservation.setDate(reservationDto.getDate());
        reservation.setPetName(reservationDto.getPetName());
        reservations.add(reservation);
        member.setReservation(reservations);
        memberRepository.save(member);
    }

    /**
     * Returns a list of pet options
     * @param email email of the current user which is automatically filled in as the principal user's email
     * @return returns a Set of pets associated with the email
     */
    public Set<Pet> reservationOptions(String email) {
        Member member = memberRepository.findByEmail(email);
        return member.getPets();
    }

    public List<Reservation> allReservations() {
        return reservationRepository.findAll();
    }





}
