package com.example.demo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.config.Bean;
import com.example.demo.config.ImageUtil;

import lombok.extern.slf4j.Slf4j;

// 해당 클래스를 컨트롤러 객체(빈)로 생성해서 등록해준다.
@Controller
@Slf4j
public class HomeController {
    
    // 요청 URL에 따라 해당 메서드를 실행시킨다.
    @RequestMapping("/")
    public String home(){
        //최상위 url(127.0.0.1:8080)로 요청하게 되면
        //home.html을 출력해준다.
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        // trace : debug 보다 좀 더 상세한 정보를 나타낸다.
        // debug : 프로그램을 디버깅 하기 위한 정보 지정
        // 디버깅 : 특정 코드까지 실행시켜, 어떤 문제점이 있는지 찾아보는 작업
        // info : 상태 변경과 같은 정보성 메세지를 나타냄
        // warn : 처리 가능한 문제, 향후 시스템 에러의 원인이 될 수 있는 경고성 메세지를 나타냄
        // error : 요청을 처리하는 중에 문제가 발생한 경우

        // 디버깅은 if-else 문 혹은 try-catch 문을 사용한다.
        // if (결과값 유무 체크) {소스가 정상적일 경우} else{에러가 발생했을 경우}
        // try{ 시도 : 내가 시도할 코드 작성 } catch {try 문을 수행하다가 에러(예외)가 발생할 경우 실행됨 }

        // 로그를 출력할 때에는 일반적으로 많은 개발자들은 system.out.println() 을 사용하고 있다. : 관공서 등에서 로그출력이 보안상 안되는 경우 (로그를 남겨 해킹 되는 걸 방지)
        // 그래서 로그 출력은 개발시에만 테스트용으로 출력하고, 일반적으로 최종 모델에서는 로그 출력을 쓰지 않는다.

        return "home";
    }

    @RequestMapping("/second")
    public String second() {
        return "second";
    }

    @RequestMapping("/exam")
    public String exam() {
        return "exam";
    }

    @GetMapping("/JSON/exam")
    @ResponseBody
    public List<String> jsonList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        return list;
        }


        

    // @RequestMapping("/JSON/exam")
    // @ResponseBody
    // public Map<String, Object> jsonMap(Map<String, Object>map) {
    //     Map<String, Object>
    //     map2 = new HashMap<String, Object>();
    //     map2.put("count","2");
    //     map2.put("list","[");
    //     map2.put("name","가");
    //     map2.put("userId","A");
    //     map2.put("userPassword","1");
    //     map2.put("name","나");
    //     map2.put("userId","B");
    //     map2.put("userPassword","2");
    //     return map2;
    
    // }


    }