/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
 * @author Admin
 */
public class StudentsDetailsController implements Initializable {

    @FXML
    private ImageView home;
    @FXML
    private ImageView close;
    
    @FXML
    private Label sid;
    @FXML
    private Label sname;
    @FXML
    private Label fname;
   
    @FXML
    private Label dob;
    @FXML
    private Label gen;
    @FXML
    private Label adm;
    @FXML
    private Label pass;
    @FXML
    private Label faname;
    @FXML
    private Label faocu;
    @FXML
    private Label fatel;
    @FXML
    private Label maname;
    @FXML
    private Label maocu;
    @FXML
    private Label matel;
    @FXML
    private Label street;
    @FXML
    private Label city;
    @FXML
    private Label skil;
    @FXML
    private Label odet;
    @FXML
    private Label clz;
    @FXML
    private Label tmode;
    @FXML
    private Label st;
    
    private String sid1;
    @FXML
    private Label lname;
    @FXML
    private Label grade;
    

    StudentsDetailsController(String c) {
   
        sid1=c;
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       OurDesign.closer=close;
        OurDesign.home=home;
        
        
        setDetails();
        
    }    

    @FXML
    private void homeex(MouseEvent event) {
      //  OurDesign.homeButton("homeex");
    }

    @FXML
    private void homeen(MouseEvent event) {
       // OurDesign.homeButton("homeen");
    }

    @FXML
    private void setHome(MouseEvent event) {
        LoadFXML.setFXML("SearchStudents.fxml");
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

    private void setDetails() {
  
        
        
        try {
            
            ResultSet rs = Db.getData("SELECT * FROM students WHERE index_no='"+sid1+"'");
            
            if (rs.first()) {                
                
                
                
                
                String sid = rs.getString(1);
                String sname = rs.getString(2);
                String mname = rs.getString(3);
                String lname = rs.getString(4);
                String dob = rs.getString(5);
                String gen = rs.getString(6);
                String pass = rs.getString(7);
                String adm = rs.getString(8);
                String faname = rs.getString(9);
                String faocu = rs.getString(10);
                String fatel = rs.getString(11);
                String maname = rs.getString(12);
                String maocu = rs.getString(13);
                String matel = rs.getString(14);
                String street = rs.getString(15);
                String city = rs.getString(16);
                String skil = rs.getString(17);
                String odet = rs.getString(18);
                String clz = rs.getString(19);
                String tmode = rs.getString(20);
                String st = rs.getString(21);
                
                
                String cid = rs.getString("Classes_idClasses");
                ResultSet rs1 = Db.getData("SELECT * FROM classes WHERE idClasses='"+clz+"'");
                ResultSet rs2 = Db.getData("SELECT * FROM travel_mode WHERE idTravel_mode='"+tmode+"'");
                String cname="";
                String grad="";
                String trmode="";
                if (rs1.first()) {
                    cname=rs1.getString("class_name");
                    grad=rs1.getString("grade");
                }
                if (rs2.first()) {
                    trmode=rs2.getString("mode_name");
                    
                }
                
                this.sid.setText(sid);
                this.sname.setText(sname);
                this.fname.setText(mname);
                this.lname.setText(lname);
                this.dob.setText(dob);
                this.gen.setText(gen);
                this.pass.setText(pass);
                this.adm.setText(adm);
                this.faname.setText(faname);
                this.faocu.setText(faocu);
                this.fatel.setText(fatel);
                this.maname.setText(maname);
                this.maocu.setText(maocu);
                this.matel.setText(matel);
                this.street.setText(street);
                this.city.setText(city);
                this.skil.setText(skil);
                this.odet.setText(odet);
                this.clz.setText(cname);
                this.grade.setText(grad);
                this.tmode.setText(trmode);
                this.st.setText(st);
                
            }
            
        } catch (Exception e) {
            System.out.println(e);
        
        }
    }

    @FXML
    private void updateView(ActionEvent event) {
        
        
          try {

           // primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(School_Management_System.class.getResource("StudentsUpdate.fxml"));
            
              StudentsUpdateController controller = new StudentsUpdateController(sid.getText());
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

        } catch (Exception e) {

            System.out.println(e);
        }
        
    }
        
        
    
    
}
