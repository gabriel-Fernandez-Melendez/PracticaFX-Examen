package application;
	
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import entidades.Contacto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ventanamain.fxml"));
	        Parent root = loader.load(); // Cargamos el archivo FXML
	        primaryStage.setTitle("Agenda de Contactos");
	        primaryStage.setScene(new Scene(root));
	        primaryStage.setResizable(false);
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<Contacto> contactos = new ArrayList<>(); 
	
	public static void main(String[] args) {
	  

	        contactos.add(new Contacto("Nombre1", "123456789", "email1@example.com", LocalDate.of(1980, Month.JANUARY, 15)));
	        contactos.add(new Contacto("Nombre2", "234567890", "email2@example.com", LocalDate.of(1975, Month.FEBRUARY, 20)));
	        contactos.add(new Contacto("Nombre3", "345678901", "email3@example.com", LocalDate.of(1990, Month.MARCH, 25)));
	        contactos.add(new Contacto("Nombre4", "456789012", "email4@example.com", LocalDate.of(1985, Month.APRIL, 10)));
	        contactos.add(new Contacto("Nombre5", "567890123", "email5@example.com", LocalDate.of(1970, Month.MAY, 5)));
	        contactos.add(new Contacto("Nombre6", "678901234", "email6@example.com", LocalDate.of(1995, Month.JUNE, 30)));
	        contactos.add(new Contacto("Nombre7", "789012345", "email7@example.com", LocalDate.of(1982, Month.JULY, 12)));
	        contactos.add(new Contacto("Nombre8", "890123456", "email8@example.com", LocalDate.of(1978, Month.AUGUST, 18)));
	        contactos.add(new Contacto("Nombre9", "901234567", "email9@example.com", LocalDate.of(1992, Month.SEPTEMBER, 22)));
	        contactos.add(new Contacto("Nombre10", "012345678", "email10@example.com", LocalDate.of(1988, Month.OCTOBER, 8)));
		launch(args);
	}
}
