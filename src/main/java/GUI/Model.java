package GUI;

import org.patriques.input.timeseries.OutputSize;

import AlphaVantageInterface.AVAccessor;
import AlphaVantageInterface.AVTechnicalIndicators;
import AlphaVantageInterface.AVTimeSeries;

public class Model {
	private AVAccessor avAccessor;
	private AVTimeSeries avTimeSeries;
	private AVTechnicalIndicators avTechnicalIndicators;
	
	public Model() {
		avAccessor = new AVAccessor();
		avTimeSeries = new AVTimeSeries(avAccessor);
		avTechnicalIndicators = new AVTechnicalIndicators(avAccessor);
	}
	
	public void updateTextArea(ViewMain viewMain, String text) {
		// text = "Test";
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
	public void accessAVTimeSeries(ViewMain viewMain, String symbol, String timeType) {
		System.out.println(timeType);
		String returnString;
		switch(timeType) {
		case "Daily":
			returnString = this.avTimeSeries.printDaily(symbol, OutputSize.COMPACT); //OutputSize.FULL 
			this.updateTextArea(viewMain, returnString);
			break;
		case "Daily Adjusted":
			returnString = this.avTimeSeries.printDailyAdjusted(symbol, OutputSize.COMPACT);
			this.updateTextArea(viewMain, returnString);
			break;
		case "Weekly":
			returnString = this.avTimeSeries.printWeekly(symbol);
			this.updateTextArea(viewMain, returnString);
			break;
		case "Weekly Adjusted":
			returnString = this.avTimeSeries.printWeeklyAdjusted(symbol);
			this.updateTextArea(viewMain, returnString);
			break;
		case "Monthly":
			returnString = this.avTimeSeries.printMonthly(symbol);
			this.updateTextArea(viewMain, returnString);
			break;
		case "Monthly Adjusted":
			returnString = this.avTimeSeries.printMonthlyAdjusted(symbol);
			this.updateTextArea(viewMain, returnString);
			break;
		}
		viewMain.getCenterPanel().changeMetaInformation("Showing " + timeType + " information for " + symbol);
	}

}
