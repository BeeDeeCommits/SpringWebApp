package com.banks.doggo.repository;

import com.banks.doggo.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** provides mechanism for CRUD operations on Contact class
 * @author Bankole Abawonse
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    /**
     *
     * @param street
     * @param city
     * @param phoneNumber
     */
    @Query  (value = "update Contact c set c.street=?1, c.city=?2, c.phoneNumber=?3")
    void updateContact(String street, String city,String phoneNumber );

    /**
     * Finds contact by member_id
     * @param id  member_id to be queried
     * @return returns a contact Object for the associated member
     */
    @Query(value = "FROM Contact c WHERE c.member.id=?1")
    Contact getContactByMemberId(Long id);

}
