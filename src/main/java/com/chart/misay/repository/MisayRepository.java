package com.chart.misay.repository;

import com.chart.misay.entity.Misay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.List;
@EnableJpaRepositories
public interface MisayRepository extends JpaRepository<Misay, Long> {

    List<Misay> findBySurgeryArea(String value);
    List<Misay> findByMemberNameContaining(String keyword);
    List<Misay> findBySurgeryAreaContaining(String keyword);

    //회원 삭제 기능
//    @Transactional
//    List<Misay> findByMemberMno(Long mno);
}

