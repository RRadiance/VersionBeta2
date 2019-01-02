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

		switch(command) {
		case "1": // Get Time Series Data
			String symbol = this.viewMain.getSymbolPanel().getSymbol();
			if(symbol.length() > 0) {
				this.model.openTimeSeriesDialogBox(this.viewMain, symbol);
			}
			else {
				createErrorDialog();
			}
			break;
		case "2": // Get Technical Indicators Data
			break;
		}
		System.out.println(command);
		
		this.model.updateTextArea(this.viewMain);
		//this.model.doSomething(); the model in turn then manipulates the view
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
