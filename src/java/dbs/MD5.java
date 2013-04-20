package dbs;

import java.security.*;
class MD5{
    MessageDigest md;
    String hash=new String();
public String hashvalue(String message)throws Exception{

        md = MessageDigest.getInstance("MD5");
        md.update(message.getBytes());
        byte byteData[] = md.digest();
        //convert the byte to hex format method 1
        /*StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        System.out.println( sb.toString());*/
        //System.out.println("d41d8cd98f00b204e9800998ecf8427e");
        //convert the byte to hex format method 2
        StringBuilder hexString = new StringBuilder();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	hash=hexString.toString();
        return hash;
    }
}