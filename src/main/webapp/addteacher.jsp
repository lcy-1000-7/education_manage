<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/6
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>学校教务管理系统</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <link rel="stylesheet" href="./layui/css/layui.css">
    <link rel="stylesheet" href="css/style.css" />
    <!-- 1. 导入CSS的全局样式 -->
    <link rel="stylesheet" href="css/style.css" />
    <%--    <link href="js/jquery-2.1.0.min.js">--%>
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin" >
    <div class="layui-header"style="background-color: #282B33;">
        <div class="layui-logo" style="background-color: #282B33;"><a href="index.jsp">首页</a></div>
        <div>
            <p class="logo">教务管理系统</p>
        </div>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
                <li class="layui-nav-item layui-nav-itemed" >
                    <a href="javascript:;">学员管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/studentMessageServlet?pageNum=1&rows=5">学员信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/studentServlet">新增学员</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed" >
                    <a href="javascript:;">班级管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findClassServlet?currentPage=1&rows=3">班级信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/classServlet">新增班级</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed" >
                    <a href="javascript:;">教师管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/teacherMessageServlet?pageNum=1&rows=5">教师信息</a></dd>
                        <dd><a href="javascript:void(0)">新增教师</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed" >
                    <a href="javascript:;">课程管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findCourseServlet?currentPage=1&rows=3">课程信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/addCourse.jsp">新增课程</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/password.jsp">修改密码</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/loginOutServlet">退出</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <fieldset class="layui-elem-field layui-field-title">

        </fieldset>
        <form method="post" action="${pageContext.request.contextPath}/addTeacherServlet" >
            <div class="container" style="width: 400px;">
                <h3 style="text-align: center;">新增教师</h3>
                <form action="" method="post">
                    <div class="form-group">
                        <label for="tname">教师姓名：</label>
                        <input type="text" class="form-control" id="tname" name="tname" required="required" placeholder="请输入姓名" />
                        <span id="tnameMsg"></span>
                    </div>

                    <div class="form-group">
                        <label>性别：</label>
                            <input type="radio" name="tsex" value="男" required="required" />男
                            <input type="radio" name="tsex" value="女" required="required" />女
                    </div>

                    <div class="form-group">
                        <label for="tbirth">出生日期：</label>
                        <input type="date" class="form-control" id="tbirth"  name="tbirth" required="required" placeholder="请输入出生日期" />
                    </div>

                    <div class="form-group">
                        <label for="tphone">联系方式：</label>
                        <input type="text" class="form-control" id="tphone" name="tphone" required="required" placeholder="请输入联系方式"/>
                    </div>

                    <div class="form-group">
                        <label for="temail">邮箱：</label>
                        <input type="text" class="form-control" id="temail" name="temail" required="required" placeholder="请输入邮箱地址"/>
                    </div>

                    <div class="form-group">
                        <label for="course">授学班级：</label>
                        <select id="course" class="form-control" name="course">
                            <c:forEach items="${list}" var="teacher" varStatus="status">
                                <option>${teacher.cname}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="school">毕业院校：</label>
                        <input type="text" class="form-control" id="school" name="school" required="required" placeholder="请输入毕业院校"/>
                    </div>
                    <div class="form-group">
                        <label for="education">学历：</label>
                        <input type="text" class="form-control" id="education" name="education" required="required" placeholder="请输入学历"/>
                    </div>
                    <div class="form-group">
                        <label for="result">成果：</label>
                        <input type="text" class="form-control" id="result" name="result" required="required" placeholder="请输入获得成就"/>
                    </div>

                    <div class="form-group" style="text-align: center">
                        <input class="btn btn-primary" type="submit" value="提交" />
                        <input class="btn btn-default" type="reset" value="重置" />
                        <input class="btn btn-default" type="button" onclick="javascript:history.back()" value="返回"/>
                    </div>
                </form>
            </div>
        </form>

    </div>


</div>
<script src="./layui/layui.js"></script>
<script src="css/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
