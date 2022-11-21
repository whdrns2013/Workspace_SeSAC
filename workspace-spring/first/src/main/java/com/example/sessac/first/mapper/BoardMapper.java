package com.example.sessac.first.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.sessac.first.model.Board;

@Mapper
public interface BoardMapper {

    public ArrayList<Board> boardList();

    public void boardCreate(Board board);

    public void boardUpdate(Board board);

    public void boardRemove(int boardNo);
    

}





