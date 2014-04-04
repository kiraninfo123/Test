<%@ taglib prefix="s" uri="/struts-tags" %>

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
<td height="430" width="70%" align="center">
	
<s:form action="loan" theme="simple">
<div id="text">
<div id="text_top">
<div id="text_top_left"></div>
<div id="text_top_right"></div>
</div>
<div id="text_body">

<TABLE>
<tr>
	<th colspan="4" bgcolor="black"><FONT SIZE="4"  COLOR="white"><B>Apply for loan</B></FONT></th>
</tr>
<tr>
	<td height="40"></td>
</tr>
<tr>
	<td align="left">Name</td>
	<td><input type="text" name="name" value=""></td>
	
	<td align="left">Occupation</td>
	<td><input type="text" name="occupation" value=""></td>
</tr>
<tr>
<td height="10"></td>
</tr>
<tr>
	<TD align="left" width="100">Salary</TD>
	<TD width="90"><select name ="salary">
	<option> - - Select Salary - - 
	<option>below 25,000/month
	<option>25,000 to 50,000/month
	<option>50,000 to 1,00,000/month
	<option>1,00,000 to 5,00,000/month
	<option>above 5,00,000/month</td>
	
	<TD align="left" width="100">Expected Amount</TD>
	<TD width="90"><select name ="amount">
	<option> - - Select Amount - - 
	<option>100,000 - 500,000
	<option>500,000 - 10,00,000
	<option>10,00,000 - 15,00,000
	<option>15,00,000 - 25,00,000
	<option>More than 25,00,000</td>
</tr>
<tr>
<td height="10"></td>
</tr>
<TR>
	  <TD align="left">Persons Address</TD>
	  <TD><INPUT TYPE="text" NAME="address1" value="" size="20" maxlength="100"></TD>
	  <TD  align="left">City</TD>
        <TD><select name ="city">
	<option>--Select City--
	<option>Bangalore
	<option> Delhi
	<option> Mumbai
	</select></td>
	  </TR>
<TR>
	<td height="10"></td>
</TR>
<TR>
	   
	<TD  align="left">State</TD>
    <TD><select name ="state">
	<option>--Select State--
	<option>Karnataka
	<option> Delhi
	<option> Maharashtra
	</select></td>
	<TD  align="left">Country</TD>
        <TD><select name ="country">
	<option>--Select Country--
	<option>India
	</select>
	</td>
</TR>


<TR>
	<td height="10"></td>
</TR>

<TR>
	   <TD align="left">Email ID</TD>
	   <TD><INPUT TYPE="text" NAME="emailid" value="" size="20" maxlength="35"></TD>
	<TD align="left">Contact Number</TD>
	<TD><INPUT TYPE="text" NAME="contact" value="" size="20" maxlength="35"></TD>
</TR>

<TR>
	<TD height= "60"></TD>
</TR>
<TR>
	<TD COLSPAN="6" align="left">
	<a href="loandocuments.jsp" target="middle"><font size="2" color="yellow">Document Details</font></a>
	<a href="calculator.jsp" target="middle"><font size="2" color="yellow">EMI Calculator</font></a>
	<s:submit action="loan" value="Apply"/></a>
	<s:reset value="Cancel"/></a>
	
</TD>
</TR>
</table> 
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