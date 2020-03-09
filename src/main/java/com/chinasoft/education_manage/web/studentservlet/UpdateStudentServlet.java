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
import java.util.Map;

@WebServlet("/updateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Student student = new Student();
        StudentUtils.populate(student,parameterMap);
        StudentService studentService = new StudentServiceImpl();
        studentService.updateStudent(student);
        response.sendRedirect(request.getContextPath()+"/studentMessageServlet?pageNum=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
