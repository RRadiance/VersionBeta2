package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonChooserPanelController implements EventHandler<ActionEvent>{
	private Model model;
	private View view;
	
	public ButtonChooserPanelController(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	/**
	 * handler to handle the ActionEvent for a button in ButtonChooserPanel
	 */
	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getText();
		System.out.println(command);
		
		this.model.updateTextArea(this.view);
		//this.model.doSomething(); the model in turn then manipulates the view
	}

}
