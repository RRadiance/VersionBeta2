package versionBeta2;

import java.util.List;
import java.util.Map;

import org.patriques.*;
import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.IntraDay;
import org.patriques.output.timeseries.data.StockData;


public class App {
	public static void main(String[] args) {
		AVAccessor accessor = new AVAccessor();
		AVTimeSeries ts = new AVTimeSeries(accessor);
		
		ts.accessIntraday("APPL", Interval.ONE_MIN, OutputSize.COMPACT);

	  }
}
