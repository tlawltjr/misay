package com.chart.misay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MisayDTO {
    private Long bno;

    private String name;

    private String age;

    private String surgeryName;//수술명

    private String surgeryDate;//수술날짜

    private String surgeryArea;//수술부위

    private String rehab;//재활

    private String rehabDate;//재활날짜

    private String memo;
}
