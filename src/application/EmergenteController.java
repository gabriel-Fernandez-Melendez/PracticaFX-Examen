package application;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class EmergenteController {

	@FXML
	private Button boton;
	
	@FXML
	private Button boton2;
	
	@FXML
	private Button boton3;
	
	@FXML
	private void MetodoAlerta() {
		System.out.println("entro");
		mostrarAlerta("prueba sin confirmacion","funciona ",AlertType.INFORMATION);
	}
	
	private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
		Alert miAlerta = new Alert(tipo);
		miAlerta.setTitle(titulo);
		miAlerta.setContentText(mensaje);
		miAlerta.showAndWait();
	}
	
	@FXML
	private void Salir() {
		Alert miAlerta = new Alert(AlertType.CONFIRMATION);
		miAlerta.setTitle("Salir");
		miAlerta.setContentText("seguro que quiere salir?");
		Optional<ButtonType> resultado = miAlerta.showAndWait();

		if(resultado.get()==ButtonType.OK) {
			System.exit(0);
		}
	}
	
	private Alert mostrarAlertaConfirmation(String titulo, String mensaje) {
		Alert miAlerta = new Alert(AlertType.CONFIRMATION);
		miAlerta.setTitle(titulo);
		miAlerta.setContentText(mensaje);
		//miAlerta.showAndWait(); ESTA LLAMADA VA DONDE SE LLAME AL METODO
		return miAlerta;
	}
	
	@FXML
	private void PruebaConfirmacion() {
		Alert datos =mostrarAlertaConfirmation("prueba de confirmacion","funciona");
		Optional<ButtonType> result = datos.showAndWait();
		 if(result.get()==ButtonType.OK) {}
	}
}
