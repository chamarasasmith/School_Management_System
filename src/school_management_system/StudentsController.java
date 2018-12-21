/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author Gihan Munasinghe
 */
public class StudentsController implements Initializable {

    @FXML
    private SplitPane sp0;
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
    @FXML
    private DatePicker admiDate;

    ObservableList<String> list = FXCollections.observableArrayList();
    ObservableList<String> list1 = FXCollections.observableArrayList("1", "2", "3", "4", "5");
    ObservableList<String> list2 = FXCollections.observableArrayList();

    private Stage primaryStage;
    @FXML
    private ImageView home;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        OurDesign.closer = close;
        OurDesign.home=home;
        
//        CSvalidator v = new CSvalidator();
//        v.onlyAlphabet(fname);
//        v.onlyLimitedChar(fatherTel, 10);
//        v.onlyLimitedChar(motherTel, 10);
//        v.onlyNumber(fatherTel);
//        v.onlyNumber(motherTel);
        
        comboLoader();
        comboLoader2();
        gradeCombo.setItems(list1);
        

        try {
            String nn = Db.getIndex();
            if (nn != null) {
                indexNo.setText(nn);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        SplitPane.Divider get = sp1.getDividers().get(0);
        get.positionProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                get.setPosition(0.29);

            }
        });

        SplitPane.Divider get1 = sp2.getDividers().get(0);
        get1.positionProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                get1.setPosition(0.5);

            }
        });

        SplitPane.Divider get2 = sp0.getDividers().get(0);
        get2.positionProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                get2.setPosition(0.15);

            }
        });

       
        
        
    
    
    
    
    
    
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
    private void save(ActionEvent event) {

   
        if(!(indexNo.getText().isEmpty())&&!(fname.getText().isEmpty())&&!(mname.getText().isEmpty())&&
                !(lname.getText().isEmpty())&&!(dob.getValue()==null)&&!(street.getText().isEmpty())&&
                !(city.getText().isEmpty())&&!(fatherName.getText().isEmpty())&&!(fatherTel.getText().isEmpty())&&
                !(fatherTel.getText().isEmpty())&&!(motherName.getText().isEmpty())&&!(motherTel.getText().isEmpty())&&
                !(motherJob.getText().isEmpty())&&!(gradeCombo.getSelectionModel().isEmpty())&&!(classCombo.getSelectionModel().isEmpty())&&
                !(admiDate.getValue()==null)){
        
        try {
            
            Db.getData("SELECT * FROM classes WHERE class_name='"+classCombo.getSelectionModel().getSelectedItem()+"' AND grade='"+gradeCombo.getSelectionModel().getSelectedItem()+"'");
            
            
            String idclass="";
            
            while(Db.rs.next()){
                   
                   idclass=Db.rs.getString("idClasses");
                   }
            
           String gen="";
           
           if(male.isSelected()){gen="Male";}
           if(female.isSelected()){gen="Female";}
            
           Db.getData("SELECT * FROM travel_mode WHERE mode_name='"+tModeCombo.getSelectionModel().getSelectedItem()+"'");
           
           String travelmode="";
           while(Db.rs.next()){
                   
                   travelmode=Db.rs.getString("idTravel_mode");
                   
                   }
           
           String stuskills="No Skills";
           if(!(skills.getText().isEmpty())){
           
               stuskills=skills.getText();
           }
           
           String studetails="No Details";
           if(!(details.getText().isEmpty())){
           
               studetails=details.getText();
           }
           
           
           
            Db.putData("INSERT INTO students(index_no,Ser_name,middle_name,last_name,dob,gender,Pass_out_date,admission_date,father_name,f_occupation,f_tel,mother_name,m_occupation,m_tel,street,city,special_skills,other_details,Classes_idClasses,Travel_mode_idTravel_mode,status)VALUES ('"+indexNo.getText()+"','"+fname.getText()+"','"+mname.getText()+"','"+lname.getText()+"','"+dob.getValue()+"','"+gen+"','"+passOutdate()+"','"+admiDate.getValue()+"','"+fatherName.getText()+"','"+fatherJob.getText()+"','"+fatherTel.getText()+"','"+motherName.getText()+"','"+motherJob.getText()+"','"+motherTel.getText()+"','"+street.getText()+"','"+city.getText()+"','"+stuskills+"','"+studetails+"','"+idclass+"','"+travelmode+"','1');");
            System.out.println("okkkkkkkkk");
             Alert a=new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK);
                    a.show();
                    
                    clearAll();
            
            
        } catch (Exception ex) {
            System.out.println(ex);
            
             Alert a=new Alert(Alert.AlertType.ERROR, "Try Again", ButtonType.OK);
                    a.show();
        }
        
        
        }else{//some filels are null
        
         Alert a=new Alert(Alert.AlertType.ERROR, "Some Important Feilds are Empty", ButtonType.OK);
                    a.show();
        
        }

        
        
    }


    public LocalDate passOutdate() {
int f=0;
        int i = new Integer(gradeCombo.getSelectionModel().getSelectedItem());
         System.out.println(i);
        if (i == 1) {  f = 4;}
        if (i == 2) {f = 3;}
        if (i == 3) {f = 2;}
        if (i == 4) {f = 1;}
        if (i == 5) {f = 0;}

        return admiDate.getValue().plusYears(f).withMonth(12).withDayOfMonth(31);

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

    @FXML
    private void setHome(MouseEvent event) {
        
      LoadFXML.setFXML("Main1.fxml");
    }

    @FXML
    private void homeex(MouseEvent event) {
        OurDesign.homeButton("homeex");
    }

    @FXML
    private void homeen(MouseEvent event) {
        OurDesign.homeButton("homeen");
    }


    private void clearAll() {
        
fname.clear();
mname.clear();
lname.clear();
 street.clear();
 city.clear();
 indexNo.clear();
fatherName.clear();
fatherTel.clear();
fatherJob.clear();
 motherTel.clear();
motherName.clear();
motherJob.clear();
skills.clear();
details.clear();

    }

   

}
