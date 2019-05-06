package userInterface;

import programBackbone.Method;
import database.DBMethod;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
	flightNumberTF, departureTimeTF, arrivalTimeTF, seatsAvailableTF;
	
	ChoiceBox<String> monthHere, dayHere, yearHere, monthThere, dayThere, yearThere;
	
	Label dateHereLB, dateThereLB;
	
	CheckBox isFilledCB;

	TableView<Flights> table; 

	VBox vBox; 

	HBox hBox, hBox2, hBox3; 

	Scene scene; 
	
	@SuppressWarnings({ "unchecked", "static-access" })
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

		departureTimeTF = new TextField();
		departureTimeTF.setPromptText("departureTime");

		arrivalTimeTF = new TextField();
		arrivalTimeTF.setPromptText("arrivalTime");

		seatsAvailableTF = new TextField();
		seatsAvailableTF.setPromptText("seatsAvailable");

		isFilledCB = new CheckBox("isFull");
		
		monthHere = new ChoiceBox<>();
		monthHere.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August",
									"August", "September", "October", "November", "December");
		monthHere.setValue("January");
		
		dayHere = new ChoiceBox<>();
		dayHere.getItems().addAll("1","2","3","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
								"21","22","23","24","25","26","27","27","28","29","30","31");
		dayHere.setValue("1");
		
		yearHere = new ChoiceBox<>();
		yearHere.getItems().addAll("2019","2020","2021","2022","2023","2024","2025");
		yearHere.setValue("2019");
		
		monthThere = new ChoiceBox<>();
		monthThere.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August",
				"August", "September", "October", "November", "December");
		monthThere.setValue("January");
		
		dayThere = new ChoiceBox<>();
		dayThere.getItems().addAll("1","2","3","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
				"21","22","23","24","25","26","27","27","28","29","30","31");
		dayThere.setValue("1");
		
		yearThere = new ChoiceBox<>();
		yearThere.getItems().addAll("2019","2020","2021","2022","2023","2024","2025");
		yearThere.setValue("2019");
		
		dateHereLB = new Label("Departure Date");
		
		dateThereLB = new Label("Arrival Date");
		
		//airline column
		TableColumn<Flights, String> airlineColumn = new TableColumn<>("Airline"); 
		airlineColumn.setMinWidth(75); 
		airlineColumn.setCellValueFactory(new PropertyValueFactory<>("airline"));

		TableColumn<Flights, String> originCityColumn = new TableColumn<>("Origin City"); 
		originCityColumn.setMinWidth(150); 
		originCityColumn.setCellValueFactory(new PropertyValueFactory<>("originCity"));

		TableColumn<Flights, String> destinationCityColumn = new TableColumn<>("Destination City"); 
		destinationCityColumn.setMinWidth(150); 
		destinationCityColumn.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));

		TableColumn<Flights, String> flightCapacityColumn = new TableColumn<>("Flight Capacity"); 
		flightCapacityColumn.setMinWidth(50); 
		flightCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("flightCapacity"));

		TableColumn<Flights, String> flightNumberColumn = new TableColumn<>("Flight Number"); 
		flightNumberColumn.setMinWidth(60); 
		flightNumberColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));

		TableColumn<Flights, String> departureDateColumn = new TableColumn<>("Departure Date"); 
		departureDateColumn.setMinWidth(75); 
		departureDateColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));

		TableColumn<Flights, String> arrivalDateColumn = new TableColumn<>("Arrival Date"); 
		arrivalDateColumn.setMinWidth(75); 
		arrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));

		TableColumn<Flights, String> departureTimeColumn = new TableColumn<>("Departure Time"); 
		departureTimeColumn.setMinWidth(75); 
		departureTimeColumn.setCellValueFactory(new PropertyValueFactory<>("departureTime"));

		TableColumn<Flights, String> arrivalTimeColumn = new TableColumn<>("Arrival Time"); 
		arrivalTimeColumn.setMinWidth(75); 
		arrivalTimeColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));

		TableColumn<Flights, String> seatsAvailableColumn = new TableColumn<>("Seats Available"); 
		seatsAvailableColumn.setMinWidth(50); 
		seatsAvailableColumn.setCellValueFactory(new PropertyValueFactory<>("seatsAvailable"));

		TableColumn<Flights, String> isFilledColumn = new TableColumn<>("is Filled"); 
		isFilledColumn.setMinWidth(30); 
		isFilledColumn.setCellValueFactory(new PropertyValueFactory<>("isFilled"));
		
		table = new TableView<>(); 
		ObservableList<Flights> flights = DBMethod.searchFlights();
		table.setItems(flights); 
		table.getColumns().addAll(airlineColumn,originCityColumn, destinationCityColumn, 
		flightCapacityColumn, flightNumberColumn, departureDateColumn, arrivalDateColumn, 
		departureTimeColumn, arrivalTimeColumn, seatsAvailableColumn, isFilledColumn); 
		
		emptySpace = new Region();

		hBox2 = new HBox(); 
		hBox2.getChildren().addAll(airlineTF, originCityTF, destinationCityTF, flightCapacityTF, flightNumberTF); 
		
		hBox3 = new HBox();
		hBox3.getChildren().addAll(dateHereLB, monthHere, dayHere, yearHere, dateThereLB, monthThere, dayThere, yearThere, departureTimeTF, arrivalTimeTF, seatsAvailableTF, isFilledCB);

		hBox = new HBox(); 
		hBox.setHgrow(emptySpace, Priority.ALWAYS);
		hBox.getChildren().addAll(addBT, deleteBT, updateBT, emptySpace, backBT);

		vBox = new VBox();
		vBox.setPadding(new Insets(10, 10, 10, 10));
		vBox.getChildren().addAll(table,hBox2, hBox3, hBox); 
		
		backBT.setOnAction(e -> Method.homepageAdmin(window, a1));
		
		addBT.setOnAction(e -> {
			Flights f1 = Method.makeFlight(airlineTF.getText(), originCityTF.getText(), destinationCityTF.getText(), 
				flightCapacityTF.getText(), flightNumberTF.getText(), departureTimeTF.getText(), arrivalTimeTF.getText(), 
				seatsAvailableTF.getText(), isFilledCB);
			
			if (DBMethod.addFlight(f1)) {
				
				table.getItems().add(f1);
				
				airlineTF.clear();
				originCityTF.clear();
				destinationCityTF.clear();
				flightCapacityTF.clear();
				flightNumberTF.clear();
				dayHere.setValue("1");
				monthHere.setValue("January");
				yearHere.setValue("2019");
				dayThere.setValue("1");
				monthThere.setValue("January");
				yearThere.setValue("2019");
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
			
			if (DBMethod.removeFlight(flight)) {
				flight.forEach(allFlights::remove);
			}
			
		});

		Scene scene = new Scene(vBox , 1100, 500); 
		window.setScene(scene); 
		window.show(); 
	}

}
