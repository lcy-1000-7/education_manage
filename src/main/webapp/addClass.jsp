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
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin" >
    <div class="layui-header"style="background-color: #282B33;">
        <div class="layui-logo" style="background-color: #282B33;">首页</div>
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
                        <dd><a href="javascript:void(0)">新增班级</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed" >
                    <a href="javascript:;">教师管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/teacherMessageServlet?pageNum=1&rows=5">教师信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/teacherServlet">新增教师</a></dd>

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
        <div class="container" style="width: 400px;">
            <h3 style="text-align: center;">新增班级</h3>
            <form action="${pageContext.request.contextPath}/addClassServlet?currentPage=1&rows=3" method="post">




                <div class="form-group">
                    <label for="classname">班级名称：</label>
                    <input type="text" class="form-control" id="classname"  name="cname" placeholder="请输入班级名称" />
                </div>

                <div class="form-group">
                    <label for="teachername">教师姓名：</label>
                    <select id="teachername" class="form-control" name="tname">
                        <c:forEach items="${teacherList}" var="teacher" varStatus="status">
                            <option>${teacher.tname}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="coursename">课程名称：</label>
                    <select id="coursename" class="form-control" name="ccname">
                        <c:forEach items="${courseList}" var="course" varStatus="status">
                            <option>${course.cname}</option>
                        </c:forEach>
                    </select>
                </div>


                <div class="form-group" style="text-align: center">
                    <input class="btn btn-primary" type="submit" value="提交" />
                    <input class="btn btn-default" type="reset" value="重置" />
                    <input class="btn btn-default" type="button" onclick="javascript:history.go(-1)" value="返回"/>
                </div>
            </form>
        </div>
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

