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
<table align="left" height="500" width="100%">
<tr>
<td  height="450" width="15%">
<%@ include file="\leftframelogin.jsp"%>
<td height="450" width="100%">
<form name="myform" method="">
<table height="450" width="100%">
<tr>
<td height="24">
</td></tr>
<tr>
<th bgcolor="black" align="left" height="10"><font color="white" size="4">
About Us
</font>
</th>
</tr>
<tr>
<td align="left"><font size="4" color="#2D69A8">
RealEstateManagement.com India is India’s leading online real estate portal that caters to real estate industry with more than 100,000 property listings. RealEstate.com’s networked team track and interpret the market forces and trends that affect real estate business to provide the best-informed solutions for real estate professionals such as developers, builders, financial institutions etc., with the major thrust in residential sector. It provides financial and real estate news to those who evaluate, invest-in and manage real estate industry. 
RealEstate.com updates property rates for both commercial and residential sector sourcing from its networked property valuators across India and other real estate institutions.</justify>
</td></tr>
<tr>
<td height="140">
</td>
</tr>
</table>
</td>
<td height="450" width="15%">
<%@ include file="\rightframe.jsp" %>
</td>
</tr>
</form>
</table>
<table align="bottom" height="50" width="100%">
<tr>
<td height="50" width="100%">
<%@include file="\footer.jsp"%>
</body>
</html>

