/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs;

import java.sql.*;
/**
 *
 * @author Kshitij
 */
public class Database {
    private Connection con=null;
    private String username="root";
    private String password="admin";
    private String url="jdbc:mysql://localhost:3309/";
    String driver="com.mysql.jdbc.Driver";
    public Database(String a){
        url=url+a;
    }
    public ResultSet trainDetails(String trainno){
        ResultSet rs=null;
        try{
            PreparedStatement stmt=con.prepareStatement("select * from train where TrainNo=?");
            stmt.setString(1,trainno);
            rs=stmt.executeQuery();
            return rs;
        }
        catch(Exception e){
            
        }
        return rs;
    }
    public boolean editTrain(String trainno,String Source,String Destination,String date,String tberth,String avail,String price){
        try{
            PreparedStatement edit=con.prepareStatement("update train set Source=?, Destination=?,date=?, TotalBerth=?,Available=?, Price=? where TrainNo=?");
            edit.setString(1, Source);
            edit.setString(2, Destination);
            edit.setString(3, date);
            edit.setString(4, tberth);
            edit.setString(5, avail);
            edit.setString(6, price);
            edit.setString(7, trainno);
            int i=edit.executeUpdate();
            if(i>=1) return true;
        }
        catch(Exception e){

        }
        return false;
    }
    public void deleteTrain(String trainno){
        try{
            PreparedStatement del=con.prepareStatement("DELETE FROM train where TrainNo=?");
            PreparedStatement dt=con.prepareStatement("Delete from reservation where TrainNo=?");
            dt.setString(1,trainno);
            dt.executeUpdate();
            del.setString(1,trainno);
            del.executeUpdate();
        }
        catch(Exception e){

        }
    }
    public ResultSet getTrains(){
        ResultSet rs=null;
        try{
            Statement users=con.createStatement();
            rs=users.executeQuery("Select * from train");
            return rs;
        }catch(Exception e){

        }
        return rs;
    }
    public ResultSet users(){
        ResultSet rs=null;
        try{
            Statement users=con.createStatement();
            rs=users.executeQuery("Select * from user");
            return rs;
        }catch(Exception e){

        }
        return rs;
    }
    public ResultSet pnrStatus(String pnr){
        ResultSet rs=null;
        try{
            PreparedStatement pn=con.prepareStatement("Select * from reservation where PNR=?");
            pn.setString(1,pnr);
            rs=pn.executeQuery();
            return rs;
        }
        catch(Exception e){
        }
        return rs;
    }
    public boolean profileUpdate(String fname,String lname,String age,String gender,String phone,String address,String email,String userid){
        try{
            PreparedStatement updatep=con.prepareStatement("update user set FirstName=?,LastName=?,Age=?,Gender=?,PhoneNumber=?,Address=?,EmailID=? where userid=?");
            updatep.setString(1, fname);
            updatep.setString(2, lname);
            updatep.setString(3, age);
            updatep.setString(4, gender);
            updatep.setString(5, phone);
            updatep.setString(6, address);
            updatep.setString(7, email);
            updatep.setString(8, userid);
            int r=updatep.executeUpdate();
            if(r>=1){return true;}else return false;
        }catch(Exception e){
        }
        return false;
    }
    public ResultSet profile(String userid){
        ResultSet rs=null;
        try{
            PreparedStatement profile=con.prepareStatement("Select * from user where userid=?");
            profile.setString(1,userid);
            rs=profile.executeQuery();
            return rs;
        }catch(Exception e){
        }
        return rs;
    }
    public ResultSet bookedhistory(String userid){           
            ResultSet rs=null;
            try{
            PreparedStatement hist=con.prepareStatement("Select * from reservation where userid=?");
            hist.setString(1,userid);
            rs=hist.executeQuery();
            return rs;}
            catch(Exception e){
            }
            return rs;
    }
    public boolean insertTrain(String trainno,String source,String destination,String totalberth,String price,String available,String date){
        try{
            PreparedStatement intrain=con.prepareStatement("Insert into train values(?,?,?,?,?,?,?)");
            intrain.setString(1,trainno);
            intrain.setString(2,source);
            intrain.setString(3,destination);
            intrain.setString(4,totalberth);
            intrain.setString(5,price);
            intrain.setString(6,available);
            intrain.setString(7,date);
            int rs=intrain.executeUpdate();
            if(rs>=1) return true;
        }
        catch(Exception e){
        }
        return false;
    }
    public boolean bookTicket(String userid,String trainno,String source,String destination,String date,String quota,String name){
        try{
            PreparedStatement book=con.prepareStatement("insert into reservation values(?,?,?,?,?,?,?,?,?,?)");
            book.setString(1,userid);
            PreparedStatement temp=con.prepareStatement("Select * from train where TrainNo=? and Date=?");
            temp.setString(1,trainno);
            temp.setString(2,date);
            int berthno=0;
            int price=0;
            int avail=0;
            ResultSet rs=temp.executeQuery();
            while(rs.next()){
                avail=rs.getInt(6);
                berthno=rs.getInt(4)-avail+1;
                price=rs.getInt(5);
            }            
            book.setString(2,trainno);
            book.setString(3,source);
            book.setString(4,destination);
            book.setString(8,date);
            book.setString(5,""+berthno);
            book.setString(6,quota);
            book.setString(7,""+price);
            java.util.Date cur=new java.util.Date();
            String pnr=""+cur.getMonth()+""+cur.getDate()+""+cur.getHours()+""+cur.getMinutes()+""+cur.getSeconds();
            //String pnr=""+cur.getTime();
            book.setString(9,pnr);
            book.setString(10,name);
            int r=book.executeUpdate();
            if(r>=1){
            PreparedStatement up=con.prepareStatement("update train set Available=? where TrainNo=? and Date=?");
            avail--;
            up.setString(1,""+avail);
            up.setString(2,trainno);
            up.setString(3,date);
            int t=up.executeUpdate();
            return true;
            }
        }
        catch(Exception e){
        }
        return false;
    }
    public int getQuota(String type){
        int value=0;
        try{
            PreparedStatement disc=con.prepareStatement("Select * from quota where Type=?");
            disc.setString(1,type);
            ResultSet rs=disc.executeQuery();
            while(rs.next()){
                value=rs.getInt("Discount");
            }
            return value;
        }
        catch(Exception e){            
        }
        return value;
    }
    public int[] getFare(String trainno){
        int f[]=new int[2];
        try{
            PreparedStatement fare=con.prepareStatement("SELECT * from train where TrainNo=?");
            fare.setString(1,trainno);
            ResultSet rs=fare.executeQuery();
            while(rs.next()){
                f[0]=rs.getInt("Price");
                f[1]=rs.getInt("Available");
            }
        }
        catch(Exception e){            
        }
        return f;
    }
    public int[][] getAvail(String source,String destination,String date){
        try{
            PreparedStatement avail=con.prepareStatement("SELECT * FROM TRAIN where Source=? and Destination=? and date=?");
            avail.setString(1,source);
            avail.setString(2,destination);
            avail.setString(3,date);
            ResultSet rs=avail.executeQuery();
            int count=0;
            while(rs.next()){
                count++;
            }
            rs=avail.executeQuery();
            int [][] tr=new int[count][2];
            count=0;
            while(rs.next()){
                tr[count][0]=rs.getInt("TrainNo");
                tr[count][1]=rs.getInt("Available");
                count++;
            }
           return tr;
        }
        catch(Exception e){
        }
       // return 0;
        return new int[0][0];
    }
    public boolean adminlogin(String user,String pwd){
        try{
            PreparedStatement login=con.prepareStatement("SELECT * FROM admin WHERE userid=? AND Password=?");
            login.setString(1,user);
            MD5 pass=new MD5();
            String pswd=pass.hashvalue(pwd);
            login.setString(2,pswd);
            ResultSet rs=login.executeQuery();
            if(rs.next()){
                    return true;
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }
    public boolean logincheck(String user,String pwd){
        try{
            PreparedStatement login=con.prepareStatement("SELECT * FROM user WHERE userid=? AND Password=?");
            login.setString(1,user);
            MD5 pass=new MD5();
            String pswd=pass.hashvalue(pwd);
            login.setString(2,pswd);
            ResultSet rs=login.executeQuery();
            while(rs.next()){
		if(rs.getString("Age")!=null)
                    return true;
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }
    public boolean connect(){
       try{
           Class.forName(driver);
           con=DriverManager.getConnection(url, username, password);
           return true;

       }
       catch(Exception e){
           //System.out.println("Connection failed:"+e);
           return false;
       }
    }
    public void close(){
        try {con.close();
       // out.println("Closed");

        }
        catch(Exception e){
          //  out.println("Could not close");
        }
    }
    public boolean Register(String[]user){
            PreparedStatement stmt;
            int i=0;
            try {
                    stmt=con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?)");
                    stmt.setString(1,user[0]);
                    MD5 pass=new MD5();
                    String pswd=pass.hashvalue(user[1]);
                    stmt.setString(2,pswd);
                    stmt.setString(3,user[2]);
                    stmt.setString(4,user[3]);
                    stmt.setString(5,user[4]);
                    stmt.setString(6,user[5]);
                    stmt.setString(7,user[6]);
                    stmt.setString(8,user[7]);
                    stmt.setString(9,user[8]);
                    i=stmt.executeUpdate();
            }
            catch (Exception e) {
                    System.out.println(e);
                    return false;
            }
            if(i>=1)return true;
            else return false;
    }

}
