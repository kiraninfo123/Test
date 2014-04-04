<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1" import="javax.servlet.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title>Real Estate Management</title>
<script language="javascript">

</script>
</head>

<%@ include file="/Header1.jsp"%>

<body>

<table align="center" height="60" width="100%" bgcolor="white">
<tr>
<td height="60" width="100%">
</td>
</tr>
</table>
<table border="1pt" height="600" width="600" align="center">
<tr>

<td height="600" width="600">
<s:form theme="simple" action="qweeeeee23">
<table>
<tr>
<td><font size="5"><u><B>Registration ...</B></u></td>
</tr>
<tr>
<td height="20"/>
</tr>
</td>
</tr>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<tr>
<td>Login Id :</td><td><input type="text" name="loginid"  size="30"></td>
<td><input type="hidden" value="<%= session.getAttribute("loginid") %>" name="loginid1"></td>
<tr>
<td height="10"/>
</tr>
</tr>
<tr>
<td>Password :</td>
<td><s:password  name="password" size="30"/></td><td>
</td>
</tr>
<tr>
<td height="10"/>
</tr>
<tr>
<td>User Name :</td>
<td><s:textfield  name="username" size="30"/>
</td>
</tr>
<tr>
<td height="10"/>
</tr>
<tr>
<td>User Address :</td>
<td><s:textfield  name="address" size="30"/>
</td>
</tr>
<tr>
<td height="10"/>
</tr>
<tr>
<td>Email Id :</td>
<td><s:textfield  name="emailid" size="30"/>
</td>
</tr>
<tr>
<td height="10"/>
</tr>
<tr>
<td>Contact Number :</td>
<td><s:textfield  name="contact" size="30"/>
</td>
</tr>
<tr>
<td height="10"/>
</tr>
<tr>
<td>City :</td> 
<td><s:textfield  name="city" size="30"/>
</td>
</tr>
<tr>
<td height="10"/>
</tr>
<tr>
<td>State :</td>
<td><s:textfield  name="state" size="30"/>
</td>
</tr>
<tr>
<td height="10"/>
</tr>
<tr>
<td>Country :</td>
<td><s:textfield name="country" size="30"/>
</td>
</tr>
<tr>
<td height="10"/>
</tr>
<tr>
<td>Select User</td><td>
<select name="type">
	<option>Builder</option>
	<option>Agent</option>
	<option>Owner</option>
	</select>
	</td>
</tr>

<tr>
<td height="10"/>
</tr>
<s:submit action="registeragain" value="Update"/></td>
<td>
<td>
<s:submit value="Cancel" action="cancelupdate"/></td>
</tr>
<tr><td><font color="red">Note : All fields are mendatory.</font></td></tr>

</table>
</s:form>
</table>
<table align="center" height="60" width="100%" bgcolor="white">
<tr>
<td height="60" width="100%">
</td>
</tr>
</table>
<table align="bottom" height="50" width="100%">
<tr>
<td><%@ include file="/footer.jsp"%>
</td>
</tr>
</table>
</body>
</html>
