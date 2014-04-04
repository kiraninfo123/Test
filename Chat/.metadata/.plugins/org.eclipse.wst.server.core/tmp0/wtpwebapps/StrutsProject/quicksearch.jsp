<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.collaba.management.vo.PropertyVO"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Iterator"%>
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
<s:form theme="simple" action="fheufhef">
<%

Collection propertylist=(Collection)session.getAttribute("quicksearch");

System.out.println("SIZE OF TIMETABLELIST"+propertylist.size());

Iterator iterT=propertylist.iterator();

PropertyVO voT=null;

%>
<%
while(iterT.hasNext())
{
	
       voT=(PropertyVO)iterT.next();

%>
<%String amenities=voT.getAmenities();
String amenityid=null;
String landmarkid=null;
if(amenities.equals("1"))
			amenityid="Park";
		else if(amenities.equals("2"))
			amenityid="Gym";
		else if(amenities.equals("3"))
			amenityid="Swimming Pool";
		else if(amenities.equals("4"))
			amenityid="Car Parking";
		else if(amenities.equals("5"))
			amenityid="Swimming Pool,Park";
		else if(amenities.equals("6"))
			amenityid="Gym+Park";
		else if(amenities.equals("7"))
			amenityid="Swimming Pool+Gym";
		else if(amenities.equals("8"))
			amenityid="Car parking,Park";
		else if(amenities.equals("9"))
			amenityid="Car Parking,Gym";
		else if(amenities.equals("10"))
			amenityid="Car Parking,Swimming Pool";
		else if(amenities.equals("11"))
			amenityid="Swimming Pool,Gym,Park";
		else if(amenities.equals("12"))
			amenityid="Car Parking,Gym,Park";
		else if(amenities.equals("13"))
			amenityid="Car Parking,Swimming Pool,Park";
		else if(amenities.equals("14"))
			amenityid="Car Parking+Swimming Pool+Park+Gym";
		System.out.println(amenityid);
		
		voT.setAmenities(amenityid);
		String landmark=voT.getLandmark();
		
		if(landmark.equals("1"))
			landmarkid="School";
		else if(landmark.equals("2"))
			landmarkid="Hospital";
		else if(landmark.equals("3"))
			landmarkid="Railway Station";
		else if(landmark.equals("4"))
			landmarkid="Bus Stand";
		else if(landmark.equals("5"))
			landmarkid="School,Hospital";
		else if(landmark.equals("6"))
			landmarkid="School,Railway Station";
		else if(landmark.equals("7"))
			landmarkid="School,Bus Stand";
		else if(landmark.equals("8"))
			landmarkid="Hospital,Railway Station";
		else if(landmark.equals("9"))
			landmarkid="Hospital,Bus Stand";
		else if(landmark.equals("10"))
			landmarkid="Railway Station,Bus Stand";
		else if(landmark.equals("11"))
			landmarkid="School,Hospital,Railway Station";
		else if(landmark.equals("12"))
			landmarkid="School,Railway Station,Bus Stand";
		else if(landmark.equals("13"))
			landmarkid="School,Hospital,Bus Stand";
		else if(landmark.equals("14"))
			landmarkid="Hospital,Railway Station,Bus Stand";
		else if(landmark.equals("15"))
			landmarkid="School,Hospital,Railway Station,Bus Stand";
		else
		{}
		voT.setLandmark(landmarkid);
		
		String propertytypeid=null;
		String property=voT.getPropertytype();
		if(property.equals("1"))
			propertytypeid="Residential";
		else if(property.equals("2"))
			propertytypeid="Commercial";
		else if(property.equals("3"))
			propertytypeid="Agricultural";
		else if(property.equals("4"))
			propertytypeid="Industrial";
		else
		{}
		voT.setPropertytype(propertytypeid);
%>


<table align="center" height="200" width="100%">

<tr height="10%">
	<th align="left"><font size="4" color="white"><b><u>Properties in <%=voT.getCity()%></u></b><font></th>
</tr>
<tr>
<td>
Select here  <input type="radio" name="propid" value="<%=voT.getId() %>"><%=voT.getId() %>
</td>
</tr>
<tr bgcolor="#EEEEE5" height="20">
	<td><font size="3" color="black">
	Property address is <%=voT.getAdd1()%> having plot number <%=voT.getPlotno()%>, and area is <%=voT.getSqft()%> sqft. Property age is <%=voT.getPropertyage()%> years and property type is <%=voT.getPropertytype()%>.
	 Landmarks are : <%=voT.getLandmark()%> , Amenities :<%=voT.getAmenities()%> and property is <%=voT.getFurnishing()%>. Number of bedrooms <%=voT.getBedrooms()%>
	,number of rooms are and  <%=voT.getRooms()%>. Cost of this property is <%=voT.getCostrange()%>.
	The name of the person who handle this property is <%=voT.getName()%>, his contact number is <%=voT.getContact()%>,emial id is <%=voT.getEmailid()%> and address is <%=voT.getAdd2()%>.
	</font></td>
</tr>


<%}%>
</table>
<s:submit action="deleteproperty" value="Delete"/>
<s:submit action="updateproperty" value="Update"></s:submit>
</s:form>
<table align="bottom" height="50" width="100%">
<tr>
<td height="50" width="100%">
<%@include file="\footer.jsp"%>
</td>
</tr>
</table>
</body>
</html>
