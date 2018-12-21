/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Gihan Munasinghe
 */
public class School_Management_System extends Application {

    public static AnchorPane root;
    public static Stage st;

    @Override
    public void start(Stage Stage) {
      //  Font.loadFont(getClass().getResourceAsStream("Font/a.ttf"), 14);
        try {

            st = Stage;
                 root=FXMLLoader.load(getClass().getResource("View1.fxml"));
            // root=FXMLLoader.load(getClass().getResource("Search_student.fxml"));
           // root = FXMLLoader.load(getClass().getResource("Students.fxml"));

            Scene scene = new Scene(root, Color.TRANSPARENT);

            st.initStyle(StageStyle.TRANSPARENT);
            st.setScene(scene);
            st.setMaximized(true);

            st.show();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
