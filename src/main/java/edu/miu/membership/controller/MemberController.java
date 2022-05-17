package edu.miu.membership.controller;

import edu.miu.membership.domain.Member;
import edu.miu.membership.dto.MemberDto;
import edu.miu.membership.service.MemberServiceImpl;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.security.RolesAllowed;
import java.io.IOException;
import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */
@RestController
@RequestMapping( "/api/miu/members")
public class MemberController {
    private MemberServiceImpl memberServiceImpl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    MemberController(MemberServiceImpl memberServiceImpl) {
        this.memberServiceImpl = memberServiceImpl;
    }


    @GetMapping()
    public String test(){
        String url = "http://loalhost:8080/api/miu/members/test";
        String string = restTemplate.getForObject(url, String.class);
        return string;
    }


    @GetMapping()
    //@RolesAllowed("admin")
    public List<MemberDto> findAll() {
     return memberServiceImpl.findAllMembers();
    }

    @GetMapping("/{memberId}")
   // @RolesAllowed("user")
    public MemberDto findOne(@PathVariable Long memberId) {

        return memberServiceImpl.findById(memberId);
    }

    @PostMapping()
    public Member save(@RequestBody Member member) throws IOException, OutputException, BarcodeException {
        return memberServiceImpl.save(member);
    }
}
