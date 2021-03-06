package com.chinasoft.education_manage.web.loginservlet;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

@WebServlet("/vcode")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(150, 50, 4, 4);

        request.getSession().setAttribute("captcha", captcha);
//        response.setContentType("application/octet-stream;charset:utf-8");
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write(response.getOutputStream());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
