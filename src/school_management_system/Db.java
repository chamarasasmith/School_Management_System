/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.TextField;

/**
 *
 * @author Gihan Munasinghe
 */
public class Db {

    static Connection con;
    static ResultSet rs;

    public static Connection getCon() throws Exception {
        if (con == null) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "zenonideas");

            return con;
        }
        return con;
    }

    public static void putData(String sql) throws Exception {
        Connection c = getCon();
        Statement st = c.createStatement();
        st.executeUpdate(sql);
      //  System.out.println(sql);

    }
    
    public static ResultSet getData(String sql) throws Exception{
    Connection c=getCon();
       Statement st = c.createStatement();
       rs=st.executeQuery(sql);
       // System.out.println(sql);
       return rs;
   
    }
    
    public static String getIndex() throws Exception{
        System.out.println("mwaaaa");
       int stucount=0;
       boolean flag=false;
    ResultSet rrr=Db.getData("select * FROM students");
        
    
    while(rrr.next()){//is not studets in database
        flag=true;
            
         stucount++;
       
        }
    if(flag){
        String cindex=(stucount+1)+"";
        return cindex;
    
    }
    else{return stucount+"";}
    
    
    
    }
}
