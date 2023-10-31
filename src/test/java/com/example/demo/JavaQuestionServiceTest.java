package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    public JavaQuestionService javaQuestionService = new JavaQuestionService();
    List<Question> expected;

    @BeforeEach
        //перед каждым тестом делаем это...
    void setUp() {
        javaQuestionService.add(new Question("Вопрос 1", "Ответ 1"));
        javaQuestionService.add(new Question("Вопрос 2", "Ответ 2"));
        javaQuestionService.add(new Question("Вопрос 3", "Ответ 3"));
        javaQuestionService.add(new Question("Вопрос 4", "Ответ 4"));

        expected = List.of(new Question("Вопрос 1", "Ответ 1"),
                new Question("Вопрос 2", "Ответ 2"),
                new Question("Вопрос 3", "Ответ 3"),
                new Question("Вопрос 4", "Ответ 4"),
                new Question("Вопрос 5", "Ответ 5"));
    }

    @Test
    void getQuestions() {
        javaQuestionService.add(new Question("Вопрос 5", "Ответ 5"));
        assertEquals(expected, javaQuestionService.getQuestions());
    }

    @Test
    void add() {
        javaQuestionService.add(new Question("Вопрос 5", "Ответ 5"));
                assertEquals(expected, javaQuestionService.getQuestions());
    }

    @Test
    void add2() {
        assertThrows(RuntimeException.class, () -> javaQuestionService.add(new Question("Вопрос 1", "Ответ 1")));
    }

    @Test
    void remove() {
        javaQuestionService.add("Вопрос 5", "Ответ 5");
        javaQuestionService.add("Вопрос 6", "Ответ 6");
        javaQuestionService.remove("Вопрос 6", "Ответ 6");
        assertEquals(expected, javaQuestionService.getQuestions());
    }

    @Test
    void remove2() {
        assertThrows(RuntimeException.class, () -> javaQuestionService.remove("Вопрос 5", "Ответ 5"));
    }

}