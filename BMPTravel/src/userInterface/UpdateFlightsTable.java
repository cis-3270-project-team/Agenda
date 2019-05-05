package userInterface;

import programBackbone.Method;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import programBackbone.Admin;
import programBackbone.Flights;

public class UpdateFlightsTable extends MainMenu {

	Stage window; 
	
	Button addBT, deleteBT, updateBT, backBT; 
	
	Region emptySpace;

	TextField airlineTF, originCityTF, destinationCityTF, flightCapacityTF,
	flightNumberTF, departureDateTF, arrivalDateTF, departureTimeTF, 
	arrivalTimeTF, seatsAvailableTF;
	
	CheckBox isFilledCB;

	TableView<Flights> table; 

	VBox vBox; 

	HBox hBox, hBox2, hBox3; 

	Scene scene; 
	public void start(Stage primaryStage, Admin a1) {
		
		window = primaryStage; 
		window.setTitle("UpdateFlightsTable");

		addBT = new Button("Add Flight"); 
		deleteBT = new Button("Delete Flight"); 
		updateBT = new Button("Update Flight"); 
		backBT = new Button("Back");

		airlineTF = new TextField(); 
		airlineTF.setPromptText("airline");

		originCityTF = new TextField();
		originCityTF.setPromptText("originCity");

		destinationCityTF = new TextField();
		destinationCityTF.setPromptText("destinationCity");

		flightCapacityTF = new TextField();
		flightCapacityTF.setPromptText("flightCapacity");

		flightNumberTF = new TextField();
		flightNumberTF.setPromptText("flightNumber");

		departureDateTF = new TextField();
		departureDateTF.setPromptText("departureDate");

		arrivalDateTF = new TextField();
		arrivalDateTF.setPromptText("arrivalDate");

		departureTimeTF = new TextField();
		departureTimeTF.setPromptText("departureTime");

		arrivalTimeTF = new TextField();
		arrivalTimeTF.setPromptText("arrivalTime");

		seatsAvailableTF = new TextField();
		seatsAvailableTF.setPromptText("seatsAvailable");

		isFilledCB = new CheckBox("isFull");
		
		//airline column
		TableColumn<Flights, String> airlineColumn = new TableColumn("Airline"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("airline"));

		TableColumn<Flights, String> originCityColumn = new TableColumn("Origin City"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("originCity"));

		TableColumn<Flights, String> destinationCityColumn = new TableColumn("Destination City"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));

		TableColumn<Flights, String> flightCapacityColumn = new TableColumn("Flight Capacity"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("flightCapacity"));

		TableColumn<Flights, String> flightNumberColumn = new TableColumn("Flight Number"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));

		TableColumn<Flights, String> departureDateColumn = new TableColumn("Departure Date"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));

		TableColumn<Flights, String> arrivalDateColumn = new TableColumn("Arrival Date"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));

		TableColumn<Flights, String> departureTimeColumn = new TableColumn("Departure Time"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("departureTime"));

		TableColumn<Flights, String> arrivalTimeColumn = new TableColumn("Arrival Time"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));

		TableColumn<Flights, String> seatsAvailableColumn = new TableColumn("Seats Available"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("seatsAvailable"));

		TableColumn<Flights, String> isFilledColumn = new TableColumn("is Filled"); 
		airlineColumn.setMinWidth(200); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("isFilled"));
		
		table = new TableView<>(); 
		ObservableList<Flights> flights = Method.searchFlights();
		table.setItems(flights); 
		table.getColumns().addAll(airlineColumn,originCityColumn, destinationCityColumn, 
		flightCapacityColumn, flightNumberColumn, departureDateColumn, arrivalDateColumn, 
		departureTimeColumn, arrivalTimeColumn, seatsAvailableColumn, isFilledColumn); 
		
		emptySpace = new Region();

		hBox2 = new HBox(); 
		hBox2.getChildren().addAll(airlineTF, originCityTF, destinationCityTF, flightCapacityTF, flightNumberTF); 
		
		hBox3 = new HBox();
		hBox3.getChildren().addAll(departureDateTF, arrivalDateTF, departureTimeTF, arrivalTimeTF, seatsAvailableTF, isFilledCB);

		hBox = new HBox(); 
		hBox.setHgrow(emptySpace, Priority.ALWAYS);
		hBox.getChildren().addAll(addBT, deleteBT, updateBT, emptySpace, backBT);

		vBox = new VBox();
		vBox.getChildren().addAll(table,hBox2, hBox3, hBox); 
		
		backBT.setOnAction(e ->{
			HomepageAdmin homepage = new HomepageAdmin();
			
			try {
				homepage.start(window, a1);
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		
		addBT.setOnAction(e -> {
			Flights f1 = Method.makeFlight(airlineTF.getText(), originCityTF.getText(), destinationCityTF.getText(), 
				flightCapacityTF.getText(), flightNumberTF.getText(), departureDateTF.getText(), arrivalDateTF.getText(),
				departureTimeTF.getText(), arrivalTimeTF.getText(), seatsAvailableTF.getText(), isFilledCB);
			
			if (Method.addFlight(f1)) {
				
				table.getItems().add(f1);
				
				airlineTF.clear();
				originCityTF.clear();
				destinationCityTF.clear();
				flightCapacityTF.clear();
				flightNumberTF.clear();
				departureDateTF.clear();
				arrivalDateTF.clear();
				departureTimeTF.clear();
				arrivalTimeTF.clear();
				seatsAvailableTF.clear();
				isFilledCB.setSelected(false);
			}
		});
		
		deleteBT.setOnAction(e ->{
			ObservableList<Flights> flight, allFlights;
			
			allFlights = table.getItems();
			
			flight = table.getSelectionModel().getSelectedItems();
			
			if (Method.removeFlight(flight)) {
				flight.forEach(allFlights::remove);
			}
			
		});

		Scene scene = new Scene(vBox); 
		window.setScene(scene); 
		window.show(); 
	}

}
