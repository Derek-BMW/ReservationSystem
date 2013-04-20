<%--
    Document   : profile
    Created on : 10 Jul, 2012, 11:33:18 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rail Reservation Service:Administrator</title>
        <link rel="icon" type="image/gif" href="images/animated_favicon1.gif">
    </head>
    <body style="PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; PADDING-TOP: 0px" onload="image(0)">
        <table width=100% >
            <tr><td colspan="2" ><%@include file="header.html" %></td></tr>
            <tr><td bgcolor="ffffff"width=140px>
                    <% if(session.getAttribute("AID")!=null){ %>
                    <a href="Admin.jsp">Admin Control Panel</a>
                    <% } %>
             </td><td>
             <div align="center">
            <%@include file="WEB-INF/jspf/admin.jspf" %>
             <%} else {
            out.println("<h2>Welcome:<font color=blue>"+session.getAttribute("AID")+"</font></h2>");

        %>

        
        <table>
            <tr><td><img src="images/list.jpg" width="64" height="64" alt="Trains List" /></td><td><a href="viewtrain.jsp" style="text-decoration:none">View trains</a></td></tr>
            <tr><td><img src="images/edit.png" width="64" height="64"  alt="Add Trains"/></td><td><a href="addtrain.jsp" style="text-decoration:none">Add train</a></td></tr>
            <tr><td><img src="images/Users.png" width="64" height="64" alt="Users List"/></td><td><a href="users.jsp" style="text-decoration:none">View users list</a></td></tr>

            <tr><td><form method="get" action="Admin.jsp?log=logout">
            <input type="Submit" value="Logout" name="log"/>
            </form></td></tr>
        </table
       
            <%}%>
        </div>
    </td></tr></table>
    </body>
</html>
