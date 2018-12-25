package versionBeta2;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;

/**
 * Allows the user to use the console to test AlphaVantage classes by inputting
 * text.
 * 
 * @author matthewhuynh
 *
 */
public class AVConsoleTester {
	public static void main(String[] args) {
		AVAccessor accessor = new AVAccessor();
		AVTimeSeries ts = new AVTimeSeries(accessor);
		String userInput = "";

		Scanner scanner = new Scanner(System.in);
		// Test AVTimeSeries using console input
		while (!userInput.equals("end")) {
			String symbol;
			System.out.println("What would you like to do? Options include:");
			System.out.println("Check Intraday [1], Daily [2], Weekly[3], Monthly [4]");
			System.out.println("Type \"end\" to exit\n");
			userInput = scanner.nextLine();
			
			if(userInput.equals("end")) {
				break;
			}
			
			// Asks user for symbol to check
			System.out.println("Which symbol?");
			symbol = scanner.nextLine();
			switch (userInput) {
			case "1":
				ts.accessIntraday(symbol, Interval.ONE_MIN, OutputSize.COMPACT);
				break;
			case "2":
				ts.accessDaily(symbol, OutputSize.COMPACT);
				break;
			case "3":
				ts.accessWeekly(symbol, OutputSize.COMPACT);
				break;
			case "4":
				ts.accessWeekly(symbol, OutputSize.COMPACT);
				break;
			}
		}

		System.out.println("End of main method");
		scanner.close();
	}
}
