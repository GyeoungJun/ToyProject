package com.toyboard.toy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyboard.toy.dto.toyboarddto;
import com.toyboard.toy.mapper.toyboardMapper;

@Service
public class toyboardService {
    
    @Autowired
    private toyboardMapper toyboardMapper;

    public List<toyboarddto> getBoardList() throws Exception{
        return toyboardMapper.getBoardList();
    }

    public void insertData(toyboarddto toyboarddto) throws Exception{
        toyboardMapper.insertData(toyboarddto);
    }

    public List<toyboarddto> viewData(int id) throws Exception{
        return toyboardMapper.viewData(id);
    }
}
