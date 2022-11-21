package com.example.miniprojectsurvey.survey.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import com.example.miniprojectsurvey.survey.model.SurveyAnswer;


@Mapper
public interface SurveyAnswerMapper {

    public void answer(SurveyAnswer surveyAnswer);

    public ArrayList<SurveyAnswer> check();

    public void surveyUpadte(SurveyAnswer answer);

    public void answerUpdate(SurveyAnswer ans);



    




    
}
