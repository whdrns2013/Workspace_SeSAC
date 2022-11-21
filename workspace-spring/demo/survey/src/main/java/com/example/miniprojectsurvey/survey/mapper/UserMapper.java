package com.example.miniprojectsurvey.survey.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.miniprojectsurvey.survey.model.User;

@Mapper
public interface UserMapper {

    public void join(User user);

    public User select(String id);

    public String getUserPw(String id);

    public ArrayList<User> selectAll();

    public String getUserName(String id);


    
}
