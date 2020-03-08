package com.chinasoft.education_manage.web;

import com.chinasoft.education_manage.domain.Student;
import com.chinasoft.education_manage.service.StudentService;
import com.chinasoft.education_manage.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str_sno = request.getParameter("sno");
        int sno = Integer.parseInt(str_sno);
        StudentService studentService = new StudentServiceImpl();
        studentService.deleteStudent(sno);
        response.sendRedirect(request.getContextPath()+"/studentMessageServlet?pageNum=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
