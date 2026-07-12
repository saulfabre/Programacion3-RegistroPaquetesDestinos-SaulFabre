package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Paquete;
import utils.ArchivoUtil;
import utils.Navegacion;

public class ConsultaPaqueteController {

    @FXML
    private Button btnCargarPaquete;

    @FXML
    private Label lblEstado;

    @FXML
    private TableView<Paquete> tablaPaquetes;

    @FXML
    private TableColumn<Paquete, String> colCodigo;

    @FXML 
    private TableColumn<Paquete, String> colDestinatario;

    @FXML 
    private TableColumn<Paquete, Double> colPeso;

    @FXML
    private TableColumn<Paquete, String> colDestino;

    @FXML
    public void initialize() {

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colDestinatario.setCellValueFactory(new PropertyValueFactory<>("destinatario"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));

        cargarPaquetes();
    }

    @FXML
    private void cargarPaquetes() {

        ObservableList<Paquete> paquetes = FXCollections.observableArrayList( 

            ArchivoUtil.leerPaquetes()
        );

        tablaPaquetes.setItems(paquetes);

        if (paquetes.isEmpty()) {
            lblEstado.setText("No hay paquetes registrados.");
            return;
        }

        lblEstado.setText("Paquetes cargados exitosamente");
    }

    @FXML
    private void abrirRegistroPaquete() {

        Navegacion.abrirVentana("/view/registro_paquete.fxml", "Registro de paquetes");
    }

    @FXML
    private void abrirRegistroDestino() {

        Navegacion.abrirVentana("/view/registro_destino.fxml", "Registro de destinos");
    }

     @FXML
    private void abrirConsultaDestinos() {

        Navegacion.abrirVentana("/view/consulta_destino.fxml", "Destinos guardados");
    } 

}
