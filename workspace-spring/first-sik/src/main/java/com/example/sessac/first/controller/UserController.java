package com.example.sessac.first.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sessac.first.model.User;

//유저 관련된 요청을 처리하는 컨트롤러
// 회원가입, 로그인, 로그아웃 
@Controller
@RequestMapping("user") // http://localhost:8080/user
public class UserController {
    @GetMapping("join") // http://localhost:8080/user/join
    public String join(){
        return "user/join";
    }

    @PostMapping("join")
    public String join(HttpSession session, User user){
        session.setAttribute("joinUser", user);
        return "redirect:/";
    }

    @GetMapping("login")
    public String login(){
        return "user/login";
    }

    @PostMapping("login")
    public String login(HttpSession session, User user){
        //세션에 저장된 회원 정보
        User userData = (User) session.getAttribute("joinUser");
        //로그인 시도하는 계정 정보
        String id = user.getUserId();
        String pw = user.getUserPw();
        //로그인이 성공했을 경우에만 세션에 유저 정보를 담아준다.
        if(userData.getUserId().equals(id) && userData.getUserPw().equals(pw)){
            session.setAttribute("user", userData);
        }else{
            session.setAttribute("user", null);
        }

        return "redirect:/";
    }

    //로그아웃 기능 구현 http://localhost:8080/user/logout
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }
}
