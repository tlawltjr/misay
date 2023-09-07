package com.chart.misay.service;

import com.chart.misay.dto.MisayDTO;
import com.chart.misay.entity.Misay;
import com.chart.misay.repository.MisayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MisayService {

    private final MisayRepository misayRepository;

    public MisayDTO read(Long bno){
        System.out.println("서비스 bno: " + bno);
        Optional<Misay> list = misayRepository.findById(bno);
        MisayDTO dto = MisayDTO.builder()
                .name(list.get().getName())
                .age(list.get().getAge())
                .surgeryDate(list.get().getSurgeryDate())
                .surgeryName(list.get().getSurgeryName())
                .surgeryArea(list.get().getSurgeryArea())
                .bno(list.get().getBno())
                .rehab(list.get().getRehab())
                .rehabDate(list.get().getRehabDate())
                .memo(list.get().getMemo())
                .build();
        System.out.println(list.get().getMemo());
        return dto;
    }

    public List getList(){
        List list = misayRepository.findAll();
        return list;
    }

    public void register(MisayDTO dto){
        Misay m = Misay.builder()
                .bno(dto.getBno())
                .age(dto.getAge())
                .rehab(dto.getRehab())
                .rehabDate(dto.getRehabDate())
                .surgeryArea(dto.getSurgeryArea())
                .surgeryDate(dto.getSurgeryDate())
                .surgeryName(dto.getSurgeryName())
                .name(dto.getName())
                .memo(dto.getMemo())
                .build();
        misayRepository.save(m);
    }
    public List<MisayDTO> getCategory(String value){

        List<MisayDTO> result = new ArrayList<>();
        List<Misay> misay = misayRepository.findBySurgeryArea(value);

        for(Misay list : misay){
            MisayDTO dto = MisayDTO.builder()
                    .bno(list.getBno())
                    .name(list.getName())
                    .age(list.getAge())
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
    public List<MisayDTO> getSearch(String keyword){

        List<MisayDTO> result = new ArrayList<>(); // 검색 결과를 저장할 리스트
        List<Misay> misay = misayRepository.searchByNameOrSurgeryName(keyword);

        for(Misay list : misay){
            MisayDTO dto = MisayDTO.builder()
                    .bno(list.getBno())
                    .name(list.getName())
                    .age(list.getAge())
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

}
