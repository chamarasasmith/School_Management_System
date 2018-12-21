/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentStatus;

import school_management_system.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.TextField;

/**
 *
 * @author Gihan Munasinghe
 */
public class Db1 {

    static Connection con;
    static ResultSet rs;

    public static Connection getCon() throws Exception {
        if (con == null) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "123");

            return con;
        }
        return con;
    }

    public static void putData(String sql) throws Exception {
        Connection c = getCon();
        Statement st = c.createStatement();
        st.executeUpdate(sql);
       // System.out.println(sql);

    }
    
    public static ResultSet getData(String sql) throws Exception{
    Connection c=getCon();
       Statement st = c.createStatement();
       rs=st.executeQuery(sql);
       // System.out.println(sql);
       return rs;
   
    }
    
    public static String getIndex() throws Exception{
        System.out.println("giyaaaa");
        
    getData("select * FROM students");
        if(rs.next()){
        
            int i=0;
            
            try {
                ResultSet r1=getData("select index_no FROM students");
                
                while (r1.next()) {
              
                 i=r1.getInt("index_no");
                    
                }
             i=++i;
                System.out.println(i); 
            } catch (Exception e) {
                System.out.println(e);
            }
        return i+"";
        }else{
        
        return 0+"";
        }
    
    }
}
