package com.chart.misay.repository;

import com.chart.misay.dto.MisayDTO;
import com.chart.misay.entity.Misay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MisayRepository extends JpaRepository<Misay, Long> {

    List<Misay> findBySurgeryArea(String value);
    @Query("SELECT m FROM Misay m WHERE m.name LIKE %:keyword% OR m.surgeryName LIKE %:keyword%")
    List<Misay> searchByNameOrSurgeryName(@Param("keyword") String keyword);

}