package com.banks.doggo.repository;

import com.banks.doggo.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query  (value = "update Contact c set c.street=?1, c.city=?2, c.phoneNumber=?3")
    void updateContact(String street, String city,String phoneNumber );
    @Query(value = "FROM Contact c WHERE c.member.id=?1")
    Contact getContactByMemberId(Long id);

}
