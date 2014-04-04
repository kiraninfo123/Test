<html>
<head>
<title>Real Estate Management</title>
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
</script>
</head>

<table align="top" height="100" width="100%">
<tr>
<td height="100" width="100%"><%@ include file="/Header.jsp"%>
</td>
</tr>
</table>

<body>
<table align="center" height="60" width="100%" bgcolor="white">
<tr>
<td height="60" width="100%">
</td>
</tr>
</table>
<table border="1pt" height="400" width="600" align="center">
<tr>
<td height="400" width="600">
<FORM method="post" action="" name="myform" enctype="multipart/form-data">
<table align="center" height="400" width="600">
<tr>
	<TD align="left" width="100"><font color="white"size="5"><u><b>Apply</b></u></font></TD>
</td>
</tr>

<tr>
<td>
</td>
</tr>
<tr>
	<TD align="left" width="100"><font color="white"size="3">Login Id</font></TD>
	<TD><INPUT TYPE="text" NAME="loginid" value="" size="30" maxlength="30"></TD>
	
</TR>
<tr>
	<TD align="left" width="100"><font color="white"size="3">Password </font></TD>
	<TD><INPUT TYPE="password" NAME="password" value="" size="30" maxlength="30"></TD>
	
</TR>
<tr>
	<TD COLSPAN="6">
	Submit Resume  <input type="file" name="filename">
</td></tr>
<tr>
<td><INPUT TYPE="button" name="applyresume" value="Apply" align="left" onClick="check(myform,'applyresume')"></td>
<td><input type="reset" name="reset" value="Reset" align="left"></td>
</TR>


</table>
<input type="hidden" id="hiddenvar" name="action" value="">
</form>
</td>
</tr>
</table>
<table align="center" height="60" width="100%" bgcolor="white">
<tr>
<td height="60" width="100%">
</td>
</tr>
</table>
<table align="bottom" height="50" width="100%">
<tr>
<td height="50" width="100%"><%@ include file="/footer.jsp"%>
</td>
</tr>
</table>
</table>
</body>
</html>
