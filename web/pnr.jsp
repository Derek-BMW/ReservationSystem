<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rail Reservation Service:Check Availability </title>
        <link rel="icon" type="image/gif" href="images/animated_favicon1.gif">
    </head>
    <body style="PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; PADDING-TOP: 0px" onload="image(0)">
        <table width=100% >
            <tr><td colspan="2" ><%@include file="header.html" %></td></tr>
            <tr><td bgcolor="ffffff"width=15%>
                    <%@include file="WEB-INF/jspf/sidebar.jspf" %>
             </td><td>
             <div align="center">
                 <h2>Check PNR Status</h2>
                 <%
                 if(request.getParameter("pnrno")!=null)
                 {
                     dbs.Database pnr=new dbs.Database("Railway");
                 pnr.connect();
                 java.sql.ResultSet rs=pnr.pnrStatus(request.getParameter("pnrno"));
                 if(rs!=null){
                     if(rs.next()){
                         %>
                         <table>
    <tr><th>Train Number</th><th>Passenger Name</th><th>Source</th><th>Destination</th><th>Journey Date</th><th>PNR Number</th><th>Berth Number</th></tr>
    <tr><td><%=rs.getString(2)%></td><td><%=rs.getString(10) %></td><td><%=rs.getString(3)%></td><td><%=rs.getString(4)%></td><td><%=rs.getString(8)%></td><td><%=rs.getString(9)%></td><td><%=rs.getString(5)%></td></tr>
                         </table>
                 <%
                     }
                 }
                 else{out.println("<font color=red>PNR Number not found in the database</font>");
                 response.setHeader("Refresh","1;URL=pnr.jsp");
                 }
                 pnr.close();}
else {
    %>
    <table><form action="pnr.jsp" method="get">
            <tr><td>PNR Number:</td><td><input type="text" name="pnrno" required/></td></tr>
            <tr><td><input type="submit" value="Get Status"/></td></tr>
        </form></table>
    <% } %>
        </div>
    </td></tr></table>
    </body>
</html>