package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Destino;
import utils.ArchivoUtil;

public class RegistroDestinoController {

    @FXML
    private TextField tfDestino = new TextField();

    @FXML
    private Label lblEstado = new Label();

    @FXML
    private ListView<Destino> listViewDestinos = new ListView<>();

    @FXML
    private void guardarDestino() {

        String destino = tfDestino.getText();

        if (destino.isEmpty()) {

            lblEstado.setText("Debe ingresar un nombre.");
            return;
        }

        Destino destinoArchivo = crearDestino();

        ArchivoUtil.guardarDestino(destinoArchivo);

        lblEstado.setText("Destino guardado en el archivo.");
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
    private Destino crearDestino() {

        return new Destino(tfDestino.getText());
    }
    
}
