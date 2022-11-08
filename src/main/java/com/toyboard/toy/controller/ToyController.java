package com.toyboard.toy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toyboard.toy.dto.toyboarddto;
import com.toyboard.toy.service.toyboardService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@Log4j2
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

    @GetMapping("/view")
    public List<toyboarddto> viewData(@RequestParam int id) throws Exception{
        return toyboardService.viewData(id);
    }

    @PostMapping("/update")
    public Map<String, String> updateData(@RequestBody toyboarddto dto) throws Exception{
        
        toyboardService.updateData(dto);
        
        return Map.of("result", "success");
    }

    @DeleteMapping("/delete")
    public Map<String, String> deleteData(@RequestParam int id) throws Exception{
        
        toyboardService.deleteData(id);

        return Map.of("result", "success");
    }

}
