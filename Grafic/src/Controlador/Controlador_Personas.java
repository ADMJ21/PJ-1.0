/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Frank
 */
public class Controlador_Personas implements Initializable {

    @FXML
    private TextField TXT_Fecha;
    @FXML
    private TextField TXT_Clave;
    @FXML
    private TableView<?> Muestra_Todo;
    @FXML
    private TableColumn<?, ?> Colum_Id;
    @FXML
    private TableColumn<?, ?> Colum_Cliente;
    @FXML
    private TableColumn<?, ?> Colum_Libro;
    @FXML
    private TableColumn<?, ?> Colum_Fecha;
    @FXML
    private TableColumn<?, ?> Colum_Clave;
    @FXML
    private ComboBox<?> Combo_Cliente;
    @FXML
    private ComboBox<?> Combo_Libro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
