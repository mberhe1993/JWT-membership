package edu.miu.membership.repository;

import edu.miu.membership.domain.Member;
import edu.miu.membership.dto.MemberDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */
public interface MemberRepository extends JpaRepository<Member, Long> {


    @Query("from Member ")
    List<Member> findAllMembers();
}
