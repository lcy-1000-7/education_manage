<%--
  Created by IntelliJ IDEA.
  User: ZLM
  Date: 2020/3/8
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <div class="layui-logo" style="background-color: #282B33;"><a href="index.jsp">首页</a></div>
        <div >
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
            <h3 style="text-align: center;">修改课程信息</h3>
            <form action="${pageContext.request.contextPath}/updateCourseServlet" method="post">
                <div class="form-group">
                    <label for="cno">课程编号：</label>
                    <input type="text" class="form-control" id="cno" name="cno" readonly="readonly" value="${aCourse.cno}"  placeholder="请输入课程编号" />
                </div>

                <div class="form-group">
                    <label for="cname">课程名称：</label>
                    <input type="text" class="form-control" id="cname"  name="cname" readonly="readonly" value="${aCourse.cname}" placeholder="请输入课程名称" />
                </div>

                <div class="form-group">
                    <label for="introduce">课程简介：</label>
                    <input type="text" class="form-control" id="introduce" name="introduce" value="${aCourse.introduce}" placeholder="请输入课程简介"/>
                </div>

                <div class="form-group">
                    <label for="stime">开课时间：</label>
                    <input type="date" class="form-control" id="stime" name="stime" value="${aCourse.stime}" placeholder="请输入开课时间"/>
                </div>

                <div class="form-group">
                    <label for="etime">结课时间：</label>
                    <input type="date" class="form-control" id="etime" name="etime" value="${aCourse.etime}" placeholder="请输入就读学校"/>
                </div>

                <div class="form-group" style="text-align: center">
                    <input class="btn btn-primary" type="submit" value="提交" />
                    <input class="btn btn-default" type="reset" value="重置" />
                    <input class="btn btn-default" onclick="javascript:history.go(-1)" type="button" value="返回"/>
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

