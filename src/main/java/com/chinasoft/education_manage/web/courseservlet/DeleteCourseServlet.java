package com.chinasoft.education_manage.web.courseservlet;

import com.chinasoft.education_manage.service.CourseService;
import com.chinasoft.education_manage.service.impl.CourseServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cno = request.getParameter("cno");
        CourseService courseService = new CourseServiceImpl();
        courseService.deleteCourse(cno);

        response.sendRedirect(request.getContextPath()+"/findCourseServlet?currentPage=1&rows=3");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }
}