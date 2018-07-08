<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>审批列表</title>
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
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
</style>
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
</SCRIPT>

<body>
<form name="fom" id="fom" method="post" action="${pageContext.request.contextPath }/eaatypeAction_search" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="${pageContext.request.contextPath}/images/nav04.gif">
          
		   </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
		           
				 <a href="${pageContext.request.contextPath }/eaaAction_toAdd?findEaaType"> <input name="button" type="button" class="right-button08" value="添加" /></a> 
	              </td>
          </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="9" align="center" bgcolor="#EEEEEE"class="tablestyle_title">&emsp; 审批类型列表 &nbsp;</td>
                    </tr>
                  <tr>
				    <td width="10%" align="center" bgcolor="#EEEEEE">选择</td>
				    <td width="10%" align="center" bgcolor="#EEEEEE">编号</td>
				     <td width="10%" align="center" bgcolor="#EEEEEE">负责人</td>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">类型名称</td>
                     <td width="10%" align="center" bgcolor="#EEEEEE">审批人</td>
                      <td width="10%" align="center" bgcolor="#EEEEEE">描述</td>
                       <td width="10%" align="center" bgcolor="#EEEEEE">审批状态</td>
                        <td width="10%" align="center" bgcolor="#EEEEEE">审批时间</td>
                    <td width="20%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <c:forEach items="${eaaList }" var="e">
                  <tr>        
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
				    <td width="10%" align="center" bgcolor="#FFFFFF">${e.id }</td>
				    <td width="10%" align="center" bgcolor="#FFFFFF">${sessionScope.emp.username}</td>
                    <td width="10%" bgcolor="#FFFFFF"><div align="center">${e.eaaType.eaa_name }</div></td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">${e.emp.e_name}</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">${e.eaa_content}</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">${e.eaa_state}</td>
                    <td width="10%" align="center" bgcolor="#FFFFFF">${e.eaa_time}</td>
                    <td bgcolor="#FFFFFF"><div align="center"><a href="${pageContext.request.contextPath }/eaaAction_findById?eaa.id=${e.id}">编辑</a> | <a href="${pageContext.request.contextPath }/eaaAction_delEaa?eaa.id=${e.id}">删除</a></div></td>
                  </tr>
				</c:forEach>
                </table></td>
              </tr>
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
                <td width="50%">共 <span class="right-text09">${totalPage }</span> 页 | 第 <span class="right-text09">${currentPage}</span> 页</td>
                <td width="49%" align="right">[<a href="${pageContext.request.contextPath }/eaaAction_findEaa" class="right-font08">首页</a> | 
                <c:if test="currentPage > 1">
                <a href="${pageContext.request.contextPath }/eaaAction_findEaa?currentPage=${currentPage-1}" class="right-font08">上一页</a> | 
           </c:if>
           <c:if test="currentPage < totalPage">
                <a href="${pageContext.request.contextPath }/eaaAction_findEaa?currentPage=${currentPage+1}" class="right-font08">下一页</a> |
                </c:if> 
                <a href="${pageContext.request.contextPath }/eaaAction_findEaa?currentPage=${totalPage}" class="right-font08">末页</a>] 
                
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    
                    </tr>
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
