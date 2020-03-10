package com.chinasoft.education_manage.web.classservlet;

import com.chinasoft.education_manage.domain.Course;
import com.chinasoft.education_manage.domain.Teacher;
import com.chinasoft.education_manage.service.ClassService;
import com.chinasoft.education_manage.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/classServlet")
public class ClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ClassService classService = new ClassServiceImpl();
        List<Teacher> teacherList =  classService.echoTeacher();
        List<Course> courseList = classService.echoCourse();
        request.setAttribute("teacherList",teacherList);
        request.setAttribute("courseList",courseList);
        request.getRequestDispatcher("/addClass.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
