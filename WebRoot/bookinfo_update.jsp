<%@ page language="java" import="java.util.*,vo.*" pageEncoding="GB18030"%>
<%@page import="dao.factory.DAOFactory"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <link href="CSS/style.css" rel="stylesheet">   
    <title>ͼ�鵵���޸�</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
  
  <%
       BookInfo bookinfo=(BookInfo)session.getAttribute("bookinfo");
  %>
  <table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">��ǰλ�ã�ͼ����� &gt; ͼ�鵵������ &gt; �޸�ͼ����Ϣ &gt;&gt;&gt;</td>
      </tr>
      <tr>
         <td align="center" valign="top"><table width="100%" height="493"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top">
	<form name="form1" method="post" action="BookInfoUpdateServlet">

	<table width="600" height="432"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td align="center">ͼ�����ƣ�</td>
        <input name="bookid" type="hidden" size="50" value="<%=bookinfo.getBookid()%>">
        <td height="39"><input name="bookname" type="text"  id="bookname"  size="60" value="<%=bookinfo.getBookname()%>" readonly>* </td>
      </tr>
      <tr>
        <td align="center">ͼ�����ͣ�</td>
        <td><select>
			 <%
			  ArrayList allBookType=(ArrayList)session.getAttribute("allBookType");
			    String btypename=(String)session.getAttribute("btypename");
			   %> 
			   <%  for(int i=0;i<allBookType.size();i++){
			  	 BookType booktype1 = (BookType)allBookType.get(i);
			   	if(booktype1.getTypename().equals(btypename)){
              %>				
                <option value="<%=booktype1.getTypename()  %> "selected="selected"><%=booktype1.getTypename()   %></option>
        	 <%
        	 }else{
        	  %>  
        	  	<option value="<%=booktype1.getTypename()  %>"><%=booktype1.getTypename()   %></option>
        	<% 
        	}}
        	 %>            
             </select>
        </td>
      </tr>
      <tr>
        <td align="center">���ߣ�</td>
        <td><input name="author" type="text"  id="author" size="40"  value="<%=bookinfo.getAuthor()%>"></td>
      </tr>
      <tr>
        <td align="center">�����磺</td>
        <td>
        <select name="publishing" class="wenbenkuang">
                     <% 
	 			ArrayList allPublishing =(ArrayList)session.getAttribute("allPublishing");
	 			 String pubname=(String)session.getAttribute("pub");
			    for(int i=0;i<allPublishing.size();i++){
			  	 Publishing pub = (Publishing)allPublishing.get(i);   
			  	 if(pub.getPubname().equals(pubname)){     
        %>
                    <option value=<%=pub.getPubname() %> selected="selected"><%=pub.getPubname() %></option>
                    <%} else{
                    %>
                    <option value=<%=pub.getPubname() %>><%=pub.getPubname() %></option>
                    <% 
                    }}
                    %>
                  </select>
          </td>
      </tr>
       <tr>
        <td align="center">ISBN��</td>
        <td><input name="isbn" type="text" id="isbn" value="<%=bookinfo.getIsbn()%>">  </td>
      </tr>
      
      <tr>
        <td align="center">�۸�</td>
        <td><input name="price" type="text" id="price" value="<%=bookinfo.getPrice()%>">(Ԫ) * </td>
      </tr>
      <tr>
        <td align="center">��ܣ�</td>
        <td><select name="casename" class="wenbenkuang" id="casename" >
          
           <%
              ArrayList allBookCase = (ArrayList)session.getAttribute("allBookCase");
               String casename=(String)session.getAttribute("casename");
			    for(int i=0;i<allBookCase.size();i++){
			  	 BookCase bookcase1 = (BookCase)allBookCase.get(i);
			  	 if(bookcase1.getCasename().equals(casename)){
              %> 		
				
                <option value="<%=bookcase1.getCasename()%>"selected="selected"><%=bookcase1.getCasename()%></option>
        	 <%
        	 }else{
        	  %>
        	  <option value="<%=bookcase1.getCasename()%>"><%=bookcase1.getCasename()%></option>
        	  <%
        	  }} 
        	  %>
             </select>
           
       </td>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
        <td><input name="Submit" type="submit" class="btn_grey" value="����" onClick="return check(form1)">
&nbsp;
<input name="Submit2" type="button" class="btn_grey" value="����" onClick="history.back()"></td>
      </tr>
    </table>
	</form>
	</td>
  </tr>
</table></td>
      </tr>
    </table>
</td>
  </tr>
</table><%@ include file="copyright.jsp"%></td>
  </tr>
</table>
  </body>
</html>