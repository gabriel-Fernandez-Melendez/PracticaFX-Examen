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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CambioTablasController extends AnchorPane implements Initializable {
    @FXML
    private TableColumn<Contacto,LocalDate> fecha;

    @FXML
    private TableColumn<Contacto,String> mail;


    @FXML
    private TableColumn<Contacto,String> nombre;

    @FXML
    private TableView<Contacto> tablacontacto;

    @FXML
    private TableColumn<Contacto,String> telefono;
 @FXML
	private Button boton_m;
	
	@FXML
	private Button boton_b;
	
	private Stage escenario;
	
    @FXML
    private void Borrar() {
    	System.out.println("si ");
    	Contacto c=tablacontacto.getSelectionModel().getSelectedItem();
    	Main.contactos.remove(c);
    	//tengo que cargarlo de este modo si o si 
    	
    	ObservableList<Contacto> lista = FXCollections.observableArrayList(Main.contactos); 
		tablacontacto.setItems(lista);
    }
    
   

    //funciona, lo importante seria recordar que tengo que mostrar un  argumento de algun tipo , en clase probar a meter un fxml que yo haya hecho 
    @FXML
    private void Modificar() {
    	System.out.println("si ");
    	 Stage childStage = new Stage();
         childStage.setTitle("Child Window");
         childStage.initModality(Modality.WINDOW_MODAL); // Block parent window
         childStage.initOwner(escenario); // Set parent reference
         childStage.setScene(new Scene(new Label("Child Content"), 200, 200));
         childStage.show();
    }
    
    
    
	public CambioTablasController(Stage es) {
		 this.escenario = es;
		System.out.println("llega al constructor");
		//recuerda , si meto mal la url el error es Caused by: java.lang.IllegalStateException: Location is not set.
		FXMLLoader load=new FXMLLoader(getClass().getResource("CambioTablas.fxml"));
		
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

	//siempre implementar este metodo , total vale perfectamente para precargar datoscosa que habra que hacer
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//IMPLEMENTAMOS AQUI LOS DATOS DEL ARRAY QUE INIZIALIZAMOS AL PRINCIPIO
		tablacontacto.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		mail.setCellValueFactory(new PropertyValueFactory<>("email"));
		fecha.setCellValueFactory(new PropertyValueFactory<>("fechanac"));//fechanac
		telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		
		ObservableList<Contacto> lista = FXCollections.observableArrayList(Main.contactos); 
		tablacontacto.setItems(lista);
		System.out.println("llego");
	}
	
}
