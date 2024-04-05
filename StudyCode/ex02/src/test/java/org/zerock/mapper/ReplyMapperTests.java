package org.zerock.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.config.DBConfig;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DBConfig.class})
@Log4j
public class ReplyMapperTests {
    private Long[] bnoArr = {8L,9L,10L,11L,12L};

    @Setter(onMethod_ = @Autowired)
    private ReplyMapper mapper;

    @Test
    public void testCreate(){
        IntStream.rangeClosed(1,10).forEach(i -> {
            ReplyVO vo = new ReplyVO();
            vo.setBno(bnoArr[i%5]);
            vo.setReply("댓글 테스트 "+i);
            vo.setReplyer("rePlyer"+i);

            mapper.insert(vo);
        });
    }

    @Test
    public void testRead(){
        Long targetRno = 5L;
        ReplyVO vo = mapper.read(targetRno);
        log.info(vo);
    }

    @Test
    public void testDelete(){
        Long targetRno = 1L;
        mapper.delete(targetRno);
    }

    @Test
    public void testUpdate(){
        Long targetRno = 2L;
        ReplyVO vo = mapper.read(targetRno);
        System.out.println(vo.getReply());
        vo.setReply("Update Reply ");

        int count = mapper.update(vo);

        log.info("UPDATE COUNT: "+count);
    }

    @Test
    public void testList(){
        Criteria cri = new Criteria();

        List<ReplyVO> replies = mapper.getListWithPaging(cri,bnoArr[0]);
        replies.forEach(reply -> log.info(reply));
    }

    @Test
    public void testMapper(){
        log.info(mapper);
    }
}
