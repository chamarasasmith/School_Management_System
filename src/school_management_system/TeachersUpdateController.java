/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
 * @author Admin
 */
public class TeachersUpdateController implements Initializable {

    @FXML
    private SplitPane sp0;
    @FXML
    private ImageView home;
    @FXML
    private ImageView close;
    @FXML
    private SplitPane sp1;
    @FXML
    private TextField fname;
    @FXML
    private TextField mname;
    @FXML
    private TextField lname;
    @FXML
    private DatePicker dob;
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup a;
    @FXML
    private RadioButton female;
    @FXML
    private TextField street;
    @FXML
    private TextField city;
    @FXML
    private TextField pTel;
    @FXML
    private TextField nic;
    @FXML
    private SplitPane sp2;
    @FXML
    private DatePicker fstappointDate;
    @FXML
    private DatePicker sclappointDate;
    @FXML
    private DatePicker inceDate;
    @FXML
    private TextArea eduQulifi;
    @FXML
    private TextArea profQulifi;
    @FXML
    private ComboBox<String> serGrade;
    @FXML
    private ComboBox<String> preClass;
    @FXML
    private TextField sFName;
    @FXML
    private TextField sJob;
    @FXML
    private TextField stel;
    @FXML
    private TextArea otherDetails;
    @FXML
    private Label NotFillerror;
    @FXML
    private ComboBox<String> tcat;
    
    ObservableList<String> list2 = FXCollections.observableArrayList();
    ObservableList<String> list3 = FXCollections.observableArrayList();
    ObservableList<String> list4 = FXCollections.observableArrayList();
    
    private String nic1;
    @FXML
    private ComboBox<String> tmode1;
    
    ObservableList<String> list = FXCollections.observableArrayList();

    TeachersUpdateController(String text1) {
    
        System.out.println(text1);
        nic1=text1;
        
        
    
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OurDesign.closer = close;
       OurDesign.home=home;
       setDetails();
       comboLoader();
       comboLoader2();
       comboLoader3();
       comboLoader4();
    } 
    
    
    private void setDetails() {
  
        
        
        try {
            
            Date d1 = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String s = sdf.format(d1);
            
            ResultSet rs = Db.getData("SELECT * FROM teachers WHERE nic='"+nic1+"'");
          //  ResultSet rs2 = Db.getData("SELECT COUNT(tid) FROM tleave WHERE tid='"+nic1+"' AND YEAR(date1)='"+s+"'");
            
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
                ResultSet rs2 = Db.getData("SELECT * FROM travel_mode WHERE idTravel_mode='"+tmode+"'");
                
                
                ResultSet rs3 = Db.getData("SELECT * FROM teachers_cat WHERE idteachers_cat='"+cat+"'");
                
               
                
                
                String cname="";
                String grad="";
                String trmode="";
                String tcat1="";
                
                if(rs3.first()) {
                    tcat1= rs3.getString("cat_name");
             }
                
                if (rs1.first()) {
                    cname=rs1.getString("class_name");
                    grad=rs1.getString("grade");
                }
                if (rs2.first()) {
                    trmode=rs2.getString("mode_name");
                    
                }
                
                
                
                this.nic.setText(nic);
                this.fname.setText(sname);
                this.mname.setText(fname);
                this.lname.setText(lname);
               
               // this..setText(gen);
               
               if (gen.equalsIgnoreCase("Male")) {
                male.setSelected(true);
                female.setSelected(false);
            }
            if (gen.equalsIgnoreCase("Female")) {
                male.setSelected(false);
                female.setSelected(true);
            }
               
                
                this.eduQulifi.setText(edu);
                this.profQulifi.setText(pro);
                this.street.setText(street);
                this.city.setText(city);
                this.pTel.setText(tel);
                this.sFName.setText(spname);
                this.stel.setText(sptel);
                this.sJob.setText(spocu);
                this.otherDetails.setText(odet);
                this.preClass.getSelectionModel().select(grad+" : "+cname);
                this.tmode1.getSelectionModel().select(trmode);
                this.serGrade.getSelectionModel().select(sgrade);
               // this..setText(st);
                this.tcat.getSelectionModel().select(tcat1);
                
                 this.dob.setValue(LocalDate.parse(dob));
                this.fstappointDate.setValue(LocalDate.parse(fap));
                this.sclappointDate.setValue(LocalDate.parse(sap));
                this.inceDate.setValue(LocalDate.parse(idate));
                
                
                
            }
            
            
            
        } catch (Exception e) {
            System.out.println(e);
        
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

    @FXML
    private void dataUpdate(ActionEvent event) {
        
        try {
        
            String gen="";
            if (male.isSelected()) {
                gen="Male";
            }
            if (female.isSelected()) {
                gen="Female";
            }
            String s2 = tmode1.getSelectionModel().getSelectedItem();
            String s = preClass.getSelectionModel().getSelectedItem();
            String[] ses = s.split(" : ");
            
            ResultSet rs = Db.getData("SELECT * FROM classes WHERE grade='"+ses[0]+"' AND class_name='"+ses[1]+"'  ");
            ResultSet rs2 = Db.getData("SELECT * FROM travel_mode WHERE mode_name='"+s2+"' ");
            ResultSet rs3 = Db.getData("SELECT * FROM teachers_cat WHERE cat_name='"+tcat.getSelectionModel().getSelectedItem()+"' ");
            String cid="";
            String tmode2="";
            String tcat2="";
            if (rs.first()) {
                cid = rs.getString("idClasses");
            }
            if (rs2.first()) {
                tmode2= rs2.getString("idTravel_mode");
            }
            if (rs3.first()) {
                tcat2= rs3.getString("idteachers_cat");
            }
            
            
            
            Db.putData("UPDATE teachers SET Ser_name='"+fname.getText()+"',middle_name='"+mname.getText()+"',last_name='"+lname.getText()+"',dob='"+dob.getValue()+"',gender='"+gen+"',first_appoint_date='"+fstappointDate.getValue()+"',school_appoint_date='"+sclappointDate.getValue()+"',increment_date='"+inceDate.getValue()+"',edu_qualifications='"+eduQulifi.getText()+"',proffesional_qualification='"+profQulifi.getText()+"',street='"+street.getText()+"',city='"+city.getText()+"',tel='"+pTel.getText()+"',spouce_name='"+sFName.getText()+"',s_tel='"+stel.getText()+"',s_occupation='"+sJob.getText()+"',other_deta='"+otherDetails.getText()+"',Classes_idClasses='"+cid+"',Travel_mode_idTravel_mode='"+tmode2+"',service_grade='"+serGrade.getSelectionModel().getSelectedItem()+"',status='1',teachers_cat_idteachers_cat='"+tcat2+"' WHERE nic='"+nic.getText()+"'");
      Alert a=new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK);
                    a.show();
        
        } catch (Exception e) {
            System.out.println(e);
             Alert a=new Alert(Alert.AlertType.ERROR, "Try Again", ButtonType.OK);
                    a.show();
        }
        
    }

    @FXML
    private void tdelete(ActionEvent event) {
        
        try {
         
            
            Db.putData("UPDATE teachers SET status='0', WHERE nic='"+nic.getText()+"'");
            
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK);
                    a.show();
      
        
        } catch (Exception e) {
            System.out.println(e);
            Alert a=new Alert(Alert.AlertType.ERROR, "Try Again", ButtonType.OK);
                    a.show();
        } 
        
    }
    
    
     public void comboLoader() {
        try {
            //Db.getData("SELECT DISTINCT class_name FROM classes");
            Db.getData("SELECT * FROM classes");
            while (Db.rs.next()) {
                list.add(Db.rs.getString("grade")+" : "+Db.rs.getString("class_name"));

            }
            preClass.setItems(list);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
     
     public void comboLoader2() {
        try {
            Db.getData("SELECT * FROM travel_mode");
            while (Db.rs.next()) {
                list2.add(Db.rs.getString("mode_name"));

            }
            tmode1.setItems(list2);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
     
      public void comboLoader3() {
        try {
            Db.getData("SELECT DISTINCT cat_name FROM teachers_cat");
            while (Db.rs.next()) {
                list3.add(Db.rs.getString("cat_name"));

            }
            tcat.setItems(list3);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
      
       public void comboLoader4() {
        try {
            ResultSet rs = Db.getData("SELECT DISTINCT service_grade FROM teachers");
            while (rs.next()) {
                list4.add(rs.getString("service_grade"));

            }
            serGrade.setItems(list4);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
     
     
     
}
