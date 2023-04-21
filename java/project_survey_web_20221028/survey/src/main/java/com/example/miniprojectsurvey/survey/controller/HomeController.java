package com.example.miniprojectsurvey.survey.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.miniprojectsurvey.survey.mapper.UserMapper;
import com.example.miniprojectsurvey.survey.model.User;

@Controller
public class HomeController {
    @Autowired
    UserMapper userMapper;
    
    @GetMapping("/")
    public String main (HttpSession session){
        session.invalidate();
        return "main";
    }

    @GetMapping("notAgree")
    public String notAgree(){
        return "notAgree";
    }

    @GetMapping("/agreement")
    public String agreement(){
        return "agreement";
    }


    @GetMapping("/surveyIntro")
    public String surveyIntro(){
        return "surveyIntro";
    }

    @GetMapping("main")
    public String main(){
        return "main";
    }

    @PostMapping("main")
    public String main (User user, @RequestParam String id,
                        @RequestParam String pw, HttpSession session, Model model){
        User userData = new User();
        userData.setUserId(id);
        userData.setUserPw(pw);
        userData.setUserName(userMapper.getUserName(id));
        session.setAttribute("userData", userData);

        String adminId = "admin";
        String adminPw = "1234";
        String getPw = userMapper.getUserPw(id);

        String page = "";

        if(id.equals(adminId) && pw.equals(adminPw)){
            page = "redirect:/adminPage";
        }else if(pw.equals(getPw)){
            session.setAttribute("joinUser", userData);
            page = "redirect:/survey/result";
        }else page = "user/loginFail";

        return page;
    }

    @GetMapping("adminPage")
    public String adminPage (Model model, HttpSession session){

        ArrayList<User> userList = userMapper.selectAll();
        model.addAttribute("userList", userList);
        System.out.println("userList : " + userList);

        return "adminPage";
    }



    
}
