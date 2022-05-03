package heb.webg5.quiz.business;

import heb.webg5.quiz.model.Question;
import heb.webg5.quiz.pojo.Result;
import heb.webg5.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();

    }

    public Question questionDetail(Long id) {
        return getAllQuestions().stream().filter(question -> Objects.equals(question.getNumber(), id))
                .findFirst()
                .orElse(null);
    }

    public void update(Question question) {
        questionRepository.save(question);
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).get();
    }

    public List<Result> findQuestionsHavingCountGreaterThan(BigInteger number) {
       List<Result>results= new ArrayList<>();
         List<Object[]> objects = questionRepository.questionByAnswersGreaterThan(number);
        for (Object[] array:objects
             ) {
             String text = (String) array[1];
             BigInteger count = (BigInteger) array[2];
             results.add(new Result(text,count));
        }
         return results;
        }
    }
