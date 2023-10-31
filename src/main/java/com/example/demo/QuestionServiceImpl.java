package com.example.demo;

import java.util.Collection;

public interface QuestionServiceImpl {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
