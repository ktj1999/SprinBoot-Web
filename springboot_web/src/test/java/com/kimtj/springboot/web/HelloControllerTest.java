package com.kimtj.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)                        //테스트 진행 시 JUnit에 내장된 실행자 외에 다른 실행자를 실행시키고, SpringRunner라는 스프링 실행자를 사용한다
@WebMvcTest(controllers = HelloController.class)    //Web에 집중하는 어노테이션
public class HelloControllerTest {
    @Autowired                                      //스프링이 관리하는 빈(Bean)을 주입 받는다
    private MockMvc mockMvc;                        //API 테스트가 가능

    @Test
    public void returnHello()throws Exception{
        String hello="hello";

        mockMvc.perform(get("/hello"))    //MockMvc를 통해 /hello 주소로 HTTP GET요청
                .andExpect(status().isOk())         //mvc.perform의 결과중 HTTP Header의 Status를 검증
                .andExpect(content().string(hello));//mvc.perform의 결과중 Controller에서 "hello"를 리턴 검증
    }

    @Test
    public void returnHelloDto() throws Exception{
        String name = "hello";
        int amount = 1000;

        mockMvc.perform(get("/hello/dto")
                .param("name", name)                                  //API 테스트시 요청 파라미터 설정
                .param("amount", String.valueOf(amount)))             //String만 가능해서 문자열로 변경
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name)))       //JSON 응답값 필드별로 검증, $로 필드명 명시
                    .andExpect(jsonPath("$.amount", is(amount)));
    }
}