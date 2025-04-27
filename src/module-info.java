module MCVTeam {
	requires java.sql;
	
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	
	opens Vista to javafx.fxml;
	
	exports Vista;
	exports Controlador;
	exports Modelo;
}