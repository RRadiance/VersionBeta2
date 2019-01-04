package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewMain implements EventHandler<ActionEvent>{

	private Model model;

	private Scene primary;
	private BorderPane root;
	private CenterPanel centerNode;
	private SymbolPanel symbolPanel;
	
	private Stage mainStage;
	private Stage timeSeriesDialogBox;
	private Stage technicalIndicatorsDialogBox;

	/**
	 * The constructor for View. 
	 * 
	 * @param model
	 * @param stage
	 */
	public ViewMain(Model model, Stage stage) {
		this.model = model;
		this.mainStage = stage;
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
		stage.setTitle("Radiance - Version Beta");
		stage.setResizable(false);
		stage.setMinWidth(800);
		stage.setMinHeight(500);
		stage.show();
		
		root.requestFocus();
		// Requests input focus on the BorderPane. Without this, the focus would be on the symbol textfield 
		// which is undesired as the user would not see the prompt text
		
	}

	/**
	 * Create the dialog box that allows the user to choose what Time Series
	 * time interval they would like to see for a given stock symbol.
	 * 
	 * @param symbol
	 */	
	public void createTimeSeriesDialogBox(String symbol) {
		this.timeSeriesDialogBox = new Stage();
		//this.timeSeriesDialogBox.initStyle(StageStyle.UNDECORATED);
		this.timeSeriesDialogBox.initModality(Modality.WINDOW_MODAL);
		this.timeSeriesDialogBox.initOwner(this.mainStage);
		
		TimeSeriesChooser timeSeriesChooser = new TimeSeriesChooser(this, this.model, symbol);
		
		Scene secondary = new Scene(timeSeriesChooser);
		this.timeSeriesDialogBox.setScene(secondary);
		this.timeSeriesDialogBox.setTitle("Time Series Data");
		this.timeSeriesDialogBox.show();
		
	}
	
	/**
	 * Create the dialog box that allows the user to choose which technical
	 * indicator they would like to see for a given stock symbol.
	 * 
	 * @param symbol
	 */
	public void createTechnicalIndicatorsDialogBox(String symbol) {
		this.technicalIndicatorsDialogBox = new Stage();
		//this.technicalIndicatorsDialogBox.initStyle(StageStyle.UNDECORATED);
		this.technicalIndicatorsDialogBox.initModality(Modality.WINDOW_MODAL);
		this.technicalIndicatorsDialogBox.initOwner(this.mainStage);
		
		TechnicalIndicatorChooser tic = new TechnicalIndicatorChooser(this, this.model, symbol);
		
		Scene secondary = new Scene(tic);
		this.technicalIndicatorsDialogBox.setScene(secondary);;
		this.technicalIndicatorsDialogBox.setTitle("Technical Indicator Data");
		this.technicalIndicatorsDialogBox.show();
	}
	
	/**
	 * Called from TimeSeriesChooserController, this closes the timeSeriesDialogBox stage
	 * (second window closes).
	 * 
	 */
	public void closeTimeSeriesDialogBox() {
		this.timeSeriesDialogBox.close();
	}
	
	/**
	 * Called from TechnicalIndChooserController, this closes the technicalIndicatorsDialogBox
	 * stage.
	 */
	public void closeTechnicalIndicatorsDialogBox() {
		this.technicalIndicatorsDialogBox.close();
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
