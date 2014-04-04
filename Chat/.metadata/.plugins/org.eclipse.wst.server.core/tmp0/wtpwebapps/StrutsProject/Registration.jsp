<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title>Golden Capital Services</title>
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

<s:form theme="simple" action="1233dbwd">
<table>
<tr>
<td><font size="5"><u><B>Registration </B></u></td>
</tr>
<tr>
<td height="20"/>
</tr>
</td>
</tr>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<tr>
<td>Login Id :</td><td><s:textfield  name="userloginid" size="30"/>
</td>
<tr>
<td height="10"/>
</tr>
</tr>
<tr>
<td>Password :</td>
<td><s:password  name="userpassword" size="30"/></td><td>
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
<TD><select name ="city">
	<option>--Select City--
	<option>Bangalore
	<option> Delhi
	<option> Mumbai
	</select></td>
</tr>
<tr>
<td height="10"/>
</tr>
<tr>
<td>State :</td>
<TD><select name ="state">
	<option>--Select State--
	<option>Karnataka
	<option> Delhi
	<option> Maharashtra
	</select>
</td>
</tr>
<tr>
<td height="10"/>
</tr>
<tr>
<td>Country :</td>
<td><select name="country">
<option>-- Select Country --</option>
<option>India</option>
</select>
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

<tr>
<td height="10"/>
</tr>
<tr>
<td colspan="5" ><s:submit action="register" value="Register"/></td>
<td>
	<s:submit action="update" value="Update"/></td>
<td>
	<s:submit action="delete" value="Delete"/></td>
<td>
	<s:reset value="Reset"/></td>
</tr>
<tr><td><input type="hidden" name="name" value="register"></td></tr>
<tr><td><font color="red">Note : All fields are mendatory.</font></td></tr>
<font color="red"><s:fielderror/>,</font>
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
