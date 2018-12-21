/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

/**
 *
 * @author Gihan Munasinghe
 */
public class teacherstb {
    
    @FXML
    final private StringProperty nic;
    @FXML
    final private StringProperty fname;
    @FXML
    final private StringProperty middle;
    @FXML
    final private StringProperty surname;
    @FXML
    final private StringProperty gender;
    @FXML
    final private StringProperty fappoint;
    
    @FXML
    final private StringProperty con;
    @FXML
    final private StringProperty status;
     

    public teacherstb(String nic, String fname, String middle, String surname, String gender, String fappoint, String con, String status) {
        this.nic = new SimpleStringProperty(nic);
        this.fname = new SimpleStringProperty(fname);
        this.middle = new SimpleStringProperty(middle);
        this.surname = new SimpleStringProperty(surname);
        this.gender = new SimpleStringProperty(gender);
        this.fappoint = new SimpleStringProperty(fappoint);
        this.con = new SimpleStringProperty(con);
        this.status = new SimpleStringProperty(status);
         
        
        
    }

    public String getNic() {
        return nic.get();
    }

    public String getFname() {
        return fname.get();
    }

    public String getMiddle() {
        return middle.get();
    }

    public String getSurname() {
        return surname.get();
    }

    public String getGender() {
        return gender.get();
    }

    public String getFappoint() {
        return fappoint.get();
    }

    public String getCon() {
        return con.get();
    }

    public String getStatus() {
        return status.get();
    }

     
    
    
}
