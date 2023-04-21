package com.example.miniprojectsurvey.survey.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.miniprojectsurvey.survey.mapper.UserMapper;
import com.example.miniprojectsurvey.survey.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
UserMapper userMapper;

    @GetMapping("/join")
    public String join(){
        return "user/join";
    }

    @PostMapping("/join")
    public String join(User user, HttpSession session, Model model){
        session.setAttribute("joinUser", user);
        // model.addAttribute("joinUser", user);
        return "redirect:/user/agreement";
    }

    @GetMapping("agreement")
    public String agreement(HttpSession session, User user){
        // User userData = (User) session.getAttribute("joinUser");
        // session.setAttribute("joinUser", userData);
        return "/user/agreement";
    }






}
