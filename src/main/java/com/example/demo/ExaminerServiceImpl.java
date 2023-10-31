package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getQuestions().size()) {
            throw new BadRequestException("Превышено количество вопросов в списке вопросов");
        }

        List<Question> examQuestions = new ArrayList<>();
        while (examQuestions.size() < amount) {
            Question q = javaQuestionService.getRandomQuestion();
            if (!examQuestions.contains(q)) {
                examQuestions.add(q);
            }
        }
        return examQuestions;
    }
}
