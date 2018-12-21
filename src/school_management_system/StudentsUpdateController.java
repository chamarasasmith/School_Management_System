/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
 * @author Gihan Munasinghe
 */
public class StudentsUpdateController implements Initializable {

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
    private TextField indexNo;
    @FXML
    private DatePicker admiDate;
    @FXML
    private SplitPane sp2;
    @FXML
    private ComboBox<String> tModeCombo;
    @FXML
    private TextField fatherName;
    @FXML
    private TextField fatherTel;
    @FXML
    private TextField fatherJob;
    @FXML
    private TextField motherTel;
    @FXML
    private TextField motherName;
    @FXML
    private TextField motherJob;
    @FXML
    private ComboBox<String> gradeCombo;
    @FXML
    private ComboBox<String> classCombo;
    @FXML
    private TextArea skills;
    @FXML
    private TextArea details;

    ObservableList<String> list = FXCollections.observableArrayList();
    ObservableList<String> list1 = FXCollections.observableArrayList("1", "2", "3", "4", "5");
    ObservableList<String> list2 = FXCollections.observableArrayList();

    
    
   String sid1;
    
    StudentsUpdateController(String text) {
       
        sid1=text;
        
       
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OurDesign.closer = close;
       OurDesign.home=home;
        
        comboLoader();
        comboLoader2();
        gradeCombo.setItems(list1);
       
        setDetails();
        
        
    } 
    
    
    
    private void setDetails(){
    
    
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
                
                
                this.indexNo.setText(sid);
                this.fname.setText(sname);
                this.mname.setText(mname);
                this.lname.setText(lname);
                
                
            if (gen.equalsIgnoreCase("Male")) {
                male.setSelected(true);
                female.setSelected(false);
            }
            if (gen.equalsIgnoreCase("Female")) {
                male.setSelected(false);
                female.setSelected(true);
            }
                
                
             //   this.gen.setText(gen);
                //this..setText(pass);
                
                
               
                this.fatherName.setText(faname);
                this.fatherJob.setText(faocu);
                this.fatherTel.setText(fatel);
                this.motherName.setText(maname);
                this.motherJob.setText(maocu);
                this.motherTel.setText(matel);
                this.street.setText(street);
                this.city.setText(city);
                this.skills.setText(skil);
                this.details.setText(odet);
                this.classCombo.getSelectionModel().select(cname);
                this.tModeCombo.getSelectionModel().select(trmode);
                this.gradeCombo.getSelectionModel().select(grad);
                //this.st.setText(st);
               
                this.dob.setValue(LocalDate.parse(dob));
                 this.admiDate.setValue(LocalDate.parse(adm));
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

    @FXML
    private void update1(ActionEvent event) {
        
         try {
        
        String gen="";
            if (male.isSelected()) {
                gen="Male";
            }
            if (female.isSelected()) {
                gen="Female";
            }
            
            
       
                ResultSet rs1 = Db.getData("SELECT * FROM classes WHERE class_name='"+classCombo.getSelectionModel().getSelectedItem()+"' AND grade='"+gradeCombo.getSelectionModel().getSelectedItem()+"'");
                ResultSet rs2 = Db.getData("SELECT * FROM travel_mode WHERE mode_name='"+tModeCombo.getSelectionModel().getSelectedItem()+"'");
                String cid1="";
                String trid="";
                if (rs1.first()) {
                    cid1=rs1.getString(1);
                    
                }
                if (rs2.first()) {
                    trid=rs2.getString(1);
                    
                }
            
        
        String sql="UPDATE students SET Ser_name='"+fname.getText()+"',middle_name='"+mname.getText()+"',last_name='"+lname.getText()+"',dob='"+dob.getValue()+"',gender='"+gen+"',admission_date='"+admiDate.getValue()+"',father_name='"+fatherName.getText()+"',f_occupation='"+fatherJob.getText()+"',f_tel='"+fatherTel.getText()+"',mother_name='"+motherName.getText()+"',m_occupation='"+motherJob.getText()+"',m_tel='"+motherTel.getText()+"',street='"+street.getText()+"',city='"+city.getText()+"',special_skills='"+skills.getText()+"',other_details ='"+details.getText()+"',Classes_idClasses='"+cid1+"',Travel_mode_idTravel_mode='"+trid+"',status='1' WHERE index_no='"+indexNo.getText()+"'";
        
       
            Db.putData(sql);
            
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK);
                    a.show();
        } catch (Exception e) {
            System.out.println(e);
            
            Alert a=new Alert(Alert.AlertType.ERROR, "Try Again", ButtonType.OK);
                    a.show();
        }
    }

    @FXML
    private void delete1(ActionEvent event) {
        
       
        
        String sql="Delete from students WHERE index_no='"+indexNo.getText()+"'";
        
        try {
            Db.putData(sql);
            
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK);
                    a.show();
        } catch (Exception e) {
            System.out.println(e);
            
            Alert a=new Alert(Alert.AlertType.ERROR, "Try Again", ButtonType.OK);
                    a.show();
        }
        
    }
    
    
    public void comboLoader2() {
        try {
            Db.getData("SELECT * FROM travel_mode");
            while (Db.rs.next()) {
                list2.add(Db.rs.getString("mode_name"));

            }
            tModeCombo.setItems(list2);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void comboLoader() {
        try {
            Db.getData("SELECT DISTINCT class_name FROM classes");
            while (Db.rs.next()) {
                list.add(Db.rs.getString("class_name"));

            }
            classCombo.setItems(list);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
}
