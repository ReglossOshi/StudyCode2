package com.humanedu.searchfood.naver.dto;

import lombok.Data;

@Data
public class ImageRegionRequest {
    private String query;
    private Integer display=10;
    private Integer start=1;
    private String sort;
    private String filter;
}
