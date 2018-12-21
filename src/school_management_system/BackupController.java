/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import cs.CSBackup;
import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Admin
 */
public class BackupController implements Initializable {

    @FXML
    private ImageView home;
    @FXML
    private ImageView close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OurDesign.closer = close;
       OurDesign.home=home;
    }    

    @FXML
    private void homeex(MouseEvent event) {
        OurDesign.homeButton("homeex");
    }

    @FXML
    private void homeen(MouseEvent event) {
        OurDesign.homeButton("homeen");
    }

    @FXML
    private void setHome(MouseEvent event) {
   
            LoadFXML.setFXML("Main1.fxml");
      
        
    }

    @FXML
    private void exiting(MouseEvent event) {
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

    @FXML
    private void backup(ActionEvent event) {
        
           try {
           
            FileChooser fc = new FileChooser();          
           String s = fc.showSaveDialog(null).getAbsolutePath().toString();
               //   String s2=s.replace('\\','/' );
             
      
               
              // String s1 = CSBackup.BackupChooser("school_db", "root","123", "3306", "localhost","E:/aa");
               String s1 = CSBackup.BackupChooser("school_db", "root","123", "3306", "localhost",s);
               System.out.println(s1);
               
               if (s1.equalsIgnoreCase("Unsuccess")) {
                   new Alert(Alert.AlertType.ERROR, "Ty Again Another Partition", ButtonType.OK).show();
               }
               if (s1.equalsIgnoreCase("Success")) {
                   new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK).show();
               }
            
        } catch (Exception e) {
            System.out.println(e);
               
        }
 
        
    }

    @FXML
    private void restore(ActionEvent event) {
        
        try {
            
             FileChooser fc = new FileChooser();
             
             
           
             fc.getExtensionFilters().add(
             new FileChooser.ExtensionFilter("SQL", "*.sql")
             );
             
               String s = fc.showOpenDialog(null).getAbsolutePath().toString();

               
               
            String s1 = CSBackup.Restore("school_db", "root","123", "3306", "localhost",s);
            
             if (s1.equalsIgnoreCase("Unsuccess")) {
                   new Alert(Alert.AlertType.ERROR, "Unsuccess", ButtonType.OK).show();
               }
               if (s1.equalsIgnoreCase("Success")) {
                   new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK).show();
               }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void ref(ActionEvent event) {
        
        
        
        String s = CSBackup.Restore("school_db","root", "123", "3306","localhost", "D:\\School_DB\\DB\\DB.sql");
        
       
        
        new Alert(Alert.AlertType.NONE, s, ButtonType.OK).show();
        
    }
    
}
