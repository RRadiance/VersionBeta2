package GUI;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class CenterPanel extends BorderPane{
	private TextArea textArea;
	private HBox toolbar;
	private Button graphButton;
	private Label metaInformation;

	public CenterPanel(Model model) {
		this.textArea = new TextArea("Enter a symbol on the left to get started");
		this.textArea.setEditable(false);
		this.graphButton = new Button("Show Graph");
		this.metaInformation = new Label();
		
		this.toolbar = new HBox();
		this.toolbar.getChildren().add(this.graphButton);
		this.toolbar.getChildren().add(this.metaInformation);
		
		this.setTop(toolbar);
		this.setCenter(textArea);
	}
	
	public void setText(String text) {
		this.textArea.setText(text);
	}
	
	public void changeMetaInformation(String text) {
		this.metaInformation.setText(text);
	}
}
