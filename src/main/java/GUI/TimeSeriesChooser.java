package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class TimeSeriesChooser extends VBox{
	private ToggleGroup toggleGroup;
	private Model model;
	private ViewMain viewMain;
	
	public TimeSeriesChooser(ViewMain viewMain, Model model, String symbol) {
		this.viewMain = viewMain;
		this.model = model;
		
		// Displays symbol the user has previously chosen
		Label stockSymbol = new Label("Get data for: " + symbol.toUpperCase());
		this.getChildren().add(stockSymbol);
		
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
		
		//this.getChildren().add(intradayButton);
		this.getChildren().add(dailyButton);
		this.getChildren().add(dailyAdjustedButton);
		this.getChildren().add(weeklyButton);
		this.getChildren().add(weeklyAdjustedButton);
		this.getChildren().add(monthlyButton);
		this.getChildren().add(monthlyAdjustedButton);
		
		Button getDataButton = new Button("Get Data");
		getDataButton.setOnAction(new TimeSeriesChooserController(this.viewMain, this.model, symbol, this));
		this.getChildren().add(getDataButton);
		
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
