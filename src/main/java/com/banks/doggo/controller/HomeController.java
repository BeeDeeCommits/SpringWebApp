package com.banks.doggo.controller;

import com.banks.doggo.dto.MemberDto;
import com.banks.doggo.model.Member;
import com.banks.doggo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/** Controller for home, signUp and LogIn requests
 * @author Bankole Abawonse
 */
@Controller
public class HomeController {

    @Autowired
    private MemberService memberService;

    /** Handler method to handle home page request.
     * @return returns index/home page.
     */
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    /**
     * Handler method to handle login page request.
     * @return returns login page.
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    /**
     * Handler method to handle member registration form request.
     * @param model Creates a model object to store data.
     * @return returns sign up page.
     */
    @GetMapping("/signup")
    public String signUp(Model model) {
        MemberDto member = new MemberDto();
        model.addAttribute("member", member);
        return "sign_up";
    }



    /**
     * Handler method to handle member registration form submit request.
     * @param memberDto retrieves model Object.
     * @param result holds the result of the validation/binding and contains errors that may have occurred.
     * @param model Creates a new model object to store data in case of errors.
     * @return returns the login page on a successful sign up.
     */
    @PostMapping("signup/save")
    public String registerMember(@Valid @ModelAttribute("member") MemberDto memberDto, BindingResult result, Model model) {
        Member existingMember = memberService.findMemberByEmail(memberDto.getEmail());

        if (existingMember != null && existingMember.getEmail() != null && !existingMember.getEmail().isEmpty()) {
            result.reject("email", null, "Email is already registered");
        }

        if (result.hasErrors()) {
            model.addAttribute("member", memberDto);
            return "sign_up";
        }

        memberService.addMember(memberDto);
        return "login";
    }
}
