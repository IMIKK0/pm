<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>main</title>
<link rel="stylesheet" rev="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>


<script language="JavaScript" type="text/javascript">
 function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check(form){
	var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
	var sfzzz = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
	var isPhone = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
	var issr = /^(19|20)\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])$/;
	// email
	var obj = document.getElementById("email");
	if(obj.value === ""){
alert("邮箱不能为空!");
return false;
}else if(!reg.test(obj.value)){
alert("请输入正确的邮箱格式!");
return false;
}
	//idCard
	var sfz = document.getElementById("sfznum");
	if(sfz.value === ""){
		alert("身份不能为空");
	return false;
	}else if(!sfzzz.test(sfz.value)){
		alert("请输入正确的身份证号码");
	return false;
	}
	//phone
	var phone = document.getElementById("phone");
	if(phone.value === ""){
		alert("手机号不能为空");
		return false;
		}else if(!isPhone.test(phone.value)){
		alert("请输入正确得手机号");
		return false;
		}
	//birthday
	var birthday = document.getElementById("birthday");
	if(birthday.value === ""){
		alert("出生年月不能为空");
		return false;
	}else if(!issr.test(birthday.value)){
		alert("请输入出生年月");
		return false;
	}else{
		return true;
	}
} 
</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="${pageContext.request.contextPath}/empAction!addEmp" onsubmit="return check(this)" method="post" enctype="multipart/form-data" name="form" >
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
					    <td nowrap="nowrap" align="right">真实姓名:</td>
					    <td><input class="text" name="emp.e_name" style="width:154px" value=""/></td>
					    <td align="right">性别:</td>
					    <td><select name="emp.e_sex" >
                            <option selected="selected">男</option>
                            <option>女</option>
                        </select></td>
					  </tr>
					  
					    <tr>
					    <td align="right">用户名:</td>
					    <td><input class="text" name="emp.username" id="username" style="width:154px" value=""/></td>
					    <td align="right">密码:</td>
					    <td><input class="text" name="emp.password" id="paswdd" style="width:154px" value=""/></td>
					  </tr>
					  
					  <tr>
					    <td align="right">出生日期:</td>
					    <td><input class="text" type="date" id="birthday" name="emp.e_birthday" style="width:154px" value=""/></td>
					    <td align="right">身份证号码:</td>
					    <td><input class="text" name="emp.id_card" id="sfznum" style="width:154px" value=""/></td>
					  </tr>
					    <tr>
					   <td align="right">员工权限:</td>
					    <td><select name="emp.jurisdiction" >
                            <option  selected="selected" value="2">普通员工</option>
                            <option value="0">超级管理员</option>
                            <option value="1">管理员</option>
                            <option value="2">普通员工</option>
                        </select></td>				
					  </tr>
					  
					  <tr>
					    <td align="right">电子邮箱:</td>
					    <td><input class="text" name="emp.e_mail" id="email" style="width:154px" value=""/></td>
					    <td align="right">电话号码:</td>
					    <td><input class="text" name="emp.e_phone" id="phone" style="width:154px" value=""/></td>
					  </tr>
					  <tr>
					    <td align="right">居住地址:</td>
					    <td><input name="emp.e_address" type="text" size="30" />                        </td>
					    <td align="right">部门:</td>
					    <td><select name="emp.dept.d_id" >
                          <option  selected="selected">==请选择==</option>
                          <option value="1">开发部</option>
                          <option value="2">外交部</option>
                        </select></td>
					  </tr>
					  <tr>
					    <td align="right">员工类型:</td>
					    <td><select name="emp.e_type" >
                            <option  selected="selected">==请选择==</option>
                            <option>实习</option>
                            <option>试用</option>
                            <option>正式员工</option>
                        </select></td>					  
					  </tr>					 					 										 
					  <tr>
					    <td align="right">描述:</td>
					    <td colspan="3"><textarea name="emp.e_describe" cols="100" rows="8"></textarea></td>
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
