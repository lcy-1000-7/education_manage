package com.chinasoft.education_manage.web.loginservlet;

import com.chinasoft.education_manage.domain.Yuangong;
import com.chinasoft.education_manage.service.YuangongService;
import com.chinasoft.education_manage.service.impl.YuangongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findPasswordServlet")
public class FindPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str_sno = request.getParameter("sno");
        YuangongService yuangongService = new YuangongServiceImpl();
        Yuangong yuangong = yuangongService.findPasswordBysno(str_sno);
        request.setAttribute("yuangong", yuangong);
        request.getRequestDispatcher("/password.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
