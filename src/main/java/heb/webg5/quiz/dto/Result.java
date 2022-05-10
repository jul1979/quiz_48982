package heb.webg5.quiz.dto;

public class Result {

    private String text;
    private Long nbAnswers;

    public Result() {
    }

    public Long getNbAnswers() {
        return nbAnswers;
    }

    public void setNbAnswers(Long nbAnswers) {
        this.nbAnswers = nbAnswers;
    }

    public Result(String text, Long nbAnswers) {
        this.text = text;
        this.nbAnswers = nbAnswers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
