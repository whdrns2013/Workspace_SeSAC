package com.example.sessac.first.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.sessac.first.model.User;

@Mapper
public interface UserMapper{
    public void join(User user);

    public String getPw(String id);

    public User selectUser(String id);

    




}

