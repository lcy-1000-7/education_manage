package com.chinasoft.education_manage.web;

import com.chinasoft.education_manage.domain.StudentPage;
import com.chinasoft.education_manage.service.StudentService;
import com.chinasoft.education_manage.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/studentMessageServlet")
public class StudentMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String pageNum = request.getParameter("pageNum");
        String rows = request.getParameter("rows");
        String selectmessage = request.getParameter("selectmessage");
        StudentService studentService = new StudentServiceImpl();
        StudentPage studentPage = studentService.findStudentMessage(pageNum,rows,selectmessage);
        request.setAttribute("studentpage",studentPage);
        request.setAttribute("selectmessage",selectmessage);
        request.getRequestDispatcher("/studentmessage.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}