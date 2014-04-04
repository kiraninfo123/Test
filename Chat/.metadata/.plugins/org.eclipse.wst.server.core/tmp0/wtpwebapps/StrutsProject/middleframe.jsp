<%@ page language="java" pageEncoding="iso-8859-1" import="javax.servlet.*"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<html>
<body>

<table width="70%" height="290" border="0">
<tr>
	<td width="60%" valign="top">
	<s:form theme="simple" action="quicksearch">
		<table width = "100%">
			<tr>
				<th colspan= "2" align="left"><b><center>&nbsp Quick Search</center></b></th>
			</tr>	
			<tr>
				<td>Property For
				</td>
				<td>	<Input type="radio" name = "propertyfor" value="buy">Buy
					<input type="radio" name="propertyfor"value="rent">Rent
					<input type="radio" name="propertyfor"value="lease">Lease
				</td>
			</tr>
			<tr>
				<td>Property Type</FONT>
				</td>
				<td><select name ="Property Type">
					<option>--Select Type--
					<option>Residential
					<option>commercial
					<option>agricultural
					<option>Industrial
				</td>
			</tr>
			<tr>
				<td>Location
				</td>
				<td><select name ="Location">
					<option>--Select Location--
					<option>Bangalore
					<option> Delhi
					<option> Mumbai
				</td>
			</tr>
			<tr>
				
				<TD align="left">Cost Range</TD>
			
	<td><select name ="costrange">
	<option>10 - 20 Lakhs
	<option>12 - 15 Lakhs
	<option>14 - 16 Lakhs
	</select></td>
			</tr>
			<tr>
				<td>
				</td>
				<td align="center"><a href="advancesearchproperty.jsp">Advance Search</font></a>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td><s:submit TYPE="button" name="quicksearch" value="Search"/></td>
			</tr>
		</table>
		</s:form>
</td>
<td valign="top" >
<table width="210%" id="w">
			<tr width="100%">
				<th colspan="4" align="left"><center>&nbsp HighLights</center></th>
			</tr>	
			
			<tr>
				<td align="center"><a href="toprealestate.jsp" target="middle">Top Real Estate  </a>
				</td>
				<td align="center"><a href="hotproperties.jsp" target="middle">Hot Properties</a>
				</td>
			</tr>
			<tr>
				<td align="center"><a href="newproperties.jsp" target="middle">New Properties</a>
				</td>	
				<td align="center"><a href="dealers.jsp" target="middle">Dealers in Focus</a>
				</td>
			</tr>
			<tr>
				<td align="center"><a href="exhibition.jsp" target="middle">Events & Exhibitions</a>
				</td>
				<td align="center"><a href="futureprojects.jsp" target="middle">Future Projects</a>
				</td>
			</tr>
			
			<tr>
				<td>&nbsp</td>
				<td></td>
			</tr>
			<tr>
				<td>&nbsp</td>
				<td></td>	
			</tr>
			<tr>
				<td>&nbsp</td>	
				<td></td>
			</tr>

		</table>
</td>
</tr>
</table>
<table width="100%" height=" 200" border=0>
<tr height="20">
	<th align="left" width="32%" bgcolor="black"><b><font color="white"><center>&nbsp Gallary</center></font></b></th>
</tr>
<tr>
	<td><marquee><img src="images/f3.jpg">&nbsp <img src="images/f2.jpg">&nbsp <img src="images/f1.jpg">&nbsp <img src="images/f4.jpg"></marquee></td>
</tr>
</table>
</body>
</html>		