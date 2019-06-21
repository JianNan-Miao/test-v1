package com.cheer.domain;

public class Question {
    private  int id;
    private  String title;
    private  String QA;
    private  String QB;
    private  String QC;
    private  String QD;
    private  String answer;

    public Question() {
    }

    public Question(int id, String title, String QA, String QB, String QC, String QD, String answer) {
        this.id = id;
        this.title = title;
        this.QA = QA;
        this.QB = QB;
        this.QC = QC;
        this.QD = QD;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQA() {
        return QA;
    }

    public void setQA(String QA) {
        this.QA = QA;
    }

    public String getQB() {
        return QB;
    }

    public void setQB(String QB) {
        this.QB = QB;
    }

    public String getQC() {
        return QC;
    }

    public void setQC(String QC) {
        this.QC = QC;
    }

    public String getQD() {
        return QD;
    }

    public void setQD(String QD) {
        this.QD = QD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", QA='" + QA + '\'' +
                ", QB='" + QB + '\'' +
                ", QC='" + QC + '\'' +
                ", QD='" + QD + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
