/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.net.URL;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Chamara Sasmith
 */
public class StudentsPrintController implements Initializable {

    @FXML
    private ComboBox<String> classes;

    ObservableList<String> list = FXCollections.observableArrayList();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      comboLoader();
    }    

    @FXML
    private void AllPrint(ActionEvent event) {
        
          try {
             String s = School_Management_System.class.getResource("/img/3.png").toString();
             
              HashMap h = new HashMap();
            h.put("img", s);
             
              JasperReport jr = JasperCompileManager.compileReport("src/Reports/studentsReport.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, h,Db.getCon() );
            System.out.println(jp == null);
            JasperViewer jv = new JasperViewer(jp, false);
           jv.setTitle("OMS version 3.0");
            //jv.setAlwaysOnTop(true);
            jv.setVisible(true);
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void classPrint(ActionEvent event) {
        
           
        if(classes.getSelectionModel().getSelectedItem()==null){
            Alert a=new Alert(Alert.AlertType.ERROR, "Select class before click button", ButtonType.OK);
                    a.show();
        }
        else{
          String ccat[]=classes.getSelectionModel().getSelectedItem().split("-");
        
        System.out.println(ccat[0]+"   "+ ccat[1]);
        try {
            ResultSet rr=Db.getData("select * from classes where class_name='"+ccat[1]+"' and grade='"+ccat[0]+"'");
                  
            while(rr.next()){
              printClasses(rr.getString("idClasses"));
       
             
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        }
      
     
        
    }
    
    
     private static  void printClasses(String classID){
    
         String s = School_Management_System.class.getResource("/img/3.png").toString();
         System.out.println("Go prints");
         
        HashMap h=new HashMap();
        
        h.put("classId", classID);
        h.put("img", s);
        try {
            Db.getData("select * from classes where idClasses='"+classID+"'");
            if(Db.rs.next()){
            h.put("className", Db.rs.getString("grade")+"-"+Db.rs.getString("class_name"));
            
            }
            
            Db.getData("select * from teachers where Classes_idClasses='"+classID+"'");
             if(Db.rs.next()){
            h.put("teacherName", Db.rs.getString("Ser_name")+" "+Db.rs.getString("last_name"));
         
            }
            
            JasperReport jr = JasperCompileManager.compileReport("src/Reports/classesR.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, h,Db.getCon() );
           
            JasperViewer jv = new JasperViewer(jp, false);
              jv.setTitle("OMS version 3.0");
            jv.setAlwaysOnTop(true);
            //  jv.setVisible(true);
            jv.setVisible(true);


          
          
        } catch (Exception ex) {
           
            System.out.println(ex);
            
        }
    
   
    }
    
    
      public void comboLoader() {
        try {
            Db.getData("SELECT * FROM classes");
            while (Db.rs.next()) {
                list.add(Db.rs.getString("grade")+"-"+Db.rs.getString("class_name"));

            }
           classes.setItems(list);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
     
     
}
