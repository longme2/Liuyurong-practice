<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/10
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-ico">
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style2.css" rel="stylesheet">
</head>
<body>
<div class="wholePage">
    <!--头部-->
    <!--header-->
    <header>
        <h1><img src="${pageContext.request.contextPath}/images/admin_logo.png"/></h1>
        <ul class="rt_nav">
            <li><a href="${pageContext.request.contextPath}/凯莱国际酒店.html" target="_blank" class="website_icon">站点首页</a></li>
            <li><a href="#" class="clear_icon">清除缓存</a></li>
            <li><a href="#" class="admin_icon">DeathGhost</a></li>
            <li><a href="#" class="set_icon">账号设置</a></li>
            <li><a href="${pageContext.request.contextPath}/凯莱国际酒店.html" class="quit_icon">安全退出</a></li>
        </ul>
    </header>
    <!--header-->
    <!--中部左侧-->
    <div class="middle-left">
        <div id="navcontainer">
            <ul id="navlist">
                <!--<div id="subnavlist">-->
                <li id="active_customer"><a href="#" id="current_customer">客户信息</a>
                    <ul id="subnavlist_customer">
                        <li id="subactive_customer"><a href="${pageContext.request.contextPath}/凯莱国际酒店.html" id="subcurrent_customer">首页</a></li>
                        <li><a href="${pageContext.request.contextPath}/html/客房预订.html">后台客房预订</a></li>
                        <li><a href="#">客户管理</a></li>
                    </ul>

                </li>
                <li id="active_income"><a href="#" id="current_income">数据中心</a>
                    <ul id="subnavlist_income">
                        <!--<li id="subactive_income"><a href="#.html" id="subcurrent_income"></a></li>-->
                        <li><a href="room_find.action">客房数据</a></li>
                        <li><a href="order_find.action">订单数据</a></li>
                    </ul>
                </li>
                <!--</div>-->
                <li><a href="#">管理员</a>
                    <ul>
                        <li><a href="管理员.html">增加管理员账号</a></li>
                        <li><a href="admin_find.action">管理员信息</a></li>
                    </ul>
                </li>
                <li id="active_table"><a href="#">数据管理</a>
                    <ul>
                        <li><a href="room_finddel.action">客房管理</a></li>
                        <li><a href="admin_finddel.action">权限管理</a></li>
                        <li><a href="order_finddel.action">订单管理</a></li>
                    </ul>
                </li>
                <li id="active_process"><a href="#">流程管理</a>
                    <ul>
                        <li><a href="流程图.html">综合流程图</a></li>
                        <li><a href="流程管理.html">逻辑关系</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--中部左侧-->
    <!--tab-->
    <div class="tab">
        <ul class="skillImg">
            <li onclick="clickC(1)" id="click1" class="clickA"><p style="text-align: center"><a href="后台.html">平台管理</a></p></li>
            <li onclick="clickC(2)" id="click2" class="clickA"><p style="text-align: center"><a href="客房管理.html">客房管理</a></p></li>
            <li onclick="clickC(3)" id="click3" class="clickA"><p style="text-align: center"><a href="后台.html">安全管理</a></p></li>
            <li onclick="clickC(4)" id="click4" class="clickA"><p style="text-align: center"><a href="后台.html">数据中心</a></p></li>
            <li onclick="clickC(5)" id="click5" class="clickA"><p style="text-align: center"><a href="表单管理.html">表单管理</a></p></li>
            <li onclick="clickC(6)" id="click6" class="clickA"><p style="text-align: center"><a href="流程管理.html">流程管理</a></p></li>
            <li onclick="clickC(7)" id="click7" class="clickA"><p style="text-align: center"><a href="后台.html">交流中心</a></p></li>
            <li onclick="clickC(8)" id="click8" class="clickA"><p style="text-align: center"><a href="后台.html">企业邮箱</a></p></li>
            <li onclick="clickC(9)" id="click9" class="clickA"><p style="text-align: center"><a href="管理员.html">管理员账户</a></p></li>
        </ul>
    </div>
    <!--tab-->
    <!--table-->
    <table id="order">
        <tbody>
        <tr>
            <th>订单号</th>
            <th>房间号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>身份证</th>
            <th>入住日期</th>
            <th>套房类型</th>
            <th>押金</th>
            <th>房价</th>
            <th>支付金额</th>
            <th>操作</th>

        </tr>
        <s:iterator value="orderList">
            <tr class="fn">
                <td><s:property value="orderId"/> </td>
                <td><s:property value="orderRoomId"/> </td>
                <td><s:property value="orderClientName"/> </td>
                <td><s:property value="orderClientSex"/> </td>
                <td><s:property value="orderClientId"/> </td>
                <td><s:property value="orderDate"/> </td>
                <td><s:property value="orderHotelType"/> </td>
                <td><s:property value="orderCashpledge"/> </td>
                <td><s:property value="orderHotelPrice"/> </td>
                <td><s:property value="orderHotelPayment" /></td>
                <td align="middle" ><a href="order_del.action?orderId=<s:property value="orderId"/>">取消订单</a></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <!--table-->
    <!--内容部分-->
    <div class="banner">
        <img src="${pageContext.request.contextPath}/images/banner.png" alt="">
    </div>
    <div class="rightside">
        <img src="${pageContext.request.contextPath}/images/侧边pic1.PNG" alt="">
    </div>
    <div class="offside">
        <img src="${pageContext.request.contextPath}/images/侧边pic2.PNG" alt="">
    </div>
    <!--内容部分-->
</div>
</body>
<script>
    var min=1,max=9;
    window.onload=clickC;
    function clickC(obj){
        if(Number(obj)){
            min=obj;
        }
        for(var i=1;i<(max+1);i++){
            if(i==min){
                document.getElementById("click"+i).className="clickA";
            }else{
                document.getElementById("click"+i).className="clickB";
            }
        }
    }

</script>
</html>
