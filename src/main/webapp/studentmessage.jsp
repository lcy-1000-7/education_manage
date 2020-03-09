<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/6
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
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
                <li class="layui-nav-item"><a href="${sessionScope.remove("yuangong")}">退出</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <div class="layui-row">
            <div class="layui-col-lg7" style="margin-top: 10px;margin-left: 20px;">
                <a href="${pageContext.request.contextPath}/addstudent.jsp" class="layui-btn">添加学员</a>
            </div>

            <div  class="layui-col-lg4" style="text-align: right" >
                <form class="form-inline" action="${pageContext.request.contextPath}/studentMessageServlet?pageNum=1&rows=5" method="post">
                <div class="layui-input-inline" style="width: 300px;margin-top: 10px;">
                    <input type="text" name="selectmessage" id="selectmessage" value="${selectmessage}" placeholder="学生编号/学生姓名" class="layui-input key">
                </div>
                <button type="submit" class="layui-btn sou" style="margin-top: 10px;">搜索</button>
                </form>
            </div>
        </div>

        <table class="layui-table layui-form">

            <thead>
            <tr>
                <th>学生编号</th>
                <th>学生姓名</th>
                <th>学生性别</th>
                <th>学生年龄</th>
                <th>父母姓名</th>
                <th>联系方式</th>
                <th>就读学校</th>
                <th>年级</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${studentpage.list}" var="student" varStatus="status">
                <tr class="id36567">
                    <td>${student.sno}</td>
                    <td>${student.sname}</td>
                    <td>${student.ssex}</td>
                    <td>${student.sage}</td>
                    <td>${student.parents}</td>
                    <td>${student.sphone}</td>
                    <td>${student.school}</td>
                    <td>${student.cno}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/echoStudentServlet?sno=${student.sno}">修改</a>
                        &nbsp;&nbsp;&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:void(0)" onclick="deleteStudent(${student.sno})">删除</a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
            <ul class="pagination">
                <c:if test="${studentpage.pageNum == 1}">
                    <li class="disabled">
                        <a href="javascript:void(0)"
                           aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
                    </li>
                </c:if>
                <c:if test="${studentpage.pageNum != 1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/studentMessageServlet?pageNum=${studentpage.pageNum-1}&rows=5&selectmessage=${selectmessage}"
                           aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${studentpage.totalPage}" var="i">
                    <c:if test="${studentpage.pageNum == i}">
                        <li class="active">
                            <a href="javascript:void(0)">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${studentpage.pageNum != i}">
                        <li><a href="${pageContext.request.contextPath}/studentMessageServlet?pageNum=${i}&rows=5&selectmessage=${selectmessage}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${studentpage.pageNum == studentpage.totalPage}">
                    <li class="disabled">
                        <a href="javascript:void(0)"
                           aria-label="Previous"><span aria-hidden="true">&raquo;</span></a>
                    </li>
                </c:if>
                <c:if test="${studentpage.pageNum != studentpage.totalPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/studentMessageServlet?pageNum=${studentpage.pageNum+1}&rows=5&selectmessage=${selectmessage}"
                           aria-label="Previous"><span aria-hidden="true">&raquo;</span></a>
                    </li>
                </c:if>
                <span style="font-size: 20px;margin-left: 10px">共${studentpage.totalCount}条记录,共${studentpage.totalPage}页</span>
            </ul>
        </div>


</div>
<script src="./layui/layui.js"></script>
<script src="css/jquery-3.3.1.min.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    function deleteStudent(sno) {
        location.href = "${pageContext.request.contextPath}/deleteStudentServlet?sno=" + sno;
    }
</script>
</body>
</html>
