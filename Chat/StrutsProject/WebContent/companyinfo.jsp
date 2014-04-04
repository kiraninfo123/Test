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
</td>
&nbsp;
<s:form action="companyinfo" theme="simple">
<td height="450" width="100%">
<div id="text">
<div id="text_top">
<div id="text_top_left"></div>
<div id="text_top_right"></div>
</div>
<div id="text_body">

<table height="450" width="100%">
<tr>
<td height="24">
</td>
</tr>
<tr height="15" width="100%">
<th bgcolor="black" align="left" height="10">Company Informations<th>
</tr>
		<tr>
		<td>
		
		<font size="3.5">		1)<u>ABC company </u>:</font>
				jhjjbbdhsbdhsdbshbdhhhhwuuuudndudwdnwunadbasbdybsybysb
				cscnsjncajjsnjanjscnjcjansjcuecbdcbyd
				hchschschschsbchsbhcsbcshcbshbchsbchsb.
				<br>
		
		</td>
		</tr>
		<tr>
		<td>
		
		<font size="3.5">		2)<u>LMC Infrastructures:</u></font>
				djdduwdubwbcibLBLUWBUWBUBBYEBEYVBEYIImscsimifeeowonadbasbdybsybysb
				cscnsjncajjsnjanjscnjcjansjcuecbdcbyd
				hchschschschsbchsbhcsbcshcbshbchsbchsb.
		
		</td>
		</tr>
		<tr>
		<td>
		
		<font size="3.5">		3)<u>QBG Infrastructures </u>:</font>
				dnsndunuefuefbesokwdowjienfuenfunugrughasmasmaaanadbasbdybsybysb
				cscnsjncajjsnjanjscnjcjansjcuecbdcbyd
				hchschschschsbchsbhcsbcshcbshbchsbchsb.
		
		</td>
		</tr>
		<tr><td height="120"></td></tr>
	</table>
	</div>
<div id="text_bottom">
<div id="text_bottom_left"></div>
<div id="text_bottom_right"></div>
</div>
<td height="440" width="15%">
<%@include file="\rightframe.jsp"%>
</td>
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