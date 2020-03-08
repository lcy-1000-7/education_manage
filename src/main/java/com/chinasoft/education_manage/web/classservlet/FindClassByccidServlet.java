package com.chinasoft.education_manage.web.classservlet;

import com.chinasoft.education_manage.domain.Class;
import com.chinasoft.education_manage.service.ClassService;
import com.chinasoft.education_manage.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findClassByccidServlet")
public class FindClassByccidServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ccid = request.getParameter("ccid");
        ClassService classService = new ClassServiceImpl();
        Class aClass = classService.findClassByccid(ccid);
        request.setAttribute("aClass", aClass);
        request.getRequestDispatcher("updateClass.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
