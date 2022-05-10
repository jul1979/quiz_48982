package heb.webg5.quiz.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDto {

    private String name;
    private Long number;
    private Integer NbReponses;
    private Integer NbOui;
    private Integer NbNon;



}
