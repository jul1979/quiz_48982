package heb.webg5.quiz.repository;

import heb.webg5.quiz.dto.Result;
import heb.webg5.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    @Query("select new heb.webg5.quiz.dto.Result(q.text,count(a)) from Question q join q.answers a group by q.text having count(a)>?1")
    List<Result> findQuestionsByAnswersCount(Long number);

    @Query("select count(ans) from Question q join q.answers ans where q.number=?1 and ans.agree=TRUE ")
    Integer nbTrueAnswers(Long number);

    @Query("select count(ans) from Question q join q.answers ans where q.number=?1 and ans.agree=FALSE ")
    Integer nbFalseAnswers(Long number);
}
