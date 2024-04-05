package org.zerock.domain;

import lombok.Data;

@Data
public class FinishedGoodsVO {
    private int finishedgoods_id;       //완제품 번호
    private String finishedgoods_name;  //완제품 이름
    private int finishedgoods_quantity; //완제품 총 수량
    private int finishedgoods_price;    //완제품 가격
    private String quantity_units;      //완제품 단위
}