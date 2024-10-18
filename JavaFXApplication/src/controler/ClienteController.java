/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Angel
 */
public class ClienteController implements Initializable {

    @FXML
    private TextField TXT_Nombre;
    @FXML
    private TextField TXT_Edad;
    @FXML
    private TextField TXT_Correo;
    @FXML
    private TextField TXT_Telefono;
    @FXML
    private TableView<?> Mostrar_Todo;
    @FXML
    private TableColumn<?, ?> Colum_Id;
    @FXML
    private TableColumn<?, ?> Colum_Nombre;
    @FXML
    private TableColumn<?, ?> Colum_elefono;
    @FXML
    private TableColumn<?, ?> Colum_Correo;
    @FXML
    private TableColumn<?, ?> Colum_Edad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Abrir_Cliente(ActionEvent event) {
    }
    
}
