<%--
  Created by IntelliJ IDEA.
  User: pengycc
  Date: 2020/3/6
  Time: 14:12
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
                        <dd><a href="${pageContext.request.contextPath}/classServlet">新增班级</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed" >
                    <a href="javascript:;">教师管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:void(0)">教师信息</a></dd>
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
        <div class="layui-row">
            <div class="layui-col-lg7" style="margin-top: 10px;margin-left: 20px;">
                <a href="${pageContext.request.contextPath}/teacherServlet" class="layui-btn">添加教师</a>
            </div>

            <form action="${pageContext.request.contextPath}/teacherMessageServlet?pageNum=1&rows=5" method="post" >
                <div  class="layui-col-lg4" style="text-align: right" >
                        <div class="layui-input-inline" style="width: 300px;margin-top: 10px;">
                            <input type="text" id="tphone" name="tphone" value="${map.tphone[0]}" placeholder="手机" class="layui-input key">
                            <input type="text" id="tname" name="tname" value="${map.tname[0]}" placeholder="用户名" class="layui-input key">
                            <input type="text" id="temail" name="temail" value="${map.temail[0]}" placeholder="邮箱" class="layui-input key">
                        </div>
                        <button type="submit" class="layui-btn sou" style="margin-top: 10px;">搜索</button>
                </div>
            </form>
        </div>

        <form action="${pageContext.request.contextPath}/teacherMessageServlet" method="post" id="form">
            <table class="layui-table layui-form">

                <thead>
                <tr>
                    <th>教师编号</th>
                    <th>教师姓名</th>
                    <th>教师性别</th>
                    <th>出生日期</th>
                    <th>联系方式</th>
                    <th>邮箱</th>
                    <th>授学班级</th>
                    <th>毕业院校</th>
                    <th>学历</th>
                    <th>成果</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${page.list}" var="teacher" varStatus="status" >
                    <tr class="id36567">
                        <td>${teacher.tno}</td>
                        <td>${teacher.tname}</td>
                        <td>${teacher.tsex}</td>
                        <td>${teacher.tbirth}</td>
                        <td>${teacher.tphone}</td>
                        <td>${teacher.temail}</td>
                        <td>${teacher.course}</td>
                        <td>${teacher.school}</td>
                        <td>${teacher.education}</td>
                        <td>${teacher.result}</td>
                        <td>
                            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findTeacherByTnoServlet?tno=${teacher.tno}">修改</a>&nbsp;
                            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/deleteTeacherServlet?tno=${teacher.tno}">删除</a>
                        </td>
                    </tr>
                </c:forEach>



                </tbody>
            </table>
        </form>

        <div class="page">
            <ul class="pagination">
                <%--向前翻页--%>
                <c:if test="${page.pageNum == 1}">
                <li class="disabled">
                </c:if>
                <c:if test="${page.pageNum != 1}">
                <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/teacherMessageServlet?pageNum=${page.pageNum > 1?page.pageNum-1:1}&rows=5&tphone=${map.tphone[0]}&tname=${map.tname[0]}&temail=${map.temail[0]}">&laquo;</a>
                </li>

                    <%--页码--%>
                    <c:forEach begin="1" end="${page.totalPage}" var="i">
                        <c:if test="${page.pageNum == i}">
                            <li class="active"><a href="${pageContext.request.contextPath}/teacherMessageServlet?pageNum=${i}&rows=5&tphone=${map.tphone[0]}&tname=${map.tname[0]}&temail=${map.temail[0]}">${i}</a></li>
                        </c:if>
                        <c:if test="${page.pageNum != i}">
                            <li><a href="${pageContext.request.contextPath}/teacherMessageServlet?pageNum=${i}&rows=5&tphone=${map.tphone[0]}&tname=${map.tname[0]}&temail=${map.temail[0]}">${i}</a></li>
                        </c:if>
                </c:forEach>

                <%--向后翻页--%>
                <c:if test="${page.pageNum == page.totalPage}">
                <li class="disabled">
                </c:if>
                <c:if test="${page.pageNum != page.totalPage}">
                <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/teacherMessageServlet?pageNum=${page.pageNum < page.totalPage?page.pageNum+1:page.totalPage}&rows=5&tphone=${map.tphone[0]}&tname=${map.tname[0]}&temail=${map.temail[0]}">&raquo;</a>
                </li>
                    <span style="font-size: 20px;margin-left: 10px">共${page.totalCount}条记录,共${page.totalPage}页</span>
            </ul>
        </div>

    </div>

    <!-- 模态框（Modal） -->
<%--    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">--%>
<%--        <div class="modal-dialog">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
<%--                    <h4 class="modal-title" id="myModalLabel">提示</h4>--%>
<%--                </div>--%>

<%--                <input id="uid" name="uid" type="hidden" >--%>
<%--&lt;%&ndash;                <span type="hidden"><input id="uid" name="uid" type="text" ></span>&ndash;%&gt;--%>
<%--                <div class="modal-body">--%>
<%--                    <div>确定删除该条记录吗？</div>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
<%--                    <button type="button" class="btn btn-primary" id="deleteUserBtn">确定删除</button>--%>
<%--                </div>--%>
<%--            </div><!-- /.modal-content -->--%>
<%--        </div><!-- /.modal -->--%>
<%--    </div>--%>


</div>
<script src="./layui/layui.js"></script>
<script src="css/jquery-3.3.1.min.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });


    <%--function showDeleteModal(obj) {--%>
    <%--    $("#uid").val(obj);// 将要删除的数据的id绑定到隐藏框里--%>
    <%--    $("#myModal").modal({--%>
    <%--        backdrop : 'static',--%>
    <%--        keyboard : false--%>
    <%--    });--%>
    <%--}--%>

    <%--$(function () {--%>
    <%--    $("#deleteUserBtn").click(function () {--%>
    <%--        location.href="${pageContext.request.contextPath}/deleteTeacherServlet?tno="+$("#uid").val();--%>
    <%--    })--%>
    <%--});--%>

</script>
</body>
</html>

