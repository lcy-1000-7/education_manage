<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <link rel="stylesheet" href="./layui/css/layui.css">
    <link rel="stylesheet" href="css/style.css" />
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin" >
    <div class="layui-header"style="background-color: gainsboro;">
        <div class="layui-logo" style="background-color: #000000;"><a href="${pageContext.request.contextPath}/index.jsp">首页</a></div>
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
                        <dd><a href="${pageContext.request.contextPath}/addstudent.jsp">新增学员</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed" >
                    <a href="javascript:;">班级管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findClassServlet?currentPage=1&rows=3">班级信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/addClass.jsp">新增班级</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed" >
                    <a href="javascript:;">教师管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/teacherMessageServlet?pageNum=1&rows=5">教师信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/addteacher.jsp">新增教师</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed" >
                    <a href="javascript:;">课程管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findCourseServlet?currentPage=1&rows=3">课程信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/addCourse.jsp">新增课程</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">财务管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/password.jsp">修改密码</a></li>
                <li class="layui-nav-item"><a href="">退出</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <fieldset class="layui-elem-field layui-field-title">

        </fieldset>
        <div class="container" style="width: 400px;">
            <h3 style="text-align: center;">新增学员</h3>
            <form action="${pageContext.request.contextPath}/updateStudentServlet" method="post">
                <input name="sno" type="hidden" value="${student.sno}">
                <div class="form-group">
                    <label for="sname">学生姓名：</label>
                    <input type="text" class="form-control" id="sname" name="sname" value="${student.sname}" readonly="readonly"  placeholder="请输入姓名" />
                </div>

                <div class="form-group">
                    <label>性别：</label>
                    <c:if test="${student.ssex == '男'}">
                        <input type="radio" name="gender" value="男" readonly="readonly" checked />男
                        <input type="radio" name="gender" value="女" readonly="readonly"  />女
                    </c:if>
                    <c:if test="${student.ssex == '女'}">
                        <input type="radio" name="gender" value="男"  readonly="readonly" />男
                        <input type="radio" name="gender" value="女" readonly="readonly" checked />女
                    </c:if>
                </div>

                <div class="form-group">
                    <label for="sage">年龄：</label>
                    <input type="text" class="form-control" id="sage"  name="sage" value="${student.sage}" readonly="readonly" placeholder="请输入年龄" />
                </div>

                <div class="form-group">
                    <label for="parents">监护人姓名：</label>
                    <input type="text" class="form-control" id="parents" name="parents" value="${student.parents}" placeholder="请输入监护人姓名"/>
                </div>

                <div class="form-group">
                    <label for="sphone">联系方式：</label>
                    <input type="text" class="form-control" id="sphone" name="sphone" value="${student.sphone}" placeholder="请输入联系方式"/>
                </div>

                <div class="form-group">
                    <label for="school">就读学校：</label>
                    <input type="text" class="form-control" id="school" name="school" value="${student.school}" placeholder="请输入就读学校"/>
                </div>

                <div class="form-group">
                    <label for="cno">年级：</label>
                    <input type="text" class="form-control" id="cno" name="cno" value="${student.cno}" placeholder="请输入年级"/>
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
