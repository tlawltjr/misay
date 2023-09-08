package com.chart.misay.controller;

import com.chart.misay.dto.MisayDTO;
import com.chart.misay.entity.Member;
import com.chart.misay.repository.MemberRepository;
import com.chart.misay.repository.MisayRepository;
import com.chart.misay.service.MisayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AlertController {

    final MemberRepository memberRepository;

    final MisayRepository misayRepository;

    final MisayService misayService;

    //회원 삭제 기능
//    @Transactional
//    @GetMapping("/deleteMember")
//    public String deleteMember(@RequestParam("mno") Long mno) {
//        misayService.deleteMember(mno);
//        System.out.println("컨트롤러 전 mno = "+mno);
//        return "<script type='text/javascript'>"
//                + "alert('삭제가 완료되었습니다.');"
//                + "location.href = document.referrer;"
//                +"</script>";
//    }
    @PostMapping("/memberChange")
    public String memberChange(@ModelAttribute MisayDTO dto){
        Optional<Member> optionalMember = memberRepository.findById(dto.getMno());

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            member.setName(dto.getName());
            member.setAge(dto.getAge());
            memberRepository.save(member);
        }
            return "<script type='text/javascript'>"
                    + "alert('수정이 완료되었습니다.');"
                    + "location.href = '/membership';"
                    + "</script>";

    }
    @PostMapping("/modify")
    public String modify(@ModelAttribute MisayDTO dto){
        misayService.modify(dto);
        return "<script type='text/javascript'>"
                + "alert('수정이 완료되었습니다.');"
                + "location.href = document.referrer;"
                +"</script>";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bno") Long bno){
        misayService.deleteBoard(bno);
        return "<script type='text/javascript'>"
                + "alert('삭제가 완료되었습니다.');"
                + "location.href = '/membership';"
                +"</script>";
    }
}
