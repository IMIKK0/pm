<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>下订单</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

</script>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="${pageContext.request.contextPath}/taskAction!findEmpName";
   document.getElementById("fom").submit();
}

</SCRIPT>

<body>
<form name="fom" id="fom" method="post" action="${pageContext.request.contextPath}/taskAction!searchTask">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
        
          <td height="62" background="${pageContext.request.contextPath}/images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
		    <td width="21"><img src="${pageContext.request.contextPath}/images/ico07.gif" width="20" height="18" /></td>
			<td width="538"> 按标题查询<input name="task.t_title" type="text">
				<input type="submit" class="right-button02" value="查 询" /></td>
			   <td width="144" align="left"></td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
	              <input name="Submit" type="button" class="right-button08" value="删除所选任务" />
	              <input name="Submit2" type="button" class="right-button08" value="添加任务" onclick="link();"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				 <tr class="CTitle" >
                    	<td height="22" colspan="7" align="center" style="font-size:16px">任务详细列表</td>
                  </tr>
                  <tr bgcolor="#EEEEEE">
				    <td width="4%" align="center" height="30">选择</td>
                    <td width="10%">任务标题</td>
					<td width="10%">计划开始时间</td>
                    <td width="10%">发送者</td>
					<td width="10%">执行人</td>
					<td width="5%">优先级</td>
					<td width="12%">操作</td>
                  </tr>
                  <c:forEach items="${listTask}" var="t">
                  <tr bgcolor="#FFFFFF">
				    <td height="20"><input type="checkbox" name="delid"/></td>
                    <td >${t.t_title}</a></td>
                    <td>${t.starttime}</td>
                    <td>admin</td>
                   
					<td>
					<c:forEach items="${t.emps}" var="emp">
					${emp.e_name}
					</c:forEach>
					</td>
                    <%-- <td>${t.emp.e_name}</td> --%>
                    <td>急</td>
                    <td><a href="${pageContext.request.contextPath}/taskAction!findTaskByid?task.t_id=${t.t_id}">编辑|</a>
					<a href="${pageContext.request.contextPath}/taskAction!deleteTask?task.t_id=${t.t_id}">删除</a></td>
                  </tr>		
                  </c:forEach>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">${page.totalPageNumber}</span> 页 | 第 <span class="right-text09">${page.pageNum}</span> 页</td>
                <td width="49%" align="right">[<a href="#" class="right-font08">首页</a> |
                 <a href="${pageContext.request.contextPath}/taskAction!findTask?num=${page.prePageNum}" class="right-font08">上一页</a> | 
                 <a href="${pageContext.request.contextPath}/taskAction!findTask?num=${page.nextPageNum}" class="right-font08">下一页</a> | 
                 <a href="${pageContext.request.contextPath}/taskAction!findTask?num=${page.totalPageNumber}" class="right-font08">末页</a>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
