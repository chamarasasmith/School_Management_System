/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.net.URL;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Chamara Sasmith
 */
public class AccountsController implements Initializable {

    @FXML
    private ImageView home;
    @FXML
    private ImageView close;
    @FXML
    private TextField nic;
    @FXML
    private TextField email;
    @FXML
    private PasswordField pw;
    @FXML
    private ComboBox<String> dcom;

    ObservableList<String> tnic;
    @FXML
    private RadioButton limit;
    @FXML
    private ToggleGroup a;
    @FXML
    private RadioButton admin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OurDesign.closer = close;
        OurDesign.home = home;
        comboLoader();

    }

    private void comboLoader() {

        try {

            tnic = FXCollections.observableArrayList();

            ResultSet rs = Db.getData("SELECT * FROM login");

            while (rs.next()) {
                tnic.add(rs.getString(4));
            }
            dcom.setItems(tnic);

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
    private void add(ActionEvent event) {

        try {

            String type2 = "";

            if (admin.isSelected()) {
                type2 = "Admin";
            }
            if (limit.isSelected()) {
                type2 = "Limit";
            }

            Db.putData("INSERT INTO login (password,email,status,Teachers_nic) VALUES ('" + pw.getText() + "','" + email.getText() + "','" + type2 + "','" + nic.getText() + "') ");
            new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK).show();
            comboLoader();
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Check Value and Try Again", ButtonType.OK).show();
        }

    }

    @FXML
    private void delete(ActionEvent event) {

        try {

            
            
            if (LoginController.type1.equalsIgnoreCase("Admin")) {

                if (dcom.getSelectionModel().getSelectedIndex()==(-1)) {
                 
                    new Alert(Alert.AlertType.WARNING, "Select NIC", ButtonType.OK).show();
                    
                }else{
                
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure?", ButtonType.NO, ButtonType.OK);
                Optional<ButtonType> o = alert.showAndWait();

                if (o.get() == ButtonType.OK) {

                    Db.putData("DELETE FROM login WHERE Teachers_nic='" + dcom.getSelectionModel().getSelectedItem() + "'");

                    new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK).show();
                    comboLoader();

                } else {

                }

                }
                
            } else {
                new Alert(Alert.AlertType.WARNING, "You have not Access", ButtonType.OK).show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Try Again", ButtonType.OK).show();
        }

    }

    @FXML
    private void check(ActionEvent event) {

        if (LoginController.type1.equalsIgnoreCase("Admin")) {

        } else {
            new Alert(Alert.AlertType.WARNING, "You have not Access", ButtonType.OK).show();
            admin.setSelected(false);
            limit.setSelected(true);
        }

    }

    @FXML
    private void showpw(ActionEvent event) {

        if (LoginController.type1.equalsIgnoreCase("Admin")) {

            try {
                
                if (dcom.getSelectionModel().getSelectedIndex()==(-1)) {
                 
                    new Alert(Alert.AlertType.WARNING, "Select NIC", ButtonType.OK).show();
                    
                }else{
                
                ResultSet data = Db.getData("SELECT * FROM login WHERE Teachers_nic='"+dcom.getSelectionModel().getSelectedItem()+"'");
             String pwd="";
                if (data.first()) {
                    pwd=data.getString("password");
                }
                
                new Alert(Alert.AlertType.INFORMATION, "Password is " + pwd, ButtonType.OK).show();
                
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else {
            new Alert(Alert.AlertType.WARNING, "You have not Access", ButtonType.OK).show();

        }

    }

}
