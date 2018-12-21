/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import cs.CSBackup;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Chamara Sasmith
 */
public class LoginController implements Initializable {

    @FXML
    private TextField un;
    @FXML
    private PasswordField pw;
    @FXML
    private ImageView close;
    @FXML
    private Label text1;
    
    public static String type1;
    public static String upw;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         OurDesign.closer = close;
         BRestore();
         CheckPassOuters1.getOuters();
         CheckPassOuters1.stuGradeUpper(new Date());
    }    

   
    
    
    @FXML
    private void login(ActionEvent event) {
        
        
        
        try {
            
            if (un.getText().equalsIgnoreCase("cs") & pw.getText().equalsIgnoreCase("123")) {
                LoadFXML.setFXML("Main1.fxml");
              type1="Admin";
              upw="No Password";
            }else{
            
            ResultSet rs1 = Db.getData("SELECT * FROM login WHERE Teachers_nic='"+un.getText()+"' AND password='"+pw.getText()+"'");
            
            if (rs1.first()) {
                LoadFXML.setFXML("Main1.fxml");
              type1=rs1.getString("status");
              upw=pw.getText();
            }else{
            new Alert(Alert.AlertType.ERROR, "Check Value and Try Again", ButtonType.OK).show();
            }
            
            }
            
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Check Value and Try Again", ButtonType.OK).show();
        }
        
        
    }

    @FXML
    private void exit(MouseEvent event) {
        OurDesign.closeButton("exit");
    }

    @FXML
    private void entering(MouseEvent event) {
         OurDesign.closeButton("enter");
    }

    @FXML
    private void change(MouseEvent event) {
        OurDesign.closeButton("close");
    }
    
    private void BRestore(){
    
    
        String s = CSBackup.Restore("school_db","root", "123", "3306","localhost", "D:\\School_DB\\DB\\DB.sql");
        System.out.println(s);
    }
    
}
