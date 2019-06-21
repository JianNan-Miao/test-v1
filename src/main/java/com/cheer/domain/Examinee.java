package com.cheer.domain;

public class Examinee {
    private  int id;
    private  String username;
    private  String password;
    private  int status;//0:未考 1：已考
    private  double score;
    private  int pass;//0:未过 1：已过




    public Examinee() {
    }

    public Examinee(int id, String username, String password, int status, double score, int pass) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.score = score;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Examinee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", score=" + score +
                ", pass=" + pass +
                '}';
    }
}
