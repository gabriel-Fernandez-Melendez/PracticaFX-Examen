package application;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController {

	//mi intencion es llevar desde aqui a todas las demas ventanas que tendra nuestro programa
		//este es el border pane de mi ventana principal colocada en el borderlayoutcenter
		@FXML
		BorderPane mainPane;
		
		//estos metodos invocan al constructor de sus clases que son un nodo fx que ce cargo
		/*
		 * public void P_NuevoContacto() { System.out.println("paso por aqui");
		 * PanelNuevoContactoController nuevocontacto = new
		 * PanelNuevoContactoController(); mainPane.setCenter(nuevocontacto); }
		 */
		
		
		public void P_Salir() {
			/*
			 * System.out.println("paso por aqui"); PanelSalirController salir = new
			 * PanelSalirController(); mainPane.setCenter(salir);
			 */
			Alert datos = new Alert(AlertType.CONFIRMATION);
			 datos.setContentText("Seguro que quiere salir de la Agenda?");
			 datos.setTitle("Cerrar Aplicacion");
			 Optional<ButtonType> result = datos.showAndWait();
			 if(result.get()==ButtonType.OK) {
				 System.exit(0);
			 }
			 else {
				 System.out.println("el usuario no salio");
			 }
		}
		
		 public void P_Datos() {
		System.out.println("paso por aqui");
		Stage primaryStage = (Stage) mainPane.getScene().getWindow();
		 VentanaParaCrearObjeto nuevocontacto = new VentanaParaCrearObjeto();
		 mainPane.setCenter(nuevocontacto);
		 }
		 
		 public void P_Tablas() {
				System.out.println("paso por aqui");
				Stage primaryStage = (Stage) mainPane.getScene().getWindow();
				CambioTablasController nuevocontacto = new CambioTablasController(primaryStage);
				 mainPane.setCenter(nuevocontacto);
				 }
		 
		
		
}
