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
public class CheckPassOuters1 {
    
     public static void getOuters() {

        String cDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        // SELECT DISTINCT * FROM viewing WHERE YEAR(viewDate)=2001 AND MONTH(viewDate)=5;
        try {
            ResultSet rs1 = Db.getData("select * from students where Pass_out_date='" + cDate + "' ");
            while (rs1.next()) {

                System.out.println(rs1.getString("Ser_name"));

                Db.putData("Update Students set status='0' where index_no='" + rs1.getString("index_no") + "'");

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void stuGradeUpper(Date d) {
        new SimpleDateFormat("yyyy").format(d);
        boolean isupdate = false;

        try {
            ResultSet rs2 = Db.getData("select * from gradeupper where last_update='" + new SimpleDateFormat("yyyy").format(d) + "' and status='1'");
            if (rs2.next()) {
                System.out.println("Update before");

            } else {

                update();

                Db.putData("INSERT INTO gradeupper (last_update,status)VALUES('" + new SimpleDateFormat("yyyy").format(d) + "','1')");

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
            getOuters();

        stuGradeUpper(new Date());
    }

    private static void update() {
        System.out.println("methodinn");
        ResultSet rc = null;
        ResultSet rf = null;
        
        Integer newclassid = 0;
        String no = null;
        try {
            ResultSet rr = Db.getData("select * from students where status=1");
            while (rr.next()) {
                no = rr.getString("index_no");
                // System.out.println("rrin");
                rc = Db.getData("select * from  classes where idClasses='" + rr.getString("Classes_idClasses") + "'");//get class by student class id s
                if (rc.next()) {//for get id of update grade and class
                    //System.out.println("rc inn");
                    newclassid = new Integer(rc.getString("grade")) + 1;
                    // System.out.println(newclassid);
                    //System.out.println("innn"); 
                    rf = Db.getData("select * from classes where grade='" + newclassid + "' and class_name='" + rc.getString("class_name") + "'");
                    //System.out.println("rf eliya");
                    if (rf.next()) {
                        //System.out.println(rf.getString("idClasses"));  
                        //rr.updateString("Classes_idClasses", rf.getString("idClasses"));
                        Db.putData("update students set Classes_idClasses='" + rf.getString("idClasses") + "' where index_no='" + no + "'");
                    } else {//
                        // System.out.println(no+" "+" grade panna");

                    }
//                 Db.putData("update students set Classes_idClasses='select idClasses from classes where grade='"+newclassid+"' and class_name='"+rc.getString("class_name")+"' ' where Classes_idClasses='"+rr.getString("Classes_idClasses")+"'");

                   // System.out.println("outttt");
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    
}
