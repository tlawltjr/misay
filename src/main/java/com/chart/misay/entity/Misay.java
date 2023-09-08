package com.chart.misay.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Misay extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String surgeryName;//수술명

    private String surgeryDate;//수술날짜

    private String surgeryArea;//수술부위

    private String rehab;//재활

    private String rehabDate;//재활날짜

    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="memberId")
    private Member member;


}
