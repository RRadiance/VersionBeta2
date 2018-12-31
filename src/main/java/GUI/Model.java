package GUI;

import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;

import AlphaVantageInterface.AVAccessor;
import AlphaVantageInterface.AVTimeSeries;

public class Model {
	private AVAccessor avAccessor;
	
	public Model() {
		avAccessor = new AVAccessor();
	}
	
	public void updateTextArea(View view) {
		String text;
		view.getCenterPanel().setText("Test");
		AVTimeSeries ts = new AVTimeSeries(avAccessor);
		ts.accessIntraday("AAPL", Interval.ONE_MIN, OutputSize.COMPACT);
	}
	

}
