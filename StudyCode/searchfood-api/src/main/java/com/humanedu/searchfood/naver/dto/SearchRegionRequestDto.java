package com.humanedu.searchfood.naver.dto;

import lombok.Data;

@Data
public class SearchRegionRequestDto {
    private String query;
    private Integer display=1;
    private Integer start=1;
    private String sort = "random";
}
