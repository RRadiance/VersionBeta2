package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ButtonChooserPanel extends VBox{
	private ViewMain viewMain; // So we can talk to our parent or other components of the view
	private Model model;
	
	/**
	 * Constructs a ButtonChooserPanel with their corresponding button and image
	 * @param viewMain
	 */
	public ButtonChooserPanel(Model model, ViewMain viewMain) {
		this.viewMain = viewMain;
		this.model = model;
		
		Button getTSData = new Button("Get Time Series Data");
		getTSData.setId("1");
		getTSData.setMinWidth(120);
		getTSData.setOnAction(new ButtonChooserPanelController(this.model, this.viewMain));
		
		Button getTIData = new Button("Get Technical Indicators Data");
		getTIData.setId("2");
		getTIData.setMinWidth(120);
		getTIData.setOnAction(new ButtonChooserPanelController(this.model, this.viewMain));
		
//		Button analyzeData = new Button("Analyze Data");
//		analyzeData.setMinWidth(120);
//		analyzeData.setOnAction(new ButtonChooserPanelController(this.model, this.view));
//		
//		Button displayAnalysis = new Button("Show Analysis");
//		displayAnalysis.setMinWidth(120);
//		displayAnalysis.setOnAction(new ButtonChooserPanelController(this.model, this.view));
		
		this.getChildren().add(getTSData);
		this.getChildren().add(getTIData);
//		this.getChildren().add(analyzeData);
//		this.getChildren().add(displayAnalysis);
		
	}
}
