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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Frank
 */
public class Controlador_Clientes implements Initializable {

    @FXML
    private TextField TXT_Nombre;
    @FXML
    private TextField TXT_Correo;
    @FXML
    private TextField TXT_Telefono;
    @FXML
    private TextField TXT_Edad;
    @FXML
    private TableView<?> Muestra_Todo;
    @FXML
    private TableColumn<?, ?> Colum_Id;
    @FXML
    private TableColumn<?, ?> Colum_Nombre;
    @FXML
    private TableColumn<?, ?> Colum_Correo;
    @FXML
    private TableColumn<?, ?> Colum_Edad;
    @FXML
    private TableColumn<?, ?> Colum_Telefono;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void insertar(){
        try{
        String Nombre_Cliente, Telefono, Email;
        int Edad;
        Nombre_Cliente= TXT_Nombre.getText();
        Telefono=TXT_Telefono.getText();
        Email=TXT_Correo.getText();
        Edad=Integer.parseInt(TXT_Edad.getText());
        if(CRUDS.CRUDCliente.insertar(Nombre_Cliente, Telefono, Email, Edad)){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro Ingresado");
            
            alerta.showAndWait();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro no Ingresado");
            
            alerta.showAndWait();
        }
            }catch(Exception e){
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Revise sus datos: "+e);

                    alerta.showAndWait();
            }
    }
    
    public void modificar(){
        try{
        String Nombre_Cliente, Telefono, Email;
        int Edad;
        Nombre_Cliente= TXT_Nombre.getText();
        Telefono=TXT_Telefono.getText();
        Email=TXT_Correo.getText();
        Edad=Integer.parseInt(TXT_Edad.getText());
        if(CRUDS.CRUDCliente.insertar(Nombre_Cliente, Telefono, Email, Edad)){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro Modificado");
            
            alerta.showAndWait();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro no Modificado");
            
            alerta.showAndWait();
        }
            }catch(Exception e){
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Revise sus datos: "+e);

                    alerta.showAndWait();
            }
    }
}
