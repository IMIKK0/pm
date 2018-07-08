<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>main</title>
<link rel="stylesheet" rev="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/xiangmu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>


<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="" method="post" enctype="multipart/form-data" name="myform" id="myform" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >任务添加页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="button" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>

		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>添加任务</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="13%">任务标题:</td>
					    <td width="41%"><input name="task.t_title" class="text" style="width:250px" type="text" size="40" />
				        <span class="red"> *</span></td>
					    </tr>
					  <tr>
					    <td nowrap align="right">计划开始时间:</td>
					    <td><input name="task.starttime" type="date" value="" id="" class="text" style="width:154px" /></td>
					    <td align="right">计划结束时间:</td>
					    <td><input name="task.endtime" id="Input" value="" type="date" class="text" style="width:154px" /></td>
					  </tr>
					   <tr>
					    <td nowrap align="right">任务执行人:</td>
					    <td colspan="3"><!-- <select name="task.emp.e_id"> -->
					      <c:forEach items="${listEmpName}" var="name" varStatus="statu">	
					      <input class="ch" type="checkbox" value="${name.e_id}" name="emp[${statu.index }].e_id">${name.e_name} 
							<%-- <option value="${name.e_id}">${name.e_name}</option> --%>
						  </c:forEach>
						<!-- </select> --></td>
					    <td align="right">优先级:</td>
					    <td><select name="select" >
                          <option  selected="selected">==请选择==</option>
                          <option>暂不</option>
                          <option>一般</option>
                          <option>需要</option>
                          <option>急</option>
                          <option>很急</option>
                        </select></td>
					  </tr>
					  <tr>
					    <td nowrap align="right" height="120px">任务说明:</td>
					    <td colspan="3"><textarea id="textarea" name="task.comment" rows="5" cols="80"></textarea></td>
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
			<input type="button" name="Submit" onclick="ename()" value="保存" class="button"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
<script language="JavaScript" type="text/javascript">
 function ename(){	
	
	//document.getElementsById("checkid");
		var c=document.getElementsByClassName("ch");
		
		var arr=[];
		var flag=false;		
		for (var i = 0; i < c.length; i++) {
			
			if(c[i].checked){
				arr.push(c[i].getAttribute("value"));
				flag=true;
			}
		}
		if(flag==true){
			$("#myform").attr("action","${pageContext.request.contextPath }/taskAction!addTask");
			$("#myform").submit();
			/* location.href="${pageContext.request.contextPath }/taskAction!addTask?checkid="+arr; */
		}else{
			alert("请至少选中一名员工");
		} 		   	
}
</script>
</html>
