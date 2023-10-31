package com.example.demo;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
