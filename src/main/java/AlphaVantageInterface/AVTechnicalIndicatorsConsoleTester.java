package AlphaVantageInterface;

import java.util.Scanner;

import org.patriques.input.technicalindicators.SeriesType;
import org.patriques.input.technicalindicators.TimePeriod;
import org.patriques.input.technicalindicators.Interval;

/**
 * Allows the user to use the console to test AVTechnicalIndicator by inputting
 * text.
 * 
 * @author matthewhuynh
 *
 */
public class AVTechnicalIndicatorsConsoleTester {
	public static void main(String[] args) {
		AVAccessor accessor = new AVAccessor();
		AVTechnicalIndicators ti = new AVTechnicalIndicators(accessor);
		String userInput = "";

		Scanner scanner = new Scanner(System.in);
		// Test AVTimeSeries using console input
		while (!userInput.equals("end")) {
			String symbol;
			System.out.println("What would you like to do? Options include:");
			System.out.println("SMA [1], EMA [2], MACD [3], MINUS_DI [4], \n" + "PLUS_DI [5], ATR [6]");
			System.out.println("Type \"end\" to exit");
			userInput = scanner.nextLine();

			if (userInput.equals("end")) {
				break;
			}

			// Asks user for symbol to check
			System.out.println("Which symbol?");
			symbol = scanner.nextLine();
			switch (userInput) {
			case "1":
				ti.accessSMA(symbol, Interval.WEEKLY, TimePeriod.of(10), SeriesType.CLOSE);
				break;
			case "2":
				ti.accessEMA(symbol, Interval.WEEKLY, TimePeriod.of(10), SeriesType.CLOSE);
				break;
			case "3":
				ti.accessMACD(symbol, Interval.DAILY);
				break;
			case "4":
				ti.accessMinusDI(symbol, Interval.WEEKLY, TimePeriod.of(10));
				break;
			case "5":
				ti.accessPlusDI(symbol, Interval.WEEKLY, TimePeriod.of(10));
				break;
			case "6":
				ti.accessATR(symbol, Interval.WEEKLY, TimePeriod.of(10));
				break;
			}
		}

		System.out.println("End of main method");
		scanner.close();

	}
}
