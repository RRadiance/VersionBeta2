package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * This creates a dialog box that allows the user to choose what
 * technical indicator they would like to see for a given stock
 * symbol. The user uses radio buttons and buttons to make their
 * decision.
 * 
 * @author matthewhuynh
 *
 */
public class TechnicalIndicatorChooser extends GridPane{
	private ToggleGroup toggleGroup;
	private Model model;
	private ViewMain viewMain;
	
	public TechnicalIndicatorChooser(ViewMain viewMain, Model model, String symbol) {
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
	
		RadioButton smaButton = new RadioButton("SMA");
		smaButton.setSelected(true); // by default, this button is selected
		RadioButton emaButton = new RadioButton("EMA");
		RadioButton macdButton = new RadioButton("MACD");
		RadioButton minusDIButton = new RadioButton("-DI");
		RadioButton plusDIButton = new RadioButton("+DI");
		RadioButton atrButton = new RadioButton("ATR");

		smaButton.setToggleGroup(toggleGroup);
		emaButton.setToggleGroup(toggleGroup);
		macdButton.setToggleGroup(toggleGroup);
		minusDIButton.setToggleGroup(toggleGroup);
		plusDIButton.setToggleGroup(toggleGroup);
		atrButton.setToggleGroup(toggleGroup);
		
		this.add(smaButton, 1, 2);
		this.add(new Label("Simple Moving Average"), 2, 2);
		this.add(emaButton, 1, 3);
		this.add(new Label("Exponential Moving Average"), 2, 3);
		this.add(macdButton, 1, 4);
		this.add(new Label("Moving Average Convergence Divergence"), 2, 4);
		this.add(minusDIButton, 1, 5);
		this.add(new Label("Negative Directional Indicator"), 2, 5);
		this.add(plusDIButton, 1, 6);
		this.add(new Label("Positive Directional Indicator"), 2, 6);
		this.add(atrButton, 1, 7);
		this.add(new Label("Average True Range"), 2, 7);
		
		Button getDataButton = new Button("Get Data");
		getDataButton.setOnAction(new TechnicalIndChooserController(this.viewMain, this.model, symbol, this));
		this.add(getDataButton, 1, 8);
		
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(new TechnicalIndChooserController(this.viewMain, this.model, symbol, this));
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
