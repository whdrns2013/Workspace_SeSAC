package com.example.sessac.first.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.catalina.SessionIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sessac.first.mapper.BoardMapper;
import com.example.sessac.first.model.Board;
import com.example.sessac.first.model.User;

@Controller
@RequestMapping("board")
// 요청에서 board 안달아줘도 됨
public class BoardController {
    @Autowired
    BoardMapper boardMapper;

    //게시글 목록 조회
    //DB에서 게시글 목록을 전부 가져와서 model에 담아 준다.
    @GetMapping("boardList")
    public String boardList (Model model, HttpSession session) {
        ArrayList <Board> boardList = boardMapper.boardList();
        System.out.println(boardList);
        model.addAttribute("boardList", boardList);
       return "board/boardList";
    }

    //게시글 작성 페이지
    @GetMapping("boardCreate")
    public String boardCreate(){
        return "board/boardCreate";
    }

    //게시글 작성 요청
    @PostMapping("boardCreate")
    public String boardCreate(Board board, HttpSession session){

        ArrayList<Board> boardList = new ArrayList<Board>();      // 게시글을 담기 위한 리스트 생성
        
        User user = (User) session.getAttribute("user");
        board.setBoardWritter(user.getUserId());
        boardMapper.boardCreate(board);
        session.setAttribute("boardList", boardList);


        return "redirect:/board/boardList";
    }

    //게시글 상세 보기
    @GetMapping("boardDetail")
    public String boardDetail(HttpSession session, Model model, @RequestParam("boardNo") int boardNo){
        ArrayList<Board> boardList = boardMapper.boardList();
        for (Board board : boardList){
            if (board.getBoardNo() == boardNo){
                model.addAttribute("board", board);
            }
        }
        return "board/boardDetail";
    }
    
    @GetMapping("boardUpdate")
    public String boardUpdate (HttpSession session, @RequestParam("boardNo") int boardNo, Model model) {
        // 수정하고자 하는 페이지의 글 정보를 가져온다.
        // boardCreate 페이지를 참고 하는데
        // textArea 택스 안에 글 정보가 있어야 한다.
        ArrayList<Board> boardList = boardMapper.boardList();
        for (Board board : boardList){
            if (board.getBoardNo() == boardNo){
                model.addAttribute("board", board);
            }
        }
        return "board/boardUpdate";
    }
    
    
    @PostMapping("boardUpdate")
    public String boardUpdate(HttpSession session, Board board) {
        
        boardMapper.boardUpdate(board);

        return "redirect:/board/boardList";
    }

    @GetMapping("boardRemove")
    public String boardRemove(@RequestParam int boardNo){
        boardMapper.boardRemove(boardNo);
        System.out.println(boardNo);
        return "redirect:/board/boardList";
    }



    }
    









