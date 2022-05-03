package heb.webg5.quiz.rest;

import heb.webg5.quiz.business.AnswerService;
import heb.webg5.quiz.business.QuestionService;
import heb.webg5.quiz.model.Answer;
import heb.webg5.quiz.model.Question;
import heb.webg5.quiz.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HelloRestJson {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;



    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/answers")
    public List<Answer> getAllAnswers(){
        return answerService.getAllAnswers();
    }

    @GetMapping("questions/{id}")
    public Question questionDetail(@PathVariable(name = "id")Long id){
       return questionService.questionDetail(id);
    }
    @GetMapping("questions/count/{number}")
    public List<Result> getQuestionsHavingCountGreaterThan(@PathVariable(name = "number") BigInteger number){
        return questionService.findQuestionsHavingCountGreaterThan(number);
    }






}
