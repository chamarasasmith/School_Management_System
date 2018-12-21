/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import static school_management_system.LoadFXML.ap;
import static school_management_system.LoadFXML.view1;

/**
 * FXML Controller class
 *
 * @author Gihan Munasinghe
 */
public class SearchStudentsController implements Initializable {

    @FXML
    private SplitPane sp0;
    @FXML
    private ImageView close;
    @FXML
    private TableView<studentstb> stable;
    @FXML
    private TableColumn<studentstb, String> sid;

    @FXML
    private TableColumn<studentstb, String> adm;
    @FXML
    private TableColumn<studentstb, String> clz;
    @FXML
    private TableColumn<studentstb, String> con;
    @FXML
    private TableColumn<studentstb, String> status;
    @FXML
    private TableColumn<studentstb, String> passout;

    ObservableList<studentstb> students;
    @FXML
    private TextField text1;
    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb2;
    @FXML
    private ImageView home;
    @FXML
    private TableColumn<studentstb, String> surname;
    @FXML
    private TableColumn<studentstb, String> middle;
    @FXML
    private TableColumn<studentstb, String> lname;
    @FXML
    private TableColumn<studentstb, String> gender;
    @FXML
    private RadioButton rb0;

    int i = 0;
    int i2 = 0;
    @FXML
    private ToggleGroup a1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OurDesign.closer = close;
        OurDesign.home = home;
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
    private void search1(MouseEvent event) {
        try {

            stable.getItems().clear();
            
            ResultSet rs = null;

            if (rb0.isSelected()) {

                rs = Db.getData("SELECT * FROM students");
                System.out.println("0");
            }

            if (rb2.isSelected()) {

                rs = Db.getData("SELECT * FROM students WHERE index_no='" + text1.getText().toString() + "'");
                System.out.println("a");
            }
            if (rb1.isSelected()) {
                rs = Db.getData("SELECT * FROM students WHERE Ser_name='" + text1.getText() + "'OR middle_name='"+text1.getText()+"' OR last_name='"+text1.getText()+"'");
                System.out.println("b");
            }

            while (rs.next()) {

                String cid = rs.getString("Classes_idClasses");
                ResultSet rs1 = Db.getData("SELECT * FROM classes WHERE idClasses='"+cid+"'");
                String cname="";
                String grad="";
                if (rs1.first()) {
                    cname=rs1.getString("class_name");
                    grad=rs1.getString("grade");
                }
                
                students = FXCollections.observableArrayList(
                        new studentstb(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6),rs.getString(8), rs.getString(11) + " / " + rs.getString(14), grad+" : "+cname, rs.getString(21), rs.getString(7))
                );

                
                sid.setCellValueFactory(new PropertyValueFactory<>("sid"));
                surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
                middle.setCellValueFactory(new PropertyValueFactory<>("middle"));
                lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
                gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
                adm.setCellValueFactory(new PropertyValueFactory<>("adm"));
                con.setCellValueFactory(new PropertyValueFactory<>("con"));
                clz.setCellValueFactory(new PropertyValueFactory<>("clz"));
                status.setCellValueFactory(new PropertyValueFactory<>("status"));
                passout.setCellValueFactory(new PropertyValueFactory<>("passout"));
                stable.getItems().addAll(students);

            }

        } catch (Exception ex) {
            System.out.println(ex);
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
    private void goDetails(MouseEvent event) {

        try {

            int f = stable.getSelectionModel().getFocusedIndex();

            if (i2 == f) {
                i++;
            } else {
                i = 0;
                i2 = stable.getSelectionModel().getFocusedIndex();
            }

            if (i == 1) {

                i = 0;

                String c = stable.getItems().get(f).getSid();
                System.out.println(c);

                FXMLLoader loader = new FXMLLoader(School_Management_System.class.getResource("StudentsDetails.fxml"));

                StudentsDetailsController controller = new StudentsDetailsController(c);
                loader.setController(controller);

                AnchorPane ap = loader.load();

                view1.setTopAnchor(ap, 0.0);
            view1.setBottomAnchor(ap, 0.0);
            view1.setLeftAnchor(ap, 0.0);
            view1.setRightAnchor(ap, 0.0);

            view1.getChildren().clear();
            view1.getChildren().add(ap);

            ScaleTransition st = new ScaleTransition(Duration.millis(250));
            st.setNode(ap);

            st.setFromX(0);
            st.setFromY(0);
            st.setToX(1);
            st.setToY(1);

            st.play();
            }
        } catch (IOException ex) {

            System.out.println(ex);
        }

    }


}
