/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Chamara Sasmith
 */
public class GradeUp {
    
    
    public static void up1(){
    
        try {
            
            Date d = new Date();
            
            SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
           
            String s = sdf.format(d);
            
             System.out.println(s);
            if (s.equalsIgnoreCase("0101")) {
            
                ResultSet rs1 = Db.getData("SELECT * FROM classes WHERE grade='5'");
                ResultSet rs2 = Db.getData("SELECT * FROM classes WHERE grade='4'");
                ResultSet rs3 = Db.getData("SELECT * FROM students");
                
                while (rs1.next()) {                    
                    
                    Db.putData("UPDATE students SET status='0' WHERE Classes_idClasses='"+rs1.getString("idClasses")+"'");
                    
                }
                
                 while (rs3.next()) {                    
                    
                     System.out.println("rs3");
                     
                    String cid = rs3.getString("Classes_idClasses");
                    ResultSet rs4 = Db.getData("SELECT * FROM classes WHERE idClasses='"+cid+"'");
                    
                     while (rs4.next()) { 
                         
                         System.out.println("rs4");
                         
                        String cname = rs4.getString("class_name");
                        int grade = rs4.getInt("grade");
                        
                         if (grade!=5) {
                            grade=grade+1; 
                         }
                        
                        ResultSet rs5 = Db.getData("SELECT * FROM classes WHERE grade='"+grade+"' AND class_name='"+cname+"'");
                        
                         if (rs5.first()) {
                             
                             System.out.println("rs5");
                             
                             Db.putData("UPDATE students SET Classes_idClasses='"+rs5.getString("idClasses")+"' WHERE index_no='"+rs3.getString("index_no")+"'");
                         }
                        
                     }
                    
                    
                }
                
                
                
                
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
    
    public static void main(String[] args) {
        up1();
    }
    
}
