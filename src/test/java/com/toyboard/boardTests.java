package com.toyboard;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.toyboard.toy.ToyApplication;
import com.toyboard.toy.dto.toyboarddto;
import com.toyboard.toy.mapper.toyboardMapper;

import lombok.extern.log4j.Log4j2;

@ContextConfiguration(classes = ToyApplication.class)
@Log4j2
@SpringBootTest
public class boardTests {
    
    @Autowired
    toyboardMapper toyboardMapper;

    @Test
    public void testAdd() throws Exception{

        toyboarddto dto = toyboarddto.builder()
            .title("addTest")
            .content("addTest")
            .read_cnt(0)
            .register_id("addTest")
            .register_time(null)
            .update_time(null)
            .build();

        toyboardMapper.insertData(dto);
    }
}
