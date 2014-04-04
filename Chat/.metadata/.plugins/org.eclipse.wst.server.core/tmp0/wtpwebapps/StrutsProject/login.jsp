<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="iso-8859-1" %>
<html>
<head>

<title>Real Estate Management</title>
<script language="javascript">

 </script>
<%@ include file="/Header1.jsp"%>
<body>
<div id="global" >
<table height="90" width="100%">
<tr>
<td height="90" width="100%">
</td>
</tr>
</table>
<s:form  theme="simple" action="login">



<TABLE  align="center" bgcolor="#2D69A8" height="300" width="450">

<tr>
	<TD align="left" width="100"><font color="white"size="5"><u><b>Login ...</b></u></font></TD>
</td>
<tr>
<td height="5"/></tr>
</tr>

	<TD><font color="white">
	User Name</font></td><td><s:textfield name="userName" /> 
	</TD></tr>
	
	<tr><td><font color="white">
	Password</font></td><td><s:password  name="password" /> </td></tr>
	<tr>
	
	<tr><td><font color="white">
	Login Id</font></td><td><s:textfield name="loginid" /> </tr></td>
	<tr>
	<tr><td><font color="black"><s:fielderror/></font></td></tr>
<td>
<s:submit value="Login" action="login"></s:submit>
</td>
<td><s:reset/></td>

</s:form>
<tr>
	<td></td>
	<td><a href="forgotpassword.jsp"><font size="2" color="white"><b><u>Forgot Password ?</u></b></font></a></td>
	<td><a href="Registration.jsp" ><font size="2" color="white"><b><u>Not Registered ?</u></b></font></a></td>
<TR>
	<TD height= "10"></TD>
</TR>
<TR>
</TD>
</TR>
</table>
</div>
<table align="center" height="100" width="100%">
<tr>
<td height="100" width="100%">
</td>
</tr>
</table>
<%@ include file="/footer.jsp"%>  
</body>
</html>







