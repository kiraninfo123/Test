/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2014-04-03 17:07:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.*;

public final class postrequirements_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/leftframelogin.jsp", Long.valueOf(1396544081311L));
    _jspx_dependants.put("/rightframe.jsp", Long.valueOf(1396544081358L));
    _jspx_dependants.put("/Header.jsp", Long.valueOf(1396544081295L));
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1396544081295L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005faction_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005freset_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005faction_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005freset_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005faction.release();
    _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005faction_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005freset_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<table align=\"top\" height=\"70\" width=\"100%\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td height=\"70\" width=\"100%\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title> </title>\r\n");
      out.write("<link href=\"styles.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function clock()\r\n");
      out.write("\t{ \r\n");
      out.write("\tvar dat = new Date();\r\n");
      out.write("\tt = dat.getDate() +\"-\"+ (dat.getMonth()+1) +\"-\"+ dat.getFullYear();\r\n");
      out.write("\tvar hour= dat.getHours();\r\n");
      out.write("\tvar min= dat.getMinutes();\r\n");
      out.write("\tvar sec = dat.getSeconds();\r\n");
      out.write("\tvar temp = \"\" + ((hour > 12) ? hour - 12 :hour) \r\n");
      out.write("\ttemp += ((min < 10) ? \":0\" : \":\") + min\r\n");
      out.write("\ttemp += ((sec < 10) ? \":0\" : \":\") + sec\r\n");
      out.write("\ttemp += (hour >= 12) ? \" PM\" : \" AM\"\r\n");
      out.write("                document.getElementById('clk').innerHTML=t + \" \" + temp;\r\n");
      out.write("//\talert(  document.getElementById('clk').text);\r\n");
      out.write("      \tid = setTimeout(\"clock()\",1000)\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onLoad=\"clock()\">\r\n");
      out.write("<div> \r\n");
      out.write("\t<table id=\"header\" \tcellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td\twidth=\"15%\"><img src=\"images/Logo.jpg\"></td>\r\n");
      out.write("\t\t\t<td class=\"text\" width=\"70%\">Property Management</td>\r\n");
      out.write("\t\t\t<td\twidth=\"15%\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr><td><label id=\"clk\"></label></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td>Call :1-800-000-250</td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td>Welcome  ");
      out.print( session.getAttribute("user") );
      out.write("&nbsp;&nbsp;&nbsp;<a href=\"login.jsp\">Logout<a></td></tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("<table width=\"100%\" bgcolor=\"#083253\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td>\r\n");
      out.write("<table align=\"center\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td align=\"center\">\r\n");
      out.write("\t<div id=\"menu\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li><a href=\"home_mod.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"news.jsp\">News</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"message.jsp\">Messages</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"careers.jsp\">Careers</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"testimonials.jsp\">Testimonials</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"contact.jsp\">Contact Us</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"Alliance.jsp\">Alliances</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"blogs.jsp\">Blogs</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"dashboards.jsp\">Dashboard</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"faqs.jsp\">Faq's</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"aboutus.jsp\">About Us</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table align=\"left\" height=\"500\" width=\"100%\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td  height=\"450\" width=\"15%\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title></title>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<table align=\"center\"  height=\"50\" width=\"35%\">\r\n");
      out.write("\t\r\n");
      out.write("</table>\r\n");
      out.write("<div id=\"sidebar\">\r\n");
      out.write("\t<div id=\"sidebar_top\"></div>\r\n");
      out.write("    <div id=\"sidebar_body\">\r\n");
      out.write("\t<table id=\"button\" height=\"400\" width=\"40\" border=\"0\" align=\"center\">\r\n");
      out.write("\t\t<tr><td class=\"bar\" align=\"center\">Categories</td></tr>\r\n");
      out.write("\t\t<tr><td align=\"center\"><a href=\"advancesearchproperty.jsp\" target=\"middle\" align=\"left\"><font><img src=\"images/search.jpg\" border=\"0\"></font></a></td></tr>\r\n");
      out.write("\t\t<tr><td align=\"center\"><a href=\"postproperty.jsp\"><img src=\"images/postproperty.jpg\" border=\"0\"></a></td></tr>\r\n");
      out.write("\t\t<tr><td align=\"center\"><a href=\"postrequirements.jsp\"><img src=\"images/postrequirements.jpg\" border=\"0\"></a></td></tr>\r\n");
      out.write("\t\t<tr><td align=\"center\"><a href=\"services.jsp\"><img src=\"images/services.jpg\" border=\"0\"></a></td></tr>\r\n");
      out.write("\t\t<tr><td align=\"center\"><a href=\"loan.jsp\"><img src=\"images/loan.jpg\" border=\"0\"></a></td></tr>\r\n");
      out.write("\t\t<tr><td align=\"center\"><a href=\"investors.jsp\"><img src=\"images/investors.jpg\" border=\"0\"></a></td></tr>\r\n");
      out.write("\t\t<tr><td align=\"center\"><a href=\"companyinfo.jsp\"><img src=\"images/companyinfo.jpg\" border=\"0\"></a></td></tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("    <div id=\"sidebar_bottom\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\t\t\t\t\t\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<td height=\"450\" width=\"70%\">\r\n");
      out.write("\r\n");
      if (_jspx_meth_s_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("<table align=\"bottom\" height=\"50\" width=\"100%\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td height=\"50\" width=\"100%\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Footer</title>\r\n");
      out.write("<body>\r\n");
      out.write("<table id=\"footer\" align=\"center\" bgcolor=\"#2D69A8\" width=\"100%\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td align=\"center\">\r\n");
      out.write("\tcopyright &copy; 2011 Real Estate Management</font>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<a href=\"terms.jsp\"  target=\"middle\">Terms & Conditions</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;    \r\n");
      out.write("\t<a href=\"privacy.jsp\"  target=\"middle\">Privacy & Policy</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<a href=\"sitemap.jsp\"  target=\"middle\">Sitemap</a>\r\n");
      out.write(" </td>\r\n");
      out.write(" </tr>\r\n");
      out.write(" <tr><td>\r\n");
      out.write("\t<marquee><font color=\"white\">Welcome to  Property Management Portal:  Call us to Advertise for Property Management & Allied Services</font></marquee>\r\n");
      out.write(" </td></tr>\r\n");
      out.write(" </table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_005fform_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:form
    org.apache.struts2.views.jsp.ui.FormTag _jspx_th_s_005fform_005f0 = (org.apache.struts2.views.jsp.ui.FormTag) _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005faction.get(org.apache.struts2.views.jsp.ui.FormTag.class);
    _jspx_th_s_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fform_005f0.setParent(null);
    // /postrequirements.jsp(21,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setAction("postrequirements");
    // /postrequirements.jsp(21,0) name = theme type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setTheme("simple");
    int _jspx_eval_s_005fform_005f0 = _jspx_th_s_005fform_005f0.doStartTag();
    if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fform_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fform_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("<div id=\"text\">\r\n");
        out.write("<div id=\"text_top\">\r\n");
        out.write("<div id=\"text_top_left\"></div>\r\n");
        out.write("<div id=\"text_top_right\"></div>\r\n");
        out.write("</div>\r\n");
        out.write("<div id=\"text_body\">\r\n");
        out.write("\r\n");
        out.write("<table width=\"100%\" height=\"408\" border=\"0\">\r\n");
        out.write("<tr>\r\n");
        out.write("\t<th colspan=\"4\" align=\"center\" bgcolor=\"black\"><FONT SIZE=\"4\"  COLOR=\"white\"><B>Post Requirments</B></FONT></th>\r\n");
        out.write("</tr>\r\n");
        out.write("<tr>\r\n");
        out.write("\t<td height=\"10\"></td>\r\n");
        out.write("<TR>\r\n");
        out.write("\r\n");
        out.write("\t<TD></TD>\r\n");
        out.write("</TR>\r\n");
        out.write("<tr>\r\n");
        out.write("\t<TD align=\"left\">I want to</TD>\r\n");
        out.write("\t<td colspan=\"3\"><Input type=\"radio\" name = \"propertyfor\" value=\"buy\">Buy\r\n");
        out.write("\t<input type=\"radio\" name=\"propertyfor\"value=\"rent\">Rent\r\n");
        out.write("\t<input type=\"radio\" name=\"propertyfor\"value=\"lease\">Lease</td>\r\n");
        out.write("\t\r\n");
        out.write("</TR>\r\n");
        out.write("<TR>\r\n");
        out.write("\t<TD align=\"left\">Property Type</TD>\r\n");
        out.write("\t<TD><select name =\"Property Type\">\r\n");
        out.write("\t<option>--Select Type--\r\n");
        out.write("\t<option>Residential\r\n");
        out.write("\t<option>Commercial\r\n");
        out.write("\t<option>Agricultural\r\n");
        out.write("\t<option>Industrial\r\n");
        out.write("\t</select></td>\r\n");
        out.write("\t\r\n");
        out.write("</td>\r\n");
        out.write("\t   <TD align=\"left\">Cost Range</TD>\r\n");
        out.write("\t\t\t\r\n");
        out.write("\t<td><select name =\"costrange\">\r\n");
        out.write("\t<option>-- Select Cost --\r\n");
        out.write("\t<option>10 - 20 Lakhs\r\n");
        out.write("\t<option>12 - 15 Lakhs\r\n");
        out.write("\t<option>14 - 16 Lakhs\r\n");
        out.write("\t</select>\r\n");
        out.write("\t</td>\r\n");
        out.write("\t\r\n");
        out.write("\r\n");
        out.write("</TR>\r\n");
        out.write("<TR>\r\n");
        out.write("\t<TD></TD>\r\n");
        out.write("</TR>\r\n");
        out.write("<tr>\r\n");
        out.write("\t<TD align=\"left\">Property Age</TD>\r\n");
        out.write("\t<TD><select name =\"propertyage\">\r\n");
        out.write("\t<option>- - Select Age- -\r\n");
        out.write("\t<option>less than 1\r\n");
        out.write("\t<option>greater 1 & less 5\r\n");
        out.write("\t<option>greater 5 & less 10\r\n");
        out.write("\t<option>greater 10\r\n");
        out.write("\t</select></TD>\r\n");
        out.write("\t<TD align=\"left\">City</TD>\r\n");
        out.write("\t  <TD><select name =\"city\">\r\n");
        out.write("\t<option>--Select City--\r\n");
        out.write("\t<option>Bangalore\r\n");
        out.write("\t<option> Delhi\r\n");
        out.write("\t<option> Mumbai\r\n");
        out.write("\t</select></td>\r\n");
        out.write("\t</tr>\r\n");
        out.write("<TR>\r\n");
        out.write("\t<TD></TD>\r\n");
        out.write("</TR>\r\n");
        out.write("<TR>\r\n");
        out.write("\t\t<td align=\"left\">State</td>\r\n");
        out.write("\t<TD><select name =\"state\">\r\n");
        out.write("\t<option>--Select State--\r\n");
        out.write("\t<option>Karnataka\r\n");
        out.write("\t<option> Delhi\r\n");
        out.write("\t<option> Maharashtra\r\n");
        out.write("\t</select></td>\r\n");
        out.write("\t\r\n");
        out.write("<td>Country</td>\r\n");
        out.write("<td><select name=\"country\">\r\n");
        out.write("<option>-- Select Country --</option>\r\n");
        out.write("<option>India</option>\r\n");
        out.write("</select>\t\r\n");
        out.write("</td>\r\n");
        out.write("</TR>\r\n");
        out.write("<TR>\r\n");
        out.write("\t<TD></TD>\r\n");
        out.write("</TR>\r\n");
        out.write("<TR></TR>\r\n");
        out.write("<TR>\r\n");
        out.write("\t<TD></TD>\r\n");
        out.write("</TR>\r\n");
        out.write("<tr>\r\n");
        out.write("\t <TD align=\"left\">No of Rooms</td>\r\n");
        out.write("\t <td><select name =\"noofrooms\">\r\n");
        out.write("\t<option>3\r\n");
        out.write("\t<option>4\r\n");
        out.write("\t<option>5\r\n");
        out.write("\t</select>Bed Rooms\r\n");
        out.write("\t<select name =\"noofbedrooms\">\r\n");
        out.write("\t<option>1\r\n");
        out.write("\t<option>2\r\n");
        out.write("\t<option>3\r\n");
        out.write("\t</select></TD> \r\n");
        out.write("\t<TD align=\"left\">Builiding/Land Area</TD>\r\n");
        out.write("\t<TD><select name =\"sqft\">\r\n");
        out.write("\t<option>-- Select Area --\r\n");
        out.write("\t<option>1000 sqft\r\n");
        out.write("\t<option>1500 sqft\r\n");
        out.write("\t<option>2000 sqft\r\n");
        out.write("\t<option>2500 sqft\r\n");
        out.write("\t<option>3000 sqft\r\n");
        out.write("\t</select>\r\n");
        out.write("\t</td>\r\n");
        out.write("\r\n");
        out.write("\t \r\n");
        out.write("</tr>\r\n");
        out.write("<tr>\t\r\n");
        out.write("</tr>\r\n");
        out.write("<TR>\r\n");
        out.write("<TD align=\"left\">Person Name</TD>\r\n");
        out.write("\t<TD><INPUT TYPE=\"text\" NAME=\"name\" value=\"\" size=\"20\" maxlength=\"20\"></TD>\r\n");
        out.write("\t \r\n");
        out.write("\t<td align=\"left\">Persons Address</td>\r\n");
        out.write("\t<td> <input type=\"text\" name=\"add2\" value=\"\" size=\"20\" maxlength=\"70\"/></td>\r\n");
        out.write("\r\n");
        out.write("\t</TR>\r\n");
        out.write("<TR>\r\n");
        out.write("\t<TD></TD>\r\n");
        out.write("</TR>\r\n");
        out.write("<TR>\r\n");
        out.write("<TD align=\"left\">Email ID</TD>\r\n");
        out.write("\t   <TD><INPUT TYPE=\"text\" NAME=\"emailid\" value=\"\" size=\"18\" maxlength=\"20\"></TD>\r\n");
        out.write("\r\n");
        out.write("\t<TD align=\"left\">Contact Number</TD>\r\n");
        out.write("\t<TD><INPUT TYPE=\"text\" NAME=\"contact\" value=\"\" size=\"20\" maxlength=\"20\"></TD>\r\n");
        out.write("\t</tr>\r\n");
        out.write("\t<tr>\r\n");
        out.write("\t<td height=\"2\"/>\r\n");
        out.write("\t</tr>\r\n");
        out.write("<tr>\r\n");
        out.write("\t<TD align=\"left\">Amenities</TD>\r\n");
        out.write("\t<TD><select name =\"amenities\">\r\n");
        out.write("\t<option> ------ Select Amenities ------</option>\r\n");
        out.write("\t<option>Park</option>\r\n");
        out.write("\t<option>Gym</option>\r\n");
        out.write("\t<option>Swimming Pool</option>\r\n");
        out.write("\t<option>Car Parking</option>\r\n");
        out.write("\t<option>Swimming Pool+Park</option>\r\n");
        out.write("\t<option>Gym+Park</option>\r\n");
        out.write("\t<option>Swimming Pool+Gym</option>\r\n");
        out.write("\t<option>Car Parking+Park</option>\r\n");
        out.write("\t<option>Car Parking+Gym</option>\r\n");
        out.write("\t<option>Car Parking+Swimming Pool</option>\r\n");
        out.write("\t<option>Swimming Pool+Gym+Park</option>\r\n");
        out.write("\t<option>Car Parking+Gym+Park</option>\r\n");
        out.write("\t<option>Car Parking+Swimming Pool+Park</option>\r\n");
        out.write("\t<option>Car Parking+Swimming Pool+Park+Gym</option>\r\n");
        out.write("\t</td>\r\n");
        out.write("\t</tr>\r\n");
        out.write("\t<tr>\r\n");
        out.write("\r\n");
        out.write("<TD align=\"left\">Landmarks</TD>\r\n");
        out.write("\t<TD><select name =\"landmark\">\r\n");
        out.write("\t<option> ------ Select Landmark ------</option>\r\n");
        out.write("\t<option>School</option>\r\n");
        out.write("\t<option>Hospital</option>\r\n");
        out.write("\t<option>Railway Station</option>\r\n");
        out.write("\t<option>Bus Stand</option>\r\n");
        out.write("\t<option>School+Hospital</option>\r\n");
        out.write("\t<option>School+Railway Station</option>\r\n");
        out.write("\t<option>School+Bus Stand</option>\r\n");
        out.write("\t<option>Hospital+Railway Station</option>\r\n");
        out.write("\t<option>Hospital+Bus Stand</option>\r\n");
        out.write("\t<option>Railway Station+Bus Stand</option>\r\n");
        out.write("\t<option>School+Hospital+Railway Station</option>\r\n");
        out.write("\t<option>School+Railway Station+Bus Stand</option>\r\n");
        out.write("\t<option>School+Hospital+Bus Stand</option>\r\n");
        out.write("\t<option>Hospital+Railway Station+Bus Stand</option>\r\n");
        out.write("\t<option>School+Hospital+Railway Station+Bus Stand</option>\r\n");
        out.write("\t</td>\r\n");
        out.write("\t\t\r\n");
        out.write("</TR>\r\n");
        out.write("<tr>\r\n");
        out.write("<td height=\"2\"/>\r\n");
        out.write("</tr>\r\n");
        out.write("<tr>\r\n");
        out.write("\t<TD align=\"left\">Furnishing</TD>\r\n");
        out.write("\t<td colspan=\"3\"><Input type=\"radio\" name = \"furnished\" value=\"furnished\">Furnished\r\n");
        out.write("\t<input type=\"radio\" name=\"furnished\" value=\"unfurnished\">Un Furnished\r\n");
        out.write("\t<input type=\"radio\" name=\"furnished\" value=\"semifurnished\">Semi Furnished\r\n");
        out.write("\t<input type=\"radio\" name=\"furnished\" value=\"other\">Other</td>\r\n");
        out.write("\t\r\n");
        out.write("\t\t\t\t \r\n");
        out.write("\t\t\t\t\r\n");
        out.write("\t\t\t</tr>\r\n");
        out.write("\t\t\r\n");
        out.write("\t</td>\r\n");
        out.write("</tr>\r\n");
        out.write("<TR>\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("\t<TD align=\"left\"><FONT  size=\"2\">Description</FONT></TD>\r\n");
        out.write("\t<TD colspan=\"3\"><textarea size=\"512\" rows=\"4\" cols=\"53\" name=\"desc\"></textarea></TD>\r\n");
        out.write("</TR>\r\n");
        out.write("<TR>\r\n");
        out.write("\t<TD height= \"5\"></TD>\r\n");
        out.write("</TR>\r\n");
        out.write("<TR>\r\n");
        out.write("\t<td colspan=\"4\" align=\"center\">");
        if (_jspx_meth_s_005fsubmit_005f0(_jspx_th_s_005fform_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t&nbsp&nbsp&nbsp&nbsp&nbsp\r\n");
        out.write("\t");
        if (_jspx_meth_s_005freset_005f0(_jspx_th_s_005fform_005f0, _jspx_page_context))
          return true;
        out.write("</td>\r\n");
        out.write("\t\r\n");
        out.write("</tr>\r\n");
        out.write("</table>\r\n");
        out.write("</div>\r\n");
        out.write("<div id=\"text_bottom\">\r\n");
        out.write("<div id=\"text_bottom_left\"></div>\r\n");
        out.write("<div id=\"text_bottom_right\"></div>\r\n");
        out.write("</div>\r\n");
        out.write("</td>\r\n");
        out.write(" <td height=\"450\" width=\"15%\">\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("<html>\r\n");
        out.write("<head>\r\n");
        out.write("<title></title>\r\n");
        out.write("<script language=\"javascript\">\r\n");
        out.write("function check(form,str)\r\n");
        out.write("{\r\n");
        out.write("jsvalue=str;\r\n");
        out.write("\r\n");
        out.write("alert(str);\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("filename=  str +\".jsp\";\r\n");
        out.write("document.getElementById(\"hiddenvar\").value = str;\r\n");
        out.write("form.method='post';\r\n");
        out.write("form.action= \"com.collaba.management.action.allied\";\r\n");
        out.write("form.submit();\r\n");
        out.write("\r\n");
        out.write("//alert(filename);\r\n");
        out.write("\r\n");
        out.write("//parent.content.location.href=filename;\r\n");
        out.write("\r\n");
        out.write("}\r\n");
        out.write("</script>\r\n");
        out.write("</head>\r\n");
        out.write("<body>\r\n");
        if (_jspx_meth_s_005fform_005f1(_jspx_th_s_005fform_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("</td>\r\n");
        out.write("</tr>\r\n");
        out.write("</body>\r\n");
        out.write("</html>");
        out.write("\r\n");
        out.write("</td>\r\n");
        int evalDoAfterBody = _jspx_th_s_005fform_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005faction.reuse(_jspx_th_s_005fform_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005faction.reuse(_jspx_th_s_005fform_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fsubmit_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:submit
    org.apache.struts2.views.jsp.ui.SubmitTag _jspx_th_s_005fsubmit_005f0 = (org.apache.struts2.views.jsp.ui.SubmitTag) _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005faction_005fnobody.get(org.apache.struts2.views.jsp.ui.SubmitTag.class);
    _jspx_th_s_005fsubmit_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fsubmit_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
    // /postrequirements.jsp(233,32) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fsubmit_005f0.setAction("postrequirements");
    // /postrequirements.jsp(233,32) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fsubmit_005f0.setValue("Submit");
    int _jspx_eval_s_005fsubmit_005f0 = _jspx_th_s_005fsubmit_005f0.doStartTag();
    if (_jspx_th_s_005fsubmit_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005faction_005fnobody.reuse(_jspx_th_s_005fsubmit_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005faction_005fnobody.reuse(_jspx_th_s_005fsubmit_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005freset_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:reset
    org.apache.struts2.views.jsp.ui.ResetTag _jspx_th_s_005freset_005f0 = (org.apache.struts2.views.jsp.ui.ResetTag) _005fjspx_005ftagPool_005fs_005freset_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.ui.ResetTag.class);
    _jspx_th_s_005freset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005freset_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
    // /postrequirements.jsp(235,1) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005freset_005f0.setValue("Cancel");
    int _jspx_eval_s_005freset_005f0 = _jspx_th_s_005freset_005f0.doStartTag();
    if (_jspx_th_s_005freset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005freset_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005freset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005freset_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005freset_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fform_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:form
    org.apache.struts2.views.jsp.ui.FormTag _jspx_th_s_005fform_005f1 = (org.apache.struts2.views.jsp.ui.FormTag) _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005faction.get(org.apache.struts2.views.jsp.ui.FormTag.class);
    _jspx_th_s_005fform_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fform_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
    // /rightframe.jsp(29,0) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f1.setAction("woeiwoew131");
    // /rightframe.jsp(29,0) name = theme type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f1.setTheme("simple");
    int _jspx_eval_s_005fform_005f1 = _jspx_th_s_005fform_005f1.doStartTag();
    if (_jspx_eval_s_005fform_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fform_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fform_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fform_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("<table width=\"15%\" height=\"60\" bgcolor=\"\" border=\"0\">\r\n");
        out.write("<tr><td height=\"10\"></td></tr>\r\n");
        out.write("<tr>\r\n");
        out.write("<th>Select Allied Service</th></tr>\r\n");
        out.write("<tr><td height=\"2\"></td></tr>\r\n");
        out.write("<tr>\r\n");
        out.write("\t<td><select name=\"alliedservices\">\r\n");
        out.write("\t\t<option>--- Select Service ---\r\n");
        out.write("\t\t<option>Architects\r\n");
        out.write("\t\t<option>Vaastu Consultants\r\n");
        out.write("\t\t<option >Builders & Developers\r\n");
        out.write("\t\t<option>Building Contractors\r\n");
        out.write("\t\t<option>Building Material\r\n");
        out.write("\t<!--\t<option>Civil Contractors\r\n");
        out.write("\t\t<option>Demolition Contractor\r\n");
        out.write("\t\t<option>Electrical Contractors\r\n");
        out.write("\t\t<option>Ceiling Contractors\r\n");
        out.write("\t\t<option>Plumbing Contractors\r\n");
        out.write("\t\t<option>Aluminium Fabricators\r\n");
        out.write("\t\t<option>Landscape Contractors\r\n");
        out.write("\t\t<option>Masonry Contractors\r\n");
        out.write("\t\t<option>Painting Contractor\r\n");
        out.write("\t\t<option>Pest Control Contractor\r\n");
        out.write("\t\t<option>Plastering Contractors\r\n");
        out.write("\t\t<option>Corpentary Work\r\n");
        out.write("\t\t<option>Borewells or  Diviners\r\n");
        out.write("\t\t<option>Soil Mechanics \r\n");
        out.write("\t\t<option>Environment Consultant   -->\r\n");
        out.write("\t\t</select>\r\n");
        out.write("\t</td>\r\n");
        out.write("</tr>\r\n");
        out.write("<tr><td>");
        if (_jspx_meth_s_005fsubmit_005f1(_jspx_th_s_005fform_005f1, _jspx_page_context))
          return true;
        out.write(" </td></tr>\r\n");
        out.write("\r\n");
        out.write("<tr height=\"300\"><td align=\"center\"><marquee direction=\"up\"><img src=\"images/f1.jpg\"> <img src=\"images/f2.jpg\"> <img src=\"images/f3.jpg\">\r\n");
        out.write("<img src=\"images/f4.jpg\"> <img src=\"images/f5.jpg\"> <img src=\"images/f6.jpg\"></marquee></td>\r\n");
        out.write("</tr>\r\n");
        out.write("</table>\r\n");
        out.write("\r\n");
        out.write("\r\n");
        int evalDoAfterBody = _jspx_th_s_005fform_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fform_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fform_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005faction.reuse(_jspx_th_s_005fform_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005faction.reuse(_jspx_th_s_005fform_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005fsubmit_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:submit
    org.apache.struts2.views.jsp.ui.SubmitTag _jspx_th_s_005fsubmit_005f1 = (org.apache.struts2.views.jsp.ui.SubmitTag) _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005faction_005fnobody.get(org.apache.struts2.views.jsp.ui.SubmitTag.class);
    _jspx_th_s_005fsubmit_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fsubmit_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f1);
    // /rightframe.jsp(63,8) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fsubmit_005f1.setAction("allied");
    // /rightframe.jsp(63,8) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fsubmit_005f1.setValue("View");
    int _jspx_eval_s_005fsubmit_005f1 = _jspx_th_s_005fsubmit_005f1.doStartTag();
    if (_jspx_th_s_005fsubmit_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005faction_005fnobody.reuse(_jspx_th_s_005fsubmit_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005faction_005fnobody.reuse(_jspx_th_s_005fsubmit_005f1);
    return false;
  }
}
