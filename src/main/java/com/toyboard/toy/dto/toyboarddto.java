package com.toyboard.toy.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class toyboarddto {
    
    private Long id;
    private String title;
    private String content;
    private int read_cnt;
    private String register_id;

    private LocalDateTime register_time;
    private LocalDateTime update_time;

}
