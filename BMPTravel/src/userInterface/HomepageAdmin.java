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
import programBackbone.Admin;
import programBackbone.User;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class HomepageAdmin extends MainMenu {

	Label helloLB; 

	Button searchFlightBT,  accountHistoryBT, logoutBT, updateFlightsInfoBT; 

	Stage window; 

	Scene scene; 

	VBox vBox; 

	Admin a1;
	
	public void start(Stage primaryStage, Admin a1)  {

		window = primaryStage; 
		window.setTitle("Home Page");
		
		searchFlightBT = new Button("Search for a Flight"); 
		accountHistoryBT = new Button("Account History List");
		logoutBT = new Button("Logout");
		updateFlightsInfoBT = new Button("Update Flights Info");
		helloLB = new Label ("Hello, and welcome back " + a1.getFirstName() + "!"); 
		
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
		

		updateFlightsInfoBT.setOnAction(e -> {
		
			UpdateFlightsTable updateTable = new UpdateFlightsTable();

			try {
			
				updateTable.start(primaryStage, a1);
				
			}
			catch(Exception ufte) {
				System.out.println(ufte);
				ufte.printStackTrace();
			}
			
		});
		
			searchFlightBT.setOnAction(e -> {
		
		SearchOutbound searchOutbound = new SearchOutbound();
		
		try {
			searchOutbound.start(primaryStage, a1);
		}
		catch (Exception e2) {
			System.out.println(e2);
			e2.printStackTrace();
		}
		});		

		scene = new Scene(grid, 600, 300);
		window.setScene(scene);
		window.show();

	}

}
