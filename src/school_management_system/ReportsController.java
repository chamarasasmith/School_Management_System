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
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
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
 * @author Gihan Munasinghe
 */
public class ReportsController implements Initializable {

    @FXML
    private SplitPane sp0;
    @FXML
    private ImageView home;
    @FXML
    private ImageView close;
    @FXML
    private Button treports;
    @FXML
    private Button sreports;
    @FXML
    private Button ereports;
    @FXML
    private AnchorPane area;
    static AnchorPane area2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OurDesign.closer = close;
        OurDesign.home = home;
        area2 = area;
        //===============================
//        
//           SplitPane.Divider get = sp0.getDividers().get(0);
//        get.positionProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//
//                get.setPosition(0.29);
//
//            }
//        });
//
//        SplitPane.Divider get1 = sp0.getDividers().get(0);
//        get1.positionProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//
//                get1.setPosition(0.5);
//
//            }
//        });
//
//        SplitPane.Divider get2 = sp0.getDividers().get(0);
//        get2.positionProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//
//                get2.setPosition(0.15);
//
//            }
//        });
//
//       
        //=================================
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
    private void LoadPrintTeachers(ActionEvent event) {
        
          
        try {
           FXMLLoader loader=new FXMLLoader(Main1Controller.class.getResource("TeachersPrintView.fxml"));
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
    private void LoadStudentPrint(ActionEvent event) {
        
            
        try {
           FXMLLoader loader=new FXMLLoader(Main1Controller.class.getResource("StudentPrintView.fxml"));
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
    private void LoadExamPrint(ActionEvent event) {
            
        try {
           FXMLLoader loader=new FXMLLoader(Main1Controller.class.getResource("ExamPrintView.fxml"));
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

}
