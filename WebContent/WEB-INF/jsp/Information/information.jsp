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
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/xiangmu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
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
    document.getElementById("fom").action="sendxiaoxi.htm";
   document.getElementById("fom").submit();
}

function on_load(){
	var loadingmsg=document.getElementById("loadingmsg");
	var mainpage=document.getElementById("mainpage");
	loadingmsg.style.display="";
	mainpage.style.display="none";
	
	loadingmsg.style.display="none";
	mainpage.style.display="";
}
</SCRIPT>
  <script type="text/javascript">
    	function updategoods() {
			var c=document.getElementsByName("checkid");
			var flag=false;
			var num=0;
			for(var i=0;i<c.length;i++){
				if(c[i].checked){
					flag=true;
					num++;
				}
			}
			if(num>1){
				alert("每次修改只能选择一条数据");
			}else if(num==0){
				alert("必须选择一条数据");
			}else{
				if(flag==true){
					$("#myform").submit();
				}
			}
		}
    	//删除
    	function deletegoods() {
    		var con;
    		con = confirm("你确定要删除这条数据吗");   	
    			var c=document.getElementsByName("checkid");
    			var flag=false;
    			for (var i = 0; i < c.length; i++) {
    				if(c[i].checked){
    					flag=true;
    				}
    			}
    			if(flag==true){
    				$("#myform").attr("action","${pageContext.request.contextPath}/informationAction!deleteInformation");
    				$("#myform").submit();
    			}else{
    				alert("请至少选择一条数据");
    			}    			   		
		}    	
    </script>
    
<body onload="on_load()">
<form name="myform" id="myform" method="post" action="">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="${pageContext.request.contextPath}/images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="${pageContext.request.contextPath}/images/ico07.gif" width="20" height="18" /></td>
			<td width="550">查看内容：按时间：
			 <input name="textfield" type="text" size="12" readonly="readonly"/><span class="newfont06">至</span>
			 <input name="textfield" type="text" size="12" readonly="readonly"/>	
			 <input name="Submit" type="button" class="right-button02" value="查 询" />
			 </td>
			 <td width="132" align="left"><a href="#" onclick="sousuo()">
			   <input name="Submit" type="button" class="right-button07" value="高级搜索" /></a></td>	
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
	              <input name="Submit" type="button" class="right-button08" onclick="deletegoods()" value="删除所选信息" />
	              <input name="Submit2" type="button" class="right-button08" value="新建信息" onclick="link();"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="6" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 消息总列表 &nbsp;</td>
                    </tr>
                  <tr>
				    <td width="4%" align="center" bgcolor="#EEEEEE">选择</td>
                    <td width="15%" height="20" align="center" bgcolor="#EEEEEE">标题</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">发送人</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">收件人</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">发送时间</td>
                    <td width="12%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <c:forEach items="${listinformation}" var="l">
                  <tr align="center">
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="checkid" value="${l.l_id}"/></td>
                    <td height="20" bgcolor="#FFFFFF">${l.l_name}</td>
                    <td bgcolor="#FFFFFF">${sessionScope.admin.username}</td>
                    <td bgcolor="#FFFFFF">${l.emp.e_name}</td>
                    <td bgcolor="#FFFFFF">${l.l_time}</td>
                    <td bgcolor="#FFFFFF"><a href="${pageContext.request.contextPath}/informationAction!deleteInformation?information.l_id=${l.l_id}">删除|</a><a href="${pageContext.request.contextPath}/informationAction!findInformationByid?information.l_id=${l.l_id}">编辑</a></td>
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
               <td width="50%">共 <span class="right-text09">${page.totalPageNumber}</span> 页 | 第 <span class="right-text09">${page.pageNum}</span> 页</td>
                <td width="49%" align="right">[<a href="#" class="right-font08">首页</a> | <a href="${pageContext.request.contextPath}/informationAction!findInformation?num=${page.prePageNum}" class="right-font08">上一页</a> | <a href="${pageContext.request.contextPath}/informationAction!findInformation?num=${page.nextPageNum}" class="right-font08">下一页</a> | <a href="${pageContext.request.contextPath}/informationAction!findInformation?num=${page.totalPageNumber}" class="right-font08">末页</a>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>

<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
</div>

</body>
</html>
