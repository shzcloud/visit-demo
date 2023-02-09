package com.xxx.controller;

import com.alibaba.fastjson2.JSON;
import com.xxx.visit.QueryVisitVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import shz.spring.model.PageVo;
import shz.visit.entity.SysVisit;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class VisitControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void page() throws Exception {
        PageVo<QueryVisitVo, SysVisit> pageVo = new PageVo<>();
        QueryVisitVo reqVo = new QueryVisitVo();
        pageVo.setData(reqVo);

        MockHttpServletRequestBuilder post = MockMvcRequestBuilders
                .post("/v1/system/visit/page")
                .header("Content-Type", "application/json")
                .content(JSON.toJSONBytes(pageVo));

        MockHttpServletResponse response = mvc.perform(post)
                .andExpect(result -> assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value()))
                .andReturn()
                .getResponse();

        System.out.println(response.getContentAsString(StandardCharsets.UTF_8));
    }
}