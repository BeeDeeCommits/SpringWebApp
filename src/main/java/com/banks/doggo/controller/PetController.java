package com.banks.doggo.controller;

import com.banks.doggo.dto.PetDto;
import com.banks.doggo.model.Member;
import com.banks.doggo.service.MemberService;
import com.banks.doggo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/** Controller for pet model
 * @author Bankole Abawonse
 */
@Controller
public class PetController {

    @Autowired
    private PetService petService;

    /**
     * Handle method to handle pet form request.
     * @param model Creates a model object to store pet data.
     * @return returns the pet page.
     */
    @GetMapping("/pet")
    public String petForm(Model model) {
        PetDto petDto = new PetDto();
        model.addAttribute("pet", petDto);
        return "pet";
    }

    /**
     * Handler method to handle pet form submit request.
     * @param petDto retrieves Pet model object.
     * @param result holds the result of validation/binding including errors that may have occurred.
     * @param model Creates a new model to store Pet data if an error occurs.
     * @return returns pet form page.
     */
    @PostMapping("pet/save")
    public String addPet(@Valid @ModelAttribute("pet") PetDto petDto, BindingResult result, Model model) {

            if (result.hasErrors()) {
                model.addAttribute("pet", petDto);
                return "pet";
            }

            petService.addPet(petDto);
            return "pet";
    }
}
