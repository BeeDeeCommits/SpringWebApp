package com.banks.doggo.controller;

import com.banks.doggo.model.Member;
import com.banks.doggo.model.Pet;
import com.banks.doggo.model.Reservation;
import com.banks.doggo.service.MemberService;
import com.banks.doggo.service.PetService;
import com.banks.doggo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Controller for the profile page
 * @author Bankole Abawonse
 */
@Controller
public class ProfileController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private PetService petService;

    @Autowired
    private ReservationService reservationService;

    /**
     * Handler method for handling profile page request.
     * @return returns the profile page.
     */
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    /**
     * This method models any user who is currently logged in
     * @param model creates a model of the current member that is logged in
     * @return returns model to the profile page.
     */
    @ModelAttribute
    public String currentUser(Model model) {
        Member currentUser = memberService.findMemberByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("currentUser", currentUser);
        return "profile";
    }

    @GetMapping("pet/delete")
    public String deletePet(@ModelAttribute("currentUser") Member member, @RequestParam("delete") String name) {
        Pet pet = petService.findByNameAndMember(name, SecurityContextHolder.getContext().getAuthentication().getName());
        petService.deletePet(pet);
        return "profile";
    }
}
