package com.banks.doggo.controller;

import com.banks.doggo.dto.ContactDto;
import com.banks.doggo.model.Contact;
import com.banks.doggo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
