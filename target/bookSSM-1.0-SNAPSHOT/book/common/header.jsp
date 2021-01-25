<%--jsp标准代码--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--    导航条部分-->
<div class="row">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav">
                <li><a href="book/index.do" ><span class="glyphicon glyphicon-home">首页</span></a></li>
                <li ><a class="glyphicon glyphicon-modal-window" href="admin/queryAllUser.do">用户管理</a></li>
                <li ><a class="glyphicon glyphicon-modal-window" href="book/queryAllBook.do">图书管理</a></li>
                </li>
            </ul>
            <ul class="nav navbar-nav pull-right ">
                <li ><a href="#">登录状态:${empty sessionScope.username?"暂未登录":sessionScope.username}</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" id="userManger" data-toggle="dropdown">个人管理 <b class="caret"></b></a>
                    <ul class="dropdown-menu">

                        <c:if test="${ empty sessionScope.username}">
                            <li><a href="book/Login.jsp"><span class="glyphicon glyphicon-user"></span> 登录</a></li>
                        </c:if>
                        <li><a href="book/Registered.jsp"><span class="glyphicon glyphicon-ok"></span> 注册</a></li>
                       <c:if test="${ not empty sessionScope.username}">
                           <li><a href="user/loginOut.do"><span class="glyphicon glyphicon-remove"></span> 注销</a></li>
                       </c:if>

                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</div>

