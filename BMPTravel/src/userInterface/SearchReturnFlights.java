package userInterface;

import database.DBMethod;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import programBackbone.Admin;
import programBackbone.Customer;
import programBackbone.Flights;
import programBackbone.Method;
import programBackbone.User;

public class SearchReturnFlights extends MainMenu {


	Stage window;
	
	Scene scene5;
	
	TableView<Flights> returnFlights;
	
	Region emptySpace;
	
	VBox vBox;
	
	HBox bottom;
	
	Button backBT, bookFlightBT, logoutBT;
	
	
	public void start(Stage primaryStage, User u1) {
		
		window = primaryStage;
		
		window.setTitle("Search Return Flights");
		
		TableColumn<Flights, String> airline = new TableColumn<>("Airline");		
		airline.setMinWidth(75);
		airline.setCellValueFactory(new PropertyValueFactory<>("airline"));
		
		TableColumn<Flights, String> origin = new TableColumn<>("Origin City");		
		origin.setMinWidth(150);
		origin.setCellValueFactory(new PropertyValueFactory<>("originCity"));
		
		TableColumn<Flights, String> destination = new TableColumn<>("Destination City");		
		destination.setMinWidth(150);
		destination.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
		
		TableColumn<Flights, String> departureTime = new TableColumn<>("Departure Time");		
		departureTime.setMinWidth(75);
		departureTime.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
		
		TableColumn<Flights, String> arrivalTime = new TableColumn<>("Arrival Time");		
		arrivalTime.setMinWidth(75);
		arrivalTime.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));

		TableColumn<Flights, java.util.Date> date = new TableColumn<>("Date");		
		date.setMinWidth(75);
		date.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		
		TableColumn<Flights, Integer> seats = new TableColumn<>("Seats Abailable");		
		seats.setMinWidth(30);
		seats.setCellValueFactory(new PropertyValueFactory<>("seatsAvailable"));
	
		returnFlights = new TableView<>();
		
		ObservableList<Flights> flights = DBMethod.searchFlights();
		
		returnFlights.setItems(flights);
		
		returnFlights.getColumns().addAll(airline, origin, destination, departureTime, arrivalTime, date, seats);
		
		backBT = new Button("back");
		
		backBT.setOnAction(e -> Method.searchFlights(window, u1));
		
		bookFlightBT = new Button("Book Flight");
		
		bookFlightBT.setOnAction(e -> {
			
			Flights f1 = (Flights) returnFlights.getSelectionModel().getSelectedItems();
			
			if(Method.bookFlight(u1, f1)) {
				Method.history(window, u1);
			}
			
		});
		
		logoutBT = new Button();
		
		logoutBT.setOnAction(e -> Method.mainMenu(window));
		
		emptySpace = new Region();
		
		bottom = new HBox();
		bottom.setHgrow(emptySpace, Priority.ALWAYS);
		bottom.getChildren().addAll(backBT, bookFlightBT, emptySpace, logoutBT);
		bottom.setPadding(new Insets(10, 10, 10, 10));
		bottom.setSpacing(10);
		
		vBox = new VBox();
		
		vBox.getChildren().addAll(returnFlights, bottom);
		vBox.setPadding(new Insets(20.0, 20.0, 20.0, 20.0));
		
		scene5 = new Scene(vBox);
		window.setScene(scene5);
		window.show();
	}
}
