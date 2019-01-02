package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SymbolPanel extends VBox{
	private ViewMain viewMain; // So we can talk to our parent or other components of the view
	private Model model;
	private TextField symbol;
	
	/**
	 * Constructs a ButtonChooserPanel with their corresponding button and image
	 * @param viewMain
	 */
	public SymbolPanel(Model model, ViewMain viewMain) {
		this.viewMain = viewMain;
		this.model = model;
		
		this.symbol = new TextField("");
		this.symbol.setPromptText("Enter Symbol");
		
		this.getChildren().add(symbol);
	}
	
	public String getSymbol() {
		return this.symbol.getText();
	}
}
