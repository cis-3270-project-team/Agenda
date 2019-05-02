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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class HomepageAdmin extends Application {

	Label helloLB; 

	Button searchFlightBT,  accountHistoryBT, logoutBT, updateFlightsInfoBT; 

	Stage window; 

	Scene scene; 

	VBox vBox; 

 
	public static void main(String[] args) throws Exception {

		launch(args); 

	}

	@Override
	public void start(Stage primaryStage)  {

		window = primaryStage; 
		window.setTitle("Home Page");
		
		searchFlightBT = new Button("Search for a Flight"); 
		accountHistoryBT = new Button("Account History List");
		logoutBT = new Button("Logout");
		updateFlightsInfoBT = new Button("Update Flights Info");
		helloLB = new Label ("Hello, and welcome back!"); 
		
		GridPane grid = new GridPane(); 
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8); 
		grid.setHgap(10);
		
		GridPane.setConstraints(helloLB, 20, 5);
		GridPane.setConstraints(searchFlightBT, 20,8); 
		GridPane.setConstraints(updateFlightsInfoBT, 20,10);
		GridPane.setConstraints(accountHistoryBT, 20, 12); 
		GridPane.setConstraints(logoutBT, 20, 14); 
		
		grid.getChildren().addAll(searchFlightBT, accountHistoryBT, logoutBT, helloLB, updateFlightsInfoBT);
		

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