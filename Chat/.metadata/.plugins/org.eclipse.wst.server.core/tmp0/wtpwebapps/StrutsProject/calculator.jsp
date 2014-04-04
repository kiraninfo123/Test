<html>
<head>
<title>---EMI Calculator---</title>
<script language="javascript">

function check(form,str)
{
jsvalue=str;

alert(str);


filename=  str +".jsp";
document.getElementById("hiddenvar").value = str;
form.method='post';
form.action= "com.collaba.management.servlet.MgmtServlet";
form.submit();

//alert(filename);

//parent.content.location.href=filename;

}
function calculate(frm)
	{
		lnamt = frm.loanamount.value;
		yrs=frm.years.value;
		irate=frm.interest.value;
		tot = (lnamt * yrs * irate)/100;
		alert("EMI Amount  "+ tot+" "+"Rs");	
	}

</script>
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
<table align="left" height="500" width="100%">
<tr>
<td  height="450" width="15%">
<%@ include file="\leftframelogin.jsp"%>
<td height="450" width="70%" align="center">
<form name="myform">
<TABLE width="100%">
<tr>
	<th colspan="4" bgcolor="black"><FONT SIZE="4"  COLOR="white"><B>EMI Calculator</B></FONT></th>
</tr>
<TR>
	<TD align="left"><FONT size="3">Loan Amount </FONT></TD>
	<TD><INPUT TYPE="text" NAME="loanamount" value="" size="10" maxlength="20"></TD>
	
</TR>
<TR>
	<TD></TD>
</TR>

<TR>
	   <TD align="left"><FONT size="3">No of Years</FONT></TD>
	   <TD><INPUT TYPE="text" name="years" value="" size="4" maxlength="3"></TD>
</TR>

<TR>
	<TD ></TD>
</TR>

<TR>
	   <TD align="left"><FONT size="3">Interest Rate</FONT></TD>
	   <TD><INPUT TYPE="text" name="interest" value="" size="2" maxlength="2"></TD>
</TR>

<TR>
	<TD height= "235"></TD>
</TR>
<TR>
	<TD COLSPAN="6" align="center">
	<a href="loan.jsp" target="middle"><font size="4" color="#2D69A8">Apply for Loan</font></a>
	<a href="loandocuments.jsp" target="middle"><font size="4" color="#2D69A8">Document Details</font></a>
	<INPUT TYPE="button" name="submit" value="Calculate" onClick="calculate(this.form)"></a>
	<INPUT TYPE="reset"  name="reset" value="Clear"></a>
	
</TD>
</TR>
</TABLE>

<td height="440" width="15%">
<%@include file="\rightframe.jsp"%>
</td>
</tr>
</form>
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