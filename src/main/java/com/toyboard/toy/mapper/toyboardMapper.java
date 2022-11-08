package com.toyboard.toy.mapper;

import java.util.List;

import com.toyboard.toy.dto.toyboarddto;

public interface toyboardMapper {
    
    public List<toyboarddto> getBoardList() throws Exception;
    public void insertData(toyboarddto toyboarddto) throws Exception;
    public List<toyboarddto> viewData(int id) throws Exception;
    public void updateData(toyboarddto toyboarddto) throws Exception;
    public void deleteData(int id) throws Exception;

    public int getTotal(toyboarddto toyboarddto) throws Exception;
    public List<toyboarddto> search(String title)throws Exception;
}
