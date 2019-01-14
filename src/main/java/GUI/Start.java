package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The program should be run from here.
 * This is where the Model and ViewMain are first instantiated.
 * The main JavaFX stage is created here.
 * @author matthewhuynh
 *
 */
public class Start extends Application {
	
	Model model;
	ViewMain viewMain;
	
	public static void main(String[]args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		//System.out.println("javafx.runtime.version: " + System.getProperties().get("javafx.runtime.version"));
		//System.out.println(System.getProperty("user.home"));
		
		this.model = new Model();
		this.viewMain = new ViewMain(model, stage);
	}
}
