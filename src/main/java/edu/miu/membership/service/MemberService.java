package edu.miu.membership.service;

import edu.miu.membership.domain.Member;
import edu.miu.membership.dto.MemberDto;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */
public interface MemberService {

    List<MemberDto> findAllMembers();
    Member save(Member member) throws IOException, BarcodeException, OutputException;
   MemberDto findById(Long memberId);
}
