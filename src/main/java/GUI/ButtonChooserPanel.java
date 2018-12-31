package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ButtonChooserPanel extends VBox{
	private View view; // So we can talk to our parent or other components of the view
	private Model model;
	
	/**
	 * Constructs a ButtonChooserPanel with their corresponding button and image
	 * @param view
	 */
	public ButtonChooserPanel(Model model, View view) {
		this.view = view;
		this.model = model;
		
		Button getData = new Button("Get Data");
		getData.setMinWidth(120);
		getData.setOnAction(new ButtonChooserPanelController(this.model, this.view));
		
		Button displayData = new Button("Display Data");
		displayData.setMinWidth(120);
		displayData.setOnAction(new ButtonChooserPanelController(this.model, this.view));
		
		Button analyzeData = new Button("Analyze Data");
		analyzeData.setMinWidth(120);
		analyzeData.setOnAction(new ButtonChooserPanelController(this.model, this.view));
		
		Button displayAnalysis = new Button("Show Analysis");
		displayAnalysis.setMinWidth(120);
		displayAnalysis.setOnAction(new ButtonChooserPanelController(this.model, this.view));
		
		this.getChildren().add(getData);
		this.getChildren().add(displayData);
		this.getChildren().add(analyzeData);
		this.getChildren().add(displayAnalysis);
		
	}
}
