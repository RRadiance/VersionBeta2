package versionBeta2;

import java.util.List;
import java.util.Map;

import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.Daily;
import org.patriques.output.timeseries.IntraDay;
import org.patriques.output.timeseries.Monthly;
import org.patriques.output.timeseries.Weekly;
import org.patriques.output.timeseries.data.StockData;

/**
 * Access the Time Series data from the AlphaVantage API.
 * 
 * @author matthewhuynh
 *
 */
public class AVTimeSeries {
	private TimeSeries stockTimeSeries;
	private AlphaVantageConnector apiConnector;

	public AVTimeSeries(AVAccessor accessor) {
		this.apiConnector = accessor.getAVConnector();
		this.stockTimeSeries = new TimeSeries(this.apiConnector);
	}

	/**
	 * Gets Intraday time series data of a given stock.
	 * 
	 * @param symbol - a stock quote
	 * @param interval - Intervals can come in 1/5/10/15/30/60 minute intervals
	 * @param outputSize - a compact output size returns the latest 100 data points, 
	 * while a full output size returns the full-length intraday time series
	 */
	public void accessIntraday(String symbol, Interval interval, OutputSize outputSize) {
		try {
			IntraDay response = stockTimeSeries.intraDay(symbol, interval, outputSize);
			
			// Stores Map of metadata from JSON object
			Map<String, String> metaData = response.getMetaData();			
			System.out.println("Information: " + metaData.get("1. Information"));
			System.out.println("Stock: " + metaData.get("2. Symbol"));

			// The list stores StockData, which is a representation of a JSON object
			List<StockData> stockData = response.getStockData();
			this.printUnadjustedTimeData(stockData);
			
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
	}
	
	/**
	 * Gets Daily time series data of a specified stock
	 * @param symbol
	 * @param outputSize
	 */
	public void accessDaily(String symbol, OutputSize outputSize) {
		Daily response = stockTimeSeries.daily(symbol, outputSize);
		
		// Stores Map of metadata from JSON object
		Map<String, String> metaData = response.getMetaData();			
		System.out.println("Information: " + metaData.get("1. Information"));
		System.out.println("Stock: " + metaData.get("2. Symbol"));

		// The list stores StockData, which is a representation of a JSON object
		List<StockData> stockData = response.getStockData();
		this.printUnadjustedTimeData(stockData);
	}
	
	/**
	 * Gets Adjusted Daily time series data of a specified stock
	 * @param symbol
	 * @param outputSize
	 */
	public void accessDailyAdjusted(String symbol, OutputSize outputSize) {
		Daily response = stockTimeSeries.daily(symbol, outputSize);
		
		// Stores Map of metadata from JSON object
		Map<String, String> metaData = response.getMetaData();			
		System.out.println("Information: " + metaData.get("1. Information"));
		System.out.println("Stock: " + metaData.get("2. Symbol"));

		// The list stores StockData, which is a representation of a JSON object
		List<StockData> stockData = response.getStockData();
		this.printAdjustedDailyTimeData(stockData);
	}
	
	/**
	 * Gets Weekly time series data of a specified stock.
	 * Note that weekly means last trading day of each week, 
	 * weekly open, weekly high, weekly low, weekly close, weekly volume
	 * 
	 * @param symbol
	 */
	public void accessWeekly(String symbol) {
		Weekly response = stockTimeSeries.weekly(symbol);

		// Stores Map of metadata from JSON object
		Map<String, String> metaData = response.getMetaData();
		System.out.println("Information: " + metaData.get("1. Information"));
		System.out.println("Stock: " + metaData.get("2. Symbol"));

		// The list stores StockData, which is a representation of a JSON object
		List<StockData> stockData = response.getStockData();
		this.printUnadjustedTimeData(stockData);
	}
	
	/**
	 * Gets Adjusted Weekly time series data of a specified stock.
	 * Note that weekly adjusted means last trading day of each week, 
	 * weekly open, weekly high, weekly low, weekly close, weekly adjusted close, 
	 * weekly volume, weekly dividend
	 * 
	 * @param symbol
	 * @param outputSize
	 */
	public void accessWeeklyAdjusted(String symbol) {
		Weekly response = stockTimeSeries.weekly(symbol);

		// Stores Map of metadata from JSON object
		Map<String, String> metaData = response.getMetaData();
		System.out.println("Information: " + metaData.get("1. Information"));
		System.out.println("Stock: " + metaData.get("2. Symbol"));

		// The list stores StockData, which is a representation of a JSON object
		List<StockData> stockData = response.getStockData();
		this.printAdjustedTimeData(stockData);
		
	}
	
	/**
	 * Gets Monthly time series data of a specified stock.
	 * Note that monthly  means last trading day of each month,
	 * monthly open, monthly high, monthly low, monthly close, monthly volume.
	 * 
	 * @param symbol
	 */
	public void accessMonthly(String symbol) {
		Monthly response = stockTimeSeries.monthly(symbol);

		// Stores Map of metadata from JSON object
		Map<String, String> metaData = response.getMetaData();
		System.out.println("Information: " + metaData.get("1. Information"));
		System.out.println("Stock: " + metaData.get("2. Symbol"));

		// The list stores StockData, which is a representation of a JSON object
		List<StockData> stockData = response.getStockData();
		this.printUnadjustedTimeData(stockData);

	}

	/**
	 * Gets Adjusted Monthly time series data of a specified stock.
	 * Note that monthly adjusted means last trading day of each month, 
	 * monthly open, monthly high, monthly low, monthly close, monthly adjusted close, 
	 * monthly volume, monthly dividend.
	 * 
	 * @param symbol
	 * @param outputSize
	 */
	public void accessMonthlyAdjusted(String symbol) {
		Monthly response = stockTimeSeries.monthly(symbol);

		// Stores Map of metadata from JSON object
		Map<String, String> metaData = response.getMetaData();
		System.out.println("Information: " + metaData.get("1. Information"));
		System.out.println("Stock: " + metaData.get("2. Symbol"));

		// The list stores StockData, which is a representation of a JSON object
		List<StockData> stockData = response.getStockData();
		this.printAdjustedTimeData(stockData);
	}
	
	/**
	 * Given a list of StockData, outputs data of each stock according to its time
	 * 
	 * @param stockData
	 */
	private void printUnadjustedTimeData(List<StockData> stockData) {
		for (StockData stock : stockData) {
			System.out.println("date:   " + stock.getDateTime());
			System.out.println("open:   " + stock.getOpen());
			System.out.println("high:   " + stock.getHigh());
			System.out.println("low:    " + stock.getLow());
			System.out.println("close:  " + stock.getClose());
			System.out.println("volume: " + stock.getVolume());
		}
	}
	
	/**
	 * Given a list of StockData for adjusted time intervals,
	 * outputs data of each stock according to its time.
	 * This may be used for weekly and monthly adjusted
	 * time intervals.
	 * 
	 * @param stockData
	 */
	private void printAdjustedTimeData(List<StockData> stockData) {
		for (StockData stock : stockData) {
			System.out.println("date:     " + stock.getDateTime());
			System.out.println("open:     " + stock.getOpen());
			System.out.println("high:     " + stock.getHigh());
			System.out.println("low:      " + stock.getLow());
			System.out.println("close:    " + stock.getClose());
			System.out.println("adj.clos: " + stock.getAdjustedClose());
			System.out.println("volume: " + stock.getVolume());
			System.out.println("dividend amnt: " + stock.getDividendAmount());
		}
	}
	
	/**
	 * Given a list of StockData for adjusted time intervals,
	 * outputs data of each stock according to its time.
	 * This may be used only for daily time intervals
	 * 
	 * @param stockData
	 */
	private void printAdjustedDailyTimeData(List<StockData> stockData) {
		for (StockData stock : stockData) {
			System.out.println("date:     " + stock.getDateTime());
			System.out.println("open:     " + stock.getOpen());
			System.out.println("high:     " + stock.getHigh());
			System.out.println("low:      " + stock.getLow());
			System.out.println("close:    " + stock.getClose());
			System.out.println("adj.clos: " + stock.getAdjustedClose());
			System.out.println("volume: " + stock.getVolume());
			System.out.println("dividend amnt: " + stock.getDividendAmount());
			System.out.println("split coeff:   " + stock.getSplitCoefficient());
		}
	}
	
}
