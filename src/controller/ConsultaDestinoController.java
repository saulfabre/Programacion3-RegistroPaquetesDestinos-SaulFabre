package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Destino;
import utils.ArchivoUtil;

public class ConsultaDestinoController {

    @FXML
    private Label lblEstado = new Label();

    @FXML
    private ListView<Destino> listViewDestinos = new ListView<>();

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
}
