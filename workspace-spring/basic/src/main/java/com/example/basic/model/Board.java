package com.example.basic.model;

import lombok.Data;

@Data
public class Board {
    
    private int bNo;  // 게시글 번호
    private String title; // 게시글 제목
    private String content; //게시글 내용
    private String user; // 게시글 작성자

}
