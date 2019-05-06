package userInterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ForgotPasswordPage extends Application {

	Label UserEmailLB;
	
	TextField UserEmailTF; 
	
	Button EnterBT, ExitBT; 
	
	Stage window; 
	
	Scene scene; 
	
	VBox vBox; 
	
	BorderPane pane;
	
	public static void main(String[] args) {
		launch(args);
	
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
	window = primaryStage; 
	window.setTitle("Forgot Password");
	
	UserEmailLB = new Label ("User Email: ");
	UserEmailTF = new TextField(); 
	
	EnterBT = new Button("Enter");
	ExitBT = new Button("Exit"); 
	ExitBT.setOnAction(event -> closeProgram());
	
	
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10, 10, 10, 10));
	grid.setVgap(8); 
	grid.setHgap(10);
	
	GridPane.setConstraints(UserEmailLB, 16, 5); 
	GridPane.setConstraints(UserEmailTF, 17, 5);
	GridPane.setConstraints(EnterBT, 17, 6);
	GridPane.setConstraints(ExitBT, 34, 0);
	
	grid.getChildren().addAll(UserEmailLB, UserEmailTF, EnterBT, ExitBT);
	
	EnterBT.setOnAction(event ->{
		ForgotPasswordNext next = new ForgotPasswordNext();
		try { 
			next.start(primaryStage);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	});
	
	scene = new Scene(grid, 650, 280);
	window.setScene(scene);
	
	window.show(); 
	
	}
	public void closeProgram() { 	
		System.out.print("Action saved!");
		window.close(); 
		
	}
}
