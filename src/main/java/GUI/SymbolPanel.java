package GUI;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * SymbolPanel contains the text field that the user can use to input 
 * a stock ticker (symbol). 
 * 
 * @author matthewhuynh
 *
 */
public class SymbolPanel extends VBox{
	private ViewMain viewMain; // So we can talk to our parent or other components of the view
	private Model model;
	private TextField symbol;
	
	/**
	 * Creates a SymbolPanel with an empty text field by default
	 * @param model
	 * @param viewMain
	 */
	public SymbolPanel(Model model, ViewMain viewMain) {
		this.viewMain = viewMain;
		this.model = model;
		
		this.symbol = new TextField("");
		this.symbol.setPromptText("Enter Symbol");
		
		this.getChildren().add(symbol);
	}
	
	/**
	 * Called from ButtonChooserPanelController, returns the stock symbol the
	 * user has inputted. 
	 * @return
	 */
	public String getSymbol() {
		return this.symbol.getText();
	}
	
	
	/**
	 * Called from ButtonChooserPanelController, changes any lowercase
	 * letters to uppercase
	 */
	public void setSymbolToUppercase() {
		this.symbol.setText(this.symbol.getText().toUpperCase());
	}
}
