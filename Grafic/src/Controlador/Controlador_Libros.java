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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Frank
 */
public class Controlador_Libros implements Initializable {

    @FXML
    private TextField TXT_Nombre;
    @FXML
    private TextField TXT_Genero;
    @FXML
    private TextField TXT_Categoria;
    @FXML
    private TableView<?> Muestra_Todo;
    @FXML
    private TableColumn<?, ?> Colum_Id;
    @FXML
    private TableColumn<?, ?> Colum_Nombre;
    @FXML
    private TableColumn<?, ?> Colum_Genero;
    @FXML
    private TableColumn<?, ?> Colum_Categoria;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
