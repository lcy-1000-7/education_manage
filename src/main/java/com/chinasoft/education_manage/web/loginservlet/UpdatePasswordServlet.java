package com.chinasoft.education_manage.web.loginservlet;

import com.chinasoft.education_manage.domain.Yuangong;
import com.chinasoft.education_manage.service.YuangongService;
import com.chinasoft.education_manage.service.impl.YuangongServiceImpl;
import com.chinasoft.education_manage.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Yuangong yuangong = (Yuangong) request.getSession().getAttribute("yuangong");
        String pwd1 = request.getParameter("pwd1");
        String pwd2 = request.getParameter("pwd2");
        if (pwd1.equals(pwd2)) {
            YuangongService yuangongService = new YuangongServiceImpl();
            yuangongService.updatePasswordBySname(yuangong,pwd1);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }else {
            request.setAttribute("message", "两次输入密码不一致");
            request.getRequestDispatcher("/password.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
