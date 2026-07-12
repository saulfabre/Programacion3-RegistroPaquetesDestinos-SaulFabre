package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Destino;
import utils.ArchivoUtil;
import utils.Navegacion;

public class ConsultaDestinoController {

    @FXML
    private Label lblEstado;

    @FXML
    private ListView<Destino> listViewDestinos;

    @FXML
    public void initialize() {
        cargarDestinos();
    }

    @FXML
    private void cargarDestinos() {

        ObservableList<Destino> destinos = FXCollections.observableArrayList(

            ArchivoUtil.leerDestinos());

        listViewDestinos.setItems(destinos);   

        if (destinos.isEmpty()) {

            lblEstado.setText("No hay destinos registrados.");
            return;
        }
        
        lblEstado.setText("Destinos cargados exitosamente.");
    }   

    @FXML
    private void abrirRegistroDestino() {

        Navegacion.abrirVentana("/view/registro_destino.fxml", "Registro de destinos");
    }

    @FXML
    private void abrirRegistroPaquete() {

        Navegacion.abrirVentana("/view/registro_paquete.fxml", "Registro de paquetes");
    }

    @FXML
    private void abrirConsultaPaquetes() {

        Navegacion.abrirVentana("/view/consulta_paquete.fxml", "Consulta de paquetes");
    }

    
}
