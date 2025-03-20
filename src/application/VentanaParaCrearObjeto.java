package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import entidades.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class VentanaParaCrearObjeto extends AnchorPane implements Initializable {

	@FXML
	private TextField nombre;

	@FXML
	private TextField telefono;

	@FXML
	private TextField correo;

	@FXML
	private DatePicker fecha;

	@FXML
	private Button guardar;

	@FXML
	private Button limpiar;

	@FXML
	private TableColumn<Contacto, LocalDate> fechanac;

	@FXML
	private TableColumn<Contacto, String> correo_tabla;

	@FXML
	private TableColumn<Contacto, String> nombre_campo;

	@FXML
	private TableView<Contacto> tablacargardatos;

	@FXML
	private TableColumn<Contacto, String> telefono_tabla;

	public VentanaParaCrearObjeto() {
		System.out.println("llega al constructor");
		FXMLLoader load = new FXMLLoader(getClass().getResource("Datos.fxml"));

		// ojo , solo me hace falta cargarlo si declaro estas variables en el propio
		// fxml
		load.setRoot(this);
		load.setController(this);

		try {
			load.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void ModificarContacto() {
		Contacto co = new Contacto();
		Contacto co_aux = new Contacto();
		Alert alerta = mostrarAlertaConfirmation("modificar contacto", "quiere modificar los datos del contacto por el nuevo ?");
		Optional<ButtonType> resultado = alerta.showAndWait();
		if (resultado.get() == ButtonType.OK) {
			co =tablacargardatos.getSelectionModel().getSelectedItem();
            //copia pega de Guardar
			String nom = nombre.getText();
			String tef = telefono.getText();
			String mail = correo.getText();		
			LocalDate necha_nac = fecha.getValue();
			//llego
			co_aux.setFechanac(necha_nac);
			co_aux.setEmail(mail);
			co_aux.setNombre(nom);
			co_aux.setTelefono(tef);
			ObservableList<Contacto> lista = FXCollections.observableArrayList(Main.contactos);
			for (Contacto c : lista) {
				if (c.equals(co)) {
					System.out.println("son iguales");
					ObservableList<Contacto> lista_nuevo = FXCollections.observableArrayList(Main.contactos);
					lista_nuevo.remove(co);
					Main.contactos.remove(co); //esta llamada es importante por que es la coleccion estatica que hace que todo se filtre correctamente
					tablacargardatos.setItems(lista_nuevo);
					lista_nuevo.add(co_aux);
					Main.contactos.add(co_aux); //lo mismo tengo que hacer para añadir es importante si no la lista es solo cada ves mas pequeña
					System.out.println("llego");

				}
			}
		}

	}

	private Alert mostrarAlertaConfirmation(String titulo, String mensaje) {
		Alert miAlerta = new Alert(AlertType.CONFIRMATION);
		miAlerta.setTitle(titulo);
		miAlerta.setContentText(mensaje);
		// miAlerta.showAndWait(); ESTA LLAMADA VA DONDE SE LLAME AL METODO
		return miAlerta;
	}

	@FXML
	private void Guardar() {
		ObservableList<Contacto> lista = FXCollections.observableArrayList(Main.contactos);
		System.out.println("entra");
		Contacto c = new Contacto();
		String nom = nombre.getText();
		String tef = telefono.getText();
		String mail = correo.getText();
		c.setEmail(mail);
		c.setNombre(nom);
		c.setTelefono(tef);
		LocalDate necha_nac = fecha.getValue();
		c.setFechanac(necha_nac);
		System.out.println("el usuario es: " + c.toString());
		lista.add(c);

		tablacargardatos.setItems(lista);
		System.out.println("llego");

	}

	@FXML
	private void LimpiarCampos() {
		nombre.setText("");
		telefono.setText("");
		correo.setText("");
		fecha.setValue(LocalDate.now());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// RECUERDA TENER CUIDADO Y MIRAR QUE NO HAYA COMPLICTO ENTRE IDS
		// IMPLEMENTAMOS AQUI LOS DATOS DEL ARRAY QUE INIZIALIZAMOS AL PRINCIPIO
		tablacargardatos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		nombre_campo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		correo_tabla.setCellValueFactory(new PropertyValueFactory<>("email"));
		fechanac.setCellValueFactory(new PropertyValueFactory<>("fechanac"));//
		telefono_tabla.setCellValueFactory(new PropertyValueFactory<>("telefono"));

		ObservableList<Contacto> lista = FXCollections.observableArrayList(Main.contactos);
		tablacargardatos.setItems(lista);
		System.out.println("llego");

	}
}
