/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class TeachersDetailsController implements Initializable {

    @FXML
    private ImageView home;
    @FXML
    private ImageView close;
    @FXML
    private Label nic;
    @FXML
    private Label sname;
    @FXML
    private Label fname;
    @FXML
    private Label lname;
    @FXML
    private Label dob;
    @FXML
    private Label gen;
    @FXML
    private Label fappoint;
    @FXML
    private Label sapp;
    @FXML
    private Label idate;
    @FXML
    private Label edu;
    @FXML
    private Label pro;
    @FXML
    private Label spname;
    @FXML
    private Label spocu;
    @FXML
    private Label sptel;
    @FXML
    private Label street;
    @FXML
    private Label city;
    @FXML
    private Label tel;
    @FXML
    private Label odet;
    @FXML
    private Label clz;
    @FXML
    private Label tmode;
    @FXML
    private Label grade;
    @FXML
    private Label st;
    @FXML
    private Label cat;
    
    private String nic1;
    @FXML
    private Label leave1;
    @FXML
    private Label grade1;

    TeachersDetailsController(String c) {
     
        nic1=c;
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           OurDesign.closer = close;
       OurDesign.home=home;
        setDetails();
    }    

    @FXML
    private void homeex(MouseEvent event) {
        //OurDesign.homeButton("homeex");
    }

    @FXML
    private void homeen(MouseEvent event) {
      //   OurDesign.homeButton("homeen");
    }

    @FXML
    private void setHome(MouseEvent event) {
        
       LoadFXML.setFXML("SearchTeachers.fxml");
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
            
            Date d1 = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String s = sdf.format(d1);
            
            ResultSet rs = Db.getData("SELECT * FROM teachers WHERE nic='"+nic1+"'");
            ResultSet rs2 = Db.getData("SELECT COUNT(tid) FROM tleave WHERE tid='"+nic1+"' AND YEAR(date1)='"+s+"'");
            
            if (rs.first()) {                
                
                String nic = rs.getString(1);
                String sname = rs.getString(2);
                String fname = rs.getString(3);
                String lname = rs.getString(4);
                String dob = rs.getString(5);
                String gen = rs.getString(6);
                String fap = rs.getString(7);
                String sap = rs.getString(8);
                String idate = rs.getString(9);
                String edu = rs.getString(10);
                String pro = rs.getString(11);
                String street = rs.getString(12);
                String city = rs.getString(13);
                String tel = rs.getString(14);
                String spname = rs.getString(15);
                String sptel = rs.getString(16);
                String spocu = rs.getString(17);
                String odet = rs.getString(18);
                String clz = rs.getString(19);
                String tmode = rs.getString(20);
                String sgrade = rs.getString(21);
                String st = rs.getString(22);
                String cat = rs.getString(23);
                
                String cid = rs.getString("Classes_idClasses");
                ResultSet rs1 = Db.getData("SELECT * FROM classes WHERE idClasses='"+clz+"'");
                ResultSet rs3 = Db.getData("SELECT * FROM travel_mode WHERE idTravel_mode='"+tmode+"'");
                ResultSet rs4 = Db.getData("SELECT * FROM teachers_cat WHERE idteachers_cat='"+cat+"'");
                
                
                String cname="";
                String grad="";
                String trmode="";
                String tcat1="";
                
                if(rs4.first()) {
                    tcat1= rs4.getString("cat_name");
             }
                if (rs1.first()) {
                    cname=rs1.getString("class_name");
                    grad=rs1.getString("grade");
                }
                if (rs3.first()) {
                    trmode=rs3.getString("mode_name");
                    
                }
                
                
                
                this.nic.setText(nic);
                this.sname.setText(sname);
                this.fname.setText(fname);
                this.lname.setText(lname);
                this.dob.setText(dob);
                this.gen.setText(gen);
                this.fappoint.setText(fap);
                this.sapp.setText(sap);
                this.idate.setText(idate);
                this.edu.setText(edu);
                this.pro.setText(pro);
                this.street.setText(street);
                this.city.setText(city);
                this.tel.setText(tel);
                this.spname.setText(spname);
                this.sptel.setText(sptel);
                this.spocu.setText(spocu);
                this.odet.setText(odet);
                this.clz.setText(cname);
                this.grade1.setText(grad);
                this.tmode.setText(trmode);
                this.grade.setText(sgrade);
                this.st.setText(st);
                this.cat.setText(tcat1);
                
            }
            
            if (rs2.first()) {
                leave1.setText(rs2.getString(1));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        
        }
    }

    @FXML
    private void backSearch(ActionEvent event) {
        
        
        try {

           // primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(School_Management_System.class.getResource("TeachersUpdate.fxml"));
            
            TeachersUpdateController controller = new TeachersUpdateController(nic.getText());
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
