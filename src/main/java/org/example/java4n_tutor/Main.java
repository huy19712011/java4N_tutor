package org.example.java4n_tutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.java4n_tutor.entity.Student;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Student student = new Student("Student 4", "Email 4", "Phone 4");
        em.persist(student);

        em.getTransaction().commit();
    }
}
