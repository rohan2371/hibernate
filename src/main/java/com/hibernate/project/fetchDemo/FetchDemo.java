package com.hibernate.project.fetchDemo;


import com.hibernate.project.entity.Address;
import com.hibernate.project.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        // get , load
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        // get student : 102
        Student student = (Student) session.load(Student.class,102);
//        System.out.println(student);

        Address ad = session.get(Address.class,2);
        System.out.println(ad.getStreet()+" "+ad.getCity()+" "+ad.getAddedDate());
        session.close();
        factory.close();
    }
}
