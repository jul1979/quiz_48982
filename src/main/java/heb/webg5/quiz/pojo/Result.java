package heb.webg5.quiz.pojo;

import java.math.BigInteger;

public class Result {

    private String text;
    private BigInteger nbAnswers;

    public Result() {
    }

    public BigInteger getNbAnswers() {
        return nbAnswers;
    }

    public void setNbAnswers(BigInteger nbAnswers) {
        this.nbAnswers = nbAnswers;
    }

    public Result(String text, BigInteger nbAnswers) {
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
