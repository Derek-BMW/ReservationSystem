<%-- 
    Document   : reserve
    Created on : 7 Jul, 2012, 10:50:45 AM
    Author     : Kshitij
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rail Reservation Service:Reservation</title>
        <link rel="icon" type="image/gif" href="images/animated_favicon1.gif">
    </head>
    <body style="PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; PADDING-TOP: 0px" onload="image(0)">
        
 <table width=100% >
            <tr><td colspan="2" ><%@include file="header.html" %></td></tr>
            <tr><td><br/>
                    <%@include file="WEB-INF/jspf/sidebar.jspf" %>
             </td><td>
             <div align="left">
        <%@include file="WEB-INF/jspf/reservation.jspf" %>
        </div>
    </td></tr></table>
    </body>
</html>
