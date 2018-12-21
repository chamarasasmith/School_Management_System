/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */

public class GenerateStudentstatus {


    
    static ArrayList<String> studentId=new ArrayList<>();

     private static void getStudetId(){
         
        
         
         
         try {
             System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
           
             String cDate="2019-12-31";
             
             Db1.getData("SELECT * FROM students where Pass_out_date='"+cDate+"' ");
             
             while(Db1.rs.next()){
             
                 studentId.add(Db1.rs.getString("index_no"));
                 
             }
             
         } catch (Exception e) {
         }
     
     
     }
     private static void setStatus() {

            for (String sid : studentId) {
            
                try {
                    Db1.putData("Update students set status='0' where index_no='"+sid+"'");
                } catch (Exception e) {
                    System.out.println(e);
                }
        }

    }
     
     public void genarateStatus(){
     getStudetId();
     setStatus();
     }
      public static String getstudentStatus(String sid) {
        
        String status="Student";
        try {
            Db1.getData("select * from students where index_no='"+sid+"'");
            
            if(Db1.rs.next()){
            
                if(Db1.rs.getString("status").equalsIgnoreCase("0")){
                
                status="Pass student";
                }
            
            }
          
            return status;
            
            
        } catch (Exception e) {
            System.out.println(e);
        return "Incorrect Id";
        }

    }
    
}
