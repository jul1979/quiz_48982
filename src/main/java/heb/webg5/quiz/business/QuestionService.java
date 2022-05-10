package heb.webg5.quiz.business;

import heb.webg5.quiz.dto.Result;
import heb.webg5.quiz.dto.SurveyDto;
import heb.webg5.quiz.model.Question;
import heb.webg5.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    public List<SurveyDto> getQuestionsInfo(){
         List<Question> allQuestions = getAllQuestions();
         ArrayList<SurveyDto> surveyDtos = new ArrayList<>();
        for (Question question:allQuestions
             ) {
             Long number = question.getNumber();
             String text = question.getText();
             Integer nbFalseAnswers = questionRepository.nbFalseAnswers(number);
             Integer nbTrueAnswers =questionRepository.nbTrueAnswers(number);
             surveyDtos.add(new SurveyDto(text,number,question.getAnswers().size(),nbTrueAnswers,nbFalseAnswers));
        }
        return surveyDtos;
    }

    public Integer TrueAnswers(Long number){
      return  questionRepository.nbTrueAnswers(number);
    }

    public Integer FalseAnswers(Long number){
        return  questionRepository.nbFalseAnswers(number);
    }

    public void update(Question question) {
        questionRepository.save(question);
    }

    public Question getQuestionById(Long id) throws IllegalArgumentException{
        if (id<0)throw new IllegalArgumentException("id must be greater than 0");
        return questionRepository.findById(id).get();
    }

    public List<Result> findQuestionsHavingCountGreaterThan(Long number){
       return  questionRepository.findQuestionsByAnswersCount(number);
        }
    }
