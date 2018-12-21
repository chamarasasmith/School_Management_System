/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
public class TeachersPrintController implements Initializable {

    @FXML
    private ToggleGroup a;
    @FXML
    private RadioButton pcat;
    @FXML
    private RadioButton pnrml;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Print1(ActionEvent event) {
        
          String reportName=null;
        
        if(pcat.isSelected()){
            reportName="src/Reports/TeachersCat.jrxml";
        
        }
      
        
        if(pnrml.isSelected()){
         reportName="src/Reports/TeachersLeave.jrxml";
        }
        
        if(reportName==null){
         Alert a=new Alert(Alert.AlertType.ERROR, "Choose Your Print type", ButtonType.OK);
                    a.show();
        
        }
        
        jprint(reportName);
        
    }
    
    
    private void jprint(String reportName) {

        try {
            
            String s = School_Management_System.class.getResource("/img/3.png").toString();
            
            HashMap h = new HashMap();
            h.put("img", s);
              JasperReport jr = JasperCompileManager.compileReport(reportName);
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
    
}
