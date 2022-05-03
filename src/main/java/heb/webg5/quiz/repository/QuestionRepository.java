package heb.webg5.quiz.repository;

import heb.webg5.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    @Query(
            value = "select number,text,count(id) from answer join question on answer.question_number=question.number group by number,text having count(id)>?1",
            nativeQuery = true)
    List<Object[]> questionByAnswersGreaterThan(BigInteger number);
}
