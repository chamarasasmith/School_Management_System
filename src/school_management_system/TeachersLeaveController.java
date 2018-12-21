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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class TeachersLeaveController implements Initializable {

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
    private TextField seach1;
    @FXML
    private TextArea des;
    @FXML
    private ComboBox<String> type;
    @FXML
    private TextField nic;
    @FXML
    private Label name;
    @FXML
    private DatePicker date1;
    @FXML
    private ListView<String> nlist;
    @FXML
    private TableView<TeachersLeavetb> ttable;
    @FXML
    private TableColumn<TeachersLeavetb, String> tnic;
    @FXML
    private TableColumn<TeachersLeavetb, String> tname;
    @FXML
    private TableColumn<TeachersLeavetb, String> ttype;
    @FXML
    private TableColumn<TeachersLeavetb, String> tdate;
    @FXML
    private TableColumn<TeachersLeavetb, String> tdes;

    ObservableList<TeachersLeavetb> tleave;
    
    ObservableList<String> ltype;
    
    ObservableList<String> ttname;
    @FXML
    private Button add;
    @FXML
    private Label subleave;
    @FXML
    private Label allleave;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
        OurDesign.closer=close;
        OurDesign.home=home;
        comboLoader();
    }


    private void comboLoader() {
    
    
        try {
            
            ltype=FXCollections.observableArrayList();
            
            ResultSet rs = Db.getData("SELECT DISTINCT(type1) FROM tleave");
            
            while (rs.next()) {                
                ltype.add(rs.getString(1));
            }
            type.setItems(ltype);
            
            
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
    private void seach(KeyEvent event) {
        
        try {
            System.out.println("eeee");
                ttable.getItems().clear();
             
            ResultSet rs=null;
        
            String s=seach1.getText()+"%";
            
        if (rb1.isSelected()) {
            
                rs=Db.getData("SELECT * FROM tleave WHERE tid LIKE '"+s+"'");
            System.out.println("a");
        }
        if (rb2.isSelected()) {
            
            ResultSet rs3=Db.getData("SELECT * FROM teachers WHERE Ser_name LIKE '"+s+"' OR middle_name LIKE '"+s+"' OR last_name LIKE '"+s+"'");
            
            while (rs3.next()) {                
            
                rs=Db.getData("SELECT * FROM tleave WHERE tid LIKE '"+rs3.getString(1)+"'");
               
            }
            
            
            System.out.println("b");
           // System.out.println(Db.rs.getString(4));
        }
        
            while (rs.next()) {                
             
                    String nic = rs.getString(1);
                    
                    ResultSet rs2=Db.getData("SELECT * FROM teachers WHERE nic='"+nic+"'");
              //  System.out.println(rs.getString(1));
              
                while (rs2.next()) {                    
                      tleave= FXCollections.observableArrayList(
               new TeachersLeavetb(rs.getString(1), rs2.getString(4), rs.getString(3), rs.getString(2), rs.getString(4))
                );
                }
              
              

        tnic.setCellValueFactory(new PropertyValueFactory<>("tnic"));
        tname.setCellValueFactory(new PropertyValueFactory<>("tname"));
        ttype.setCellValueFactory(new PropertyValueFactory<>("ttype"));
        tdate.setCellValueFactory(new PropertyValueFactory<>("tdate"));
        tdes.setCellValueFactory(new PropertyValueFactory<>("tdes"));
         
        ttable.getItems().addAll(tleave); 
      
                          
            }
        
        
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }

    @FXML
    private void addt(ActionEvent event) {
        
        String s = JOptionPane.showInputDialog(null);
        
        ltype.add(s);
        
        type.setItems(ltype);
        
        type.getSelectionModel().select(s);
        
        setCount();
        
    }

    @FXML
    private void setTName(KeyEvent event) {
        
         try {
            
            String s=nic.getText()+"%";
            String s2=nic.getText();
             
            ttname=FXCollections.observableArrayList();
            
            ResultSet rs = Db.getData("SELECT * FROM teachers WHERE nic LIKE '"+s+"'");
            ResultSet rs2 = Db.getData("SELECT * FROM teachers WHERE nic='"+s2+"'");
            
            while (rs.next()) {                
                ttname.add(rs.getString(4));
            }
            
            nlist.setItems(ttname);
            
             if (rs2.first()) {   
                 name.setText(rs2.getString(4));
                 
            }else{
             name.setText(".........................");
             }
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
    }

    @FXML
    private void setNic(MouseEvent event) {
        
        try {
            
             
            String s = nlist.getSelectionModel().getSelectedItem();
           
            
            ResultSet rs = Db.getData("SELECT * FROM teachers WHERE last_name='"+s+"'");
            
            while (rs.next()) {                
                nic.setText(rs.getString(1));
                name.setText(s);
            }
            
            
            
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        
    }

    @FXML
    private void setNic2(KeyEvent event) {
        
        try {
            
             
            String s = nlist.getSelectionModel().getSelectedItem();
           
            
            ResultSet rs = Db.getData("SELECT * FROM teachers WHERE last_name='"+s+"'");
            
            while (rs.next()) {
                name.setText(s);
                nic.setText(rs.getString(1));
            }
            
            
            
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
    }

    @FXML
    private void save(ActionEvent event) {
        
        if (nic.getText().isEmpty() | type.getSelectionModel().getSelectedIndex()==(-1) | date1.getValue()==null ) {
            
          new Alert(Alert.AlertType.ERROR, "Some Feilds are Empty", ButtonType.OK).show();
            
        }else{
        
        
        try {
            
            Db.putData("INSERT INTO tleave VALUES ('"+nic.getText()+"','"+date1.getValue()+"','"+type.getSelectionModel().getSelectedItem()+"','"+des.getText()+"')");
            
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Success!", ButtonType.OK);
            a.show();
            ttable.getItems().clear();
            seach1.clear();
        } catch (Exception e) {
            System.out.println(e);
            Alert a=new Alert(Alert.AlertType.ERROR, "Try Again!", ButtonType.OK);
            a.show();
        }
        
        }
    }

    @FXML
    private void update1(ActionEvent event) {
        
        
        
        try {
            Db.putData("UPDATE tleave SET date1='"+date1.getValue()+"', type1='"+type.getSelectionModel().getSelectedItem()+"', des='"+des.getText()+"' WHERE tid='"+ttable.getSelectionModel().getSelectedItem().getTnic()+"'AND date1='"+ttable.getSelectionModel().getSelectedItem().getTdate()+"' ");
            
            
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Success!", ButtonType.OK);
            a.show();
            ttable.getItems().clear();
            seach1.clear();
        } catch (Exception e) {
            System.out.println(e);
            Alert a=new Alert(Alert.AlertType.ERROR, "Try Again!", ButtonType.OK);
            a.show();
        }
       
        
    }

    @FXML
    private void setValue1(MouseEvent event) {
        
         try {
            
            
            TeachersLeavetb a= ttable.getSelectionModel().getSelectedItem();
            
            nic.setText(a.getTnic());
            name.setText(a.getTname());
            type.getSelectionModel().select(a.getTtype());
            date1.setValue(LocalDate.parse(a.getTdate()));
            des.setText(a.getTdes());
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    @FXML
    private void setValue2(KeyEvent event) {
        
         try {
            
            
            TeachersLeavetb a= ttable.getSelectionModel().getSelectedItem();
            
            nic.setText(a.getTnic());
            name.setText(a.getTname());
            type.getSelectionModel().select(a.getTtype());
            date1.setValue(LocalDate.parse(a.getTdate()));
            des.setText(a.getTdes());
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    @FXML
    private void setcount1(ActionEvent event) {
        
        setCount();
      
    }

    void setCount(){
    
          try {
            
            
              if (date1.getValue()==null | type.getSelectionModel().getSelectedIndex()==(-1)) {
                  
                
                  
              }else{
              
            
            ResultSet rs1 = Db.getData("SELECT COUNT(tid) FROM tleave WHERE tid='"+nic.getText()+"' AND YEAR(date1)='"+date1.getValue()+"'");
            ResultSet rs2 = Db.getData("SELECT COUNT(tid) FROM tleave WHERE tid='"+nic.getText()+"' AND YEAR(date1)='"+date1.getValue()+"' AND type1='"+type.getSelectionModel().getSelectedItem()+"' ");
            
            if (rs1.first()) {
                String s = rs1.getString(1);
                allleave.setText(s);
            }
            
            if (rs2.first()) {
                String s = rs2.getString(1);
                subleave.setText(s);
            }
            
            
              }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    
    }

    @FXML
    private void setcount2(ActionEvent event) {
        
        setCount();
        
    }
    
}
