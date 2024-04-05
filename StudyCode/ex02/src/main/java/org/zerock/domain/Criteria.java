package org.zerock.domain;


import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class Criteria {
    private int pageNum;
    private int pageSize;

    private String type;
    private String keyword;

    public Criteria() {
        this(1,10);
    }

    public Criteria(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String[] getTypeArr(){
        return type == null? new String[]{}:type.split("");
    }


}
