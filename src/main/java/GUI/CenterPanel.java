package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * The CenterPanel is a BorderPane that stores the main graphical display for the user. 
 * It outputs graphical and raw stock data. In the ViewMain, the CenterPanel belongs
 * in the center node of the MainView BorderPane.
 * 
 * @author matthewhuynh
 *
 */
public class CenterPanel extends BorderPane{
	private TextArea textArea;
	private HBox toolbar;
	private Button graphButton;
	private Button rawDataButton;
	private Label metaInformation;
	
	public CenterPanel(Model model) {
		this.textArea = new TextArea("Enter a symbol on the left to get started");
		this.textArea.setEditable(false);
		
		// Add to HBox
		this.graphButton = new Button("Show Graph");
		this.graphButton.setDisable(true);
		this.rawDataButton = new Button("Raw Data");
		this.rawDataButton.setDisable(true);
		this.metaInformation = new Label();
		
		this.toolbar = new HBox();
		this.toolbar.getChildren().add(this.graphButton);
		this.toolbar.getChildren().add(this.rawDataButton);
		this.toolbar.getChildren().add(this.metaInformation);
		
		this.setTop(toolbar);
		this.setCenter(textArea);
	}
	
	/**
	 * Displays raw stock data. Called from Model.
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.textArea.setText(text);
	}
	
	/**
	 * Displays the stock symbol and data type currently
	 * being displayed. Called from Model.
	 * 
	 * @param text
	 */
	public void changeMetaInformation(String text) {
		this.metaInformation.setText(text);
	}
}
