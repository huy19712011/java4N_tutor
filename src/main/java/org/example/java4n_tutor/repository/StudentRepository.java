package org.example.java4n_tutor.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.java4n_tutor.entity.Student;

import java.util.List;

public class StudentRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    EntityManager em = emf.createEntityManager();

    public List<Student> getStudents() {

        // Native Query
        return em.createNativeQuery("SELECT * FROM students", Student.class).getResultList();

        // JPQL
        //return em.createQuery("SELECT s from Student s", Student.class).getResultList();
    }

    public void addStudent(Student student) {

        em.getTransaction().begin();

        em.persist(student);

        em.getTransaction().commit();
    }

    public void deleteStudent(long id) {

        em.getTransaction().begin();

        em.remove(em.find(Student.class, id));

        em.getTransaction().commit();
    }

    public Student getStudentById(Long id) {

        return em.find(Student.class, id);
    }

    public void updateStudent(Student student) {

        em.getTransaction().begin();

        em.merge(student);

        em.getTransaction().commit();
    }
}
