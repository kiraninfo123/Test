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
				<th colspan= "2" align="left" bgcolor="black"><b><font color="white"><center>&nbsp Project Details</center></font></b></th>
			</tr>
<tr>

<td height="600" width="600">
<s:form theme="simple" action="qwee8492849">
<table>
<tr>
<td> Project Name :</td>
<td><input type="text" size="30" name="name"></td>
</tr>
<td> Project Location :</td>
<td><select name ="location">
					<option>--Select Location--
					<option>Bangalore
					<option> Delhi
					<option> Mumbai
				</td>
</tr>
<tr>

<td><FONT  COLOR="black"size="2">Property Type</FONT>
				</td>
				<td><select name ="Property Type">
					<option>--Select Type--
					<option>Residential
					<option>commercial
					<option>agricultural
					<option>Industrial
				</td>
</tr>
<tr>
<td> Project Cost :</td>
<td><select name ="costrange">
	<option>10 - 20 Lakhs
	<option>12 - 15 Lakhs
	<option>14 - 16 Lakhs
	</select></td>
	</tr>
<tr>
<td>
<input type="hidden" value="<%=session.getAttribute("loginid")%>" name="loginid">
</td>
</tr>
<tr>
<td height="20">
</td>
</tr>
<tr>
<td >
<s:submit action="detail"/>
</td>
<tr>
</table>
</s:form>
</td>
</tr>
</table>
<%@ include file="/footer.jsp"%>
</body>
</html>

