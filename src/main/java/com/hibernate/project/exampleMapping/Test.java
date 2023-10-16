package com.hibernate.project.exampleMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");


        // creating question1
        Question q1 = new Question();
        q1.setQuestionId(18);
        q1.setQuestion("what is java ?");

        // creating answer1 object
        Answer ans1 = new Answer();
        ans1.setAnswerId(173);
        ans1.setAnswer("Java is Programming language");
        ans1.setQuestion(q1);
        q1.setAnswer(ans1);

        // creating question2
        Question q2 = new Question();
        q2.setQuestionId(45);
        q2.setQuestion("What is hibernate");

        // creating answer2 object
        Answer ans2 = new Answer();
        ans2.setAnswerId(195);
        ans2.setAnswer("Hibernate is java framework that makes easier development of java application" +
                "to interact with database");
        ans2.setQuestion(q2);
        q2.setAnswer(ans2);


        // creating question3
        Question q3 = new Question();
        q3.setQuestionId(24);
        q3.setQuestion("what is spring-orm");

        // creating answer3 object
        Answer ans3 = new Answer();
        ans2.setAnswerId(135);
        ans3.setAnswer("Object relational mapping spring with hibernate ");
        ans3.setQuestion(q3);
        q3.setAnswer(ans3);








        // session
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();


        Transaction tx = session.beginTransaction();
        // save
        session.save(ans1);
        session.save(q1);

        // object 2
        session.save(ans2);
        session.save(q2);

        session.save(ans3);
        session.save(q3);
        tx.commit();
        session.close();
        factory.close();


    }
}
