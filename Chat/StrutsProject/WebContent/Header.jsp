<html>
<head>
<title> </title>
<link href="styles.css" rel="stylesheet" type="text/css">
<script language="javascript">
function clock()
	{ 
	var dat = new Date();
	t = dat.getDate() +"-"+ (dat.getMonth()+1) +"-"+ dat.getFullYear();
	var hour= dat.getHours();
	var min= dat.getMinutes();
	var sec = dat.getSeconds();
	var temp = "" + ((hour > 12) ? hour - 12 :hour) 
	temp += ((min < 10) ? ":0" : ":") + min
	temp += ((sec < 10) ? ":0" : ":") + sec
	temp += (hour >= 12) ? " PM" : " AM"
                document.getElementById('clk').innerHTML=t + " " + temp;
//	alert(  document.getElementById('clk').text);
      	id = setTimeout("clock()",1000)
	}
</script>
</head>
<body onLoad="clock()">
<div> 
	<table id="header" 	cellpadding="0" cellspacing="0">
		<tr>
			<td	width="15%"><img src="images/Logo.jpg"></td>
			<td class="text" width="70%">Property Management</td>
			<td	width="15%">
				<table>
					<tr><td><label id="clk"></label></td></tr>
					<tr><td>Call :1-800-000-250</td></tr>
					<tr><td>Welcome  <%= session.getAttribute("user") %>&nbsp;&nbsp;&nbsp;<a href="login.jsp">Logout<a></td></tr>
				</table>
			</td>
			</td>
		</tr>
	</table>
<table width="100%" bgcolor="#083253">
<tr>
<td>
<table align="center">
<tr>
<td align="center">
	<div id="menu">
		<ul>
			<li><a href="home_mod.jsp">Home</a></li>
			<li><a href="news.jsp">News</a></li>
			<li><a href="message.jsp">Messages</a></li>
			<li><a href="careers.jsp">Careers</a></li>
			<li><a href="testimonials.jsp">Testimonials</a></li>
			<li><a href="contact.jsp">Contact Us</a></li>
			<li><a href="Alliance.jsp">Alliances</a></li>
			<li><a href="blogs.jsp">Blogs</a></li>
			<li><a href="dashboards.jsp">Dashboard</a></li>
			<li><a href="faqs.jsp">Faq's</a></li>
			<li><a href="aboutus.jsp">About Us</a></li>
		</ul>
	</div>
</td>
</tr>
</table>
</td>
</tr>
</table>
</div>
</body>

</html>