package com.chinasoft.education_manage.web.classservlet;

import com.chinasoft.education_manage.domain.Class;
import com.chinasoft.education_manage.domain.Page;
import com.chinasoft.education_manage.service.ClassService;
import com.chinasoft.education_manage.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findClassServlet")
public class FindClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String str_currentPage = request.getParameter("currentPage");
        int currentPage = Integer.parseInt(str_currentPage);
        String str_rows = request.getParameter("rows");
        int rows = Integer.parseInt(str_rows);

        Map<String, String[]> search = request.getParameterMap();

        ClassService classService = new ClassServiceImpl();
        Page<Class> page = classService.findClass(currentPage, rows, search);

        request.setAttribute("page",page);
        request.setAttribute("search",search);

        request.getRequestDispatcher("/classmessage.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
