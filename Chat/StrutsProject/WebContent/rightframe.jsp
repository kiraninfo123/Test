<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
form.action= "com.collaba.management.action.allied";
form.submit();

//alert(filename);

//parent.content.location.href=filename;

}
</script>
</head>
<body>
<s:form action="woeiwoew131" theme="simple">


<table width="15%" height="60" bgcolor="" border="0">
<tr><td height="10"></td></tr>
<tr>
<th>Select Allied Service</th></tr>
<tr><td height="2"></td></tr>
<tr>
	<td><select name="alliedservices">
		<option>--- Select Service ---
		<option>Architects
		<option>Vaastu Consultants
		<option >Builders & Developers
		<option>Building Contractors
		<option>Building Material
	<!--	<option>Civil Contractors
		<option>Demolition Contractor
		<option>Electrical Contractors
		<option>Ceiling Contractors
		<option>Plumbing Contractors
		<option>Aluminium Fabricators
		<option>Landscape Contractors
		<option>Masonry Contractors
		<option>Painting Contractor
		<option>Pest Control Contractor
		<option>Plastering Contractors
		<option>Corpentary Work
		<option>Borewells or  Diviners
		<option>Soil Mechanics 
		<option>Environment Consultant   -->
		</select>
	</td>
</tr>
<tr><td><s:submit  action="allied" value="View" /> </td></tr>

<tr height="300"><td align="center"><marquee direction="up"><img src="images/f1.jpg"> <img src="images/f2.jpg"> <img src="images/f3.jpg">
<img src="images/f4.jpg"> <img src="images/f5.jpg"> <img src="images/f6.jpg"></marquee></td>
</tr>
</table>


</s:form>
</td>
</tr>
</body>
</html>