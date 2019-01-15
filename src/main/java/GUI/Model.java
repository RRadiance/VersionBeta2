package GUI;

import org.patriques.input.technicalindicators.Interval;
import org.patriques.input.technicalindicators.SeriesType;
import org.patriques.input.technicalindicators.TimePeriod;
import org.patriques.input.timeseries.OutputSize;

import AlphaVantageInterface.AVAccessor;
import AlphaVantageInterface.AVTechnicalIndicators;
import AlphaVantageInterface.AVTimeSeries;

/**
 * The Model is controlled by the Controllers and manipulates the graphical view components.
 * All API accesses are also done through the Model.
 * 
 * @author matthewhuynh
 *
 */
public class Model {
	private AVAccessor avAccessor;
	private AVTimeSeries avTimeSeries;
	private AVTechnicalIndicators avTechnicalIndicators;
	
	public Model() {
		avAccessor = new AVAccessor();
		avTimeSeries = new AVTimeSeries(avAccessor);
		avTechnicalIndicators = new AVTechnicalIndicators(avAccessor);
	}
	
	/**
	 * Updates the raw data text area.
	 * 
	 * @param viewMain
	 * @param text
	 */
	public void updateTextArea(ViewMain viewMain, String text) {
		viewMain.getCenterPanel().setText(text);
	}
	
	/**
	 * Tells the View to create a new dialog box that shows
	 * time series data options
	 * 
	 * @param viewMain
	 * @param symbol
	 */
	public void openTimeSeriesDialogBox(ViewMain viewMain, String symbol) {
		viewMain.createTimeSeriesDialogBox(symbol);
	}
	
	/**
	 * Tells the View to create a new dialog box that shows
	 * technical indicator data options
	 * 
	 * @param viewMain
	 * @param symbol
	 */
	public void openTechnicalIndicatorsDialogBox(ViewMain viewMain, String symbol) {
		viewMain.createTechnicalIndicatorsDialogBox(symbol);
	}
	
	/**
	 * Determines what type of time series data the user would like to see by checking
	 * which radio button they have selected. Accesses the AV Interface, calling
	 * the appropriate method in AVTimeSeries.
	 * 
	 * @param symbol
	 * @param timeType
	 */
	public void accessAVTimeSeries(ViewMain viewMain, String symbol, String timeType) {
		System.out.println(timeType);
		String returnString = "Something went wrong with retrieving data for " + symbol + 
				".\nPlease check the symbol and your internet connection and try again.";
		try {
			switch (timeType) {
			case "Daily":
				returnString = this.avTimeSeries.printDaily(symbol, OutputSize.COMPACT); // OutputSize.FULL
				this.avTimeSeries.packageDaily(symbol, OutputSize.COMPACT);
				break;
			case "Daily Adjusted":
				returnString = this.avTimeSeries.printDailyAdjusted(symbol, OutputSize.COMPACT);
				break;
			case "Weekly":
				returnString = this.avTimeSeries.printWeekly(symbol);
				break;
			case "Weekly Adjusted":
				returnString = this.avTimeSeries.printWeeklyAdjusted(symbol);
				break;
			case "Monthly":
				returnString = this.avTimeSeries.printMonthly(symbol);
				break;
			case "Monthly Adjusted":
				returnString = this.avTimeSeries.printMonthlyAdjusted(symbol);
				break;
			}
		} catch (Exception e) {
			returnString = "Something went wrong with retrieving data for " + symbol + 
					".\nPlease check the symbol and your internet connection and try again." +
					"\nDeveloper Notes: See exception in Model.accessAVTimeSeries";
		}
		this.updateTextArea(viewMain, returnString);
		viewMain.getCenterPanel().changeMetaInformation("Showing " + timeType + " information for " + symbol);
	}

	/**
	 * Determines what type of technical indicator data the user would 
	 * like to see by checking hich radio button they have selected. 
	 * Accesses the AV Interface, calling the appropriate method in AVTechnicalIndicators.
	 * 
	 * @param symbol
	 * @param timeType
	 */
	public void accessAVTechnicalIndicators(ViewMain viewMain, String symbol, String tiType) {
//		System.out.println(symbol);
//		System.out.println(tiType);
		String returnString = "Something went wrong with retrieving data for " + symbol + 
				".\nPlease check the symbol and your internet connection and try again.";
		try {
			switch(tiType) {
			case "SMA":
				returnString = this.avTechnicalIndicators.printSMA(symbol, Interval.WEEKLY, TimePeriod.of(10), SeriesType.CLOSE);
				break;
			case "EMA":
				returnString = this.avTechnicalIndicators.printEMA(symbol, Interval.WEEKLY, TimePeriod.of(10), SeriesType.CLOSE);
				break;
			case "MACD":
				returnString = this.avTechnicalIndicators.printMACD(symbol, Interval.WEEKLY);
				break;
			case "-DI":
				returnString = this.avTechnicalIndicators.printMinusDI(symbol, Interval.WEEKLY, TimePeriod.of(10));
				break;
			case "+DI":
				returnString = this.avTechnicalIndicators.printPlusDI(symbol, Interval.WEEKLY, TimePeriod.of(10));
				break;
			case "ATR":
				returnString = this.avTechnicalIndicators.printATR(symbol, Interval.WEEKLY, TimePeriod.of(10));
				break;
			}
		} catch (Exception e) {
			returnString = "Something went wrong with retrieving data for " + symbol + 
					".\nPlease check the symbol and your internet connection and try again." +
					"\nDeveloper Notes: See exception in Model.accessAVTechnicalIndicators";
		}
		System.out.println("Reached");
		this.updateTextArea(viewMain, returnString);
		viewMain.getCenterPanel().changeMetaInformation("Showing " + tiType + " information for " + symbol);
	}

}
