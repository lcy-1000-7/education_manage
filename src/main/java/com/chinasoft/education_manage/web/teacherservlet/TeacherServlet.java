package com.chinasoft.education_manage.web.teacherservlet;

import com.chinasoft.education_manage.domain.Class;
import com.chinasoft.education_manage.service.TeacherService;
import com.chinasoft.education_manage.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacherServlet")
public class TeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        TeacherService teacherService = new TeacherServiceImpl();
        List<Class> list = teacherService.echoClass();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/addteacher.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
