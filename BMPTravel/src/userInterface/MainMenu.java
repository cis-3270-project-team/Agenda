package userInterface;

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
import javafx.scene.layout.VBox;

public class MainMenu extends Application{
	private static final int CENTER = 0;

	// creating the labels 
	Label UserNameLB, PasswordLB;  


	TextField UserNameTF, PasswordTF; 


	Button loginBT, registerBT, exitBT, forgotPassBT;


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
		forgotPassBT = new Button("Forgot Password");

		// registerBT.setOnAction(e -> RegisetWindow.d);
		exitBT = new Button("Exit");
		exitBT.setOnAction(event -> closeProgram()); 
		UserNameLB = new Label("Username:");
		PasswordLB = new Label("Password:");
		UserNameTF = new TextField();
		PasswordTF = new TextField();

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8); 
		grid.setHgap(10);

		GridPane.setConstraints(UserNameLB, 0, 0); 
		GridPane.setConstraints(UserNameTF, 0, 1);
		GridPane.setConstraints(PasswordLB, 0, 2);
		GridPane.setConstraints(PasswordTF, 0, 3);
		GridPane.setConstraints(loginBT, 0, 4);
		GridPane.setConstraints(registerBT, 0, 5);
		GridPane.setConstraints(exitBT, 42, 0);
		GridPane.setConstraints(forgotPassBT, 0, 7);
		
		grid.getChildren().addAll(UserNameLB, UserNameTF, PasswordLB, PasswordTF, loginBT, registerBT, exitBT, forgotPassBT); 

		scene = new Scene(grid, 650, 280);
		window.setScene(scene);
		
		window.setOnCloseRequest(event -> closeProgram()) ;

		registerBT.setOnAction(event -> {
			
			RegisterWindow registerwindow = new RegisterWindow(); 

			try {
				registerwindow.start(primaryStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}); 
		loginBT.setOnAction(event1 -> {

			HomePage homepage = new HomePage(); 
			
			try {
				homepage.start(primaryStage);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		window.show();
	}

	public void closeProgram() { 
		System.out.print("Action saved!");
		window.close(); 

	}
}