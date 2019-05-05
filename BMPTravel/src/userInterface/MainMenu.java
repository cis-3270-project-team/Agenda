package userInterface;

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
import javafx.scene.layout.VBox;

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
		GridPane.setConstraints(userNameTF, 0, 1);
		GridPane.setConstraints(passwordLB, 0, 2);
		GridPane.setConstraints(passwordTF, 0, 3);
		GridPane.setConstraints(loginBT, 0, 4);
		GridPane.setConstraints(registerBT, 0, 5);
		GridPane.setConstraints(exitBT, 42, 0);
		GridPane.setConstraints(forgotPassBT, 0, 7);
		
		grid.getChildren().addAll(userNameLB, userNameTF, passwordLB, passwordTF, loginBT, registerBT, exitBT, forgotPassBT); 

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

			u1 = Method.login(userNameTF.getText(), passwordTF.getText());
			
			try {
				if (u1 instanceof Admin) {
				
					Admin a1 = (Admin) u1;
				
					HomepageAdmin homepageAdmin = new HomepageAdmin();
				
					homepageAdmin.start(primaryStage, a1);
				
				}
				else {
					HomePage homepage = new HomePage(); 
			
					homepage.start(primaryStage, u1);
				}
				
			}catch (NullPointerException npe) {
				npe.printStackTrace();
				
				System.out.println("Caught");
				
				AlertBox.display("Invalid UserName or Password", "The User Name and/or Password is Incorrect");
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			});
		
		forgotPassBT.setOnAction(e -> {
			try {
				ForgotPasswordPage forgotPage = new ForgotPasswordPage();
				
				forgotPage.start(primaryStage);
				
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		
		window.show();
	}

	public void closeProgram() { 
		System.out.print("Good Bye :(");
		window.close(); 

	}
}