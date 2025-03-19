module agendaFX_GabrielFernandez {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	  // Abre el paquete "entidades" a javafx.base
    opens entidades to javafx.base;

	opens application to javafx.graphics, javafx.fxml;
}
