<%@ page language="java" import="java.util.*,vo.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<% 
	    request.setCharacterEncoding("utf-8"); 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示图书档案信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="CSS/style.css" rel="stylesheet">
  </head>
  
  <body>
  <%  
 	ArrayList allBookInfo =(ArrayList) session.getAttribute("allBookInfo");
  %>
     <%@include file="banner.jsp" %>
     <%@include file="navigation.jsp" %>
     <table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
      <tr>
         <td height="385" valign="top" bgcolor="#FFFFFF"><table width="99%" height="341"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
       <tr>
         <td height="341" valign="top" style="padding:5px;"><table width="98%" height="295"  border="0" cellpadding="0" cellspacing="0">
      <tr>
          <td height="22" valign="top" class="word_orange">当前位置：系统设置 &gt; 图书档案设置 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td height="273" align="center" valign="top">
         <%
          	if(allBookInfo.isEmpty()){
          	
          	

         %>
           <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="36" align="center">暂无图书档案信息！</td>
            </tr>
          </table>
          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><a href="bookinfo_add.jsp">添加图书档案信息</a></td>
  </tr>
</table>
          <%
          }else{
	%>
          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
           <td><a href="bookinfo_add.jsp" >添加图书档案信息</a> </td>
         
          </tr>
          </table>
 
	 
     
  <table width="100%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
  <td width="5%"    bgcolor="#F9D16B">图书编号</td>
    <td width="15%" bgcolor="#F9D16B">图书名称</td>
    <td width="12%" bgcolor="#F9D16B">图书类型</td>
    <td width="10%" bgcolor="#F9D16B">作者</td>
    <td width="15%" bgcolor="#F9D16B">出版社</td>
    <td width="12%" bgcolor="#F9D16B">ISBN</td>
    <td width="12%" bgcolor="#F9D16B">价格</td>
     <td width="10%" bgcolor="#F9D16B">书架</td>
    <td width="10%" bgcolor="#F9D16B">修改</td>
    <td width="10%" bgcolor="#F9D16B">删除</td>
  </tr>
   <%
     for(int i=0;i<allBookInfo.size();i++){
     	BookInfo bookinfo = (BookInfo)allBookInfo.get(i);
     	
      
	%> 
  <tr>
  <td style="padding:5px;"><%=bookinfo.getBookid() %></td>
   <td style="padding:5px;"><%=bookinfo.getBookname() %></td>
    <td style="padding:5px;"><%=bookinfo.getTypename() %></td>
    <td style="padding:5px;"><%=bookinfo.getAuthor()%></td>
    <td style="padding:5px;"><%=bookinfo.getPubname()%></td>
    <td style="padding:5px;"><%=bookinfo.getIsbn()%></td>
    <td style="padding:5px;"><%=bookinfo.getPrice()%></td>
    <td style="padding:5px;"><%=bookinfo.getCasename()%></td>
     <td align="center"><a href="BookInfoFindByIdServlet?bookid=<%=bookinfo.getBookid() %>&btypename=<%=bookinfo.getTypename()%>&pub=<%=bookinfo.getPubname() %>&casename=<%=bookinfo.getCasename() %>" >修改</a></td>
    <td align="center"><a href="BookInfoDeleteByIdServlet?bookid=<%=bookinfo.getBookid() %>" >删除</a></td> 
 
  </tr>
<%
}}
%>  
 </table>
</td>
      </tr>
    </table>
</td>
  </tr>
</table><%@ include file="copyright.jsp"%></td>
  </tr>
</table>
  </body>
</html>
