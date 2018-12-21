/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Gihan Munasinghe
 */
public class TeachersController implements Initializable {

    @FXML
    private SplitPane sp1;
    @FXML
    private ToggleGroup a;
    @FXML
    private SplitPane sp2;
    @FXML
    private SplitPane sp0;
    @FXML
    private ImageView close;
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
    private TextField sMname;
    @FXML
    private TextField sLName;
    @FXML
    private TextField sJob;
    @FXML
    private TextField stel;
    
   
    @FXML
    private TextArea otherDetails;
    
ObservableList<String> serviceGrades=FXCollections.observableArrayList("I","2-I","2-II","3-I","3-II","other"); 
   ObservableList<String> teacherClass=FXCollections.observableArrayList(); 
     ObservableList<String> teacherCat=FXCollections.observableArrayList(); 
      ObservableList<String> ttravel=FXCollections.observableArrayList(); 
    @FXML
    private ImageView home;
    @FXML
    private Label NotFillerror;
    @FXML
    private ComboBox<String> tcat;
    @FXML
    private ComboBox<String> tmode1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OurDesign.closer=close;
        OurDesign.home=home;
        comboLoader();
       
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

    
    
    private void comboLoader() {
    serGrade.setItems(serviceGrades);

        try {
            Db.getData("select * from classes ");
            
            while(Db.rs.next()){
            
                String sclasses=Db.rs.getString("grade")+" -: "+Db.rs.getString("class_name");
            
                teacherClass.add(sclasses);
            }
            
            preClass.setItems(teacherClass);
            
            
         Db.getData("select * from teachers_cat");
            
         while(Db.rs.next()){
         
            String cat=Db.rs.getString("cat_name");
         
        teacherCat.add(cat);
         } 
         
          tcat.setItems(teacherCat);
         
          
        Db.getData("select * from travel_mode"); 
           while(Db.rs.next()){
         
            String trvel=Db.rs.getString("mode_name");
         
        ttravel.add(trvel);
         } 
         
           tmode1.setItems(ttravel);
        
            
        } catch (Exception e) {
            System.out.println(e);}

    }

    @FXML
    private void datasave(ActionEvent event) {
        
      //check field
        if(fieldChecker()){
        
           //check databse is it saved Okkk
        if(dataSetter()){
         System.out.println("Saved Okk");
         
              Alert a=new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK);
                    a.show();
                    
                    clearAll();
        
        }else{
               Alert a=new Alert(Alert.AlertType.WARNING, "No Data Insert try Again", ButtonType.OK);
                    a.show();
        }
         // any is filed empty
        }else{
        
        Alert a=new Alert(Alert.AlertType.ERROR, "Some Important Feilds are Empty", ButtonType.OK);
                    a.show();
        
        }
        
       
       
        
     
        
        
    }



    private boolean dataSetter() {

        String gender=null;
        if(male.isSelected()){gender="Male";}
        if(female.isSelected()){gender="Female";}
        
       
     
      
        int classRow=preClass.getSelectionModel().getSelectedIndex();
   
        
        

String[] ss=preClass.getSelectionModel().getSelectedItem().split("-: ");
        System.out.println(ss[0]);
        System.out.println(ss[1]);

String tclassId=null;
String ttravelId=null;
String tcatId=null;
        try {
      
     Db.getData("select * from classes where class_name='"+ss[1]+"' and grade='"+ss[0]+"' ");
      while(Db.rs.next()){
      
      tclassId=Db.rs.getString("idClasses");
          System.out.println(tclassId);
      }      
            
      Db.getData("select * from travel_mode where mode_name='"+tmode1.getSelectionModel().getSelectedItem()+"'");
      while(Db.rs.next()){
      
      ttravelId=Db.rs.getString("idTravel_mode");
      }
        
      Db.getData("select * from teachers_cat where cat_name='"+tcat.getSelectionModel().getSelectedItem()+"'");
      while(Db.rs.next()){
      
      tcatId=Db.rs.getString("idteachers_cat");
      }
      
      String teaOdeatils="No Other Details";
      if(!(otherDetails.getText().isEmpty())){
      teaOdeatils=otherDetails.getText();
      }
      
      String teaeduqlifi="No Education Qulifications";
      if(!(eduQulifi.getText().isEmpty())){
      teaeduqlifi=eduQulifi.getText();
      
      }
      
      String teaprofqlifi="No proffessional Qulifications";
      if(!(profQulifi.getText().isEmpty())){
      
          teaprofqlifi=profQulifi.getText();
      }
      
          String spouceName="No Spouce";
            String ssjob="No Job";
            String sptel="No Tel";
      
      if(sFName.getText().isEmpty()&&sMname.getText().isEmpty()
              &&sLName.getText().isEmpty()&&sJob.getText().isEmpty()&&stel.getText().isEmpty()){
      
         
          ssjob="No Spouce";
          sptel="No Spouce";
      
      }else{
      
          if(!(sJob.getText().isEmpty())){ ssjob=sJob.getText(); }
          if(!(stel.getText().isEmpty())){ sptel=stel.getText();}
          if(!(sFName.getText().isEmpty())){ spouceName=sFName.getText();}
          if(!(sMname.getText().isEmpty())){ spouceName=spouceName+" "+sMname.getText();}
          if(!(sLName.getText().isEmpty())){ spouceName=spouceName+" "+sLName.getText();}
      
          
      
      }
      
        
           
      
      
      
      
            String sql="INSERT INTO teachers(nic,Ser_name,middle_name,last_name,dob,gender,first_appoint_date,school_appoint_date,increment_date,edu_qualifications,proffesional_qualification,street,city,tel,spouce_name,s_tel,s_occupation,other_deta,Classes_idClasses,Travel_mode_idTravel_mode,service_grade,status,teachers_cat_idteachers_cat)VALUES ('"+nic.getText()+"','"+fname.getText()+"','"+mname.getText()+"','"+lname.getText()+"','"+dob.getValue()+"','"+gender+"','"+fstappointDate.getValue()+"','"+sclappointDate.getValue()+"','"+inceDate.getValue()+"','"+teaeduqlifi+"','"+teaprofqlifi+"','"+street.getText()+"','"+city.getText()+"','"+pTel.getText()+"','"+spouceName+"','"+sptel+"','"+ssjob+"','"+teaOdeatils+"','"+tclassId+"','"+ttravelId+"','"+serGrade.getSelectionModel().getSelectedItem()+"','1','"+tcatId+"')";
            
            
            Db.putData(sql);
           return true;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        
    }

    private boolean fieldChecker() {
       
        ArrayList<String> al=new ArrayList();
        boolean status=true;
        //check fields
        if(nic.getText().isEmpty()){al.add("nic"); status=false;}
        if(fname.getText().isEmpty()){al.add("fname");status=false;}
        if(mname.getText().isEmpty()){al.add("mname");status=false;}
        if(lname.getText().isEmpty()){al.add("lname");status=false;}
        if(dob.getValue() == null){al.add("dob");status=false;}
        if(street.getText().isEmpty()){al.add("street");status=false;}
        if(city.getText().isEmpty()){al.add("city");status=false;}
        if(fstappointDate.getValue()==null){al.add("First Appointed Date");status=false;}
        if(sclappointDate.getValue()==null){al.add("School Appointed Date");status=false;}
        if(inceDate.getValue()==null){al.add("Salary Increment Date");status=false;}
        if(tcat.getSelectionModel().isEmpty()){al.add("tcat");status=false;}
        if(tmode1.getSelectionModel().isEmpty()){al.add("travel mode");status=false;}
        if(serGrade.getSelectionModel().isEmpty()){al.add("Service grade");status=false;}
        
        //=========== ending
        
        for (String fieldname : al) {
            
            System.out.println(al);
        }
        
        
        return status;
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
   private void clearAll() {
        
fname.clear();
mname.clear();
lname.clear();
 street.clear();
 city.clear();
pTel.clear();
nic.clear();
eduQulifi.clear();
profQulifi.clear();
sFName.clear();
sMname.clear();
sLName.clear();
sJob.clear();
stel.clear();
    }
    
    
}
