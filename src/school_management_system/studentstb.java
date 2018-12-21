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
public class studentstb {
    
    
    final private StringProperty sid;
    @FXML
    final private StringProperty surname;
    @FXML
    final private StringProperty middle;
    @FXML
    final private StringProperty lname;
    @FXML
    final private StringProperty gender;
    @FXML
    final private StringProperty adm;
    @FXML
    final private StringProperty con;
    @FXML
    final private StringProperty clz;
    @FXML
    final private StringProperty status;
    @FXML
    final private StringProperty passout;

    public studentstb(String sid, String surname, String middle, String lname, String gender, String adm, String con, String clz, String status, String passout) {
        this.sid = new SimpleStringProperty(sid);
        this.surname = new SimpleStringProperty(surname);
        this.middle = new SimpleStringProperty(middle);
        this.lname = new SimpleStringProperty(lname);
        this.gender = new SimpleStringProperty(gender);
        this.adm = new SimpleStringProperty(adm);
        this.con = new SimpleStringProperty(con);
        this.clz = new SimpleStringProperty(clz);
        this.status = new SimpleStringProperty(status);
        this.passout = new SimpleStringProperty(passout);
    }

    public String getSid() {
        return sid.get();
    }

    public String getSurname() {
        return surname.get();
    }

    public String getMiddle() {
        return middle.get();
    }

    public String getLname() {
        return lname.get();
    }

    public String getGender() {
        return gender.get();
    }

    public String getAdm() {
        return adm.get();
    }

    public String getCon() {
        return con.get();
    }

    public String getClz() {
        return clz.get();
    }

    public String getStatus() {
        return status.get();
    }

    public String getPassout() {
        return passout.get();
    }

     
    
    
    
}
