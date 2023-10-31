package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service

public class JavaQuestionService implements QuestionServiceImpl {


    private List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        List <Question> qQ = questions.stream()
                        .filter(q -> q.getQuestion().equals(question.getQuestion()))
                                .toList();
        if (qQ.size() > 0) {
            throw new RuntimeException("Такой вопрос уже есть");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionRemove = questions.stream()
                .filter(q -> q.getQuestion().equals(question) && q.getAnswer().equals(answer))
                .findFirst().orElseThrow();
        questions.remove(questionRemove);
        return questionRemove;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomInt = random.nextInt(questions.size());
        return questions.get(randomInt);
    }
}
