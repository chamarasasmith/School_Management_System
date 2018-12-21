/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import cs.CSBackup;
import java.io.File;
import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Gihan Munasinghe
 */
public class OurDesign {

    static ImageView closer;
    static ImageView home;

    public static void closeButton(String event) {

        if (event.equalsIgnoreCase("close")) {
            try {

                CSBackup.Backup("school_db", "root", "123", "3306", "localhost", "D:\\School_DB\\DB\\", "DB");
                CSBackup.Backup("school_db", "root", "123", "3306", "localhost", "D:\\School_DB\\Backup\\");

            } catch (Exception e) {
                System.out.println(e);
            }

            System.exit(0);
        }
        if (event.equalsIgnoreCase("enter")) {

            //File file = new File("src/img/2.png");
            URL url = School_Management_System.class.getResource("/img/2.png");
            // Image image = new Image(file.toURI().toString());
            // System.out.println(url);
            Image image = new Image(url.toString());
            closer.setImage(image);

        }
        if (event.equalsIgnoreCase("exit")) {
            File file = new File("src/img/1.png");

            Image image = new Image(file.toURI().toString());
            closer.setImage(image);

        }

    }

    public static void homeButton(String event) {

        if (event.equalsIgnoreCase("homeen")) {
            File file = new File("src/img/home2.png");
            Image image = new Image(file.toURI().toString());
            home.setImage(image);

        }
        if (event.equalsIgnoreCase("homeex")) {
            File file = new File("src/img/home1.png");
            Image image = new Image(file.toURI().toString());
            home.setImage(image);

        }

    }

}
