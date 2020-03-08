package com.chinasoft.education_manage.web.courseservlet;

import com.chinasoft.education_manage.domain.Course;
import com.chinasoft.education_manage.service.CourseService;
import com.chinasoft.education_manage.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findCourseBycnoServlet")
public class FindCourseBycnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        CourseService courseService = new CourseServiceImpl();
        Course aCourse = courseService.findCourseBycno(cno);
        request.setAttribute("aCourse",aCourse);
        request.getRequestDispatcher("updateCourse.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}