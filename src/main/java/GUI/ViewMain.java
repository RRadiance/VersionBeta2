package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewMain implements EventHandler<ActionEvent>{

	private Model model;

	private Scene primary;
	private BorderPane root;
	private CenterPanel centerNode;
	private SymbolPanel symbolPanel;

	/**
	 * The constructor for View. 
	 * 
	 * @param model
	 * @param stage
	 */
	public ViewMain(Model model, Stage stage) {
		this.model = model;
		initUI(stage);
	}

	/**
	 * This method creates the panels that store most of the graphical elements
	 * that the user will see. This method is also in charge of laying out
	 * the elements in a specified order.
	 * 
	 * @param stage
	 */
	private void initUI(Stage stage) {


		// BorderPane root = new BorderPane();
		root = new BorderPane();
		VBox leftNode = new VBox();
		this.symbolPanel = new SymbolPanel(this.model, this);
		leftNode.getChildren().add(symbolPanel);
		leftNode.getChildren().add(new ButtonChooserPanel(this.model, this));
		centerNode = new CenterPanel(this.model);
		
		root.setLeft(leftNode);
		root.setCenter(centerNode);
		root.setTop(createMenuBar());

		primary = new Scene(root);
		stage.setScene(primary);
		stage.setTitle("Version Beta");
		stage.show();

		
	}

	public void createTimeSeriesDialogBox(String symbol) {
		Stage timeSeriesDialogBox = new Stage();
		TimeSeriesChooser timeSeriesChooser = new TimeSeriesChooser(this.model, symbol);
		
		
		Scene secondary = new Scene(timeSeriesChooser);
		timeSeriesDialogBox.setScene(secondary);
		timeSeriesDialogBox.setTitle("Time Series Data");
		timeSeriesDialogBox.show();
		
	}
	
	public CenterPanel getCenterPanel() {
		return this.centerNode;
	}
	
	public SymbolPanel getSymbolPanel() {
		return this.symbolPanel;
	}
	
	/**
	 * Creates a menubar that is located at the top of the program.
	 * 
	 */
	private MenuBar createMenuBar() {

		MenuBar menuBar = new MenuBar();
		Menu menu;
		MenuItem menuItem;

		// A menu for File

		menu = new Menu("File");

		menuItem = new MenuItem("New");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Open");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Save");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Exit");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		// Another menu for Edit

		menu = new Menu("Edit");

		menuItem = new MenuItem("Cut");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Copy");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Paste");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Undo");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Redo");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		return menuBar;
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println(((MenuItem) event.getSource()).getText());
	}
}
