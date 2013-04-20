package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/header.html");
    _jspx_dependants.add("/WEB-INF/jspf/sidebar.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/login.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Rail Reservation Service </title>\n");
      out.write("        <link rel=\"icon\" type=\"image/gif\" href=\"images/animated_favicon1.gif\">\n");
      out.write("    </head>\n");
      out.write("    <body  style=\"PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; PADDING-TOP: 0px\" onload=\"image(0)\">\n");
      out.write("        <table width=100% border=\"0\" >\n");
      out.write("            <tr><td colspan=\"2\">");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function image(i){\n");
      out.write("             i=(i+1)%8;\n");
      out.write("            document.getElementById(\"slideshow\").src=\"images/\"+i+\".jpg\";\n");
      out.write("            var funt=\"image(\"+i+\")\";\n");
      out.write("            setTimeout(funt,3000);\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("<div style=\"height:142px; background-color:#cccccc\"  >\n");
      out.write("        <div >\n");
      out.write("            <div style=\"PADDING-LEFT: 10px; FLOAT: left; PADDING-TOP: 0px\">\n");
      out.write("                <a href=\"index.jsp\"><img style=\"border:none\" src=\"images/trainlogo.png\" width=\"206\" height=\"142\"  /></a>\n");
      out.write("            </div>\n");
      out.write("            <div style=\"PADDING-LEFT:30px; FLOAT:left; padding-top:0px\">\n");
      out.write("                <img style=\"border:none\" src=\"images/logo.png\"  alt=\"Site Name\" height=\"100\"/>\n");
      out.write("            </div>\n");
      out.write("            <div style=\"padding-right:0px; FLOAT:right; padding-top:0px\" >\n");
      out.write("                <img style=\"border:none\" id=\"slideshow\" src=\"images/0.jpg\" width=\"256\" height=\"142\"/>\n");
      out.write("            </div>\n");
      out.write("            <div style=\"Padding-top:100px\">\n");
      out.write("            <ul style=\"text-align: left;margin: auto;width:1200px\">\n");
      out.write("\t\t<li style=\"display: inline;padding: 0px;margin: 0px;\"><a href=\"index.jsp\"><img style=\"border:none\" src=\"images/home.png\" alt=\"home\" /></a></li>\n");
      out.write("                <li style=\"display: inline;padding: 0px;margin: 0px;\"><a href=\"\"><img style=\"border:none\" src=\"images/about.png\" alt=\"about\" /></a></li>\n");
      out.write("                <li style=\"display: inline;padding: 0px;margin: 0px;\"><a href=\"\"><img style=\"border:none\" src=\"images/contact.png\" alt=\"contact\" /></a></li>\n");
      out.write("            </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("<marquee border=\"1\" behavior=\"scroll\" direction=\"left\" ><font color=\"red\">Please logout before closing the window... Please check your booked ticket history incase of failed transactions...</font><font color=\"blue\"> Thank you for using our Online Reservation service..</font></marquee>");
      out.write("</td></tr>\n");
      out.write("            <tr><td bgcolor=\"ffffff\"width=140px><br/>\n");
      out.write("                    ");
      out.write("<a href=\"pnr.jsp\" style=\"text-decoration:none\" visited:color=\"#FF0000\">PNR Status</a><br/>\n");
      out.write("<a href=\"Admin.jsp\">Admin</a><br/>\n");
      out.write("\n");
      out.write("        ");
         if(request.getParameter("log")!=null){
            session.setAttribute("SID", null);
            response.sendRedirect("index.jsp");
            }
            else { if(session.getAttribute("SID")!=null) {
      out.write("\n");
      out.write("\n");
      out.write("            <a href=\"Avail.jsp\" style=\"text-decoration:none\" visited:color=\"#FF0000\">Check Availability</a><br/>\n");
      out.write("            <a href=\"bookhistory.jsp\" style=\"text-decoration:none\">Booking History</a><br/>\n");
      out.write("            <a href=\"profile.jsp\" style=\"text-decoration:none\">Profile</a><br/>\n");
      out.write("            <form method=\"get\" action=\"index.jsp?log=logout\">\n");
      out.write("            <input type=\"Submit\" value=\"Logout\" name=\"log\"/>\n");
      out.write("            </form>\n");
      out.write("                ");
 } } 
      out.write('\n');
      out.write("\n");
      out.write("             </td><td>\n");
      out.write("             <div align=\"center\">\n");
      out.write("            ");
      out.write('\n');
      out.write('\n');

if(request.getParameter("username")!=null){
    dbs.Database login=new dbs.Database("railway");
    if(!login.connect())
        out.println("Error!Could not Connect to the Database");
        //out.println(login.logincheck(request.getParameter("username"),request.getParameter("password")));
        //out.println("Username"+request.getParameter("username")+"Password"+request.getParameter("password"));
   if(!login.logincheck(request.getParameter("username"),request.getParameter("password"))){
        login.close();
        out.println("<font color=\"RED\">Invalid User Name or Password</font>");
        response.setHeader("Refresh","5;URL=index.jsp");
        }
    else{
        session.setAttribute("SID",request.getParameter("username"));
        out.println("<font color=\"green\">Login Successful<br/>Please wait while we redirect you!!</font>");
        response.setHeader("Refresh","3;URL=index.jsp");
        }
}
else if(session.getAttribute("SID")==null)
/*{
out.println("<h1>"+session.getAttribute("SID")+"</h1>");
}
else*/
{ 
      out.write("\n");
      out.write("<h1>Please Login to continue!</h1>\n");
      out.write("\n");
      out.write("            <form method=\"post\" action=\"index.jsp\">\n");
      out.write("                <table>\n");
      out.write("\n");
      out.write("                    <tr><td>Username:</td><td><input type=\"number\" name=\"username\" placeholder=\"Username\" title=\"Username\" required /></td></tr>\n");
      out.write("                    <tr><td>Password:</td><td><input type=\"password\" name=\"password\" placeholder=\"Password\" title=\"Password\" required /></td></tr>\n");
      out.write("                    <tr><td><input type=\"reset\"/></td><td  align=right><input type=\"image\" src=\"images/login.jpg\"  value=\"Login\" title=\"Log In\"/></td></tr>\n");
      out.write("                    <tr><td colspan=\"2\" align=\"center\"> <a href=\"register.jsp\" title=\"Register\" ><img title=\"Register for new account\" src=\"images/register.jpg\" alt=\"Register\"/></a></td></tr>\n");
      out.write("                </table>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");
} else {
            out.println("<h2>Welcome:<font color=blue>"+session.getAttribute("SID")+"</font></h2>");

        
      out.write("\n");
      out.write("\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </td></tr>\n");
      out.write("            </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
