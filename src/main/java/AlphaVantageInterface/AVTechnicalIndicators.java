package AlphaVantageInterface;

import java.util.List;
import java.util.Map;

import org.patriques.AlphaVantageConnector;
import org.patriques.TechnicalIndicators;
import org.patriques.input.technicalindicators.Interval;
import org.patriques.input.technicalindicators.SeriesType;
import org.patriques.input.technicalindicators.TimePeriod;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.technicalindicators.ATR;
import org.patriques.output.technicalindicators.EMA;
import org.patriques.output.technicalindicators.MACD;
import org.patriques.output.technicalindicators.MINUS_DI;
import org.patriques.output.technicalindicators.PLUS_DI;
import org.patriques.output.technicalindicators.SMA;
import org.patriques.output.technicalindicators.data.IndicatorData;
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
	
	/**
	 * Gets SMA (Simple Moving Average) values
	 * 
	 * 
	 * See https://www.alphavantage.co/documentation/ for more description of each parameter
	 * @param symbol
	 * @param interval
	 * @param timePeriod
	 * @param seriesType
	 */
	public void accessSMA(String symbol, Interval interval, TimePeriod timePeriod, SeriesType seriesType) {
		try {
			SMA response = ti.sma(symbol, interval, timePeriod, seriesType);
			Map<String, String> metaData = response.getMetaData();
		    System.out.println("Symbol: " + metaData.get("1: Symbol"));
		    System.out.println("Indicator: " + metaData.get("2: Indicator"));
		    
		    // IndicatorData stored in output/technicalindicators/data/IndicatorData
		    List<IndicatorData> smaData = response.getData();
		    for (IndicatorData data : smaData) {
				System.out.println("date:     " + data.getDateTime());
				System.out.println("sma:     " + data.getData());
		    }
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
	}

	/**
	 * Gets EMA (exponential moving average) values
	 * 
	 * @param symbol
	 * @param interval
	 * @param timePeriod
	 * @param seriesType
	 */
	public void accessEMA(String symbol, Interval interval, TimePeriod timePeriod, SeriesType seriesType) {
		try {
			EMA response = ti.ema(symbol, interval, timePeriod, seriesType);
			Map<String, String> metaData = response.getMetaData();
		    System.out.println("Symbol: " + metaData.get("1: Symbol"));
		    System.out.println("Indicator: " + metaData.get("2: Indicator"));
		    
		    // IndicatorData stored in output/technicalindicators/data/IndicatorData
		    List<IndicatorData> emaData = response.getData();
		    for (IndicatorData data : emaData) {
				System.out.println("date:     " + data.getDateTime());
				System.out.println("ema:     " + data.getData());
		    }
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
	}
	
	/**
	 * Gets PLUS_DI (plus directional indicator) values
	 * 
	 * @param symbol
	 * @param interval
	 * @param timePeriod
	 */
	public void accessPlusDI(String symbol, Interval interval, TimePeriod timePeriod) {
		try {
			PLUS_DI response = ti.plus_di(symbol, interval, timePeriod);
			Map<String, String> metaData = response.getMetaData();
		    System.out.println("Symbol: " + metaData.get("1: Symbol"));
		    System.out.println("Indicator: " + metaData.get("2: Indicator"));
		    
		    // IndicatorData stored in output/technicalindicators/data/IndicatorData
		    List<IndicatorData> plusDiData = response.getData();
		    for (IndicatorData data : plusDiData) {
				System.out.println("date:     " + data.getDateTime());
				System.out.println("plus_di:     " + data.getData());
		    }
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
	}
	
	/**
	 * Gets MINUS_DI (minus directional indicator) values
	 * 
	 * @param symbol
	 * @param interval
	 * @param timePeriod
	 */
	public void accessMinusDI(String symbol, Interval interval, TimePeriod timePeriod) {
		try {
			MINUS_DI response = ti.minus_di(symbol, interval, timePeriod);
			Map<String, String> metaData = response.getMetaData();
		    System.out.println("Symbol: " + metaData.get("1: Symbol"));
		    System.out.println("Indicator: " + metaData.get("2: Indicator"));
		    
		    // IndicatorData stored in output/technicalindicators/data/IndicatorData
		    List<IndicatorData> minusDiData = response.getData();
		    for (IndicatorData data :minusDiData) {
				System.out.println("date:     " + data.getDateTime());
				System.out.println("minus_di:     " + data.getData());
		    }
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
	}
	
	/**
	 * Gets ATR (average true range) values
	 * 
	 * @param symbol
	 * @param interval
	 * @param timePeriod
	 */
	public void accessATR(String symbol, Interval interval, TimePeriod timePeriod) {
		try {
			ATR response = ti.atr(symbol, interval, timePeriod);
			Map<String, String> metaData = response.getMetaData();
		    System.out.println("Symbol: " + metaData.get("1: Symbol"));
		    System.out.println("Indicator: " + metaData.get("2: Indicator"));
		    
		    // IndicatorData stored in output/technicalindicators/data/IndicatorData
		    List<IndicatorData> atrData = response.getData();
		    for (IndicatorData data: atrData) {
				System.out.println("date:     " + data.getDateTime());
				System.out.println("atr:     " + data.getData());
		    }
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
	}
	
	
	/**
	 * Gets MACD of a given symbol in a specified interval.
	 * 
	 * TODO: Figure out what TimePeriod represents
	 * 
	 * See https://www.alphavantage.co/documentation/ for more description of each parameter
	 * 
	 * @param symbol
	 * @param interval
	 */
	public void accessMACD(String symbol, Interval interval) {
		try {
		      MACD response = ti.macd(symbol, interval, TimePeriod.of(10), SeriesType.CLOSE, null, null, null);
		      Map<String, String> metaData = response.getMetaData();
		      System.out.println("Symbol: " + metaData.get("1: Symbol"));
		      System.out.println("Indicator: " + metaData.get("2: Indicator"));

		      //MACDData stored in output/technicalindicators/data/MACDData.java
		      List<MACDData> macdData = response.getData();
		      for (MACDData data: macdData) {
		        System.out.println("date:           " + data.getDateTime());
		        System.out.println("MACD Histogram: " + data.getHist());
		        System.out.println("MACD Signal:    " + data.getSignal());
		        System.out.println("MACD:           " + data.getMacd());
		      }
		    } catch (AlphaVantageException e) {
		      System.out.println("something went wrong");
		    }
	}
	
	public String printSMA(String symbol, Interval interval, TimePeriod timePeriod, SeriesType seriesType) {
		String returnString = "";
		try {
			SMA response = ti.sma(symbol, interval, timePeriod, seriesType);
			Map<String, String> metaData = response.getMetaData();
		    returnString += "Symbol: " + metaData.get("1: Symbol") + "\n";
		    returnString += "Indicator: " + metaData.get("2: Indicator") + "\n";
		    
		    // IndicatorData stored in output/technicalindicators/data/IndicatorData
		    List<IndicatorData> smaData = response.getData();
		    for (IndicatorData data : smaData) {
				returnString += "date:     " + data.getDateTime() + "\n";
				returnString += "sma:     " + data.getData() + "\n";
		    }
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
		return returnString;
	}
	
	public String printEMA(String symbol, Interval interval, TimePeriod timePeriod, SeriesType seriesType) {
		String returnString = "";
		try {
			EMA response = ti.ema(symbol, interval, timePeriod, seriesType);
			Map<String, String> metaData = response.getMetaData();
			returnString += "Symbol: " + metaData.get("1: Symbol") + "\n";
		    returnString += "Indicator: " + metaData.get("2: Indicator") + "\n";
		    
		    // IndicatorData stored in output/technicalindicators/data/IndicatorData
		    List<IndicatorData> emaData = response.getData();
		    for (IndicatorData data : emaData) {
		    	returnString += "date:     " + data.getDateTime() + "\n";
				returnString += "ema:     " + data.getData() + "\n";
		    }
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
		return returnString;
	}
	
	public String printPlusDI(String symbol, Interval interval, TimePeriod timePeriod) {
		String returnString = "";
		try {
			PLUS_DI response = ti.plus_di(symbol, interval, timePeriod);
			Map<String, String> metaData = response.getMetaData();
			returnString += "Symbol: " + metaData.get("1: Symbol") + "\n";
		    returnString += "Indicator: " + metaData.get("2: Indicator") + "\n";
		    
		    // IndicatorData stored in output/technicalindicators/data/IndicatorData
		    List<IndicatorData> plusDiData = response.getData();
		    for (IndicatorData data : plusDiData) {
		    	returnString += "date:     " + data.getDateTime() + "\n";
				returnString += "plus_di:     " + data.getData() + "\n";
		    }
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
		return returnString;
	}
	
	public String printMinusDI(String symbol, Interval interval, TimePeriod timePeriod) {
		String returnString = "";
		try {
			MINUS_DI response = ti.minus_di(symbol, interval, timePeriod);
			Map<String, String> metaData = response.getMetaData();
			returnString += "Symbol: " + metaData.get("1: Symbol") + "\n";
		    returnString += "Indicator: " + metaData.get("2: Indicator") + "\n";
		    
		    // IndicatorData stored in output/technicalindicators/data/IndicatorData
		    List<IndicatorData> minusDiData = response.getData();
		    for (IndicatorData data :minusDiData) {
		    	returnString += "date:     " + data.getDateTime() + "\n";
				returnString += "minus_di:     " + data.getData() + "\n";
		    }
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
		return returnString;
	}
	
	public String printATR(String symbol, Interval interval, TimePeriod timePeriod) {
		String returnString = "";
		try {
			ATR response = ti.atr(symbol, interval, timePeriod);
			Map<String, String> metaData = response.getMetaData();
			returnString += "Symbol: " + metaData.get("1: Symbol") + "\n";
		    returnString += "Indicator: " + metaData.get("2: Indicator") + "\n";
		    
		    // IndicatorData stored in output/technicalindicators/data/IndicatorData
		    List<IndicatorData> atrData = response.getData();
		    for (IndicatorData data: atrData) {
		    	returnString += "date:     " + data.getDateTime() + "\n";
				returnString += "atr:     " + data.getData() + "\n";
		    }
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
		return returnString;
	}
	
	public String printMACD(String symbol, Interval interval) {
		String returnString = "";
		try {
		      MACD response = ti.macd(symbol, interval, TimePeriod.of(10), SeriesType.CLOSE, null, null, null);
		      Map<String, String> metaData = response.getMetaData();
		      returnString += "Symbol: " + metaData.get("1: Symbol") + "\n";
			    returnString += "Indicator: " + metaData.get("2: Indicator") + "\n";

		      //MACDData stored in output/technicalindicators/data/MACDData.java
		      List<MACDData> macdData = response.getData();
		      for (MACDData data: macdData) {
		    	returnString += "date:     " + data.getDateTime() + "\n";
		        returnString += "MACD Histogram: " + data.getHist() + "\n";
		        returnString += "MACD Signal:    " + data.getSignal() + "\n";
		        returnString += "MACD:           " + data.getMacd() + "\n";
		      }
		    } catch (AlphaVantageException e) {
		      System.out.println("something went wrong");
		    }
		return returnString;
	}
}
