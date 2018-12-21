/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import static school_management_system.School_Management_System.root;

/**
 * FXML Controller class
 *
 * @author Gihan Munasinghe
 */
public class Main1Controller implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private ImageView student;
    @FXML
    private ImageView settings;
    @FXML
    private ImageView teacher;
    @FXML
    private ImageView reports;
    @FXML
    private ImageView b12;
    @FXML
    private ImageView b21;
    @FXML
    private ImageView b22;
    @FXML
    private ImageView b31;
    @FXML
    private ImageView b32;
    @FXML
    private ImageView b41;
    @FXML
    private ImageView b121;
    @FXML
    private ImageView b211;
    @FXML
    private ImageView b221;
    @FXML
    private ImageView b311;
    @FXML
    private ImageView b321;
    @FXML
    private ImageView b411;
    @FXML
    private ImageView b421;
    @FXML
    private ImageView students1;
    @FXML
    private ImageView settings1;
    @FXML
    private ImageView teachers1;
    @FXML
    private ImageView reports1;
    @FXML
    private ImageView b11;
    @FXML
    private ImageView b111;
    @FXML
    private StackPane stack;
    @FXML
    private ImageView b42;

    ParallelTransition pt;
    FadeTransition ft;
    FadeTransition ft1;
    public static Stage primaryStage;
    @FXML
    private ImageView close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         OurDesign.closer = close;
     

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    void setFade(Node n1, Node n2) {

        pt = new ParallelTransition();

        ft = new FadeTransition(Duration.millis(500));
        ft.setNode(n1);
        ft.setFromValue(0);
        ft.setToValue(1);

        ft1 = new FadeTransition(Duration.millis(500));
        ft1.setNode(n2);
        ft1.setFromValue(0);
        ft1.setToValue(1);

        pt.getChildren().addAll(ft, ft1);
        pt.play();

    }

    @FXML
    private void stuex(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        //  b11.setVisible(false);
        b42.setVisible(false);
        //  b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void stuen(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(true);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void seten(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(true);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void teaen(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(true);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void repex(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        //  b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        //  b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void repen(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(true);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    private void b421(MouseEvent event) {
//       b421.setVisible(true);
        System.out.println("aa");
    }

    @FXML
    private void stex(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        // b21.setVisible(false);
        b211.setVisible(false);
        //  b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);
    }

    @FXML
    private void teaex(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        // b31.setVisible(false);
        b311.setVisible(false);
        // b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);
    }

    @FXML
    private void stuok(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(true);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b42.setVisible(false);

        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);
        b12.setVisible(true);
        b11.setVisible(true);

        setFade(b11, b12);

    }

    @FXML
    private void stok(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(true);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(true);
        b211.setVisible(false);
        b22.setVisible(true);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

        setFade(b21, b22);

    }

    @FXML
    private void teaok(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(true);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(true);
        b311.setVisible(false);
        b32.setVisible(true);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

        setFade(b31, b32);

    }

    @FXML
    private void repok(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(true);

        b11.setVisible(false);
        b42.setVisible(true);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(true);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

        setFade(b41, b42);

    }

    @FXML
    private void seaen(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(true);
        b42.setVisible(false);
        b12.setVisible(true);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(true);
        b121.setVisible(false);

    }

    @FXML
    private void regen(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(true);
        b42.setVisible(false);
        b12.setVisible(true);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(true);

    }

    @FXML
    private void bacen(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(true);
        b211.setVisible(true);
        b22.setVisible(true);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void useren(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(true);
        b211.setVisible(false);
        b22.setVisible(true);
        b221.setVisible(true);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void reg1en(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(true);
        b311.setVisible(true);
        b32.setVisible(true);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void sea1en(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(true);
        b311.setVisible(false);
        b32.setVisible(true);
        b321.setVisible(true);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void exen(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(true);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(true);
        b411.setVisible(true);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void exex(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(true);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(true);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void seaex(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(true);
        b42.setVisible(false);
        b12.setVisible(true);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void seaok(MouseEvent event) {

         LoadFXML.setFXML("SearchStudents.fxml");
    }

    @FXML
    private void reqex(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(true);
        b42.setVisible(false);
        b12.setVisible(true);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void reqok(MouseEvent event) {
        
        LoadFXML.setFXML("Students.fxml");
    }

    @FXML
    private void bacex(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(true);
        b211.setVisible(false);
        b22.setVisible(true);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void bacok(MouseEvent event) {
        
        LoadFXML.setFXML("Backup.fxml");
       
        
    }

    @FXML
    private void userex(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(true);
        b211.setVisible(false);
        b22.setVisible(true);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void userok(MouseEvent event) {
        
         if (LoginController.type1.equalsIgnoreCase("Admin")) {

             LoadFXML.setFXML("Accounts.fxml");
           
        } else {
            new Alert(Alert.AlertType.WARNING, "You have not Access", ButtonType.OK).show();

        }
        
        
    }

    @FXML
    private void req1ex(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(true);
        b311.setVisible(false);
        b32.setVisible(true);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void req1ok(MouseEvent event) {

        //here code
         LoadFXML.setFXML("teachers.fxml");

    }

    @FXML
    private void sea1ex(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(false);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(true);
        b311.setVisible(false);
        b32.setVisible(true);
        b321.setVisible(false);
        b41.setVisible(false);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void sea1ok(MouseEvent event) {
        
        LoadFXML.setFXML("SearchTeachers.fxml");
        
        
    }

    @FXML
    private void exok(MouseEvent event) {
        
           LoadFXML.setFXML("AllReports.fxml");
    }

    @FXML
    private void eveex(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(true);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(true);
        b411.setVisible(false);

        b421.setVisible(false);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void eveok(MouseEvent event) {
         
            LoadFXML.setFXML("TeachersLeave.fxml");

    }

    @FXML
    private void eveen(MouseEvent event) {

        logo.setVisible(true);
        students1.setVisible(true);
        settings1.setVisible(true);
        teachers1.setVisible(true);
        reports1.setVisible(true);

        student.setVisible(false);

        settings.setVisible(false);
        teacher.setVisible(false);
        reports.setVisible(false);

        b11.setVisible(false);
        b42.setVisible(true);
        b12.setVisible(false);
        b121.setVisible(false);
        b21.setVisible(false);
        b211.setVisible(false);
        b22.setVisible(false);
        b221.setVisible(false);
        b31.setVisible(false);
        b311.setVisible(false);
        b32.setVisible(false);
        b321.setVisible(false);
        b41.setVisible(true);
        b411.setVisible(false);

        b421.setVisible(true);

        b111.setVisible(false);
        b121.setVisible(false);

    }

    @FXML
    private void regiStudents(MouseEvent event) {

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
    
    
}
