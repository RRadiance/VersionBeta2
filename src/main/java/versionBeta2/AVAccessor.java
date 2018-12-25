package versionBeta2;

import org.patriques.AlphaVantageConnector;

/**
 * Creates an access point for the AlphaVantage API.
 * 
 * @author matthewhuynh
 *
 */
public class AVAccessor {
	private String apiKey;
	private int timeout;
	private AlphaVantageConnector apiConnector;
	
	public AVAccessor() {
		this.apiKey = "5YOKEKYYTQZHPYM1";
	    this.timeout = 3000;
	    this.apiConnector = new AlphaVantageConnector(apiKey, timeout);
	}
	
	public AlphaVantageConnector getAVConnector() {
		return this.apiConnector;
	}
}
