package com.toyboard.toy.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@ToString
public class toyboarddto {
    
    private Long id;
    private String title;
    private String content;
    private int read_cnt;
    private String register_id;

    private LocalDateTime register_time;
    private LocalDateTime update_time;

    public toyboarddto(Long id, String title, String content, int read_cnt, String register_id, LocalDateTime register_time, LocalDateTime update_time){
        this.id = id;
        this.title = title;
        this.content = content;
        this.read_cnt = read_cnt;
        this.register_id = register_id;
        this.register_time = register_time;
        this.update_time = update_time;
    }

}
