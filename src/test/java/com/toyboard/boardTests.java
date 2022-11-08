package com.toyboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.toyboard.toy.ToyApplication;
import com.toyboard.toy.dto.toyboarddto;
import com.toyboard.toy.mapper.toyboardMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ContextConfiguration(classes = ToyApplication.class)
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

    @Test
    public void testView() throws Exception{

        int id = 3;
        log.info("dddd");
        log.info(toyboardMapper.viewData(id));
        
        toyboardMapper.viewData(id).forEach(data -> {
            log.info(data);
        });
    }
}
