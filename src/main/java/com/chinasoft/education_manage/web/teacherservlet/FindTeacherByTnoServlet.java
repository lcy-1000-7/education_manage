package com.chinasoft.education_manage.web.teacherservlet;

import com.chinasoft.education_manage.domain.Teacher;
import com.chinasoft.education_manage.service.TeacherService;
import com.chinasoft.education_manage.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findTeacherByTnoServlet")
public class FindTeacherByTnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String tno = request.getParameter("tno");
        TeacherService service = new TeacherServiceImpl();
        Teacher teacher = service.findTeacherByTno(tno);
        request.setAttribute("teacher",teacher);
        request.getRequestDispatcher("/updateteacher.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
