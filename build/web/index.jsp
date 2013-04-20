<%-- 
    Document   : index
    Created on : 29 Jun, 2012, 1:01:37 PM
    Author     : Kshitij
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rail Reservation Service </title>
        <link rel="icon" type="image/gif" href="images/animated_favicon1.gif">
    </head>
    <body  style="PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; PADDING-TOP: 0px" onload="image(0)">
        <table width=100% border="0" >
            <tr><td colspan="2"><%@include file="header.html" %></td></tr>
            <tr><td bgcolor="ffffff"width=140px><br/>
                    <%@include file="WEB-INF/jspf/sidebar.jspf" %>
             </td><td>
             <div align="center">
            <%@include file="WEB-INF/jspf/login.jspf" %>
        <%} else {
            out.println("<h2>Welcome:<font color=blue>"+session.getAttribute("SID")+"</font></h2>");

        %>

            <%}%>
        </div>
    </td></tr>
            </table>
    </body>
</html>
