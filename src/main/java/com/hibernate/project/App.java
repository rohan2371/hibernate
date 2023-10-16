package com.hibernate.project;

import com.hibernate.project.entity.Address;
import com.hibernate.project.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Maven project started..." );
        Configuration cfg = new Configuration();



        cfg.configure("hibernate.cfg.xml");
        SessionFactory  factory = cfg.buildSessionFactory();
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Student st = new Student(102,"Virat Kohli","Delhi");
        //creating object of address class
        Address ad = new Address();
        ad.setStreet("street5");
        ad.setCity("Mumbai");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(50.42);
        //Reading Image
        FileInputStream fis = new FileInputStream("src/main/resources/gmail_dp.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(ad);
        session.save(st);
        session.getTransaction().commit();
        session.close();
        factory.close();
        System.out.println("Done...");

    }
}
