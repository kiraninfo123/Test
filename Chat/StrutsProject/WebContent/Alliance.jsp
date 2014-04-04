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
<td height="450" width="100%">
<form name="myform" method="">
<table height="450" width="100%">
<tr>
<td height="24">
</td>
<tr height="15" width="100%">
<th bgcolor="black" align="left" height="10"><font color="white" size="4"><b>Alliances</b></font>
</tr>
<TR>
	<TD><FONT SIZE="4"><B>Company </B></FONT></td>

<td><FONT SIZE="4" ><B>Description</B></FONT></td>

</tr>
<tr>
<td><img src="images/Logo.jpg" alt="" width="100" height="80" ></td>

<td><font size="3" color="#2D69A8">Collaboration Technologies is a software development, training and consultancy centre. 
It is dedicated to deliver good quality services in Software development and consultancy. 
                    We also have an expertise in training to improve the quality of work at all levels in an organization
                    </font></td>
</tr>


<tr>
<td><img src="images/Logo.jpg"  alt="" width="100" height="80" ></td>
<td><font size="3" color="#2D69A8">Collaboration Technologies is a software development, training and consultancy centre. It is dedicated to deliver good quality services in Software development and consultancy. 
                    We also have an expertise in training to improve the quality of work at all levels in an organization.</font></td>

</tr>

<tr>
<td><img src="images/Logo.jpg"  alt="" width="100" height="80" ></td>
<td><font size="3" color="#2D69A8">Collaboration Technologies is a software development, training and consultancy centre. It is dedicated to deliver good quality services in Software development and consultancy. 
                    We also have an expertise in training to improve the quality of work at all levels in an organization.</font></td>

</tr>
<tr>
<td height="50">
</td>
</tr>
</table>
</td>
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
</BODY>
</HTML>