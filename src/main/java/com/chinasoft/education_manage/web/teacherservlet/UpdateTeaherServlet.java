package com.chinasoft.education_manage.web.teacherservlet;

import com.chinasoft.education_manage.domain.Teacher;
import com.chinasoft.education_manage.service.TeacherService;
import com.chinasoft.education_manage.service.impl.TeacherServiceImpl;
import com.chinasoft.education_manage.utils.TeacherUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/updateTeacherServlet")
public class UpdateTeaherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Teacher teacher = TeacherUtils.populate(new Teacher(), map);
        TeacherService service = new TeacherServiceImpl();
        service.updateTeacher(teacher);
        response.setCharacterEncoding("utf-8");
        response.sendRedirect(request.getContextPath()+"/teacherMessageServlet?pageNum=1&rows=5");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
