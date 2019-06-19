package com.cheer.dao;

import com.cheer.domain.Question;

import java.util.List;

public interface QuestionMapper {
    public  void insertQuestion(Question question);

    public List<Question> getQuestion();
}
