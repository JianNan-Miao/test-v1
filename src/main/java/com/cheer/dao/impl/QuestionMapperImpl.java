package com.cheer.dao.impl;

import com.cheer.dao.QuestionMapper;
import com.cheer.domain.Question;
import com.cheer.util.DBUtils;
import com.cheer.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class QuestionMapperImpl {
    public static void main(String[] args) {
        /*Question question=new Question("1","a","c","d","e","d");
         QuestionMapperImpl questionMapper= new QuestionMapperImpl();
        questionMapper.insertQuestion(question);*/
        List<Question> list = new QuestionMapperImpl().getQuestion();
        System.out.println(list);
    }

    public void insertQuestion(Question question){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        sqlSession.getMapper(QuestionMapper.class).insertQuestion(question);
        MybatisUtils.closeSqlSession(sqlSession);
    }

    public List<Question> getQuestion(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Question> questionList = sqlSession.getMapper(QuestionMapper.class).getQuestion();
        MybatisUtils.closeSqlSession(sqlSession);
        return questionList;
    }



}
