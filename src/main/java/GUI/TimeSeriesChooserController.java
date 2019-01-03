package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
		String radioButtonName = this.tsc.getToggledButton();
		this.viewMain.closeTimeSeriesDialogBox();
		this.model.accessAVTimeSeries(this.viewMain, this.symbol, radioButtonName);
	}
	
}
