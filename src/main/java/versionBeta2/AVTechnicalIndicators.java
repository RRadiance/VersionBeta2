package versionBeta2;

import java.util.List;
import java.util.Map;

import org.patriques.AlphaVantageConnector;
import org.patriques.TechnicalIndicators;
import org.patriques.input.technicalindicators.Interval;
import org.patriques.input.technicalindicators.SeriesType;
import org.patriques.input.technicalindicators.TimePeriod;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.technicalindicators.MACD;
import org.patriques.output.technicalindicators.data.MACDData;

/**
 * Access the Technical Indicators data from the
 * AlphaVantage API.
 * 
 * @author matthewhuynh
 *
 */
public class AVTechnicalIndicators {
	private TechnicalIndicators ti;
	private AlphaVantageConnector apiConnector;

	public AVTechnicalIndicators(AVAccessor accessor) {
		this.apiConnector = accessor.getAVConnector();
		this.ti = new TechnicalIndicators(this.apiConnector);
	}
	
	public void accessMACD(String symbol, Interval interval) {
		try {
		      MACD response = ti.macd(symbol, interval, TimePeriod.of(10), SeriesType.CLOSE, null, null, null);
		      Map<String, String> metaData = response.getMetaData();
		      System.out.println("Symbol: " + metaData.get("1: Symbol"));
		      System.out.println("Indicator: " + metaData.get("2: Indicator"));

		      List<MACDData> macdData = response.getData();
		      macdData.forEach(data -> {
		        System.out.println("date:           " + data.getDateTime());
		        System.out.println("MACD Histogram: " + data.getHist());
		        System.out.println("MACD Signal:    " + data.getSignal());
		        System.out.println("MACD:           " + data.getMacd());
		      });
		    } catch (AlphaVantageException e) {
		      System.out.println("something went wrong");
		    }
	}
}
