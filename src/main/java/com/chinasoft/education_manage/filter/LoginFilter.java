package com.chinasoft.education_manage.filter;

import org.springframework.util.ObjectUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 该过滤器用来拦截用户登录方面的设置、
 * 如果该用户没有登陆 则让他跳到登陆页面
 * 如果该用户已经登陆过则可以放他直接访问index.jsp页面
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        1.将req类型强制转换
        HttpServletRequest request = (HttpServletRequest) req;
//        2.获取请求资源的路径
        String uri = request.getRequestURI();
//        3.判断是否包含有登陆相关的路径，然后放行掉
        if (uri.contains("/login.jsp") || uri.contains("/vcode") ||
                uri.contains("/css/") || uri.contains("/js/") ||
                uri.contains("/fonts/") || uri.contains("/loginServlet") ||
                uri.contains("/img/") || uri.contains("/layui/")) {
            chain.doFilter(req, resp);
        } else {
//            如果登陆了 则可以放行到index.jsp页面
            Object yuangong = request.getSession().getAttribute("yuangong");
            if (!ObjectUtils.isEmpty(yuangong)) {
                chain.doFilter(req, resp);
            } else {
//              如果没有登陆
                HttpServletResponse response = (HttpServletResponse) resp;
                request.getServletContext().setAttribute("msg", "您没有登陆，搞鸡毛呢！");
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
