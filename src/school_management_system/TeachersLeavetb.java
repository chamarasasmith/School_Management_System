/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

/**
 *
 * @author Admin
 */
public class TeachersLeavetb {
    
    
    private SimpleStringProperty tnic;
    @FXML
    private  SimpleStringProperty tname;
    @FXML
    private  SimpleStringProperty ttype;
    @FXML
    private SimpleStringProperty tdate;
    @FXML
    private  SimpleStringProperty tdes;

    public TeachersLeavetb(String tnic, String tname, String ttype, String tdate, String tdes) {
        this.tnic = new SimpleStringProperty(tnic);
        this.tname = new SimpleStringProperty(tname);
        this.ttype = new SimpleStringProperty(ttype);
        this.tdate = new SimpleStringProperty(tdate);
        this.tdes = new SimpleStringProperty(tdes);
    }

    public String getTnic() {
        return tnic.get();
    }

    public String getTname() {
        return tname.get();
    }

    public String getTtype() {
        return ttype.get();
    }

    public String getTdate() {
        return tdate.get();
    }

    public String getTdes() {
        return tdes.get();
    }
    
    
    
    
    
    
}
