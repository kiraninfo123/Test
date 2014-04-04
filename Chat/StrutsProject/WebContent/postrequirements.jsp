<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title></title>
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
<td height="450" width="70%">

<s:form action="postrequirements" theme="simple">
<div id="text">
<div id="text_top">
<div id="text_top_left"></div>
<div id="text_top_right"></div>
</div>
<div id="text_body">

<table width="100%" height="408" border="0">
<tr>
	<th colspan="4" align="center" bgcolor="black"><FONT SIZE="4"  COLOR="white"><B>Post Requirments</B></FONT></th>
</tr>
<tr>
	<td height="10"></td>
<TR>

	<TD></TD>
</TR>
<tr>
	<TD align="left">I want to</TD>
	<td colspan="3"><Input type="radio" name = "propertyfor" value="buy">Buy
	<input type="radio" name="propertyfor"value="rent">Rent
	<input type="radio" name="propertyfor"value="lease">Lease</td>
	
</TR>
<TR>
	<TD align="left">Property Type</TD>
	<TD><select name ="Property Type">
	<option>--Select Type--
	<option>Residential
	<option>Commercial
	<option>Agricultural
	<option>Industrial
	</select></td>
	
</td>
	   <TD align="left">Cost Range</TD>
			
	<td><select name ="costrange">
	<option>-- Select Cost --
	<option>10 - 20 Lakhs
	<option>12 - 15 Lakhs
	<option>14 - 16 Lakhs
	</select>
	</td>
	

</TR>
<TR>
	<TD></TD>
</TR>
<tr>
	<TD align="left">Property Age</TD>
	<TD><select name ="propertyage">
	<option>- - Select Age- -
	<option>less than 1
	<option>greater 1 & less 5
	<option>greater 5 & less 10
	<option>greater 10
	</select></TD>
	<TD align="left">City</TD>
	  <TD><select name ="city">
	<option>--Select City--
	<option>Bangalore
	<option> Delhi
	<option> Mumbai
	</select></td>
	</tr>
<TR>
	<TD></TD>
</TR>
<TR>
		<td align="left">State</td>
	<TD><select name ="state">
	<option>--Select State--
	<option>Karnataka
	<option> Delhi
	<option> Maharashtra
	</select></td>
	
<td>Country</td>
<td><select name="country">
<option>-- Select Country --</option>
<option>India</option>
</select>	
</td>
</TR>
<TR>
	<TD></TD>
</TR>
<TR></TR>
<TR>
	<TD></TD>
</TR>
<tr>
	 <TD align="left">No of Rooms</td>
	 <td><select name ="noofrooms">
	<option>3
	<option>4
	<option>5
	</select>Bed Rooms
	<select name ="noofbedrooms">
	<option>1
	<option>2
	<option>3
	</select></TD> 
	<TD align="left">Builiding/Land Area</TD>
	<TD><select name ="sqft">
	<option>-- Select Area --
	<option>1000 sqft
	<option>1500 sqft
	<option>2000 sqft
	<option>2500 sqft
	<option>3000 sqft
	</select>
	</td>

	 
</tr>
<tr>	
</tr>
<TR>
<TD align="left">Person Name</TD>
	<TD><INPUT TYPE="text" NAME="name" value="" size="20" maxlength="20"></TD>
	 
	<td align="left">Persons Address</td>
	<td> <input type="text" name="add2" value="" size="20" maxlength="70"/></td>

	</TR>
<TR>
	<TD></TD>
</TR>
<TR>
<TD align="left">Email ID</TD>
	   <TD><INPUT TYPE="text" NAME="emailid" value="" size="18" maxlength="20"></TD>

	<TD align="left">Contact Number</TD>
	<TD><INPUT TYPE="text" NAME="contact" value="" size="20" maxlength="20"></TD>
	</tr>
	<tr>
	<td height="2"/>
	</tr>
<tr>
	<TD align="left">Amenities</TD>
	<TD><select name ="amenities">
	<option> ------ Select Amenities ------</option>
	<option>Park</option>
	<option>Gym</option>
	<option>Swimming Pool</option>
	<option>Car Parking</option>
	<option>Swimming Pool+Park</option>
	<option>Gym+Park</option>
	<option>Swimming Pool+Gym</option>
	<option>Car Parking+Park</option>
	<option>Car Parking+Gym</option>
	<option>Car Parking+Swimming Pool</option>
	<option>Swimming Pool+Gym+Park</option>
	<option>Car Parking+Gym+Park</option>
	<option>Car Parking+Swimming Pool+Park</option>
	<option>Car Parking+Swimming Pool+Park+Gym</option>
	</td>
	</tr>
	<tr>

<TD align="left">Landmarks</TD>
	<TD><select name ="landmark">
	<option> ------ Select Landmark ------</option>
	<option>School</option>
	<option>Hospital</option>
	<option>Railway Station</option>
	<option>Bus Stand</option>
	<option>School+Hospital</option>
	<option>School+Railway Station</option>
	<option>School+Bus Stand</option>
	<option>Hospital+Railway Station</option>
	<option>Hospital+Bus Stand</option>
	<option>Railway Station+Bus Stand</option>
	<option>School+Hospital+Railway Station</option>
	<option>School+Railway Station+Bus Stand</option>
	<option>School+Hospital+Bus Stand</option>
	<option>Hospital+Railway Station+Bus Stand</option>
	<option>School+Hospital+Railway Station+Bus Stand</option>
	</td>
		
</TR>
<tr>
<td height="2"/>
</tr>
<tr>
	<TD align="left">Furnishing</TD>
	<td colspan="3"><Input type="radio" name = "furnished" value="furnished">Furnished
	<input type="radio" name="furnished" value="unfurnished">Un Furnished
	<input type="radio" name="furnished" value="semifurnished">Semi Furnished
	<input type="radio" name="furnished" value="other">Other</td>
	
				 
				
			</tr>
		
	</td>
</tr>
<TR>



	<TD align="left"><FONT  size="2">Description</FONT></TD>
	<TD colspan="3"><textarea size="512" rows="4" cols="53" name="desc"></textarea></TD>
</TR>
<TR>
	<TD height= "5"></TD>
</TR>
<TR>
	<td colspan="4" align="center"><s:submit action="postrequirements" value="Submit"/>
	&nbsp&nbsp&nbsp&nbsp&nbsp
	<s:reset value="Cancel"/></td>
	
</tr>
</table>
</div>
<div id="text_bottom">
<div id="text_bottom_left"></div>
<div id="text_bottom_right"></div>
</div>
</td>
 <td height="450" width="15%">
<%@include file="\rightframe.jsp"%>
</td>
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