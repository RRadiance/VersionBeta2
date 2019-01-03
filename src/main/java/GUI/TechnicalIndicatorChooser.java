package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class TechnicalIndicatorChooser extends VBox{
	private ToggleGroup toggleGroup;
	private Model model;
	private ViewMain viewMain;
	
	public TechnicalIndicatorChooser(ViewMain viewMain, Model model, String symbol) {
		this.viewMain = viewMain;
		this.model = model;
		
		// Displays symbol the user has previously chosen
		Label stockSymbol = new Label("Get data for: " + symbol.toUpperCase());
		this.getChildren().add(stockSymbol);
		
		// Add buttons that allow user to choose what data they want to see
		// Eventually, use loops to condense the code
		this.toggleGroup = new ToggleGroup();
		

		RadioButton smaButton = new RadioButton("SMA");
		smaButton.setSelected(true); // by default, this button is selected
		RadioButton emaButton = new RadioButton("EMA");
		RadioButton macdButton = new RadioButton("MACD");
		RadioButton minusDIButton = new RadioButton("Minus DI");
		RadioButton plusDIButton = new RadioButton("Plus DI");
		RadioButton atrButton = new RadioButton("ATR");

		//intradayButton.setToggleGroup(toggleGroup);
		smaButton.setToggleGroup(toggleGroup);
		emaButton.setToggleGroup(toggleGroup);
		macdButton.setToggleGroup(toggleGroup);
		minusDIButton.setToggleGroup(toggleGroup);
		plusDIButton.setToggleGroup(toggleGroup);
		atrButton.setToggleGroup(toggleGroup);
		
		//this.getChildren().add(intradayButton);
		this.getChildren().add(smaButton);
		this.getChildren().add(emaButton);
		this.getChildren().add(macdButton);
		this.getChildren().add(minusDIButton);
		this.getChildren().add(plusDIButton);
		this.getChildren().add(atrButton);
		
		Button getDataButton = new Button("Get Data");
		getDataButton.setOnAction(new TechnicalIndChooserController(this.viewMain, this.model, symbol, this));
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
