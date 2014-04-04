<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="iso-8859-1" %>
<html>
<head>
<title>Real Estate Management</title>
<script language="javascript">
function clock()
{ 
	var dat = new Date();
	t = dat.getDate() +"-"+ (dat.getMonth()+1) +"-"+ dat.getYear();
	var hour= dat.getHours();
	var min= dat.getMinutes();
	var sec = dat.getSeconds();
	var temp = "" + ((hour > 12) ? hour - 12 :hour) 
	temp += ((min < 10) ? ":0" : ":") + min
	temp += ((sec < 10) ? ":0" : ":") + sec
	temp += (hour >= 12) ? " P.M." : " A.M."
                document.getElementById('clk').innerHTML=t + " " + temp;
//	alert(  document.getElementById('clk').text);
      	id = setTimeout("clock()",1000)
}
function check(form,str)
{
jsvalue=str;

alert(str);


filename=  str +".jsp";
document.getElementById("hiddenvar").value = str;
form.method='post';
form.action= "com.collaba.management.action.Registration";
form.submit();

//alert(filename);

//parent.content.location.href=filename;

}
	
 </script>
<%@ include file="/Header.jsp"%>
<table height="90" width="100%">
<tr>
<td height="90" width="100%">
</td>
</tr>
</table>
<s:form  theme="simple" action="x1">



<TABLE  align="center" bgcolor="#0191E0" height="300" width="450">

<tr>
	<TD align="left" width="100"><font color="white"size="5"><u><b>Login ...</b></u></font></TD>
</td>
</tr>


	<TD>
	User Name</td><td><s:textfield name="userName"  tooltip="Enter User Name" labelposition="top" /> 
	</TD></tr>
	<tr><td>
	Password</td><td><s:password  name="password"  tooltip="Enter Password" labelposition="top" /> </tr></td>
	<tr>
	<tr><td>
	Login Id</td><td><s:textfield name="loginid"  tooltip="Enter Loginid" labelposition="top" /> </tr></td>
	<tr>
<td>
<s:submit value="Done" action="deleteuser"></s:submit>
</td>
<td><s:reset/></td>

</s:form>
<tr>
	<td></td>
	<td><a href="forgotpassword.jsp"><font size="2" color="black"><b><u>Forgot Password</u></b></font></a></td>
<TR>
	<TD height= "10"></TD>
</TR>
<TR>
</TD>
</TR>
</table>

<table align="center" height="100" width="100%">
<tr>
<td height="100" width="100%">
</td>
</tr>
</table>
<%@ include file="/footer.jsp"%>  
</body>
</html>







