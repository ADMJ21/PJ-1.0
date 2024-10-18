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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.libro;
import model.prestamos;

/**
 * FXML Controller class
 *
 * @author Angel
 */
public class PrestamosController implements Initializable {

    @FXML
    private TextField TXT_Fecha;
    @FXML
    private TextField TXT_Clave;
    @FXML
    private TableView<prestamos> Mostrar_Todo;
    @FXML
    private TableColumn<?, ?> Colum_Id;
    @FXML
    private TableColumn<?, ?> Colum_Cliente;
    @FXML
    private TableColumn<?, ?> Colum_Libro;
    @FXML
    private TableColumn<?, ?> Colum_Fecha;
    @FXML
    private TableColumn<?, ?> Column_Clave;
    

    private ObservableList<prestamos> listPrestamos;
    private Integer idPestamos;

    
    public void limpiar(){
    TXT_Clave.setText("");
    TXT_Fecha.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar();
    }    

    public void mostrar(){
        listPrestamos=FXCollections.observableArrayList();
        for(Iterator it = CRUDS.CRUDCliente.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            listPrestamos.add(new prestamos());
            //Se mantiene los valores que se encuentran en CRUDS, en Universo
        }
        this.Colum_Id.setCellValueFactory(new PropertyValueFactory(""));
        this.Colum_Cliente.setCellValueFactory(new PropertyValueFactory(""));
        this.Colum_Libro.setCellValueFactory(new PropertyValueFactory(""));
        this.Colum_Fecha.setCellValueFactory(new PropertyValueFactory(""));
        this.Column_Clave.setCellValueFactory(new PropertyValueFactory(""));
            Mostrar_Todo.setItems(listPrestamos);
    }
    
    @FXML
    private void Selecionar_Datos(MouseEvent event) {
    }
    
    @FXML
    private void insertar(ActionEvent event) {
    }

    @FXML
    private void modificar(ActionEvent event) {
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }

    /**
     * @return the idPestamos
     */
    public Integer getIdPestamos() {
        return idPestamos;
    }

    /**
     * @param idPestamos the idPestamos to set
     */
    public void setIdPestamos(Integer idPestamos) {
        this.idPestamos = idPestamos;
    }
    
}
