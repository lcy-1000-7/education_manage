package com.chinasoft.education_manage.web.loginservlet;

import cn.hutool.captcha.ShearCaptcha;
import com.chinasoft.education_manage.domain.Yuangong;
import com.chinasoft.education_manage.service.YuangongService;
import com.chinasoft.education_manage.service.impl.YuangongServiceImpl;
import com.chinasoft.education_manage.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码集
        request.setCharacterEncoding("utf-8");
        //获取参数
        String verifycode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        ShearCaptcha captcha = (ShearCaptcha) session.getAttribute("captcha");
        session.removeAttribute("captcha");
        //验证失败则重新登录
        if (!captcha.verify(verifycode)) {
            request.setAttribute("msg", "验证码输入错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        //将获取的参数封装为map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //调试敏感词过滤
        String sname = parameterMap.get("sname")[0];
        //集合这种的元素封装为对象的属性
        Yuangong yuangong = CommonUtils.populate(new Yuangong(), parameterMap);
        YuangongService yuangongService = new YuangongServiceImpl();
        Yuangong y = yuangongService.findYuangongByNameAndPassword(yuangong);
        if (y != null) {
            //表示登陆成功
            session.setAttribute("yuangong", yuangong);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            request.setAttribute("msg", "用户名或密码输入错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
