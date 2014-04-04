<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title></title>

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

<td height="450" width="100%" align="center">
<s:form action="oppwpwqpwq1213" theme="simple">
<div id="text">
<div id="text_top">
<div id="text_top_left"></div>
<div id="text_top_right"></div>
</div>
<div id="text_body">

<TABLE>
<tr>
		<th colspan="4" align="center" bgcolor="black"><FONT SIZE="4"  COLOR="white"><B>Services Details</B></FONT></th>
	
</tr>
<TR>
	<TD height="10"></TD>
</TR>
<tr>
	<td>Service type</td>
	<td><select name="alliedservices">
		<option >--- Select Service ---
		<option>Architects
		<option >Vaastu Consultants
		<option>Builders & Developers
		<option >Building Contractors
		<option >Building Materials
		</select>
		</td>
<TD align="left">Contact Number</TD>
	<TD><INPUT TYPE="text" NAME="number" value="" size="20" maxlength="30"></TD>	
</tr>
<TR>
	<TD align="left">Company</TD>
	<TD><INPUT TYPE="text" NAME="companyname" value="" size="20" maxlength="40"></TD>
	<TD align="left">Website</TD>
	<TD><INPUT TYPE="text" NAME="companywebsite" value="" size="20" maxlength="40"></TD>
	
</TR>
<TR>
	<TD></TD>
</TR>

<TR>
	   <TD align="left">Company Address</TD>   
	<TD><INPUT TYPE="text" NAME="add1" value="" size="20" maxlength="50"></td>
	<TD align="left">Persons Address</TD>
	<TD><INPUT TYPE="text" NAME="add2" value="" size="20" maxlength="50"></TD>
</TR>

<TR>
	<TD ></TD>
</TR>

<TR>
	   <TD align="left">City</TD>
	   <TD><select name ="city">
	<option>--Select City--
	<option>Bangalore
	<option> Delhi
	<option> Mumbai
	</select></td>
	  <TD align="left">State</TD>
	   <TD><select name ="state">
	<option>--Select State--
	<option>Karnataka
	<option> Delhi
	<option> Maharashtra
	</select>
	</td>
<TR>
	<TD ></TD>
</TR>

<TR>
	   <TD align="left">Country</TD>
	   <TD><INPUT TYPE="text" name="country" value="" size="20"></TD>
	   <TD align="left">Email ID</TD>
	   <TD><INPUT TYPE="text" NAME="emailid" value="" size="20" maxlength="20"></TD>
</tr>
<TR>
	<TD></TD>
</TR>
<TR>
	<TD align="left">Contact Person</TD>
	<TD><INPUT TYPE="text" NAME="contactperson" value="" size="20" maxlength="20"></TD>
	
</TR>
<tr>
</tr>
<tr>

</tr>
<TR>
	<TD></TD>
</TR>
<TR>
	<TD align="left">Description</TD>
	<TD colspan="3"><textarea size="512" rows="5" cols="60" name="desc"></textarea></TD>
</TR>
<TR>
	<TD height= "10"></TD>
</TR>
	<tr>
	<td colspan="4" align="center">	
		
		<s:submit action="service" value="Submit"/>
	</td>
		
	</tr>

</TABLE>
 </div>
<div id="text_bottom">
<div id="text_bottom_left"></div>
<div id="text_bottom_right"></div>
</div>
<td height="440" width="15%">
<%@include file="\rightframe.jsp"%>
</td>
</tr>

</s:form>
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
