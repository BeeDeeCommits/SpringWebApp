package com.banks.doggo.controller;

import com.banks.doggo.model.Member;
import com.banks.doggo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Controller for the profile page
 * @author Bankole Abawonse
 */
@Controller
public class ProfileController {
    @Autowired
    private MemberService memberService;

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
}
