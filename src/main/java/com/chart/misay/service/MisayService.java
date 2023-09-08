package com.chart.misay.service;

import com.chart.misay.dto.MisayDTO;
import com.chart.misay.entity.Member;
import com.chart.misay.entity.Misay;
import com.chart.misay.repository.MemberRepository;
import com.chart.misay.repository.MisayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MisayService {

    private final MisayRepository misayRepository;

    private final MemberRepository memberRepository;

    public void deleteBoard(Long bno){
        Optional<Misay> misayOptional = misayRepository.findById(bno);

        if (misayOptional.isPresent()) {
            Misay misay = misayOptional.get();
            misayRepository.delete(misay);
        } else {
            // 지정된 bno에 해당하는 Misay 엔티티가 없을 때 처리
        }
    }

    public void modify(MisayDTO dto){
        Member member = Member.builder().name(dto.getName()).build();
        Misay misay = Misay.builder()
                .bno(dto.getBno())
                .memo(dto.getMemo())
                .member(member)
                .surgeryName(dto.getSurgeryName())
                .surgeryDate(dto.getSurgeryDate())
                .surgeryArea(dto.getSurgeryArea())
                .rehabDate(dto.getRehabDate())
                .rehab(dto.getRehab())
                .build();
        misayRepository.save(misay);
    }

    public MisayDTO read(Long bno){
        Misay list = misayRepository.getOne(bno);
        Member member = list.getMember();
        MisayDTO dto = MisayDTO.builder()
                .mno(member.getMno())
                .name(member.getName())
                .age(member.getAge())
                .surgeryDate(list.getSurgeryDate())
                .surgeryName(list.getSurgeryName())
                .surgeryArea(list.getSurgeryArea())
                .bno(list.getBno())
                .rehab(list.getRehab())
                .rehabDate(list.getRehabDate())
                .memo(list.getMemo())
                .build();
        return dto;
    }

    public List getList(){
        List<MisayDTO> result = new ArrayList<>(); // 검색 결과를 저장할 리스트
        List<Misay> misay = misayRepository.findAll();

        for(Misay list : misay){
            Member member = list.getMember();
            MisayDTO dto = MisayDTO.builder()
                    .bno(list.getBno())
                    .name(member.getName())
                    .age(member.getAge())
                    .surgeryDate(list.getSurgeryDate())
                    .surgeryName(list.getSurgeryName())
                    .surgeryArea(list.getSurgeryArea())
                    .rehab(list.getRehab())
                    .rehabDate(list.getRehabDate())
                    .memo(list.getMemo())
                    .build();
            result.add(dto);
        }
        return result;
    }

    public void register(MisayDTO dto){

        Member member = memberRepository.getOne(dto.getMno());

        Misay m = Misay.builder()
                .member(member)
                .bno(dto.getBno())
                .rehab(dto.getRehab())
                .rehabDate(dto.getRehabDate())
                .surgeryArea(dto.getSurgeryArea())
                .surgeryDate(dto.getSurgeryDate())
                .surgeryName(dto.getSurgeryName())
                .memo(dto.getMemo())
                .build();

        misayRepository.save(m);
    }
    public List<MisayDTO> getCategory(String value){

        List<MisayDTO> result = new ArrayList<>();
        List<Misay> misay = misayRepository.findBySurgeryArea(value);

        for(Misay list : misay){
            Member member = list.getMember();
            MisayDTO dto = MisayDTO.builder()
                    .bno(list.getBno())
                    .name(member.getName())
                    .age(member.getAge())
                    .surgeryDate(list.getSurgeryDate())
                    .surgeryName(list.getSurgeryName())
                    .surgeryArea(list.getSurgeryArea())
                    .rehab(list.getRehab())
                    .rehabDate(list.getRehabDate())
                    .memo(list.getMemo())
                    .build();
            result.add(dto);
        }
        return result;
    }
    public List<MisayDTO> getSurgery(String keyword){

        List<MisayDTO> result = new ArrayList<>(); // 검색 결과를 저장할 리스트
        List<Misay> misay = misayRepository.findBySurgeryAreaContaining(keyword);

        for(Misay list : misay){
            Member member = list.getMember();
            MisayDTO dto = MisayDTO.builder()
                    .bno(list.getBno())
                    .name(member.getName())
                    .age(member.getAge())
                    .surgeryDate(list.getSurgeryDate())
                    .surgeryName(list.getSurgeryName())
                    .surgeryArea(list.getSurgeryArea())
                    .rehab(list.getRehab())
                    .rehabDate(list.getRehabDate())
                    .memo(list.getMemo())
                    .build();
            result.add(dto);
        }
        return result;
    }
    public List<MisayDTO> getName(String keyword){

        List<MisayDTO> result = new ArrayList<>(); // 검색 결과를 저장할 리스트
        List<Misay> misay = misayRepository.findByMemberNameContaining(keyword);

        for(Misay list : misay){
            Member member = list.getMember();
            MisayDTO dto = MisayDTO.builder()
                    .bno(list.getBno())
                    .name(member.getName())
                    .age(member.getAge())
                    .surgeryDate(list.getSurgeryDate())
                    .surgeryName(list.getSurgeryName())
                    .surgeryArea(list.getSurgeryArea())
                    .rehab(list.getRehab())
                    .rehabDate(list.getRehabDate())
                    .memo(list.getMemo())
                    .build();
            result.add(dto);
        }
        return result;
    }
    public void member(MisayDTO dto){
        Member member = Member.builder().name(dto.getName()).age(dto.getAge()).build();
        memberRepository.save(member);
    }

    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    public List<Member> searchMembers(String keyword){
        return memberRepository.findByNameContaining(keyword);
    }

    public MisayDTO getMisayDTO(Long mno){
        Member member = memberRepository.getOne(mno);
        MisayDTO dto = MisayDTO.builder()
                .mno(member.getMno())
                .name(member.getName())
                .age(member.getAge())
                .build();
        return dto;
    }
//    @Transactional
//    public void deleteMember(Long mno){
//        List<Misay> list = misayRepository.findByMemberMno(mno);
//        misayRepository.deleteAll(list);
//        memberRepository.deleteById(mno);
//    }

}
