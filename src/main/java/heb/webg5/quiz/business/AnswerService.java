package heb.webg5.quiz.business;

import heb.webg5.quiz.model.Answer;
import heb.webg5.quiz.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> getAllAnswers(){
        return  answerRepository.findAll();
    }
    public void saveAnswer(Answer answer){
         answerRepository.save(answer);
    }




}
