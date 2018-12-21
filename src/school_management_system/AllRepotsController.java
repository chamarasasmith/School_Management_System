/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Chamara Sasmith
 */
public class AllRepotsController implements Initializable {

    @FXML
    private AnchorPane area;
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
    private void tea(ActionEvent event) {
        
         try {
           FXMLLoader loader=new FXMLLoader(Main1Controller.class.getResource("TeachersPrint.fxml"));
            AnchorPane ap=loader.load();
            area.setTopAnchor(ap, 0.0);
            area.setBottomAnchor(ap, 0.0);
            area.setLeftAnchor(ap, 0.0);
            area.setRightAnchor(ap, 0.0);
            
            area.getChildren().clear();
            area.getChildren().add(ap);
            
                 ScaleTransition transition=new ScaleTransition(Duration.millis(250));
                 transition.setNode(ap);
                 
                 transition.setFromX(0);
                 transition.setFromY(0);
                 transition.setToX(1);
                 transition.setToY(1);
                 
                 transition.play();
            
            
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
    }

    @FXML
    private void stu(ActionEvent event) {
        
        
         try {
           FXMLLoader loader=new FXMLLoader(Main1Controller.class.getResource("StudentsPrint.fxml"));
            AnchorPane ap=loader.load();
            area.setTopAnchor(ap, 0.0);
            area.setBottomAnchor(ap, 0.0);
            area.setLeftAnchor(ap, 0.0);
            area.setRightAnchor(ap, 0.0);
            
            area.getChildren().clear();
            area.getChildren().add(ap);
            
                 ScaleTransition transition=new ScaleTransition(Duration.millis(250));
                 transition.setNode(ap);
                 
                 transition.setFromX(0);
                 transition.setFromY(0);
                 transition.setToX(1);
                 transition.setToY(1);
                 
                 transition.play();
            
            
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
    }

    @FXML
    private void exam(ActionEvent event) {
        
        try {
           FXMLLoader loader=new FXMLLoader(Main1Controller.class.getResource("ExamPrint.fxml"));
            AnchorPane ap=loader.load();
            area.setTopAnchor(ap, 0.0);
            area.setBottomAnchor(ap, 0.0);
            area.setLeftAnchor(ap, 0.0);
            area.setRightAnchor(ap, 0.0);
            
            area.getChildren().clear();
            area.getChildren().add(ap);
            
                 ScaleTransition transition=new ScaleTransition(Duration.millis(250));
                 transition.setNode(ap);
                 
                 transition.setFromX(0);
                 transition.setFromY(0);
                 transition.setToX(1);
                 transition.setToY(1);
                 
                 transition.play();
            
            
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
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
    
    
    
    
}
