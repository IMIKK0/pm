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
  <form action="${pageContext.request.contextPath}/project_uploadfoAction!uploadFile" method="post" enctype="multipart/form-data" name="form" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >文件上传</th>
  </tr>
  <tr>
    <td class="CPanel">
      <table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr align="center"><td height="30" style="font-size:16px">XXX项目</td>
		</tr>
		<TR>
		  <td height="26">	
			<table width="100%" border="0" cellpadding="2" align="center" cellspacing="1">	
			
					<tr class="TablePanel" >
						<td width="30%" align="right">文件名</td>
						<td width="50%" align="center">文件路径</td>	
						<td width="20%" ><a href="#">添加文件|</a><a href="#">删除文件</a></td>        	
					</tr>
					<tr>
					    <td align="right">所属项目:</td>
					    <td><select name="" >
                            <option  selected="selected">==请选择==</option>
                            <option>阿里巴巴</option>
                            <option>网易云</option>
                            <option>腾讯</option>
                        </select></td>					  
					  </tr>			
					<tr>
						<td align="right">XXXX</td>
						<td align="center"><input name="myfile" type="file" class="button" id="xxx" size="20" /></td>	        	
					    <td align="center">&nbsp;</td>
					</tr>										
							
			</table>								  
		</TD>									
	</TR>
</TABLE>
</td>
</tr>
<TR>
<TD colspan="2" align="center" height="50px">
<input type="submit" value="保存" class="button" />
<input type="button" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
</TR>
</TABLE>
 </td>
</tr>
</table>

</div>
</form>
</body>
</html>
