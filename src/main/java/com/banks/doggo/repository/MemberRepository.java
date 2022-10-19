package com.banks.doggo.repository;

import com.banks.doggo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/** provides mechanism for CRUD operations on Member class
 * @author Bankole Abawonse
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    /** Abstract method for finding member by email.
     * @param email email to be queried against database.
     * @return Member with the email passed in.
     */
    @Query(value = "FROM Member m where m.email =? 1")
    Member findByEmail(String email);
}
