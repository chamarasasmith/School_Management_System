/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Chamara Sasmith
 */
public class View1Controller implements Initializable {

    @FXML
    private AnchorPane mview;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      LoadFXML.view1=mview;
      //LoadFXML.setFXML("Main1.fxml");
      LoadFXML.setFXML("Login.fxml");
    }    
    
}
