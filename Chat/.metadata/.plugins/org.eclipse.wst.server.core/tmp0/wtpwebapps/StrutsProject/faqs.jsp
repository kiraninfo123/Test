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
<form name="myform" method="">
<td height="450" width="100%">
<table align="left" height="450" width="100%">
<tr>
<td height="24">
</td>
</tr>
<tr>
<th bgcolor="black" align="left" height="10"><font color="white" size="4"> FAQ's
</font>
</th>
</tr>
<tr>
	<td><b><font size="4"><u>Registration</u></font></b></td>
</tr>
<tr>
	<td><font size="4"><b>How to register?</font><b></td>
</tr>
<tr>
	<td><font size="3" color="#2D69A8">You can register on realestate.com through a simple registration process. 
	Go to “Register!” on Homepage and fill a simple form. You can choose your profile type
	 (Owners, Agent).</font></td>
</tr>
<tr>
	<td><b><font size="4"><u>Search</u></font></b></td>
</tr>
<tr>
	<td><font size="4"><b>How to Search Property?</b></font></td>
</tr>
<tr>
	<td><font size="3" color="#2D69A8">This search helps you find properties quickly on the basis of the type of transaction (Buy/Rent), 
		type of property, Location (City), CostRange.</font></td>
</tr>
<tr>
	<td><b><font size="4"><u>Post Requirements</u></font></b></td>
</tr>
<tr>
	<td><font size="4"><b>What is Post Requirements?</b></font></td>
</tr>
<tr>
	<td><font size="3" color="#2D69A8">If there are “No records found” on the search result page matching your search criteria, or you do not like any of the 		properties displayed matching the criteria then RealEstate team recommends you to “Post Your Requirement”. We will send you updates on 		properties matching your requirements through email. .</font></td>
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