package userInterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainMenu extends Application{

	Button loginBT, registerBT, exitBT;
	
	Stage window;
	
	Scene scene;
	
	VBox vBox;
	
	BorderPane pane;
	
	
	public static void main(String[] args) {
		launch(args);

	}
	@Override
	public  void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Main Menu");
		
		loginBT = new Button("Log in");
		registerBT = new Button("Register");
		exitBT = new Button("Exit");
		
		vBox = new VBox();
		vBox.getChildren().addAll(loginBT, registerBT);
		
		pane = new BorderPane();
		pane.setTop(exitBT);
		pane.setAlignment(exitBT, Pos.TOP_RIGHT);
		pane.setMargin(exitBT, new Insets(4, 4, 4, 4));
		
		vBox.setAlignment(Pos.CENTER);
		vBox.setMargin(loginBT, new Insets(8, 8, 8, 8));
		
		pane.setCenter(vBox);
		
		scene = new Scene(pane, 250, 150);
		window.setScene(scene);
		
		window.show();
	}
}
