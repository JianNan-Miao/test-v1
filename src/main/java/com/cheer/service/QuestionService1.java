package com.cheer.service;

import com.cheer.dao.impl.QuestionMapperImpl;
import com.cheer.domain.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionService1 {
    public static void main(String[] args) {
        new QuestionService1().insertQuestion();
    }
    public void insertQuestion(){
        QuestionMapperImpl qmi=new QuestionMapperImpl();
        WorkBooks workBooks=new WorkBooks();
        Map<Integer, List<String>> map = workBooks.readBook();
        List<String> list = map.get(1);
        List<String> titleList=new ArrayList<>();
        List<String> QAList=new ArrayList<>();
        List<String> QBList=new ArrayList<>();
        List<String> QCList=new ArrayList<>();
        List<String> QDList=new ArrayList<>();
        List<String> answerList=new ArrayList<>();
        for(int i=0;i<list.size();i=i+6){
            String title=list.get(i);
            titleList.add(title);
        }
        for(int i=1;i<list.size();i=i+6){
            String QA=list.get(i);
            QAList.add(QA);
        }
        for(int i=2;i<list.size();i=i+6){
            String QB=list.get(i);
            QBList.add(QB);
        }
        for(int i=3;i<list.size();i=i+6){
            String QC=list.get(i);
            QCList.add(QC);
        }
        for(int i=4;i<list.size();i=i+6){
            String QD=list.get(i);
            QDList.add(QD);
        }
        for(int i=5;i<list.size();i=i+6){
            String answer=list.get(i);
            answerList.add(answer);
        }

        for(int i=0;i<6;i++){
            Question question=new Question(titleList.get(i),QAList.get(i),
                    QBList.get(i),QCList.get(i),QDList.get(i),answerList.get(i));
            qmi.insertQuestion(question);
        }
    }
}
