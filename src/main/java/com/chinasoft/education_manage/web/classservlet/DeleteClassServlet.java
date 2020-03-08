package com.chinasoft.education_manage.web.classservlet;

import com.chinasoft.education_manage.service.ClassService;
import com.chinasoft.education_manage.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteClassServlet")
public class DeleteClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ccid = request.getParameter("ccid");
        ClassService classService = new ClassServiceImpl();
        classService.deleteClass(ccid);
        response.sendRedirect(request.getContextPath() + "/findClassServlet?currentPage=1&rows=3");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
