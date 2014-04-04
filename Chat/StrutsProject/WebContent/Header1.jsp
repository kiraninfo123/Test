<html>
<head>

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
</script>
<title></title>
</head>
<body onLoad="clock()">
  <div id="header"> 
<table bgcolor="#2D69A8" width="100% height="100">
<tr>
<td height="80">
	<td width="15%"> <img src="images/Logo.jpg" width="150" height="100" alt=""></td>
	<td width="65%" align="center"><Font size="6" color="white"><b>Property Management</b></font></td>
                <td width="20%">
	<table>
		<tr><td  align="left"><font size="4" color="white"><label id="clk"></label></font></td></tr>
	<tr>		<td align="left"><font size="2" color="white"><b>Customer Call :1-800-000-250</b></font></td></tr>		
	</table>
	</td>
	</td>
</tr>
</table>
</body>

</html>