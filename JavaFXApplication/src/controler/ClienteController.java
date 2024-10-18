/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.cliente;

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
    private TableView<cliente> Mostrar_Todo;
    @FXML
    private TableColumn<?, ?> Colum_Id;
    @FXML
    private TableColumn<?, ?> Colum_Nombre;
    @FXML
    private TableColumn<?, ?> Colum_Telefono;
    @FXML
    private TableColumn<?, ?> Colum_Correo;
    @FXML
    private TableColumn<?, ?> Colum_Edad;
    
    private ObservableList<cliente> listcliente;
    private Integer idPersona;
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar();
    }

    public void limpiar(){
    TXT_Nombre.setText("");
    TXT_Correo.setText("");
    TXT_Telefono.setText("");
    TXT_Edad.setText("");

}
    
    public void mostrar(){
        listcliente=FXCollections.observableArrayList();
        for(Iterator it = CRUDS.CRUDCliente.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            listcliente.add(new cliente((Integer) item[0], (String) item[1],(String) item[2], (String) item[3], (Integer) item[4]));
            //Se mantiene los valores que se encuentran en CRUDS, en Universo
        }
        this.Colum_Id.setCellValueFactory(new PropertyValueFactory("idCliente"));
        this.Colum_Nombre.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
        this.Colum_Telefono.setCellValueFactory(new PropertyValueFactory("telefonoCliente"));
        this.Colum_Correo.setCellValueFactory(new PropertyValueFactory("emailCliente"));
        this.Colum_Edad.setCellValueFactory(new PropertyValueFactory("edad"));
            Mostrar_Todo.setItems(listcliente);
    }
    
    @FXML
    private void Selecionar_Datos(MouseEvent event) {
        cliente c=this.Mostrar_Todo.getSelectionModel().getSelectedItem();
        idPersona=c.getIdCliente();
        TXT_Nombre.setText(c.getNombreCliente()+"");
        TXT_Telefono.setText(c.getTelefonoCliente()+"");
        TXT_Correo.setText(c.getEmailCliente()+"");
        TXT_Edad.setText(c.getEdad()+"");
    }
    
    @FXML
    public void insertar(){
        try{
        String nombre, telefono, correo;
        int edad;
        nombre= TXT_Nombre.getText();
        telefono=TXT_Telefono.getText();
        correo=TXT_Correo.getText();
        edad=Integer.parseInt(TXT_Edad.getText());
        if(CRUDS.CRUDCliente.insertar(nombre, telefono, correo, edad)){
            mostrar();
            limpiar();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro Ingresado");
            
            alerta.showAndWait();
            //Muestra una alerta que los datos fueron ingresados
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro no Ingresado");
            
            alerta.showAndWait();
            //Muestra una alerta que los datos fueron ingresados
        }
            }catch(Exception e){
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Revise sus datos: "+e);

                    alerta.showAndWait();
                    //Muestra una alerta que los datos fueron ingresados
            }
    }

    @FXML
    public void modificar(){
        try{
        String nombre, telefono, correo;
        int edad;
        nombre= TXT_Nombre.getText();
        telefono=TXT_Telefono.getText();
        correo=TXT_Correo.getText();
        edad=Integer.parseInt(TXT_Edad.getText());
        if(CRUDS.CRUDCliente.Modificar(getIdPersona(), nombre, telefono, correo, edad)){
            mostrar();
            limpiar();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro Modificado");
            
            alerta.showAndWait();
            //Muestra una alerta que los datos fueron ingresados
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro no Modificado");
            
            alerta.showAndWait();
            //Muestra una alerta que los datos fueron ingresados
        }
            }catch(Exception e){
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Revise sus datos: "+e);

                    alerta.showAndWait();
                    //Muestra una alerta que los datos fueron ingresados
            }
    }
    
    @FXML
    public void eliminar(){
        try{
        if(CRUDS.CRUDCliente.Eliminar(getIdPersona())){
            mostrar();
            limpiar();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro Eliminado");
            
            alerta.showAndWait();
            //Muestra una alerta que los datos fueron ingresados
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro no Eliminado");
            
            alerta.showAndWait();
            //Muestra una alerta que los datos fueron ingresados
        }
            }catch(Exception e){
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Revise sus datos: "+e);

                    alerta.showAndWait();
                    //Muestra una alerta que los datos fueron ingresados
            }
    }
    

    /**
     * @return the idPersona
     */
    public Integer getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    
}
