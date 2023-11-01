package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Mock
    JavaQuestionService javaQuestionService;

    List<Question> questions;
    Question question1;
    Question question2;
    Question question3;
    Question question4;
    Question question5;
    @BeforeEach
    public void setUp() {
        question1 = new Question("Вопрос 1", "Ответ 1");
        question2 = new Question("Вопрос 2", "Ответ 2");
        question3 = new Question("Вопрос 3", "Ответ 3");
        question4 = new Question("Вопрос 4", "Ответ 4");
        question5 = new Question("Вопрос 5", "Ответ 5");
        questions = List.of(question1, question2, question3, question4, question5);
        when(javaQuestionService.getQuestions()).thenReturn(questions);
    }
    @Test
    void getQuestions() {
        assertThrows(BadRequestException.class, () -> examinerService.getQuestions(6));
    }
    @Test
    void getQuestions2() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(question1, question2, question3);
        assertEquals(List.of(question1,question2,question3), examinerService.getQuestions(3));
    }
}