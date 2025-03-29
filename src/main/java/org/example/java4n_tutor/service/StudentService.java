package org.example.java4n_tutor.service;

import org.example.java4n_tutor.entity.Student;
import org.example.java4n_tutor.repository.StudentRepository;

import java.util.List;

public class StudentService
{

    StudentRepository studentRepository = new StudentRepository();

    public List<Student> getStudents() {

        return studentRepository.getStudents();
    }

    public void addStudent(Student student) {

        studentRepository.addStudent(student);
    }

    public void deleteStudent(long id) {

        studentRepository.deleteStudent(id);
    }

    public Student getStudentById(Long id) {

        return studentRepository.getStudentById(id);
    }

    public void updateStudent(Student student) {

        studentRepository.updateStudent(student);
    }
}
