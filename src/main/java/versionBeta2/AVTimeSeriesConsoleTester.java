package versionBeta2;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;

/**
 * Allows the user to use the console to test AVTimeSeries by inputting
 * text.
 * 
 * @author matthewhuynh
 *
 */
public class AVTimeSeriesConsoleTester {
	public static void main(String[] args) {
		AVAccessor accessor = new AVAccessor();
		AVTimeSeries ts = new AVTimeSeries(accessor);
		String userInput = "";

		Scanner scanner = new Scanner(System.in);
		// Test AVTimeSeries using console input
		while (!userInput.equals("end")) {
			String symbol;
			System.out.println("What would you like to do? Options include:");
			System.out.println("Check Intraday [1], Daily [2], Daily Adj [3], Weekly [4], \n"
					+ "Weekly Adj [5], Monthly [6], Monthly Adj [7]");
			System.out.println("Type \"end\" to exit");
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
				ts.accessDailyAdjusted(symbol, OutputSize.COMPACT);
				break;
			case "4":
				ts.accessWeekly(symbol);
				break;
			case "5":
				ts.accessWeeklyAdjusted(symbol);
				break;
			case "6":
				ts.accessMonthly(symbol);
				break;
			case "7":
				ts.accessMonthlyAdjusted(symbol);
				break;
			}
		}

		System.out.println("End of main method");
		scanner.close();
	}
}
