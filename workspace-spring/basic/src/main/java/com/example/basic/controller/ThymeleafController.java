package com.example.basic.controller;

import java.security.Key;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.basic.model.Board;
import com.example.basic.model.Member;

@Controller
public class ThymeleafController {
    @GetMapping("user") // localhost:8080/user
    public String user(Model model) {
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("userId", 1);
        user.put("userName", "user01");
        user.put("userPw", "userPW");

        model.addAttribute("user", user);

        return "user";
    }

    @GetMapping("userList")
    public String userList(Model model) {
        List<Member> userList = new ArrayList<Member>();

        Member member = new Member();
        member.setName("홍길동");
        member.setUserId("hong1");
        member.setUserPassWord("hong1234");
        userList.add(member);

        member = new Member();
        member.setName("이순신");
        member.setUserId("lee2");
        member.setUserPassWord("lee1234");
        userList.add(member);

        member = new Member();
        member.setName("임꺽정");
        member.setUserId("lim3");
        member.setUserPassWord("lim1234");
        userList.add(member);

        model.addAttribute("userList", userList);

        return "userList";
    }

    @GetMapping("userListTest")
    public String param(@RequestParam String name, String userId, String userPassWord, Model model) {

        List list = new ArrayList<>();

        Member member = new Member();
        member.setName(name);
        member.setUserId(userId);
        member.setUserPassWord(userPassWord);
        list.add(member);

        model.addAttribute("list", member);

        return "userListTest";
    }

    @GetMapping("board")
    public String board(Model model) {

        ArrayList<Board> boardList = new ArrayList<>();

        Board board = new Board();
        board.setBNo(1);
        board.setTitle("첫 번째 글입니다.");
        board.setContent("첫 번째 내용입니다.");
        board.setUser("작성자1");
        boardList.add(board);

        board = new Board();
        board.setBNo(2);
        board.setTitle("두 번째 글입니다.");
        board.setContent("두 번째 내용입니다.");
        board.setUser("작성자2");
        boardList.add(board);

        board = new Board();
        board.setBNo(3);
        board.setTitle("세 번째 글입니다.");
        board.setContent("세 번째 내용입니다.");
        board.setUser("작성자3");
        boardList.add(board);

        model.addAttribute("boardList", boardList);

        return "board";
    }

    // boardDetail : 조건에 맞는 보드 직접 넣어주기
    @GetMapping("boardDetail")
    public String boardDetail(Model model, @RequestParam("bNo") int bNo){

        ArrayList<Board> boardList = new ArrayList<>();
        Board result = new Board();
        Board board = new Board();


            board.setBNo(1);
            board.setTitle("첫 번째 글입니다.");
            board.setContent("첫 번째 내용입니다.");
            board.setUser("작성자1");
            boardList.add(board);

            board = new Board();
            board.setBNo(2);
            board.setTitle("두 번째 글입니다.");
            board.setContent("두 번째 내용입니다.");
            board.setUser("작성자2");
            boardList.add(board);
 
            board = new Board();
            board.setBNo(3);
            board.setTitle("세 번째 글입니다.");
            board.setContent("세 번째 내용입니다.");
            board.setUser("작성자3");
            boardList.add(board);
            result = board;

    

        for (int i = 0 ; i < boardList.size() ; i++){
            if (bNo == boardList.get(i).getBNo()){
                result = boardList.get(i);
            }
        }

        model.addAttribute("result", result);
        return "boardDetail";

        }

    // boardDetail : get set 메서드 이용
    //     @GetMapping("boardDetail")
    // public String boardDetail(Model model, @RequestParam("bNo") int bNo){

    //     ArrayList<Board> boardList = new ArrayList<>();
    //     Board result = new Board();

    //     Board board = new Board();
    //     board.setBNo(1);
    //     board.setTitle("첫 번째 글입니다.");
    //     board.setContent("첫 번째 내용입니다.");
    //     board.setUser("작성자1");
    //     boardList.add(board);

    //     board = new Board();
    //     board.setBNo(2);
    //     board.setTitle("두 번째 글입니다.");
    //     board.setContent("두 번째 내용입니다.");
    //     board.setUser("작성자2");
    //     boardList.add(board);

    //     board = new Board();
    //     board.setBNo(1);
    //     board.setTitle("세 번째 글입니다.");
    //     board.setContent("세 번째 내용입니다.");
    //     board.setUser("작성자3");
    //     boardList.add(board);


    //     for (int i = 1 ; i < 4 ; i++){
    //         if( i == bNo){
    //             result.setBNo(boardList.get(i).getBNo());
    //             result.setBNo(boardList.get(i).getTitle());
    //             result.setBNo(boardList.get(i).getContent());
    //             result.setBNo(boardList.get(i).getUser());
    //         }
    //         }

    //     model.addAttribute("result", boardList);

    //     return "boardDetail";
    // }

    @GetMapping("mode")
    public String mode(Model model, @RequestParam Map<String, Object> map) {

        // for(String data : map.keySet()){
        // System.out.println("동적 파라미터 확인 : " + map.get(data));
        // }

        model.addAttribute("name", map.get("name"));
        model.addAttribute("auth", map.get("auth"));
        model.addAttribute("category", map.get("category"));

        return "mode";
    }

    @GetMapping("member")
    public String getMember(Model model, @RequestParam("userId") String userId) {

        List<Member> memberList = new ArrayList();

        Member member = new Member();
        member.setName("홍길동");
        member.setUserId("hong1");
        member.setUserPassWord("123");
        memberList.add(member);

        member = new Member();
        member.setName("이순신");
        member.setUserId("lee2");
        member.setUserPassWord("456");
        memberList.add(member);

        member = new Member();
        member.setName("임꺽정");
        member.setUserId("lim3");
        member.setUserPassWord("789");
        memberList.add(member);

        model.addAttribute("memberList", memberList);
        model.addAttribute("userId", userId);

        return "member";
    }

    @GetMapping("admin")
    public String admin(@RequestParam String userId, Model model) {
        model.addAttribute("userId", userId);
        return "admin";
    }

    @GetMapping("admin2")
    public String admin2(@RequestParam String userId, Model model) {

        String result = "";

        // 방법1
        if (userId.compareTo("admin") == 0) {
            result = "관리자님 어서 오세요";
        } else
            result = "잘못된 접근입니다. 홈 화면으로 돌아가세요.";

        // 방법2
        if (userId.equals("admin")) {
            result = "관리자님 어서 오세요";
        } else
            result = "잘못된 접근입니다. 홈 화면으로 돌아가세요.";

        model.addAttribute("result", result);

        return "admin2";
    }

    @GetMapping("gugudan")
    public String gugudan(@RequestParam String dan, Model model) {

        int num = Integer.parseInt(dan);
        // 이 방식 대신에 @RequestParam int dan 으로 선언해도 됨
        String result = "";

        for (int i = 2; i <= num; i++) {
            result += "구구단 " + i + "단입니다." + "\n";
            for (int j = 1; j < 10; j++) {
                result += i + "*" + j + "=" + i * j + "\n";
            }
        }

        model.addAttribute("result", result);

        return "gugudan";
    }

    @GetMapping("gugudan2")
    public String gugudan2(@RequestParam String dan, Model model) {

        int num = Integer.parseInt(dan);
        List list = new ArrayList();

        for (int i = 2; i <= num; i++) {
            for (int j = 1; j <= 9; j++) {
                list.add(i + "*" + j + "=" + i * j);
            }
        }

        model.addAttribute("list", list);
        return "gugudan2";
    }

    @GetMapping("login")
    public String login(@RequestParam String id, @RequestParam int pw, Model model) {

        String message = "";

        if (id.equals("admin")) {
            if (pw == 1234) {
                message = "성공적으로 로그인 되었습니다.";
            } else
                message = "비밀번호를 확인해 주세요.";
        } else
            message = "아이디를 확인해 주세요.";
        model.addAttribute("Message", message);

        // switch (id.equals("admin"))
        // case 1: // id == "admin"
        // switch (pw){
        // case 1234: message = "성공적으로 로그인 되었습니다.";
        // default : message = "비밀번호를 확인하세요.";
        // }
        // default : message = "아이디를 확인하세요.";
        // }
        // model.addAttribute("Message", message);

        return "login";
    }

    @GetMapping("login3")
    public String login3(){
        return "login3";
    }

    @PostMapping("login3")
    public String login3(Model model, @RequestParam("id") String id, @RequestParam("pw") String pw){
        System.out.println("아이디 확인 : " + id);
        System.out.println("비밀번호 확인 : " + pw);
        model.addAttribute("id",id);
        model.addAttribute("pw",pw);
        return "loginresult";
    }





    @GetMapping("login4")
    public String login4(@RequestParam String id, @RequestParam String pw, Model model) {

        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "login4";
    }

    // @GetMapping("login2")
    // public String login2 (@RequestParam String id, @RequestParam String pw, Model
    // model){

    // int num = Integer.parseInt(pw);
    // String page = "";

    // if (id == null) {
    // if (pw == null) {
    // page = "home";
    // }else{
    // page = "loginFail";
    // }
    // }else if(id.equals("admin")){
    // if (num == 1234){
    // page = "adminPage";
    // }else{
    // page = "loginFail";
    // }
    // }else if(id.equals("user")){
    // if(num == 5678){
    // page = "userPage";
    // }else{
    // page = "loginFail";
    // }
    // }else{
    // page = "loginFail";
    // }

    // return page;
    // }

    // @GetMapping("login2")
    // public String login2 (@RequestParam Map<String,String> map, Model model){

    //     String mapString = map.toString();
    //     String page = "";

    //     if(mapString.equals("{id=admin, pw=1234}")){
    //         page = "adminPage";
    //     }else if(mapString.equals("{id=user, pw=5678}")){
    //         page = "userPage";
    //     }else if(mapString == "{}"){
    //         page="home";
    //     }else page="loginFail";

    // return page;

    @GetMapping("login2")
    public String login2 (@RequestParam Map<String,String> map, Model model){

        String id = (String) map.get("id");
        String pw = (String) map.get("pw");
        String mapString = map.toString();
        String page = "";

        String adminId = "admin";
        String userId = "user";
        String adminPw = "1234";
        String userPw = "5678";

        if(id == null && pw == null){
            if(mapString == "{}"){
            page="home";
            }else page="loginFail";
        }else if(id.equals(adminId)){
            if(pw.equals(adminPw)){
                page = "adminPage";
            }else{
                page="loginFail";
            }
        }else if(id.equals(userId)){
            if(pw.equals(userPw)){
                page="userPage";
            }else{
                page="loginFail";
            }

        }else page="loginFail";
        return page;
}

    @GetMapping("adminLogin")
    public String adminLogin(){
        return "adminLogin";
    }

    @PostMapping("adminLogin")
    public String adminLogin(Model model, @RequestParam Map<String, Object> map){

        String id = (String) map.get("id");
        String pw = (String) map.get("pw");

        String adminId = "admin";
        String adminPw = "1234";

        String page = "";

        if(id.equals(adminId) && pw.equals(adminPw)){
        }else{
            page = "loginFail";
        }
        return page;
    }  

    // @GetMapping("GetMappingParctice")
    // public String loginPagePractice(@RequestParam Map<String, Object> map){

    //     List list = new ArrayList<>();
    //     String id = "";
    //     String pw = "";

    //     for (int i = 1; i < 11 ; i++){
    //         id = char(i) + char(i) + char(i);
    //     }


    //     return "loginPagePractice"; 
    // }


    @PostMapping("GetMappingParctice")
    public String loginPagePractice(Model model, @RequestParam Map<String, Object> map){
        String page = "";



        return page;
    }





    @GetMapping("pagination")
    public String pagination(Model model, @RequestParam(defaultValue = "1") int page){
       
        int startPage = (page - 1) / 2 + 1;
        // int startPage = (page - 1) / 총페이지숫자 * 총페이지숫자 + 1;
        int endPage = startPage + 8;

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("page", page);

        return "pagination";
    }

    @GetMapping("linkUrl")
    public String linkUrl(Model model, @RequestParam(defaultValue = "1") int page){
       
        int startPage = (page - 1) / 10 * 10 + 1;
        int endPage = startPage + 9;

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("page", page);

        return "linkUrl";
    }

    @GetMapping("linkUrl2")
    public String linkUr2(Model model, @RequestParam(defaultValue = "1") int page){
       
        int startPage = (page - 1) / 10 * 10 + 1;
        int endPage = startPage + 9;

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("page", page);

        return "linkUrl2";
    }


    @GetMapping("loginPractice")
    public String loginPractice(){
        return "loginPractice";
    }




}

