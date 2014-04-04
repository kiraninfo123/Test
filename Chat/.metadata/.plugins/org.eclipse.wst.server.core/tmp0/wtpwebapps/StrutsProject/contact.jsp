<html>
<head>
<title></title>
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
<link href="default.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>

<table align="top" height="50" width="100%">
<tr>
<td height="50" width="100%">
<%@ include file="\Header.jsp"%>
</td>
</tr>
</table>

<table align="top" height="50" width="100%">
<tr>
<td  height="450" width="15%">
<%@ include file="\leftframelogin.jsp"%>
<form name="myform">
<td height="450" width="100%">
<table height="450" width="100%">
<tr>
<td height="24">
</td></tr>
<tr>
<th bgcolor="black" align="left" height="10"><font color="white" size="4">
Contact Us
</font>
</th>
</tr>
<tr>
<td align="left"><font size="4" color="#2D69A8">
<u><b>Collaboration Technologies</b></u></font>
</td>
</tr>
<tr>
<td><font size="3" color="#2D69A8">
#314/1, Cellar, R.J.Plaza, 1st H-Cross, 7th Main, Subbanna Garden,</font>
</td></tr>
<tr><td><font size="3" color="#2D69A8"> Vijayanagar, Bangalore - 560040 ; Cell: 9886272445 </font></td></tr>
 <tr><td><font size="3" color="#2D69A8">Url :</font> <a href="www.collaborationtech.co.in"><font size="3" color="#2D69A8"><b>www.collaborationtech.co.in</b></a></font>&nbsp 
</TR>
</TD>
<tr>
<td height="200">
</td>
</tr>
</table>
<td height="450" width="15%">
<%@ include file="\rightframe.jsp"%>
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