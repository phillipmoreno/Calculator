import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		//The FXML file is loaded 
		Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
		
		//New scene object is created
		Scene scene = new Scene(root);
		
		//Stage is set
		stage.setScene(scene);
		
		//Stage is centered
		stage.centerOnScreen();
		
		//Title is set to "Calculator"
		stage.setTitle("Calculator");
		
		//Stage is displayed 
		stage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}