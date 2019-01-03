package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class TimeSeriesChooser extends GridPane{
	private ToggleGroup toggleGroup;
	private Model model;
	private ViewMain viewMain;
	
	public TimeSeriesChooser(ViewMain viewMain, Model model, String symbol) {
		this.viewMain = viewMain;
		this.model = model;
		this.setPadding(new Insets(10,10,10,10));
		this.setVgap(10);
		
		// Displays symbol the user has previously chosen
		Label stockSymbol = new Label("Get data for: " + symbol.toUpperCase());
		this.add(stockSymbol, 1, 1);
		
		// Add buttons that allow user to choose what data they want to see
		// Eventually, use loops to condense the code
		this.toggleGroup = new ToggleGroup();
		
		//RadioButton intradayButton = new RadioButton("Intraday");
		RadioButton dailyButton = new RadioButton("Daily");
		dailyButton.setSelected(true);
		RadioButton dailyAdjustedButton = new RadioButton("Daily Adjusted");
		RadioButton weeklyButton = new RadioButton("Weekly");
		RadioButton weeklyAdjustedButton = new RadioButton("Weekly Adjusted");
		RadioButton monthlyButton = new RadioButton("Monthly");
		RadioButton monthlyAdjustedButton = new RadioButton("Monthly Adjusted");

		//intradayButton.setToggleGroup(toggleGroup);
		dailyButton.setToggleGroup(toggleGroup);
		dailyAdjustedButton.setToggleGroup(toggleGroup);
		weeklyButton.setToggleGroup(toggleGroup);
		weeklyAdjustedButton.setToggleGroup(toggleGroup);
		monthlyButton.setToggleGroup(toggleGroup);
		monthlyAdjustedButton.setToggleGroup(toggleGroup);
		
		//this.add(intradayButton);
		this.add(dailyButton, 1, 2);
		this.add(dailyAdjustedButton, 1, 3);
		this.add(weeklyButton, 1, 4);
		this.add(weeklyAdjustedButton, 1, 5);
		this.add(monthlyButton, 1, 6);
		this.add(monthlyAdjustedButton, 1, 7);
		
		Button getDataButton = new Button("Get Data");
		getDataButton.setOnAction(new TimeSeriesChooserController(this.viewMain, this.model, symbol, this));
		this.add(getDataButton, 1, 8);
		
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(new TimeSeriesChooserController(this.viewMain, this.model, symbol, this));
		this.add(cancelButton, 2, 8);
	}
	
	/**
	 * Return the string name of the toggled radio button that the user has chosen.
	 * 
	 * @return
	 */
	public String getToggledButton() {
		RadioButton selectedRadioButton = (RadioButton) this.toggleGroup.getSelectedToggle();
		String radioButtonName = selectedRadioButton.getText();
		return radioButtonName;
	}
	
	
}
