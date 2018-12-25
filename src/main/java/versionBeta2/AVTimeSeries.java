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
	
	public void accessIntraday(String quote, Interval interval, OutputSize outputSize) {
		try {
			IntraDay response = stockTimeSeries.intraDay(quote, interval, outputSize);
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
}
