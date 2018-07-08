<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>网上商城114订购</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
</head>
<!-- <script type="text/javascript">
//全局变量a和b，分别获取用户框和密码框的value值
var a = document.getElementsByTagName("input")[0].value; //用户名
var b = document.getElementsByTagName("input")[1].value; //密码
//username失去焦点后验证value值
function oBlur_1() {
 if (!a) { //用户框value值为空
 document.getElementById("remind_1").innerHTML = "请输入用户名！";
 /* document.getElementById("change_margin_1").style.marginBottom = 1 + "px"; */
 } else { //用户框value值不为空
 document.getElementById("remind_1").innerHTML = "";
 /* document.getElementById("change_margin_1").style.marginBottom = 19 + "px"; */
 }
}
//username获得焦点的隐藏
function oFocus_1() {
	 document.getElementById("remind_1").innerHTML = "";
	 /* document.getElementById("change_margin_1").style.marginBottom = 19 + "px"; */
	}
</script> -->
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="images/top02.gif"><img src="images/top03.gif" width="776" height="147" /></td>
  </tr>
</table>
<form action="${pageContext.request.contextPath }/empAction!login" method="post">
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="images/line01.gif" width="5" height="292" /></td>
      </tr>
    </table></td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">用户名称：<br /></td>
        <td width="69%"><input name="emp.username" type="text" size="30" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密　码：<br /></td>
        <td><input name="emp.password" value="" type="password" size="30" /><span style="color:red">${msg}</span></td>
      </tr> 
      
      <tr>
        <td height="35">&nbsp;</td>
        <td><input name="Submit2" type="submit" class="right-button01" value="确认登陆" />
          <input name="Submit232" type="submit" class="right-button02" value="重 置" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("#yzm").click(function(){
			 this.src='${pageContext.request.contextPath }/empAction!yzm?'+Math.random();
		});
	})
	
</script>
</html>