package com.example.proyecto.citas.acitas;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CitaController implements Initializable {

    @FXML
    private TableView<Cita> tblCitas;

    @FXML
    private TableColumn<Cita, String> colNombres, colApellidos, colTipoDocumento, colNumDoc,
            colCelular, colEmail, colTipoCita, colEspecialistas, colFecha, colHora;

    @FXML
    private TextField txtNombres, txtApellidos, txtNumDoc,
            txtCelular, txtEmail, txtFecha, txtHora;

    @FXML
    private Button btnAgregar, btnModificar, btnEliminar;

    private ObservableList<Cita> citas;

    @FXML
    private TextField txtTipoDocumento, txtTipoCita, txtEspecialistas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicializar la lista observable
        citas = FXCollections.observableArrayList();

        // Configurar las columnas del TableView
        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colTipoDocumento.setCellValueFactory(new PropertyValueFactory<>("tipoDocumento"));
        colNumDoc.setCellValueFactory(new PropertyValueFactory<>("numeroDocumento"));
        colCelular.setCellValueFactory(new PropertyValueFactory<>("celular"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTipoCita.setCellValueFactory(new PropertyValueFactory<>("tipoCita"));
        colEspecialistas.setCellValueFactory(new PropertyValueFactory<>("especialista"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));

        // Vincular la lista observable con el TableView
        tblCitas.setItems(citas);
    }

    @FXML
    private void agregarCita(ActionEvent event) {
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String tipoDocumento = txtTipoDocumento.getText();
        String numDoc = txtNumDoc.getText();
        String celular = txtCelular.getText();
        String email = txtEmail.getText();
        String tipoCita = txtTipoCita.getText();
        String especialista = txtEspecialistas.getText();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();

        Cita cita = new Cita(nombres, apellidos, tipoDocumento, numDoc, celular, email, tipoCita, especialista, fecha, hora);

        if (!citas.contains(cita)) {
            citas.add(cita);
            tblCitas.refresh();
            limpiar();
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "La cita ya existe");
        }
    }

    @FXML
    private void modificarCita(ActionEvent event) {
        Cita citaSeleccionada = tblCitas.getSelectionModel().getSelectedItem();
        if (citaSeleccionada == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe seleccionar una cita para modificar.");
            return;
        }

        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String tipoDocumento = txtTipoDocumento.getText();
        String numDoc = txtNumDoc.getText();
        String celular = txtCelular.getText();
        String email = txtEmail.getText();
        String tipoCita = txtTipoCita.getText();
        String especialista = txtEspecialistas.getText();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();

        Cita nuevaCita = new Cita(nombres, apellidos, tipoDocumento, numDoc, celular, email, tipoCita, especialista, fecha, hora);

        if (!citas.contains(nuevaCita) || citaSeleccionada.equals(nuevaCita)) {
            citas.remove(citaSeleccionada);
            citas.add(nuevaCita);
            tblCitas.refresh();
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Ya existe una cita con los datos proporcionados.");
        }
    }

    @FXML
    private void eliminarCita(ActionEvent event) {
        Cita citaSeleccionada = tblCitas.getSelectionModel().getSelectedItem();
        if (citaSeleccionada == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe seleccionar una cita para eliminar.");
            return;
        }
        citas.remove(citaSeleccionada);
        tblCitas.refresh();
        limpiar();
    }

    @FXML
    private void seleccionar(javafx.scene.input.MouseEvent mouseEvent) {
        Cita citaSeleccionada = tblCitas.getSelectionModel().getSelectedItem();
        if (citaSeleccionada != null) {
            txtNombres.setText(citaSeleccionada.getNombres());
            txtApellidos.setText(citaSeleccionada.getApellidos());
            txtNumDoc.setText(citaSeleccionada.getNumeroDocumento());
            txtCelular.setText(citaSeleccionada.getCelular());
            txtEmail.setText(citaSeleccionada.getEmail());
            txtFecha.setText(citaSeleccionada.getFecha());
            txtHora.setText(citaSeleccionada.getHora());
            txtTipoDocumento.setText(citaSeleccionada.getTipoDocumento());
            txtTipoCita.setText(citaSeleccionada.getTipoCita());
            txtEspecialistas.setText(citaSeleccionada.getEspecialista());
        }
    }

    private void limpiar() {
        txtNombres.clear();
        txtApellidos.clear();
        txtNumDoc.clear();
        txtCelular.clear();
        txtEmail.clear();
        txtFecha.clear();
        txtHora.clear();
        txtTipoDocumento.clear();
        txtTipoCita.clear();
        txtEspecialistas.clear();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
