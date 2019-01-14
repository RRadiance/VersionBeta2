package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Controls TimeSeriesChooserController, handling any button events and
 * checking which radio button (each representing a time series interval)
 * the user has chosen.
 * 
 * @author matthewhuynh
 *
 */
public class TimeSeriesChooserController implements EventHandler<ActionEvent> {
	private Model model;
	private TimeSeriesChooser tsc;
	private String symbol;
	private ViewMain viewMain;
	
	public TimeSeriesChooserController(ViewMain viewMain, Model model, String symbol, TimeSeriesChooser tsc) {
		this.viewMain = viewMain;
		this.model = model;
		this.tsc = tsc;
		this.symbol = symbol;
	}
	
	/**
	 * Tells the model to access the appropriate Time Series data from the AV Interface
	 * 
	 */
	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getText();
		this.viewMain.closeTimeSeriesDialogBox();
		
		// If the Get Data button was pressed, then we access the AV interface
		if (command.equals("Get Data")) {
			String radioButtonName = this.tsc.getToggledButton();
			this.viewMain.closeTimeSeriesDialogBox();
			this.model.accessAVTimeSeries(this.viewMain, this.symbol, radioButtonName);
		}
	}
	
}
