/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Angel
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void Abrir_Cliente() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/cliente.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Libros");

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Abrir_Libros() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/libro.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Libros");

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Abrir_Prestamos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/Prestamos.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Prestamos");

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
