<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>main</title>
<link rel="stylesheet" rev="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="${pageContext.request.contextPath }/eaaAction_editEaa" method="post" enctype="multipart/form-data" name="form" target="mainFrame" >
  <input type="hidden" name="eaa.id" value="${eaa.id }" />
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >审批基本信息录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="submit" name="button" value="保存" onclick="alert('保存成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
				<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>审批信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					    <tr>
					    <td align="right">审批人</td>
					    <td><select name="eaa.emp.e_id" >
					    <c:forEach items="${empList}" var="emp">
                          <option value="${emp.e_id}">${emp.e_name}</option>
                          </c:forEach>
                        </select></td>
					  <td align="right">审批类型</td>
					    <td><select name="eaa.eaaType.id" >
					    <c:forEach items="${eaaTypeList}" var="et">
                          <option value="${et.id }">${et.eaa_name}</option>
                          </c:forEach>
                        </select></td>
					  </tr>
					     
					  <tr>
					    <td nowrap="nowrap" align="right">审批时间:</td>
					    <td><input class="text" name="eaa.eaa_time" type="Date" style="width:154px" value="${eaa.eaa_time }"/></td>
					    <td align="right">审批状态:</td>
					    <td><input class="text" name='eaa.eaa_state' style="width:154px" value="${eaa.eaa_state }"/></td>
					  </tr>
					 
					  <tr>
					    <td align="right">描述:</td>
					    <td colspan="3"><textarea name="eaa.eaa_content" cols="100" rows="8" value="${eaa.eaa_content }"></textarea></td>
					    </tr>
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		

		
		
		
		</TABLE>
	
	
	 </td>
  </tr>
  
  
		
		
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="add" value="保存" class="button" />　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  </table>

</div>
</form>
</body>
</html>
