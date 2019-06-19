package com.cheer.domain;

public class Information {
    private int id;
    private int correct;
    private int incorrect;
    private int miss_answer;
    private double score;
    private  String pass;

    public Information() {
    }

    public Information(int id, int correct, int incorrect, int miss_answer, double score, String pass) {
        this.id = id;
        this.correct = correct;
        this.incorrect = incorrect;
        this.miss_answer = miss_answer;
        this.score = score;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public int getMiss_answer() {
        return miss_answer;
    }

    public void setMiss_answer(int miss_answer) {
        this.miss_answer = miss_answer;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", correct=" + correct +
                ", incorrect=" + incorrect +
                ", miss_answer=" + miss_answer +
                ", score=" + score +
                ", pass='" + pass + '\'' +
                '}';
    }
}
