package com.toyboard.toy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toyboard.toy.dto.toyboarddto;
import com.toyboard.toy.service.toyboardService;

@RestController
@RequestMapping("/api")
public class ToyController {

    @Autowired
    private toyboardService toyboardService;
    
    @GetMapping("/notice")
    public String info()
    {
        return "게시판입니다.";
    }

    @GetMapping("/board")
    public List<toyboarddto> getBoardList() throws Exception{
        return toyboardService.getBoardList();
    }

    @PostMapping("/add")
    public Map<String, String> add(@RequestBody toyboarddto dto) throws Exception{
        
        toyboardService.insertData(dto);

        return Map.of("result", "success");
    }

}
