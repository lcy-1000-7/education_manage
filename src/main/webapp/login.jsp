<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>学校教务管理系统</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/login.css"/>
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function refreshCode() {
            $("#vcode").attr("src","${pageContext.request.contextPath}/vcode?data="+new Date())
        }
    </script>
</head>
<body>
<div class="login">
    <h2>学校教务管理系统</h2>
    <form class="layui-form" method="post" action="${pageContext.request.contextPath}/loginServlet">
        <div class="layui-form-item">
            <input type="sname" id="sname" name="sname" placeholder="请输入用户名..." required lay-verify="required"
                   class="layui-input">
            <i class="layui-icon input-icon"></i>
        </div>
        <div class="layui-form-item">
            <input type="password" id="password" name="password" placeholder="请输入密码..." required lay-verify="required"
                   class="layui-input">
            <i class="layui-icon input-icon"></i>
        </div>
        <div class="layui-form-item">
            <input type="text" id="verifycode" name="verifycode" placeholder="请输入验证码..." required lay-verify="required"
                   class="layui-input" style="width: 120px;">
            <i class="layui-icon input-icon"></i>
        </div>
        <div class="layui-form-item">
            <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/vcode" title="看不清点击刷新"
                                                    id="vcode"></a>
            <i class="layui-icon input-icon"></i>
        </div>
        <div class="layui-form-item">
            <button style="width: 100%" class="layui-btn" lay-submit lay-filter="login">登录</button>
        </div>
    </form>

    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert">
            <span>&times;</span></button>
        <strong>${msg == null ? "": msg}</strong>
    </div>
</div>
</body>
</html>
