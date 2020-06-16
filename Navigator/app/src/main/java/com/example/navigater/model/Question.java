package com.example.navigater.model;

public class Question {
    int id;
    String question_1;
    String question_2;
    String question_3;

    public Question() {
    }

    public Question(int id, String question_1, String question_2, String question_3) {
        this.id = id;
        this.question_1 = question_1;
        this.question_2 = question_2;
        this.question_3 = question_3;
    }

    public int getId() {
        return id;
    }

    public String getQuestion_1() {
        return question_1;
    }

    public void setQuestion_1(String question_1) {
        this.question_1 = question_1;
    }

    public String getQuestion_2() {
        return question_2;
    }

    public void setQuestion_2(String question_2) {
        this.question_2 = question_2;
    }

    public String getQuestion_3() {
        return question_3;
    }

    public void setQuestion_3(String question_3) {
        this.question_3 = question_3;
    }

    public void setId(int id) {
        this.id = id;
    }


}
