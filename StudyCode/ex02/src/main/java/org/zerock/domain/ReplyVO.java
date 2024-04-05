package org.zerock.domain;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Data
public class ReplyVO {
    private Long rno;
    private Long bno;
    private String reply;
    private String replyer;
    private Date replyDate;

    public void setReplyDate(Date replyDate){
        this.replyDate = replyDate;
    }

    public String getReplyDate(){
        LocalDateTime today = LocalDateTime.now(); //현재 시간
        Date today1 = java.sql.Timestamp.valueOf(today);
        String thisTime = "";
        long timeM1 = replyDate.getTime();
        long timeM2 = today1.getTime();

        long gap = timeM2-timeM1;

        System.out.println(gap);

        if (gap < (1000 * 60 * 60 * 24)) {
            SimpleDateFormat transFormat2 = new SimpleDateFormat("HH:mm:ss");
            thisTime = transFormat2.format(replyDate);
        } else {
            SimpleDateFormat transFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            thisTime = transFormat2.format(replyDate);
            System.out.println(thisTime);
        }
        return thisTime;
        //return replyDate;
    }
    private String updateDate;
}
