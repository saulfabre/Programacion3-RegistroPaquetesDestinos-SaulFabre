package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import model.Destino;
import model.Paquete;
import utils.ArchivoUtil;

public class RegistroPaqueteController {

    @FXML
    private TextField tfCodigoPaquete;

    @FXML
    private TextField tfDestinatario;

    @FXML
    private TextField tfPesoPaquete;

    @FXML
    private Label lblEstado;

    @FXML
    private ComboBox<Destino> cbDestino;

    @FXML
    private ProgressBar barraProgreso;

    @FXML
    private void guardarPaquete() {

        String codigo = tfCodigoPaquete.getText();
        String destinatario = tfDestinatario.getText();
        String peso = tfPesoPaquete.getText();
        
        if (codigo.isEmpty()) {

            lblEstado.setText(("Debe ingresar un codigo."));
            return;
        }

        if (destinatario.isEmpty()) {

            lblEstado.setText(("Debe ingresar un destinatario."));
            return;
        }

        if (peso.isEmpty()) {

            lblEstado.setText(("Debe ingresar un peso."));
            return;
        }

        if (cbDestino.getValue() == null) {

            lblEstado.setText(("Debe seleccionar un destino."));
            return;
        }

        Thread hilo = new Thread(() -> {
        try {

            for (int i = 0; i <= 10; i++) {

                Thread.sleep(300);
                int progreso = i;

                Platform.runLater(() -> {
                    barraProgreso.setProgress(progreso / 10.0);
                    lblEstado.setText(("Guardando... " + (progreso * 10) + "%"));
                });
            }

        Paquete paquete = crearPaquete();
        ArchivoUtil.guardarPaquete(paquete);

        Platform.runLater(() -> {
            lblEstado.setText("Paquete guardado en el archivo.");
        });

        } catch (Exception e) {
            System.out.println("Error al guardar el paquete " + e.getMessage());
        }

        finally {
            Platform.runLater(() -> {
                barraProgreso.setProgress(0);
            });
        }
    }); 

    hilo.start();
};

    @FXML
    private void cargarDestinos() {

        ObservableList<Destino> destinos = FXCollections.observableArrayList(

            ArchivoUtil.leerDestinos());

            cbDestino.setItems(destinos);

            if (destinos.isEmpty()) {
                lblEstado.setText("No hay destinos registrados.");
            }

        }    

    @FXML
    private Paquete crearPaquete() {

        return new Paquete(tfCodigoPaquete.getText(), tfDestinatario.getText(), Double.parseDouble(tfPesoPaquete.getText()), cbDestino.getValue().getNombre());
    }  
}
