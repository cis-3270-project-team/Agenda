package userInterface;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import programBackbone.User;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class HomePage extends MainMenu {
		
	Label helloLB; 
		
	Button searchFlightBT,  accountHistoryBT, logoutBT; 

	Stage window; 

	Scene scene; 

	VBox vBox; 
	
	User u1;


		public void start(Stage primaryStage, User u1)  {
		window = primaryStage; 
		window.setTitle("Home Page");

		searchFlightBT = new Button("Search for a Flight"); 
		accountHistoryBT = new Button("Account History List");
		logoutBT = new Button("Logout");
		helloLB = new Label ("Hello, and welcome back " + u1.getFirstName() + "!"); 

		GridPane grid = new GridPane(); 
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8); 
		grid.setHgap(10);

		GridPane.setConstraints(helloLB, 20, 5);			
		GridPane.setConstraints(searchFlightBT, 20,10); 
		GridPane.setConstraints(accountHistoryBT, 20, 12); 			
		GridPane.setConstraints(logoutBT, 20, 14); 

		grid.getChildren().addAll(searchFlightBT, accountHistoryBT, logoutBT, helloLB);

		logoutBT.setOnAction(event -> {
			MainMenu mainmenu = new MainMenu(); 
			try {
				mainmenu.start(primaryStage); 
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		});

		scene = new Scene(grid, 600, 300);
		window.setScene(scene);
		window.show();
	}
		
}