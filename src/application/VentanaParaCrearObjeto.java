package application;

import java.io.IOException;
import java.time.LocalDate;

import entidades.Contacto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class VentanaParaCrearObjeto extends AnchorPane{

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
	
	public VentanaParaCrearObjeto() {
		System.out.println("llega al constructor");
		FXMLLoader load=new FXMLLoader(getClass().getResource("Datos.fxml"));
		
		//ojo , solo me hace falta cargarlo si declaro estas variables en el propio fxml
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
		System.out.println("entra");
			Contacto c= new Contacto();
			String nom =nombre.getText();
			String tef = telefono.getText();
			String mail =correo.getText();
			c.setEmail(mail);
			c.setNombre(nom);
			c.setTelefono(tef);
			LocalDate necha_nac =fecha.getValue();
			c.setFechanac(necha_nac);
			System.out.println("el usuario es: "+c.toString());
	}
	
	@FXML
	private void LimpiarCampos() {
	nombre.setText("");
	telefono.setText("");
	correo.setText("");
	fecha.setValue(LocalDate.now());
	}
}
