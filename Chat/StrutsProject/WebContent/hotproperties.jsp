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
</head>
<link href="default.css" rel="stylesheet" type="text/css" media="screen" />
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
</td>
</tr>
<tr height="10" width="100%">
<th bgcolor="black" align="left"><font color="white" size="4"><b>Hot Properties</b></font>
</th>
</tr>

<tr>
<td height="390">
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