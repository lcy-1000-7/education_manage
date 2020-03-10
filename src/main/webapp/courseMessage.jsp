<%--
  Created by IntelliJ IDEA.
  User: ZLM
  Date: 2020/3/8
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>课程信息</title>
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
        <div class="layui-row">
            <div class="layui-col-lg7" style="margin-top: 10px;margin-left: 20px;">
                <a href="${pageContext.request.contextPath}/addCourse.jsp?currentPage=1&rows=3" class="layui-btn">添加课程</a>
            </div>

            <form action="${pageContext.request.contextPath}/findCourseServlet?currentPage=1&rows=3" method="post">
                <div class="layui-input-inline" style="width: 300px;margin-top: 10px;">
                    <input type="text" name="cname" id="cname" value="${search.cname[0]}" placeholder="课程名称" class="layui-input key">
                </div>
                <button type="submit" class="layui-btn sou" style="margin-top: 10px;">搜索</button>
            </form>

        </div>
        <form action="${pageContext.request.contextPath}/deleteCourseServlet" method="post">
            <table class="layui-table layui-form">
                <thead>
                <tr>
                    <th>课程编号</th>
                    <th>课程名称</th>
                    <th>课程简介</th>
                    <th>开课时间</th>
                    <th>结课时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <c:forEach items="${page.list}" var="course">
                    <tbody>
                    <tr>
                        <td>${course.cno}</td>
                        <td>${course.cname}</td>
                        <td>${course.introduce}</td>
                        <td>${course.stime}</td>
                        <td>${course.etime}</td>
                        <td>
                            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findCourseBycnoServlet?cno=${course.cno}">修改</a>&nbsp;&nbsp;&nbsp;
                            <a class="btn btn-default btn-sm" href="javascript:void (0)" onclick="deleteCourse(${course.cno})">删除</a>
                        </td>
                    </tr>

                    </tbody>
                </c:forEach>
            </table>
        </form>

        <div class="page">
            <ul class="pagination">
                <c:if test="${page.currentPage <= 1}">
                <li class="disabled">
                    <span>&laquo;</span>
                    </c:if>
                    <c:if test="${page.currentPage > 1}">
                <li>
                    <a href="${pageContext.request.contextPath}/findCourseServlet?currentPage=${page.currentPage - 1}&rows=3&cname=${search.cname[0]}" aria-label="Previous">
                        &laquo;
                    </a>
                    </c:if>
                </li>

                <c:forEach begin="1" end="${page.totalPage}" var="i">
                    <c:if test="${page.currentPage == i}">
                        <li class="active"><a href="javascript:void (0)">${i}</a></li>
                    </c:if>
                    <c:if test="${page.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/findCourseServlet?currentPage=${i}&rows=3&cname=${search.cname[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>

                <c:if test="${page.currentPage >= page.totalPage}">
                <li class="disabled">
                    <span>&raquo;</span>
                    </c:if>
                    <c:if test="${page.currentPage < page.totalPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/findCourseServlet?currentPage=${page.currentPage + 1}&rows=3&cname=${search.cname[0]}" aria-label="Previous">
                        &raquo;
                    </a>
                    </c:if>
                </li>

                <span style="font-size: 20px; margin-left: 10px">共${page.totalCount}条记录，共${page.totalPage}页</span>
            </ul>
        </div>

    </div>

</div>
<script src="./layui/layui.js"></script>
<script src="css/jquery-3.3.1.min.js"></script>
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    function deleteCourse(cno) {
        console.log(cno);
        location.href = "${pageContext.request.contextPath}/deleteCourseServlet?cno=" + cno;

    }

</script>
</body>
</html>
