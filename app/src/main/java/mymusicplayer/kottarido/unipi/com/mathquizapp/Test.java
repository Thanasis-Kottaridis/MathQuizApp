package mymusicplayer.kottarido.unipi.com.mathquizapp;

import java.util.List;

public class Test implements Comparable<Test> {
    private List<Question> questions;
    private List<Float> answers;
    private Long score;
    private String time;
    private boolean useCalculator;
    private boolean inTime;

    public Test(List<Question> questions, List<Float>answers, long score, String time, boolean useCalculator, boolean inTime) {
        this.questions = questions;
        this.answers = answers;
        this.score = score;
        this.time = time;
        this.useCalculator = useCalculator;
        this.inTime = inTime;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Float> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Float> answers) {
        this.answers = answers;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isUseCalculator() {
        return useCalculator;
    }

    public void setUseCalculator(boolean useCalculator) {
        this.useCalculator = useCalculator;
    }

    public boolean isInTime() {
        return inTime;
    }

    public void setInTime(boolean inTime) {
        this.inTime = inTime;
    }

    @Override
    public int compareTo(Test test) {
        return this.score.compareTo(test.getScore());
    }
}
