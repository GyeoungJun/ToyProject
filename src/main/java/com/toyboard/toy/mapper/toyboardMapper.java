package com.toyboard.toy.mapper;

import java.util.List;

import com.toyboard.toy.dto.toyboarddto;

public interface toyboardMapper {
    
    public List<toyboarddto> getBoardList() throws Exception;
}