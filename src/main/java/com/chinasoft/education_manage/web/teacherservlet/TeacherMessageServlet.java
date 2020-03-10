package com.chinasoft.education_manage.web.teacherservlet;

import com.chinasoft.education_manage.domain.Page;
import com.chinasoft.education_manage.domain.Teacher;
import com.chinasoft.education_manage.domain.TeacherPage;
import com.chinasoft.education_manage.service.TeacherService;
import com.chinasoft.education_manage.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/teacherMessageServlet")
public class TeacherMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        TeacherService service = new TeacherServiceImpl();
//        List<Teacher> list = service.findAllTeacher();
//        request.setAttribute("list",list);
//        request.getRequestDispatcher("/teachermessage.jsp").forward(request,response);


        request.setCharacterEncoding("utf-8");
        String pageNum = request.getParameter("pageNum");
        String rows = request.getParameter("rows");
//        System.out.println(pageNum);
        Map<String, String[]> map = request.getParameterMap();
        TeacherService service = new TeacherServiceImpl();
        TeacherPage<Teacher> page = service.findGroupPage(pageNum,rows,map);
        request.setAttribute("page",page);
        request.setAttribute("map",map);
        request.getRequestDispatcher("/teachermessage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
