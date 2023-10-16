package com.hibernate.project.embeddingObject;


import com.hibernate.project.entity.Certificate;
import com.hibernate.project.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Student student1 = new Student();
        student1.setId(105);
        student1.setName("Tejas Choudhari");
        student1.setCity("Solapur");

        Certificate cer = new Certificate();
        cer.setCourse("Spring boot");
        cer.setDuration("1 month");
        student1.setCertificate(cer);

        Transaction tx = session.beginTransaction();
        session.save(student1);
        tx.commit();
        session.close();
        factory.close();

    }
}
