
<%--jsp标准代码--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%--引入资源--%>
    <%@ include file="/book/common/resoures.jsp"%>
    <title>用户管理页面</title>
    <style>
        tr td{
            text-align: center;
        }
    </style>

</head>
<body>
<div class="container-fluid">

    <!--    导航条部分-->
    <div class="row">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="collapse navbar-collapse" >
                <ul class="nav navbar-nav">
                    <li><a href="book/queryAllBook.do" ><span class="glyphicon glyphicon-home">首页</span></a></li>
                    <li ><a class="glyphicon glyphicon-modal-window" href="admin/queryAllUser.do">用户管理</a></li>
                    <li ><a class="glyphicon glyphicon-modal-window" href="book/queryAllBook.do">图书管理</a></li>
                    </li>
                </ul>
                <ul class="nav navbar-nav pull-right ">
                    <li ><a href="#">登录状态:${empty sessionScope.username?"暂未登录":sessionScope.username}</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" id="userManger" data-toggle="dropdown">个人管理 <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/book_ctiy/book/Registered.jsp"><span class="glyphicon glyphicon-ok"></span> 注册</a></li>
                            <li><a href="/book_ctiy/admin/userServlet?action=loginOut"><span class="glyphicon glyphicon-remove"></span> 注销</a></li>

                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <!--    数据表格展示-->

    <div class="col-lg-11 ">

        <div style="position: relative;margin-bottom: 20px ;margin-top: 80px" class="text-center" >
            <input type="text" id="search" placeholder="请输入用户名" >
            <button class="btn-default btn-success" > <span class="glyphicon glyphicon-search"></span>搜索</button>
            <div class="pull-right operation_btn">
                <!-- 按钮触发模态框 -->
                <button class="btn btn-success " data-toggle="modal" data-target="#myModal"> <span class="glyphicon glyphicon-plus"></span>添加</button>

            </div>
        </div>
        <table border="1" class=" table table-hover" >
            <thead >
            <tr class="btn-primary">
                <th class="hidden">id</th>
                <th>用户名</th>
                <th>密码</th>
                <th>邮箱</th>
                <th>电话</th>

                <th class="text-center">操作</th>
            </tr>
            </thead>
            <tbody id="tbody" >


            <c:forEach  items="${requestScope.userList}" var="user" >
                <tr>

                    <td class="hidden">${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>
                        <button class='btn-danger noupdate '>取消</button>
                        <button class='btn-primary confirm_update updatein '>确认修改</button>
                        <button class=' btn-danger del' type="button">删除</button>
                        <button class='btn-primary update' type="button">修改</button>
                    </td>
                </tr>

            </c:forEach>


            </tbody>
        </table>

    </div>


    <div class="row">

        <!-- 模态框（Modal） -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title text-center text-primary btn btn-success" id="myModalLabel">添加用户</h4>
                    </div>
                    <div class="modal-body .box" id="input-content">

                        <form action="admin/addUser.do" method="post">
                            <p>	<button class="btn btn-info text-center" style="width: 60px;height: 30px;">用户名: </button>  <input name="username" type="text" value="controller" ></p>
                            <p>	<button class="btn btn-info text-center" style="width: 60px;height: 30px;">密码: </button>  <input name="password" type="text" value="root123" ></p>
                            <p><button class="btn btn-info text-center" style="width: 60px;height: 30px;">邮箱 : </button> <input name="email"  type="text" value="root@qq.com" ></p>
                            <p><button class="btn btn-info text-center" style="width: 60px;height: 30px;">电话 : </button> <input name="phone"  type="text" value="1008622" ></p>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="submit"  class="btn btn-success">提交更改</button>

                            </div>
                        </form>
                    </div>

                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
    </div>

</div>


<script type="text/javascript">
    $(function () {
        //一开始先让去修修改和确认修改隐藏
        $(".noupdate").hide();
        $(".updatein").hide();


        //删除功能
        $(".del").click(function () {
            if (confirm("确认删除?")){
                //获取id值
                var id = $(this).parent().parent().find("td:eq(0)").text();
                //通过ajax post请求 删除id
                $.post("admin/deleteUser.do",{userId:id} ,function (data) {
                    window.location.href="admin/queryAllUser.do";
                });
            }
        })


        //搜索功能 focusout:输入框失去焦点事件
        $("#search").focusout(function () {
            var input_val = $(this).val();
            window.location.href="admin/likeUser.do?username="+input_val;
        })

        //修改功能
        var arr=new Array(5);

        $(".update").click(function () {
            for (var i = 0;i<5;i++){
                var td_val=$(this).parent().parent().find("td:eq("+i+")").text();
                $(this).parent().parent().find("td:eq("+i+")").html("<input type='text' value='"+td_val+"'>");
            }
            $(this).parent().find(".update").hide();
            $(this).parent().find(".del").hide();
            $(this).parent().find(".noupdate").show();
            $(this).parent().find(".updatein").show();
            //取消操作
            $(this).parent().find(".noupdate").click(function () {
                for (var i = 0;i<5;i++){
                    var input_val=$(this).parent().parent().find("td:eq("+i+")>input:text").val();
                    $(this).parent().parent().find("td:eq("+i+")").html(input_val);
                }
                $(this).parent().find(".update").show();
                $(this).parent().find(".del").show();
                $(this).parent().find(".noupdate").hide();
                $(this).parent().find(".updatein").hide();

            })
        })
        $(".confirm_update").click(function () {
            //获取修改后的所有input——value值
            for (var i = 0 ; i<5; i++){
                var ip_val =$(this).parent().parent().find("td:eq("+i+")>input:text").val();
                arr[i] =ip_val;
                console.log(arr);
            }
            $.post("admin/updateUser.do",{

                id:arr[0],
                username:arr[1],
                password:arr[2],
                email :arr[3],
                phone:arr[4],
             },function () {
                window.location.href = "admin/queryAllUser.do";
            });

        })
    })


</script>

</body>
</html>