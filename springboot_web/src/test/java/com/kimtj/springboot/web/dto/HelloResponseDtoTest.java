package com.kimtj.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {
    @Test
    public void lombokFunTest() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);      //assertThat() 값과 isEqualTo()값 같으면 True
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}