package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class JavaQuestionController {

    private final QuestionServiceImpl questionService;

    public JavaQuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/exam/java/add")
    Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/exam/java/remove")
    Question remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.remove(question, answer);
    }

    @GetMapping("/exam/java")
    Collection<Question> getAll() {
        return questionService.getAll();
    }


}
