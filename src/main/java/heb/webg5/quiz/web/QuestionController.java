package heb.webg5.quiz.web;

import heb.webg5.quiz.business.AnswerService;
import heb.webg5.quiz.business.QuestionService;
import heb.webg5.quiz.model.Answer;
import heb.webg5.quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @GetMapping("/")
    public String questions(Model model){
         List<Question> allQuestions = questionService.getAllQuestions();
         model.addAttribute("questions",allQuestions);
         return "questions";
    }

    @GetMapping("/questions/{id}")
    public String detail(@PathVariable(name ="id") Long id, Model model){
         Answer answer = new Answer();
         model.addAttribute("answer",answer);
        Question question = questionService.questionDetail(id);
         String text = question.getText();
         Collection<Answer> answers = question.getAnswers();
         model.addAttribute("text",text);
         model.addAttribute("answers",answers);
         model.addAttribute("localDate", LocalDate.now());
         model.addAttribute("question_number",id);
         return "detail";
    }

    @PostMapping(value = "/register/{question_number}")
    public String register(@PathVariable(name = "question_number") Long question_number,
                           @Valid @ModelAttribute(name="answer") Answer answer,
                           Errors errors, Model model){
        //Webg5g48982quizzApplication.log.info("Date:"+ now);
        // DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        answer.setDateAdded(LocalDate.now());
        answer.setQuestion(questionService.getQuestionById(question_number));
        if (errors.hasErrors()) {
            model.addAttribute("questions",questionService.getAllQuestions());
            return "redirect:/";
        }
        Question questionToUpdate = questionService.getAllQuestions().stream()
                .filter(question -> Objects.equals(question_number, question.getNumber()))
                .findFirst()
                .get();
        questionToUpdate.getAnswers().add(answer);
        questionService.update(questionToUpdate);
        return "redirect:/questions/{question_number}";
    }



}
