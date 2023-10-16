package com.hibernate.project.exampleMapping;

import javax.persistence.*;

@Entity
public class Answer {

    // if use mappedBy then their is no extra column create for question_id
    // if we not use mappedBy then question_id column will create
    @OneToOne(mappedBy = "answer")
    @JoinColumn(name = "question_id")
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer() {
        super();
    }

    public Answer(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



}
