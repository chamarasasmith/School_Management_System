/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import static school_management_system.LoadFXML.view1;

/**
 * FXML Controller class
 *
 * @author Gihan Munasinghe
 */
public class SearchTeachersController implements Initializable {

    @FXML
    private SplitPane sp0;
    @FXML
    private ImageView home;
    @FXML
    private ImageView close;
    @FXML
    private RadioButton rb1;
    @FXML
    private ToggleGroup a1;
    @FXML
    private RadioButton rb2;
    @FXML
    private TextField text1;
    @FXML
    private TableView<teacherstb> stable;
    @FXML
    private TableColumn<teacherstb, String> fname;
    @FXML
    private TableColumn<teacherstb, String> con;
    @FXML
    private TableColumn<teacherstb, String> status;
    @FXML
    private TableColumn<teacherstb, String> nic;
    @FXML
    private TableColumn<teacherstb, String> middle;
    @FXML
    private TableColumn<teacherstb, String> surname;
    @FXML
    private TableColumn<teacherstb, String> gender;
    @FXML
    private TableColumn<teacherstb, String> fappoint;
    
    ObservableList<teacherstb> teachers;

    int i = 0;
    int i2 = 0;
    @FXML
    private RadioButton rb0;
    
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
    private void search1(MouseEvent event) {
        
         try {
            
             stable.getItems().clear();
             
            ResultSet rs=null;
        if (rb0.isSelected()) {
            
                rs=Db.getData("SELECT * FROM teachers");
            System.out.println("0");
        }
            
            
        if (rb2.isSelected()) {
            
                rs=Db.getData("SELECT * FROM teachers WHERE nic='"+text1.getText().toString()+"'");
            System.out.println("a");
        }
        if (rb1.isSelected()) {
            rs=Db.getData("SELECT * FROM teachers WHERE Ser_name='"+text1.getText()+"' OR middle_name='"+text1.getText()+"' OR last_name='"+text1.getText()+"'");
            
            System.out.println("b");
           // System.out.println(Db.rs.getString(4));
        }
        
            while (rs.next()) {                
             
            
              //  System.out.println(rs.getString(1));
                teachers= FXCollections.observableArrayList(
               new teacherstb(Db.rs.getString(1), Db.rs.getString(4), Db.rs.getString(3), Db.rs.getString(2), Db.rs.getString(6), Db.rs.getString(7), Db.rs.getString(14), Db.rs.getString(22))
           
                );

        nic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        middle.setCellValueFactory(new PropertyValueFactory<>("middle"));
        fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        fappoint.setCellValueFactory(new PropertyValueFactory<>("fappoint"));
        con.setCellValueFactory(new PropertyValueFactory<>("con"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        stable.getItems().addAll(teachers); 
      
                          
            }
        
        
        
        
         
        } catch (Exception ex) {
                System.out.println(ex);
            }
        
    }

    @FXML
    private void goTDeatails(MouseEvent event) {
        
        try {

            int f = stable.getSelectionModel().getFocusedIndex();

            if (i2 == f) {
                i++;
            } else {
                i = 0;
                i2 = stable.getSelectionModel().getFocusedIndex();
            }

            if (i == 2) {

                i = 0;

                String c = stable.getItems().get(f).getNic();
                System.out.println(c);

                FXMLLoader loader = new FXMLLoader(School_Management_System.class.getResource("TeachersDetails.fxml"));

                TeachersDetailsController controller = new TeachersDetailsController(c);
               
                loader.setController(controller);

                AnchorPane ap = loader.load();

                 view1.setTopAnchor(ap, 0.0);
            view1.setBottomAnchor(ap, 0.0);
            view1.setLeftAnchor(ap, 0.0);
            view1.setRightAnchor(ap, 0.0);

            view1.getChildren().clear();
            view1.getChildren().add(ap);

            ScaleTransition st = new ScaleTransition(Duration.millis(250));
            st.setNode(ap);

            st.setFromX(0);
            st.setFromY(0);
            st.setToX(1);
            st.setToY(1);

            st.play();

            }
        } catch (IOException ex) {

            System.out.println(ex);
        }
        
        
    }
    
}
