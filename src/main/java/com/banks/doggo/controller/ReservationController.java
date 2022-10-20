package com.banks.doggo.controller;

import com.banks.doggo.dto.ReservationDto;
import com.banks.doggo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Date;


/** Controller for the reservation model
 * @author Bankole Abawonse
 */
@Controller
public class ReservationController {


    @Autowired
    private ReservationService reservationService;

    /**
     * Handler method to handle reservation form request.
     * @param model creates a model object mapped to store reservation data.
     * @return returns the reservation page.
     */
    @GetMapping("/reservation")
    public String reservationForm(Model model) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setDate(new Date());
        model.addAttribute("reservation", reservationDto);
        return "reservation";
    }

    /**
     * @param model maps a model to a Set of Pets
     */
    @ModelAttribute
    public void petList(Model model) {
        model.addAttribute("petList", reservationService.reservationOptions(SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    /**
     *
     * @param reservationDto holds reservation data retrieved from form
     * @param result holds the result of validation/binding including errors that may have occurred.
     * @param model maps form fields to reservationDto
     * @param email email field of the current user
     * @return
     */
    @PostMapping("/reservation/save")
    public String makeReservation(@ModelAttribute("reservation") ReservationDto reservationDto, BindingResult result, Model model, @RequestParam("email") String email) {

        if (result.hasErrors()) {
            model.addAttribute("reservation", reservationDto);
            return "reservation";
        }

        reservationService.addReservation(reservationDto, email);

        return "reservation";
    }
}
