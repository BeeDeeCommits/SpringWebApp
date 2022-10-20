package com.banks.doggo.service;

import com.banks.doggo.dto.ContactDto;
import com.banks.doggo.exception.ContactNotFoundException;
import com.banks.doggo.model.Contact;
import com.banks.doggo.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/** Im
 * @author Bankole Abawonse
 */
@Service
@AllArgsConstructor
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact findContactById(Long id) throws Exception {
        Optional<Contact> potentialContact = contactRepository.findById(id);
        if (potentialContact.isPresent()) {
            Contact contact = potentialContact.get();
            return contact;
        } else {
            throw new ContactNotFoundException("Contact not found");
        }
    }

    public void addContact(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setCity(contactDto.getCity());
        contact.setStreet(contact.getStreet());
        contact.setPhoneNumber(contactDto.getPhoneNumber());
        contactRepository.save(contact);
    }
}
