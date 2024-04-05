package com.humanedu.starbucks.controller;

import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@AutoConfigureMockMvc
@SpringBootTest
public class NoticeControllerTests {
    @Autowired
    private WebApplicationContext ctx; //스프링 컨텍스트
    private MockMvc mockMvc;//실제를 사용전 모의 mvc

    @Before //@Test 코드 실행전에 항상 실행하는 코드
    public void setUp(){
        log.info("setup.........");
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception{
        log.info("testList...."+
                this.mockMvc.perform(MockMvcRequestBuilders.get("/adminNoticeList"))
                        .andReturn().getModelAndView().getModelMap());
    }
}
