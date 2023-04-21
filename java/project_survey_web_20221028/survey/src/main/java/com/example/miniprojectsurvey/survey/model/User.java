package com.example.miniprojectsurvey.survey.model;

import lombok.Data;

@Data
public class User {

    String userId;
    String userPw;
    String userName;
    Boolean sexMale;
    Boolean sexFemale;
    String birthDate;
    
}
