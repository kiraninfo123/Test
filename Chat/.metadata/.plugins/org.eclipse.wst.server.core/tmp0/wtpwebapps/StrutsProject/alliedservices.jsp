<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.collaba.management.vo.AlliedVO"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Iterator"%>
<html>
<head>
<title></title>
</head>
<link href="default.css" rel="stylesheet" type="text/css" media="screen" />
<body>
<table align="top" height="70" width="100%">
<tr>
<td height="70" width="100%">
<%@ include file="\Header.jsp"%>
</td>
</tr>
</table>
<%

Collection propertylist=(Collection)session.getAttribute("alliedservice");

System.out.println("SIZE OF TIMETABLELIST"+propertylist.size());

Iterator iterT=propertylist.iterator();

AlliedVO voT=null;

%>
<%
while(iterT.hasNext())
{
	
       voT=(AlliedVO)iterT.next();
}
%>
<table width="100%" height="400">
<tr width="100%" bgcolor="gray">
<th align="left"><font size="5">Allied Serivce Details<font></th>
<tr>
<td width="100%" height="390">
<table width="" height="390" align="left" bgcolor="#DCEC7D">
<tr><td width="4%"><u><b>Person Details</b></u> </td><td width="10%"></td><td width="4%"><b><u>Company Details</b></u></td></tr>
<tr>
<td width="4%">Name : </td><td width="10%"><%=voT.getCperson()%></td><td width="4%">Company Name :</td><td width="10%"><%=voT.getCompany()%></td>
</tr>
<tr>
<td width="4%">Contact Number : </td><td width="10%"><%=voT.getContact()%></td><td width="4%">Company Location :</td><td width="10%"><%=voT.getAddress1()%></td>
</tr>
<tr>
<td width="4%">Persons Address : </td><td width="10%"><%=voT.getAddress2()%></td><td width="4%">Comany Website(URL) :</td><td width="10%"><%=voT.getUrl()%></td>
</tr>
<tr>
<td >City :  </td><td width="10%"><%=voT.getCity()%></td>
</tr>
<tr>
<td >State :  </td><td width="10%"><%=voT.getState()%></td>
</tr>
<tr>
<td>Company Description :</td><td><%=voT.getDesc()%></td></tr>
</table>
</td>
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
