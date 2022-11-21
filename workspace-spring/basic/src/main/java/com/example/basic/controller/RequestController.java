package com.example.basic.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RequestController {
    
    @GetMapping("req/http")
    public String http(HttpServletRequest request){
        String name = request.getParameter("name");
        String pageNum = request.getParameter("pageNum");
        return name + " , " + pageNum;
    }

    @GetMapping(value="req/param1")
    public String param1(@RequestParam("key1") String key1, @RequestParam int key2){
        // http://localhost:8080/req/param1?key1=hyuk&key2=10
        // @RequestParam("key1") String key1 : key1의 이름을 갖는 파라미터의 값을 문자열 변수 key1에 저장
        // @RequestParam("key2") int key2 : key2의 이름을 갖는 파라미터의 값을 int형 변수 key2에 저장
        return key1 + " , " + key2;
        // key 1번에는 주소의 key1에 할당된 값이 들어옴
        // key 2번에는 주소의 key2에 할당된 값이 들어옴
        // 머자먹으로, key1 , key 형식으로 출력함
    }


    @GetMapping(value="req/param2")
    public String param2(@RequestParam Map<String, Object> map){
        return map.toString();
    }

    @GetMapping("req/path/{path1}/{path2}")
    public String path(@PathVariable("path1") String path1, @PathVariable("path2") String path2){
        return path1 + path2;
    }

    //MAP 형식

    @GetMapping("req/data")
    public Map<String, Object> data(@RequestParam Map<String, Object> req){
        return req;
    }







    
    }
    




    


