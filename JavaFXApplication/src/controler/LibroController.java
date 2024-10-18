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
import model.libro;

/**
 * FXML Controller class
 *
 * @author Angel
 */
public class LibroController implements Initializable {

    @FXML
    private TextField TXT_Nombre;
    @FXML
    private TextField TXT_Genero;
    @FXML
    private TextField TXT_Categoria;
    @FXML
    private TableView<libro> Mostrar_Todo;
    @FXML
    private TableColumn<?, ?> Colum_Id;
    @FXML
    private TableColumn<?, ?> Colum_Nombre;
    @FXML
    private TableColumn<?, ?> Colum_Genero;
    @FXML
    private TableColumn<?, ?> Colum_Categoria;
    
    private ObservableList<libro> listLibro;
    private Integer idlibro;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar();
    }    

    public void limpiar(){
    TXT_Nombre.setText("");
    TXT_Genero.setText("");
    TXT_Categoria.setText("");
    }
    
    public void mostrar(){
        listLibro=FXCollections.observableArrayList();
        for(Iterator it = CRUDS.CRUDCliente.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            listLibro.add(new libro((Integer) item[0], (String) item[1],(String) item[2], (String) item[3]));
            //Se mantiene los valores que se encuentran en CRUDS, en Universo
        }
        this.Colum_Id.setCellValueFactory(new PropertyValueFactory("idCliente"));
        this.Colum_Nombre.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
        this.Colum_Genero.setCellValueFactory(new PropertyValueFactory("telefonoCliente"));
        this.Colum_Categoria.setCellValueFactory(new PropertyValueFactory("emailCliente"));
            Mostrar_Todo.setItems(listLibro);
    }
    
    @FXML
    private void Selecionar_Datos(MouseEvent event) {
        libro l=this.Mostrar_Todo.getSelectionModel().getSelectedItem();
        idlibro=l.getIdLibros();
        TXT_Nombre.setText(l.getNombre()+"");
        TXT_Genero.setText(l.getGenero()+"");
        TXT_Categoria.setText(l.getCategoria()+"");
    }
    
    @FXML
    private void insertar(ActionEvent event) {
        try{
        String nombre, genero, categoria;
        nombre= TXT_Nombre.getText();
        genero=TXT_Genero.getText();
        categoria=TXT_Categoria.getText();
        if(CRUDS.CRUDLibro.insertar(nombre, genero, categoria)){
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
    private void modificar(ActionEvent event) {
        try{
        String nombre, genero, categoria;
        nombre= TXT_Nombre.getText();
        genero=TXT_Genero.getText();
        categoria=TXT_Categoria.getText();
        if(CRUDS.CRUDLibro.Modificar(getIdlibro(), nombre, genero, categoria)){
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
    private void eliminar(ActionEvent event) {
        try{
        if(CRUDS.CRUDLibro.Eliminar(getIdlibro())){
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
     * @return the idlibro
     */
    public Integer getIdlibro() {
        return idlibro;
    }

    /**
     * @param idlibro the idlibro to set
     */
    public void setIdlibro(Integer idlibro) {
        this.idlibro = idlibro;
    }
    
}
