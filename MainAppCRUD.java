package com.example.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class MainAppCRUD {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            System.out.println("Creating new students...");
            Student student1 = new Student("Krish", "Kumar", "krish@example.com");
            Student student2 = new Student("John", "Doe", "john@example.com");
            session.save(student1);
            session.save(student2);
            System.out.println("Students saved.");

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        try {
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            System.out.println("\nReading students...");
            List<Student> students = session.createQuery("from Student", Student.class).list();
            for (Student s : students) {
                System.out.println(s);
            }
            
            int studentIdToUpdate = students.get(0).getId();
            tx.commit();

            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            System.out.println("\nUpdating student with id " + studentIdToUpdate);
            Student studentToUpdate = session.get(Student.class, studentIdToUpdate);
            if (studentToUpdate != null) {
                studentToUpdate.setEmail("krish.new@example.com");
                session.update(studentToUpdate);
                System.out.println("Student updated.");
            }
            tx.commit();

            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            int studentIdToDelete = students.get(1).getId();
            System.out.println("\nDeleting student with id " + studentIdToDelete);
            Student studentToDelete = session.get(Student.class, studentIdToDelete);
            if (studentToDelete != null) {
                session.delete(studentToDelete);
                System.out.println("Student deleted.");
            }
            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        HibernateUtil.shutdown();
    }
}
