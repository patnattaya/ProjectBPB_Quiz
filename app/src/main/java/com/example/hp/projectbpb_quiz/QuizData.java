package com.example.hp.projectbpb_quiz;

import com.example.hp.projectbpb_quiz.model.Quiz;

import java.util.ArrayList;

/**
 * Created by HP on 5/12/2560.
 */

public class QuizData {
    private static QuizData sInstance;
    public ArrayList<Quiz> quizDataList;

    public static QuizData getInstance(){
        if(sInstance == null){
            sInstance = new QuizData();
        }
        return sInstance;
    }
}
