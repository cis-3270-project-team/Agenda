package userInterface;

import database.DBMethod;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import programBackbone.Admin;
import programBackbone.Method;
import programBackbone.User;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainMenu extends Application{ 
	private static final int CENTER = 0;

	// creating the labels 
	Label userNameLB, passwordLB;  

	TextField userNameTF, passwordTF; 

	Button loginBT, registerBT, exitBT, forgotPassBT;

	Stage window;

	Scene scene;

	VBox vBox;

	BorderPane pane;

	User u1;

/*	public static void main(String[] args) {

		launch(args);

	}*/

	@Override

	public  void start(Stage primaryStage) throws Exception{

		window = primaryStage;
		window.setTitle("Main Menu");
		
		loginBT = new Button("Log in");
		registerBT = new Button("Register");
		forgotPassBT = new Button("Forgot Password");

		exitBT = new Button("Exit");
		exitBT.setOnAction(event -> closeProgram()); 
		userNameLB = new Label("Username:");
		userNameTF = new TextField();
		passwordLB = new Label("Password:");
		passwordTF = new TextField();
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8); 
		grid.setHgap(10);

		GridPane.setConstraints(userNameLB, 0, 0); 
		GridPane.setConstraints(userNameTF, 1, 0);
		GridPane.setConstraints(passwordLB, 0, 3);
		GridPane.setConstraints(passwordTF, 1, 3);
		GridPane.setConstraints(loginBT, 0, 4);
		GridPane.setConstraints(registerBT, 0, 5);
		GridPane.setConstraints(exitBT, 15, 0);
		GridPane.setConstraints(forgotPassBT, 0, 8);
		
		grid.getChildren().addAll(userNameLB, userNameTF, passwordLB, passwordTF, loginBT, registerBT, exitBT, forgotPassBT); 

		scene = new Scene(grid, 500, 250);
		window.setScene(scene);
		
		window.setOnCloseRequest(event -> closeProgram()) ;

		registerBT.setOnAction(event -> Method.register(window)); 
		
		loginBT.setOnAction(event1 -> {

			u1 = DBMethod.login(userNameTF.getText(), passwordTF.getText());
			
			if (u1 instanceof Admin) {
				
				Admin a1 = (Admin) u1;
				
				Method.homepageAdmin(window, a1);
				
			}
			else {
				Method.homepage(window, u1);
			}
			});
		
		forgotPassBT.setOnAction(e -> Method.forgotStage1(window));
		
		window.show();
	}

	public void closeProgram() { 
		System.out.print("Good Bye :(");
		window.close(); 

	}
}