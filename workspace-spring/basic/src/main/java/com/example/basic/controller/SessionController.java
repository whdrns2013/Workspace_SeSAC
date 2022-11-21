package com.example.basic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.basic.model.User;

@Controller
public class SessionController {
    
    @GetMapping("sessionLogin")
    public String session() {
        return "sessionLogin";
    }
    // sessionLogin 페이지로 이동

    @PostMapping("sessionLogin")
    public String session(User user, HttpSession session) {
        session.setAttribute("user", user);
        return "redirect:/main";
    }
    // sessionLogin 페이지에서 로그인 시도
    // return : locahost:8080/main 값 반환(이동)

    @GetMapping("main")
    public String main(){
        return "main";
    }
    // main 요청값을 받은 경우 localhost:8080/main 값 반환(이동)

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user"); // 특정 세션의 값을 지울 때 사용
        session.invalidate(); // 세션의 정보를 모두 제거
        return "redirect:/";
    }


}
