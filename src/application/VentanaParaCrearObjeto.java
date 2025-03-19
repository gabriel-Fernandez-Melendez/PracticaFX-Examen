package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import entidades.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
	private void Guardar() {
		ObservableList<Contacto> lista =FXCollections.observableArrayList(Main.contactos);
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
		
				  tablacargardatos.setItems(lista); System.out.println("llego");
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
			//RECUERDA TENER CUIDADO Y MIRAR QUE NO HAYA COMPLICTO ENTRE IDS
		  // IMPLEMENTAMOS AQUI LOS DATOS DEL ARRAY QUE INIZIALIZAMOS AL PRINCIPIO
		  tablacargardatos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		  nombre_campo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		  correo_tabla.setCellValueFactory(new PropertyValueFactory<>("email"));
		  fechanac.setCellValueFactory(new PropertyValueFactory<>("fechanac"));//
		  telefono_tabla.setCellValueFactory(new
		  PropertyValueFactory<>("telefono"));
		  
		  ObservableList<Contacto> lista =
		  FXCollections.observableArrayList(Main.contactos);
		  tablacargardatos.setItems(lista); System.out.println("llego");
		 

	}
}
