package com.example.sessac.first.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.sessac.first.mapper.UserMapper;
import com.example.sessac.first.model.User;

// 유저 관련된 요청을 처리하는 컨트롤러
// 회원가입, 로그인 로그아웃 등
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserMapper userMapper;


    @GetMapping("join")     // 위에서 user가 있으므로 이 요청은 user/join 이 됨
    public String join ( ){
        return "user/join";
    }

    @PostMapping("join")
    public String join(HttpSession session, User user){

        // session.setAttribute("joinUser", user);
        // 회원가입한 사람은 joinUser라는 이름에 담아줄 것임
        // 이는 요청에 따라 user 클래스를 만드는 의미가 있음
        userMapper.join(user);
        return "redirect:/";
    }

    @GetMapping("login")
    public String login(){
        return "user/login";
    }   



    @PostMapping("login")
    public String login(User user, HttpSession session){

        // 세션에 저장된 회원 정보
        // User userData = (User) session.getAttribute("joinUser");

        // 로그인 시도하는 계정 정보
        String id = user.getUserId();
        String pw = user.getUserPw();
        String getPw = userMapper.getPw(id);
        if(getPw != null){
            if(getPw.equals(user.getUserPw())){
                // DB에서 유저 정보를 가져와서 user Data에 저장
                User userData = userMapper.selectUser(id);
                session.setAttribute("user", userData);
            }
        }else{
            session.setAttribute("user", null);
        }

        // 로그인이 성공했을 경우에 세션에 유저 정보를 담아준다.
        // if (id.equals(userData.getUserId()) && pw.equals(userData.getUserPw())){
        //     session.setAttribute("user", userData);
        // }

        // redirect를 붙이면 되고 안붙이면 안되네? 이게 머징?
        // redirect가 있으면 -> 주소를 요청하는 것임
        // redirect가 없으면 -> 파일을 요청하는 것임
        return "redirect:/";
    }


    @GetMapping("logout")
    public String logout (HttpSession session){
        session.removeAttribute("user");
        // session.invalidate();
        return "redirect:/";
    }






}
