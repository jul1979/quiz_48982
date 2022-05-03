package heb.webg5.quiz.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id_seq")
    @SequenceGenerator(name="question_id_seq", sequenceName = "QUESTION_ID_SEQ", allocationSize=100)
    private Long number;
    @NotBlank(message = "ne peut être vide")
    private String text;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonManagedReference
    private Collection<Answer> answers;
}
