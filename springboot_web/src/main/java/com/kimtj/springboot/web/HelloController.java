package com.kimtj.springboot.web;

import com.kimtj.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,    //name (@RequestParam("name")) 으로 넘긴 파라미터를 name(String name)에 저장
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
