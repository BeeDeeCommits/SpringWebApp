package com.banks.doggo.service;

import com.banks.doggo.dto.ContactDto;
import com.banks.doggo.exception.ContactNotFoundException;
import com.banks.doggo.model.Contact;
import com.banks.doggo.model.Member;
import com.banks.doggo.repository.ContactRepository;
import com.banks.doggo.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/** Implements logic for Contact class
 * @author Bankole Abawonse
 */
@Service
@AllArgsConstructor
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private MemberRepository memberRepository;


    /**
     * Associates a contact with a member
     * @param contactDto retrieves contact field from form
     */
    public void addContact(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setCity(contactDto.getCity());
        contact.setStreet(contactDto.getStreet());
        contact.setPhoneNumber(contactDto.getPhoneNumber());
        Member member = memberRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        member.setContact(contact);
        contact.setMember(member);
        contactRepository.save(contact);
        //memberRepository.save(member);
    }

}
