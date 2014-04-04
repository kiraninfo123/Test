<%@ taglib prefix="s" uri="/struts-tags"%>
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

<td height="450" width="100%" align="center">
<s:form action="gfeygf32382" theme="simple">

<TABLE>
<tr>
		<th colspan="4" align="center" bgcolor="black"><FONT SIZE="4"  COLOR="white"><B>Services Details</B></FONT></th>
	
</tr>
<TR>
	<TD height="10"></TD>
</TR>
<TR>
	<TD height="10"></TD>
</TR>
<tr>
	<td><FONT SIZE="2">Service type</font></td>
	<td><select name="alliedservices">
		<option >--- Select Service ---
		<option>Architects
		<option >Vaastu Consultants
		<option>Builders & Developers
		<option >Building Contractors
		<option >Building Materials
		</select>
		</td>
<TD align="left"><FONT  size="2">Contact Number</FONT></TD>
	<TD><INPUT TYPE="text" NAME="number" value="" size="20" maxlength="30"></TD>	
</tr>
<TR>
	<TD align="left"><FONT size="2">Company</FONT></TD>
	<TD><INPUT TYPE="text" NAME="companyname" value="" size="20" maxlength="40"></TD>
	<TD align="left"><FONT size="2">Website</FONT></TD>
	<TD><INPUT TYPE="text" NAME="companywebsite" value="" size="20" maxlength="40"></TD>
	
</TR>
<TR>
	<TD></TD>
</TR>

<TR>
	   <TD align="left"><FONT size="2">Company Address</FONT></TD>   
	<TD><INPUT TYPE="text" NAME="add1" value="" size="20" maxlength="50"></td>
	<TD align="left"><FONT  size="2">Persons Address</FONT></TD>
	<TD><INPUT TYPE="text" NAME="add2" value="" size="20" maxlength="50"></TD>
</TR>

<TR>
	<TD ></TD>
</TR>

<TR>
	   <TD align="left"><FONT size="2">City</FONT></TD>
	   <TD><select name ="city">
	<option>--Select City--
	<option>Bangalore
	<option> Delhi
	<option> Mumbai
	</select></td>
	  <TD align="left"><FONT size="2">State</FONT></TD>
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
	   <TD align="left"><FONT size="2">Country</FONT></TD>
	   <TD><INPUT TYPE="text" name="country" value="" size="20"></TD>
	   <TD align="left"><FONT size="2">Email ID</FONT></TD>
	   <TD><INPUT TYPE="text" NAME="emailid" value="" size="20" maxlength="20"></TD>
</tr>
<TR>
	<TD></TD>
</TR>
<TR>
	<TD align="left"><FONT  size="2">Contact Person</FONT></TD>
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
	<TD align="left"><FONT size="2">Description</FONT></TD>
	<TD colspan="3"><textarea size="512" rows="5" cols="60" name="desc"></textarea></TD>
</TR>
<tr>
<td><input type="hidden" name="id" value="<%=session.getAttribute("id")%>">
</td>
</tr>

<TR>
	<TD height= "10"></TD>
</TR>
	<tr>
	<td colspan="4" align="center">	
		
		<s:submit action="myservices1" value="Update"/>
		<s:reset value="Reset"/>
	</td>
		
	</tr>

</TABLE>
</s:form>
<td height="440" width="15%">
<%@include file="\rightframe.jsp"%>
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
