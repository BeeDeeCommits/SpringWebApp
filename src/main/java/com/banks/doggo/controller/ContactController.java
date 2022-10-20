package com.banks.doggo.controller;

import com.banks.doggo.dto.ContactDto;
import com.banks.doggo.model.Contact;
import com.banks.doggo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/** Controller for the contact class
 * @author Bankole Abawonse
 */
@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    /**
     * Handler method to handle contact form request.
     * @param model creates a model object from the form fields.
     * @return returns the contact page.
     */
    @GetMapping("/contact")
    public String contact(Model model) {
        ContactDto contactDto = new ContactDto();
        model.addAttribute("contact", contactDto);
        return "contact";
    }

    /**
     * Handle method for handling contact form submit request.
     * @param contactDto retrieves model fields from form.
     * @param result holds the result of the validation/binding and contains errors that may have occurred.
     * @param model creates a model of the ContactDto object.
     * @return returns the contact form.
     */
    @PostMapping("/contact/save")
    public String addContact(@Valid @ModelAttribute("contact") ContactDto contactDto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("contact", contactDto);
            return "contact";
        }
        contactService.addContact(contactDto);
        return "contact";
    }
}
