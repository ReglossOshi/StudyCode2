package org.zerock.controller;

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
public class BoardControllerTests {
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
                this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                        .andReturn().getModelAndView().getModelMap());
    }
    @Test
    public void testRegister() throws Exception{
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("title","테스트 새글 제목")
                .param("content","테스트 새글 내용")
                .param("writer","user00")).andReturn().getModelAndView().getViewName();
        log.info(resultPage);
    }

    @Test
    public void testGet() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders
                        .get("/board/get")
                        .param("bno","2"))
                .andReturn()
                .getModelAndView()
                .getModelMap());
    }

    @Test
    public void testModify() throws Exception{
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
                .param("bno","1")
                .param("title","수정된 테스트 새글 제목")
                .param("content","수정된 테스트 새글 내용")
                .param("writer","user00"))
                .andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }

    @Test
    public void testRemove() throws Exception{
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno","25"))
                .andReturn().getModelAndView().getViewName();
        log.info(resultPage);
    }
}
