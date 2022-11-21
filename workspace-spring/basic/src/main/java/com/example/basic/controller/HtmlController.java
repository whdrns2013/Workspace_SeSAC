package com.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.basic.model.Member;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

import org.springframework.web.servlet.ModelAndView;



@Controller
public class HtmlController {
    
    // basic 프로젝트에서 작성
    // 1. controller 폴더 생성
    // 2. controller 폴더 안에 HtmlController 클래스 생성
    // 3. Controller 애너테이션 적용
    // 4. RequestMapping 추가해 127.0.0.1:8080 으로 요청시
    // 4-1. templates 폴더 내에 home.html 생성
    // 5 home.html을 보여주도록 작성해보기


    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/html/string")
    public String String() {
        // 반환 타입이 String일 때, 반환값에 보여줄 경로를 명시
        return "html/string"; 
    }
    
    @GetMapping("html/void")
    public void htmlVoid(){
    }
    
    @GetMapping("html/map")
    public Map<String, Object> htmlMap(Map<String, Object> map) {
        Map<String, Object> map2 = new HashMap<String, Object>();
        return map2;
        }

    @GetMapping("html/model")
    public Model htmlModel(Model model) {
        return model;
    }

    @GetMapping("html/modelAndView")
    public ModelAndView modelAndView() {
        ModelAndView mav = new ModelAndView();
        // ModelAndView를 리턴받을때, setViewName 메섣를 통해 출력할 화면을 지정한다.
        mav.setViewName("html/model_and_view");
        return mav;
    } 

    @GetMapping("/html/object")
    public Member htmlObject(){
        Member member = new Member();
        member.setName("박종혁");
        return member;
    }

    @GetMapping("/html/exam")
    public String htmlexam() {
        return "html/exam";
    }

    @GetMapping("signup")
    public String signUp (@ModelAttribute Member member){
        // name;userId;userPassWord;
        return "html/signup";
    }

    @GetMapping("welcome")   // localhost:8080/welcome
    public String welcome(Model model){
        List<String> list = new ArrayList<>();
        list.add("list1");
        list.add("list2");
        list.add("list3");

        model.addAttribute("list", list);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", 22);
        model.addAttribute("map", map);

        Member member = new Member();
        member.setName("hyuk");
        member.setUserId("yyyy01");
        member.setUserPassWord("password123");
        model.addAttribute("member", member);

        model.addAttribute("message","thymeleaf");

        return "welcome";
    }








    }