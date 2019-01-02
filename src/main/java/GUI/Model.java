package GUI;

import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;

import AlphaVantageInterface.AVAccessor;
import AlphaVantageInterface.AVTechnicalIndicators;
import AlphaVantageInterface.AVTimeSeries;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Model {
	private AVAccessor avAccessor;
	private AVTimeSeries avTimeSeries;
	private AVTechnicalIndicators avTechnicalIndicators;
	
	public Model() {
		avAccessor = new AVAccessor();
		avTimeSeries = new AVTimeSeries(avAccessor);
		avTechnicalIndicators = new AVTechnicalIndicators(avAccessor);
	}
	
	public void updateTextArea(ViewMain viewMain) {
		String text = "Test";
		viewMain.getCenterPanel().setText(text);
//		AVTimeSeries ts = new AVTimeSeries(avAccessor);
//		ts.accessIntraday("AAPL", Interval.ONE_MIN, OutputSize.COMPACT);
	}
	
	public void openTimeSeriesDialogBox(ViewMain viewMain, String symbol) {
		viewMain.createTimeSeriesDialogBox(symbol);
	}
	
	/**
	 * Determines what type of data the user would like to see by checking
	 * which radio button they have selected. Accesses the AV Interface, calling
	 * the appropriate method in AVTimeSeries.
	 * 
	 * @param symbol
	 * @param timeType
	 */
	public void accessAVTimeSeries(String symbol, String timeType) {
		System.out.println(timeType);
		switch(timeType) {
		case "Daily":
			//this.avTimeSeries.doMethod();
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
