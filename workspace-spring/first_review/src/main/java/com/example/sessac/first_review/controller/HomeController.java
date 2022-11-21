package com.example.sessac.first_review.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sessac.first_review.model.Board;
import com.example.sessac.first_review.model.UserL;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
    return "home";    
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join")
        public String join(UserL user, HttpSession session){
            session.setAttribute("joinUser", user);
            return "redirect:/";
        }

    @GetMapping("login")
    public String login(){
    return "login";
    }
    
    @PostMapping("login")
    public String login(UserL user, HttpSession session){

        UserL joinUser = (UserL) session.getAttribute("joinUser");

        String id = user.getId();
        String pw = user.getPw();

        String page = "";


        if(joinUser == null){
            page = "home";
        }else if (id.equals(joinUser.getId()) && pw.equals(joinUser.getPw())){
            session.setAttribute("user", user);
            page = "redirect:/";
        }else page = "loginFail";


        return page;
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
    return "redirect:/";
    }


    @GetMapping("boardList")
        public String boardList(HttpSession session, Model model){
            
            if(session.getAttribute("boardList") == null){
                model.addAttribute("boardList", null);
            }else{
                model.addAttribute("boardList",session.getAttribute("boardList"));
            }

        return "boardList";
    }
    
    @GetMapping("createBoard")
    public String createBoard(){
        return "createBoard";
    }

    @PostMapping("createBoard")
    public String createBoard(Board board, HttpSession session, UserL user, Model model){
        
        List<Board> boardList = new ArrayList<Board>();

        board.setBoardNo("1");
        board.setBoardTitle((String) session.getAttribute("boardTitle"));
        board.setBoardContent((String) session.getAttribute("baordContent"));
        board.setBoardWritter((String) session.getAttribute(user.getId()));
        boardList.add(board);

        model.addAttribute("boardList", boardList);

        return "redirect: /boardList";
    }




}