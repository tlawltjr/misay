package com.chart.misay.repository;

import com.chart.misay.entity.Member;
import com.chart.misay.entity.Misay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByNameContaining(String keyword);

}
