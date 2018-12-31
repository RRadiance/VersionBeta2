package GUI;


import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class CenterPanel extends GridPane{
	private TextArea textArea;

	public CenterPanel(Model model) {
		textArea = new TextArea("Default Text");
		this.add(textArea, 1, 1);
		textArea.setEditable(false);
	}
	
	public void setText(String text) {
		this.textArea.setText(text);
	}
}
