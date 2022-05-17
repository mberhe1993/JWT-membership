package edu.miu.membership.service;

import edu.miu.membership.domain.*;
import edu.miu.membership.dto.*;
import edu.miu.membership.modelmapper.MapStruct;
import edu.miu.membership.repository.MemberRepository;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;
    private MapStruct mapStruct;
    private ModelMapper modelMapper;

    @Autowired
    MemberServiceImpl(MemberRepository memberRepository,
                      ModelMapper modelMapper,
                      MapStruct mapStruct) {
        this.memberRepository = memberRepository;
        this.mapStruct = mapStruct;
        this.modelMapper = modelMapper;
    }
    @Override
    @Transactional(readOnly = true)
    public List<MemberDto> findAllMembers() {
        List<Member> members = memberRepository.findAllMembers();
        List<MemberDto> memberDtos = members.stream().map(member -> mapStruct.convertToMemberDto(member))
                .collect(Collectors.toList());;
        return memberDtos;
    }
    @Override
    public Member save(Member member) throws IOException, BarcodeException, OutputException {

        //Barcode barcode = BarcodeFactory.createEAN13("adfadfasdf");
       // member.getBadges().iterator().next().setBarcode(BarcodeImageHandler.getImage(barcode));
        return memberRepository.save(member);
    }
    @Override
    public MemberDto findById(Long memberId) {
        Member  member = memberRepository.findById(memberId).orElse(null);
        return mapStruct.convertToMemberDto(member);
    }
}
