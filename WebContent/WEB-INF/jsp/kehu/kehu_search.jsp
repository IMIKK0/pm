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
<!-- 删除 -->
<script type="text/javascript" src="js /jquery-1.8.3.min.js"></script>
<script>
	  function delcustomer(){		 
		  var c=document.getElementsByName("checks");
		 //标识
		 var flag=false;
		  for(var i=0;i<c.length;i++){			 
			  //判断是否被选中
			  if(c[i].checked){
				  flag=true;
				  break;//跳出循环
			
			  } 
		  }
		  if(flag==true){
			  //修改action的值
			  $("#myform").attr("action","${pageContext.request.contextPath}/customerAction_delCustomer");
			//提交表单
			  $("#myform").submit();
		  }else{
			  alert("请至少选择一条数据");
		  }
		 
	  }
	
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
    document.getElementById("fom").action="kehu.htm";
   document.getElementById("fom").submit();
}

</SCRIPT>

<body>
<form name="form" id="myform" action="${pageContext.request.contextPath}/customerAction_delCustomer" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="24"><img src="../images/ico07.gif" width="20" height="18" /></td>
			  <td width="519"><label>公司名称:
			      <input name="text" type="text" nam="gongs" />
			  </label>
			    </input>
			    <input name="Submit" type="button" class="right-button02" value="查 询" /></td>
			   <td width="679" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>	
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
		           <input name="add_button" type="submit" class="right-button08" onclick=delcustomer() value="删除所选人员信息" /> 
		           <a href="add_kehu.jsp"><input name="submit" type="button" class="right-button08" value="添加人员信息" /></a>
		           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	              </td>
          </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td sty height="20" colspan="14" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> 客户详细列表 &nbsp;</td>
                    </tr>
                  <tr>
				    <td width="8%" align="center" bgcolor="#EEEEEE">选择</td>
					 <td width="12%" height="20" align="center" bgcolor="#EEEEEE">公司名称</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">联系人</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">联系电话</td>
                    <td width="14%" align="center" bgcolor="#EEEEEE">联系地址</td>
					<td width="28%" align="center" bgcolor="#EEEEEE">公司背景</td>
					<td width="10%" align="center" bgcolor="#EEEEEE">添加时间</td>
                    <td width="11%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                   <c:forEach items="${searchList }" var="search">
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="checks"/>${search.c_id}</td>
					<td height="20" bgcolor="#FFFFFF">${search.company}</a></td>
                    <td bgcolor="#FFFFFF">${search.c_name}</a></td>
                    <td height="20" bgcolor="#FFFFFF">${search.c_phone}</td>
                    <td bgcolor="#FFFFFF">${search.c_address}</td>
                    <td bgcolor="#FFFFFF">${search.c_desc}</td>
                    <td bgcolor="#FFFFFF">${search.createtime}</td>
					<td bgcolor="#FFFFFF"><a href="${pageContext.request.contextPath }/customerAction_findById?customer.c_id=${search.c_id}">编辑</a> | <a href="${pageContext.request.contextPath }/customerAction_delCustomer?customer.c_id=${c.c_id}">删除</a></td>
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
                <td width="49%" align="right">[<a href="${pageContext.request.contextPath }/customerAction_findCustomer" class="right-font08">首页</a> | 
                <c:if test="currentPage > 1">
                <a href="${pageContext.request.contextPath }/customerAction_findCustomer?currentPage=${currentPage-1}" class="right-font08">上一页</a> | 
           </c:if>
           <c:if test="currentPage < totalPage">
                <a href="${pageContext.request.contextPath }/customerAction_findCustomer?currentPage=${currentPage+1}" class="right-font08">下一页</a> |
                </c:if> 
                <a href="${pageContext.request.contextPath }/customerAction_findCustomer?currentPage=${totalPage}" class="right-font08">末页</a>] 
                
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

