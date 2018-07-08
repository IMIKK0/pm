<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
  <form action="${pageContext.request.contextPath}/empAction!updateEmp" method="post" enctype="multipart/form-data" name="form" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >员工基本信息录入</th>
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
				<legend>员工信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					  <!--   <td width="16%" align="right" nowrap="nowrap">密码:</td>
					    <td width="34%"><input class="text" name='datevalue2' style="width:154px" value=""></td> -->
					  </tr>
					    
					    
					  <tr>
					    <td nowrap="nowrap" align="right">真实姓名:</td>
					    <input type="hidden" name="emp.e_id" value="${emp.e_id}">
					    <td><input class="text" name="emp.e_name" style="width:154px" value="${emp.e_name}"/></td>
					    <td align="right">性别:</td>
					    <td><select name="emp.e_age" >
                            <option selected="selected">${emp.e_sex}</option>
                            <option>男</option>
                            <option>女</option>
                        </select></td>
					  </tr>
					  
					  
					  <tr>
					    <td align="right">出生日期:</td>
					    <td><input class="text" name="emp.e_birthday" style="width:154px" value="${emp.e_birthday}"/></td>
					    <td align="right">身份证号码:</td>
					    <td><input class="text" name="emp.id_card" style="width:154px" value="${emp.id_card}"/></td>
					  </tr>
					  <tr>
					    <td align="right">电子邮箱:</td>
					    <td><input class="text" name="emp.e_mail" style="width:154px" value="${emp.e_mail}"/></td>
					    <td align="right">电话号码:</td>
					    <td><input class="text" name="emp.e_phone" style="width:154px" value="${emp.e_phone}"/></td>
					  </tr>
					  <tr>
					    <td align="right">居住地址:</td>
					    <td><input name="emp.e_address" value="${emp.tasks.t_title}" type="text" size="30" />                        </td>
					    <td align="right">职位:</td><%-- ${emp.task.t_title} ${emp.e_address} --%>
					    <td><select name="dept_id" >
                          <option  selected="selected">${emp.dept.d_name}</option>
                          <option>程序员</option>
                          <option>项目经理</option>
                          <option>经理</option>
                        </select></td>
					  </tr>						 					 										 
					  <tr>
					    <td align="right">描述:</td>
					    <td colspan="3"><textarea name="emp.e_describe" cols="100" rows="8">${emp.e_describe}</textarea></td>
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
			<input type="submit" value="保存" class="button"/>　
			</TD>
		</TR>
		</TABLE>		
	 </td>
  </tr>      
  </table>
</div>
</form>
</body>
</html>
