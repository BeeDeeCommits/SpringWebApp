package com.banks.doggo.service;

import com.banks.doggo.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
}
