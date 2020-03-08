package com.chinasoft.education_manage.web.courseservlet;

import com.chinasoft.education_manage.domain.Course;
import com.chinasoft.education_manage.service.CourseService;
import com.chinasoft.education_manage.service.impl.CourseServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateCourseServlet")
public class UpdateCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Course aCourse = new Course();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(aCourse, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    CourseService courseService = new CourseServiceImpl();
    courseService.updateCourse(aCourse);

    response.sendRedirect(request.getContextPath()+"findCourseServlet?currentPage=1&rows=3");

}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}