<% 
String tn=request.getParameter("trainno");
dbs.Database trd=new dbs.Database("Railway");
trd.connect();
java.sql.ResultSet rs=trd.trainDetails(tn);
while(rs.next()){
%>
<h2>Edit train</h2>
<form method="GET" action="edit">
    <table>
        <tr><td>Train name</td><td><input type="text" name="trainno"value="<%=request.getParameter("trainno")%>" readonly /></td></tr>
        <tr><td>Source</td><td><input type="text" name="Source" value="<%=rs.getString(2)%>" required></td></tr>
        <tr><td>Destination</td><td><input type="text" name="Destination" value="<%=rs.getString(3)%>" required></td></tr>
        <tr><td>Fare</td><td><input type="text" name="Price" value="<%=rs.getString(5)%>" required></td></tr>
        <tr><td>Total Berth</td><td><input type="text" name="tberth" value="<%=rs.getString(4)%>" required></td></tr>
        <tr><td>Running Date</td><td><input type="text" name="date" value="<%=rs.getString(7)%>" required ></td></tr>
        <tr><td></td><td><input type="submit" value="Update"/></td></tr>
    </table>
</form>
        <% }

        trd.close();%>