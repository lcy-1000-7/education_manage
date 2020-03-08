package com.chinasoft.education_manage.web.studentservlet;

import com.chinasoft.education_manage.domain.Student;
import com.chinasoft.education_manage.service.StudentService;
import com.chinasoft.education_manage.service.impl.StudentServiceImpl;
import com.chinasoft.education_manage.utils.StudentUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Student student = StudentUtils.populate(new Student(),request.getParameterMap());
        StudentService studentService = new StudentServiceImpl();
        studentService.addStudent(student);
        response.sendRedirect(request.getContextPath()+"/studentMessageServlet?pageNum=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}