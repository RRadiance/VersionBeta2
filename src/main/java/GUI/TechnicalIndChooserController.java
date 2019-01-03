package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TechnicalIndChooserController implements EventHandler<ActionEvent> {
	private Model model;
	private TechnicalIndicatorChooser tic;
	private String symbol;
	private ViewMain viewMain;
	
	public TechnicalIndChooserController(ViewMain viewMain, Model model, String symbol, TechnicalIndicatorChooser tic) {
		this.viewMain = viewMain;
		this.model = model;
		this.tic = tic;
		this.symbol = symbol;
	}
	
	/**
	 * Tells the model to access the appropriate Time Series data from the AV Interface
	 * 
	 */
	@Override
	public void handle(ActionEvent event) {
		String radioButtonName = this.tic.getToggledButton();
		this.viewMain.closeTechnicalIndicatorsDialogBox();
		this.model.accessAVTechnicalIndicators(this.viewMain, this.symbol, radioButtonName);
	}
	
}
