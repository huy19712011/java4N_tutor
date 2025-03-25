package org.example.java4n_tutor.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.java4n_tutor.entity.Student;
import org.example.java4n_tutor.service.StudentService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = {
        "/students",
        "/students/new",
        "/students/insert"
})
public class StudentServlet extends HttpServlet {

    // Inject StudentService
    StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Creating menu
        String path = request.getServletPath();

        switch (path) {

            case "/students":
                listStudents(request, response);
                break;
            case "/students/new":
                showNewForm(request, response);
                break;
            case "/students/insert":
                insertStudent(request, response);
                break;
        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // read data from form
        Student student = getStudentFromForm(request);

        // save student to list
        studentService.addStudent(student);

        // redirect to list view
        response.sendRedirect("/students");
    }

    private Student getStudentFromForm(HttpServletRequest request) {

        //Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Student student = new Student(name, email, phone);

        return student;
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/view/addStudentForm.jsp")
                .forward(request, response);
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // data: students from DB
        List<Student> students = studentService.getStudents();

        // view:
        request.setAttribute("students", students);
        request.getRequestDispatcher("/view/studentList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}