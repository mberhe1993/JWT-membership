package edu.miu.membership.controller;

import edu.miu.membership.domain.Badge;
import edu.miu.membership.domain.Membership;
import edu.miu.membership.dto.MemberDto;
import edu.miu.membership.dto.MembershipDto;
import edu.miu.membership.service.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class MemberControllerTest {

    @Autowired
    MemberController memberController;
    @MockBean
    MemberService memberService;
    MemberDto memberDto;

    @BeforeEach
    void setUp() {
        memberDto=MemberDto.builder().id(1L).firstName("Mhreteab").lastName("Adhanom").build();
        Mockito.when(memberService.findById(1L)).thenReturn(memberDto);
    }

    @Test
    void findAll() {
    }

    @Test
    void findOne() {
        MemberDto memberDtoExpected=memberController.findOne(1L);
        Assertions.assertEquals(memberDtoExpected.getFirstName(),"Aron");
    }

    @Test
    void save() {
    }
}