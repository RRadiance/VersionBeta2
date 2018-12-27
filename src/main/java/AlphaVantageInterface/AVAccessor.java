package AlphaVantageInterface;

import org.patriques.AlphaVantageConnector;

/**
 * Creates an access point for the AlphaVantage API.
 * 
 * @author matthewhuynh
 *
 */
public class AVAccessor {
	private static String apiKey = "5YOKEKYYTQZHPYM1";
	private int timeout = 3000;
	private AlphaVantageConnector apiConnector;
	
	public AVAccessor() {
	    this.apiConnector = new AlphaVantageConnector(AVAccessor.apiKey, this.timeout);
	}
	
	public AlphaVantageConnector getAVConnector() {
		return this.apiConnector;
	}
}
