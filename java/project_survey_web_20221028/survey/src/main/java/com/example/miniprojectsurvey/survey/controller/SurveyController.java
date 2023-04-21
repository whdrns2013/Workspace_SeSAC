package com.example.miniprojectsurvey.survey.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.miniprojectsurvey.survey.mapper.SurveyAnswerMapper;
import com.example.miniprojectsurvey.survey.mapper.UserMapper;
import com.example.miniprojectsurvey.survey.model.SurveyAnswer;
import com.example.miniprojectsurvey.survey.model.User;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("survey")
public class SurveyController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    SurveyAnswerMapper surveyAnswerMapper;

    // 질문번호와 답변이 담긴 Map을 생성
    Map<String,String> answerList = new HashMap<String,String>();
    
    @GetMapping("surveyIntro")
    public String surveyIntro(HttpSession session){
    User userData = (User) session.getAttribute("joinUser");
    userMapper.join(userData);
    answerList.put("userId", userData.getUserId());
    return "survey/surveyIntro";
    }


    @GetMapping("survey1")
    public String survey1(HttpSession session){
        return "survey/survey1";
    }

    @PostMapping("survey1")
    public String survey1(HttpSession session, @RequestParam Map<String,String> map){
        
        Set<String> keys = map.keySet();
        Iterator<String> iter = keys.iterator();

        while(iter.hasNext()){
            String key = iter.next();
            answerList.put(key, map.get(key));
        }

        return "survey/survey2";
    }


    @GetMapping("survey2")
    public String survey2(HttpSession session){
        return "survey/survey2";
    }


    @PostMapping("survey2")
    public String survey2(HttpSession session, @RequestParam Map<String,String> map){

        Set<String> keys = map.keySet();
        Iterator<String> iter = keys.iterator();

        while(iter.hasNext()){
            String key = iter.next();
            answerList.put(key, map.get(key));
        }

        return "survey/survey3";
    }


    @GetMapping("survey3")
    public String survey3(HttpSession session){
        return "survey/survey3";
    }


    @PostMapping("survey3")
    public String survey3(HttpSession session, @RequestParam Map<String,String> map){

        Set<String> keys = map.keySet();
        Iterator<String> iter = keys.iterator();

        while(iter.hasNext()){
            String key = iter.next();
            answerList.put(key, map.get(key));
        }      

        System.out.println(answerList);
        return "survey/preResult";
    }


    @GetMapping("preResult")
    public String preResult (){
    return "survey/preResult";
    }

    @PostMapping("preResult")
    public String preResult(HttpSession session){
        //TO DO;답변 DB로 돌리기

        SurveyAnswer surveyAnswer = new SurveyAnswer();
        surveyAnswer.setUserId(answerList.get("userId"));
        surveyAnswer.setAnswer1(answerList.get("answer1"));
        surveyAnswer.setAnswer2(answerList.get("answer2"));
        surveyAnswer.setAnswer3(answerList.get("answer3"));
        surveyAnswer.setAnswer4(answerList.get("answer4"));
        surveyAnswer.setAnswer5(answerList.get("answer5"));
        surveyAnswer.setAnswer6(answerList.get("answer6"));
        surveyAnswer.setAnswer7(answerList.get("answer7"));
        surveyAnswer.setAnswer8(answerList.get("answer8"));
        surveyAnswer.setAnswer9(answerList.get("answer9"));
        surveyAnswer.setAnswer10(answerList.get("answer10"));
        surveyAnswer.setAnswer11(answerList.get("answer11"));
        surveyAnswer.setAnswer12(answerList.get("answer12"));
        surveyAnswer.setAnswer13(answerList.get("answer13"));
        surveyAnswer.setAnswer14(answerList.get("answer14"));
        surveyAnswer.setAnswer15(answerList.get("answer15"));

        surveyAnswerMapper.answer(surveyAnswer);     
        System.out.println("preResult : " + surveyAnswer);

    return "redirect:/survey/result";
    }

    @GetMapping("result")
    public String result (HttpSession session, Model model){

        ArrayList<SurveyAnswer> ansList = surveyAnswerMapper.check();
        User userData = (User) session.getAttribute("joinUser");
        SurveyAnswer answerList = new SurveyAnswer();
        ArrayList<String> answer = new ArrayList<String>();
        
        System.out.println("userData : " + userData);
        System.out.println("ansList : " + ansList);
        
        for (SurveyAnswer ans : ansList){
            if( ans.getUserId().equals(userData.getUserId())){
                answerList = ans;
                answer.add("1." + answerList.getAnswer1());
                answer.add("2." + answerList.getAnswer2());
                answer.add("3." + answerList.getAnswer3());
                answer.add("4." + answerList.getAnswer4());
                answer.add("5." + answerList.getAnswer5());
                answer.add("6." + answerList.getAnswer6());
                answer.add("7." + answerList.getAnswer7());
                answer.add("8." + answerList.getAnswer8());
                answer.add("9." + answerList.getAnswer9());
                answer.add("10." + answerList.getAnswer10());
                answer.add("11." + answerList.getAnswer11());
                answer.add("12." + answerList.getAnswer12());
                answer.add("13." + answerList.getAnswer13());
                answer.add("14." + answerList.getAnswer14());
                answer.add("15." + answerList.getAnswer15());
                System.out.println("answerList : " + answerList);
                System.out.println("ans10" + answerList.getAnswer10());
                System.out.println("answer : " + answer);
            }
        }
        
        model.addAttribute("answer", answer);
        model.addAttribute("userData", userData);
        System.out.println("0000 : " + userData);

        
    return "/survey/result";
    }




    
    @PostMapping("result")
    public String result(){
        return "final";
    }
    


    @GetMapping("correction")
    public String correction(HttpSession session, @RequestParam("userId") String userId, Model model){
    
        ArrayList<SurveyAnswer> ansList = surveyAnswerMapper.check();
        for (SurveyAnswer ans : ansList){
            if(ans.getUserId().equals(userId)){
                model.addAttribute("ans", ans);
                session.setAttribute("ans", ans);
            }
        }
            return "/survey/correction";
        }
    
    
    @PostMapping("correction")
    public String correction(HttpSession session, SurveyAnswer survAns){
        SurveyAnswer ans = new SurveyAnswer();
        ans = (SurveyAnswer) session.getAttribute("ans");
        surveyAnswerMapper.surveyUpadte(ans);
        System.out.println("ans : " + ans);
        return "redirect:/board/boardList";
    }
    



}
