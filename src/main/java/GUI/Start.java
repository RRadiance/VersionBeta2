package GUI;

import javafx.application.Application;
import javafx.stage.Stage;
import AlphaVantageInterface.AVAccessor;

public class Start extends Application {
	
	Model model; // Model
	ViewMain viewMain; // View + Controller
	
	public static void main(String[]args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("javafx.runtime.version: " + System.getProperties().get("javafx.runtime.version"));
		System.out.println(System.getProperty("user.home"));
		
		this.model = new Model();
		this.viewMain = new ViewMain(model, stage);
	}
}
