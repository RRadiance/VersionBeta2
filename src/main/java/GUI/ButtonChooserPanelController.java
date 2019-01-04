package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class ButtonChooserPanelController implements EventHandler<ActionEvent>{
	private Model model;
	private ViewMain viewMain;
	
	public ButtonChooserPanelController(Model model, ViewMain viewMain) {
		this.model = model;
		this.viewMain = viewMain;
	}
	
	/**
	 * handler to handle the ActionEvent for a button in ButtonChooserPanel
	 */
	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getId();
		String symbol = this.viewMain.getSymbolPanel().getSymbol();
		this.viewMain.getSymbolPanel().setSymbolToUppercase();
		symbol = symbol.toUpperCase();
		
		// Check to see if symbol is of valid length
		if(symbol.length() > 0) {
			switch(command) {
			// If user chooses Time Series
			case "1":
				this.model.openTimeSeriesDialogBox(this.viewMain, symbol);
				break;
			// If user chooses Technical Indicators
			case "2":
				this.model.openTechnicalIndicatorsDialogBox(this.viewMain, symbol);
				break;
			}
		}
		else {
			createErrorDialog();
		}
		//System.out.println(command);
	}
	
	/**
	 * Creates a GUI pop-up box when the user does not 
	 * input a valid stock symbol
	 * 
	 * 
	 */
	private void createErrorDialog() {
		String errorMessage = "You must enter a stock symbol";
		Alert dialogBox = new Alert(AlertType.WARNING);
		dialogBox.setTitle("Warning");
		dialogBox.setHeaderText("Invalid stock symbol entered");
		dialogBox.setContentText(errorMessage);
		dialogBox.showAndWait();
	}

}
