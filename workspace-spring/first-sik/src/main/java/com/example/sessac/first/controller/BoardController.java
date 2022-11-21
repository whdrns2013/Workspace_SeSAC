package com.example.sessac.first.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sessac.first.model.Board;
import com.example.sessac.first.model.User;

@Controller
@RequestMapping("board")
public class BoardController {
    @GetMapping("boardList") //게시글 목록 조회
    public String boardList(HttpSession session, Model model){
        if(session.getAttribute("boardList") != null){ 
            //게시글 작성이 되었거나, 게시글이 존재할때
            model.addAttribute("boardList", session.getAttribute("boardList"));
        }else{
            //게시판에 글이 없는 상태
            model.addAttribute("boardList", null);
        }
        return "board/boardList";
    }

    @GetMapping("boardCreate") //게시글 작성 페이지 
    public String boardCreate(){
        return "board/boardCreate";
    }

    @PostMapping("boardCreate") //게시글 작성 요청
    public String boardCreate(HttpSession session, Board board){
        ArrayList<Board> boardList = new ArrayList<>();//게시글을 담기위한 리스트 생성
        board.setBoardNo("1");//파라미터에 게시글 번호는 없었기 때문에 추가
        User user = (User) session.getAttribute("user");
        board.setBoardWriter(user.getUserName());
        boardList.add(board); //게시글리스트에 생성한 게시글 저장
        System.out.println(" boardList : "+boardList); //게시글 정보 확인
        session.setAttribute("boardList", boardList);//세션에 게시글목록 저장
        return "redirect:/board/boardList";
    }

    @GetMapping("boardDetail") //게시글 상세보기
    public String boardDetail(HttpSession session, Model model, @RequestParam("boardNo") String boardNo){
         ArrayList<Board> boardList = (ArrayList<Board>) session.getAttribute("boardList");
         for(Board board : boardList){
            if(board.getBoardNo().equals(boardNo)){
                model.addAttribute("board", board);
            }
         }
        return "board/boardDetail";
    }

    @GetMapping("boardUpdate")
    public String boardupdate(HttpSession session, @RequestParam("boardNo") String boardNo , Model model){
        //수정하고자 하는 페이지의 글정보를 가져온다.
        //boardCreate페이지를 참고 하는데
        //textArear 태그 안에 글정보가 있어야 하겠다.
        ArrayList<Board> boardList = (ArrayList<Board>) session.getAttribute("boardList");
         for(Board board : boardList){
            if(board.getBoardNo().equals(boardNo)){
                model.addAttribute("board", board);
            }
         }
        return "board/boardUpdate";
    }

    @PostMapping("boardUpdate")
    public String boardUpdate(HttpSession session, Board board){
        ArrayList<Board> boardList = new ArrayList<>();//게시글을 담기위한 리스트 생성
        boardList.add(board); //게시글리스트에 생성한 게시글 저장
        System.out.println(" boardList : "+boardList); //게시글 정보 확인
        session.setAttribute("boardList", boardList);//세션에 게시글목록 저장
        return "redirect:/board/boardList";
    }
}
