package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.Member;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class JsonController {
    @GetMapping("/json/string")
    @ResponseBody
    public String jsonString () {
        return "반환할 데이터입니다.";
    }

    @GetMapping("json/map")
    @ResponseBody
    public Map<String, Object> jsonMap() {
        Map<String,Object> map2 = new HashMap<String, Object> ();
        map2.put("name", "john");
        map2.put("userId", "유저 아이디1");
        map2.put("userPw", "패스워드");
        return map2;
    }

    @GetMapping ("json/object")
    @ResponseBody
    public Member jsonObject() {
        Member member = new Member();
        member.setName("홍길동");
        member.setUserId("user01");
        member.setUserPassWord("password01");


        return member;
    }


    @GetMapping ("json/list")
    @ResponseBody
    public List jsonList() {
        List list = new ArrayList();
        list.add("list1");
        list.add("list2");
        list.add("list3");
        list.add("list4");
        list.add("list5");
        return list;
    }
    
    public String gugudan() {
        String sum = "";
        for (int i = 1 ; i < 10 ; i++){
            sum += "==구구단 "+ i+ " 단==";
            for (int j = 1 ; j < 10 ; j++){
                sum += i + "*" + j + "=" + i*j + "\n";
            }
        }
        return sum;
    }

    @GetMapping ("json/exam")
    @ResponseBody
    public Map<String, Object> jsonExam() {
        
        Member member1 = new Member();
        member1.setName("가");
        member1.setUserId("A");
        member1.setUserPassWord("1");

        Member member2 = new Member();
        member2.setName("나");
        member2.setUserId("B");
        member2.setUserPassWord("2");
        
        List list1 = new ArrayList();
        list1.add(member1);
        list1.add(member2);

        Map<String, Object> map1 = new HashMap<String,Object>();
        map1.put("count", 2);
        map1.put("list", list1);
        map1.put("gugudan",gugudan());
        
        return map1;
    }
    
    @GetMapping ("json/exam2")
    @ResponseBody
    public Map<String, Object> jsonExam2() {
        

        Member member1 = new Member();
        member1.setName("가");
        member1.setUserId("A");
        member1.setUserPassWord("1");

        Member member2 = new Member();
        member2.setName("나");
        member2.setUserId("B");
        member2.setUserPassWord("2");
        
        List list1 = new ArrayList();
        list1.add(member1);
        list1.add(member2);

        Map<String, Object> map1 = new HashMap<String,Object>();
        map1.put("count", 2);
        map1.put("list", list1);
        map1.put("gugudan",gugudan());
        
        return map1;
    }


} 