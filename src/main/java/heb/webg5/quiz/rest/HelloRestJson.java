package heb.webg5.quiz.rest;

import heb.webg5.quiz.business.QuestionService;
import heb.webg5.quiz.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HelloRestJson {

    @Autowired
    private QuestionService questionService;


    @GetMapping("questions/count/{number}")
    public List<Result> getQuestionsHavingCountGreaterThan(@PathVariable(name = "number") Long number){
        return questionService.findQuestionsHavingCountGreaterThan(number);
    }






}
