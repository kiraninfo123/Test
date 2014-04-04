<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.collaba.management.vo.AlliedVO"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Iterator"%>
<html>
<head>
<title></title>
<script language="javascript">
</script>
</head>
<body>
<table align="top" height="70" width="100%">
<tr>
<td height="70" width="100%">
<%@ include file="\Header.jsp"%>
</td>
</tr>
</table>
<table align="left" height="500" width="100%">
<tr>
<td  height="450" width="15%">
<%@ include file="\leftframelogin.jsp"%>
</td>
<td>
<s:form action="iwij323232" theme="simple">
<td height="450" width="70%">
<table align="center" height="200" width="100%">

<tr height="10%">
	<th align="left"><font size="4"><b><u>Building Contractors </u></b><font></th>
</tr>
<tr bgcolor="#2D69A8" height="4">
<th align="left">Service ID</th>
	<th align="left">Contact Person</th>
	<th align="left">Person Contact Number</th>
	<th align="left">Company Name</th>
</tr>
<%

Collection propertylist=(Collection)session.getAttribute("allied");

System.out.println("SIZE OF TIMETABLELIST"+propertylist.size());

Iterator iterT=propertylist.iterator();

AlliedVO voT=null;

%>

<%
while(iterT.hasNext())
{
	
       voT=(AlliedVO)iterT.next();

%>
<tr>
<td><input type="radio" name="choice" value="<%=voT.getAid()%>" > <%=voT.getAid()%>
</td>
<td>
<%=voT.getCperson()%>
</td>
<td>
<%=voT.getContact()%>
</td>
<td>
<%=voT.getCompany()%>
</td>
<%}%>
</tr>
<tr>
<td height="300">
</td>
</tr>
<tr>
<td><input type="hidden" name="id" value="building">
</td>
</tr>
<tr>
<td><font color="red"><u>Note </u>: Please select from above options for update,delete, or to view details.</font></td>
</tr>
<tr>
<td align="center"><s:submit action="allieddetail" value="Details" />&nbsp&nbsp&nbsp&nbsp
		<s:submit action="alliedupdate" value="Update"/>&nbsp&nbsp&nbsp&nbsp
		<s:submit action="allieddelete" value="Delete"/>
</td>
</tr>
</table>
<input type="hidden" id="hiddenvar" name="action" value="">
<td height="450" width="15%">
<%@include file="\rightframe.jsp"%>
</td>
</s:form> 
</tr>
</table>
<table align="bottom" height="50" width="100%">
<tr>
<td height="50" width="100%">
<%@include file="\footer.jsp"%>
</td>
</tr>
</table>
</body>
</html>