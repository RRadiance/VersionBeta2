package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class TimeSeriesChooserController implements EventHandler<ActionEvent> {
	private Model model;
	private TimeSeriesChooser tsc;
	private String symbol;
	
	public TimeSeriesChooserController(Model model, String symbol, TimeSeriesChooser tsc) {
		this.model = model;
		this.tsc = tsc;
		this.symbol = symbol;
	}
	
	/**
	 * Determines what type of data the user would like to see by checking
	 * which radio button they have selected.
	 * 
	 */
	@Override
	public void handle(ActionEvent event) {
		String radioButtonName = this.tsc.getToggledButton();
		this.model.accessAVTimeSeries(this.symbol, radioButtonName);
		
		System.out.println(radioButtonName);
		switch(radioButtonName) {
		case "Daily":
			break;
		case "Daily Adjusted":
			break;
		case "Weekly":
			break;
		case "Weekly Adjusted":
			break;
		case "Monthly":
			break;
		case "Monthly Adjusted":
			break;
		}
	}
	
}
