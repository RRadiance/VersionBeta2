package versionBeta2;

import java.util.List;
import java.util.Map;

import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.IntraDay;
import org.patriques.output.timeseries.data.StockData;

/**
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
			Map<String, String> metaData = response.getMetaData();
			System.out.println("Information: " + metaData.get("1. Information"));
			System.out.println("Stock: " + metaData.get("2. Symbol"));

			List<StockData> stockData = response.getStockData();
			stockData.forEach(stock -> {
				System.out.println("date:   " + stock.getDateTime());
				System.out.println("open:   " + stock.getOpen());
				System.out.println("high:   " + stock.getHigh());
				System.out.println("low:    " + stock.getLow());
				System.out.println("close:  " + stock.getClose());
				System.out.println("volume: " + stock.getVolume());
			});
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
		
	}
	
	/**
	 * Gets Adjusted Daily time series data of a specified stock
	 * @param symbol
	 * @param outputSize
	 */
	public void accessDailyAdjusted(String symbol, OutputSize outputSize) {
		
	}
	
	/**
	 * Gets Weekly time series data of a specified stock
	 * @param symbol
	 * @param outputSize
	 */
	public void accessWeekly(String symbol, OutputSize outputSize) {
		
	}
	
	/**
	 * Gets Adjusted Weekly time series data of a specified stock
	 * @param symbol
	 * @param outputSize
	 */
	public void accessWeeklyAdjusted(String symbol, OutputSize outputSize) {
		
	}
	
	/**
	 * Gets Monthly time series data of a specified stock
	 * @param symbol
	 * @param outputSize
	 */
	public void accessMonthly(String symbol, OutputSize outputSize) {
		
	}
	
	/**
	 * Gets Adjusted Monthly time series data of a specified stock
	 * @param symbol
	 * @param outputSize
	 */
	public void accessMonthlyAdjusted(String symbol, OutputSize outputSize) {
		
	}
	
	
}
