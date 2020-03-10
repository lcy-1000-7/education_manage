package com.chinasoft.education_manage.web.courseservlet;

import com.chinasoft.education_manage.domain.Course;
import com.chinasoft.education_manage.domain.CoursePage;
import com.chinasoft.education_manage.service.CourseService;
import com.chinasoft.education_manage.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findCourseServlet")
public class FindCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String str_currentPage = request.getParameter("currentPage");
        int currentpage = Integer.parseInt(str_currentPage);
        String str_rows = request.getParameter("rows");
        int rows = Integer.parseInt(str_rows);

        Map<String, String[]> search = request.getParameterMap();

        CourseService courseService = new CourseServiceImpl();
        CoursePage<Course> page = courseService.findCourse(currentpage,rows,search);

        request.setAttribute("page",page);
        request.setAttribute("search",search);
        request.getRequestDispatcher("/courseMessage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}