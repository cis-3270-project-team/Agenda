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

public class ForgotPasswordNext extends MainMenu {

	Label messageLB, questionLB; 

	Button EnterBT, ExitBT; 

	TextField answerTF; 

	Stage window; 

	Scene scene; 

	VBox vBox; 

	BorderPane pane; 
	
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage; 
		window.setTitle("Security Question"); 

		messageLB = new Label("Please answer the following security question:" ); 
		questionLB = new Label("Question from database"); 
		answerTF = new TextField(); 

		EnterBT = new Button("Enter"); 
		ExitBT = new Button("Exit"); 
		ExitBT.setOnAction(event -> closeProgram());
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8); 
		grid.setHgap(10);

		GridPane.setConstraints(messageLB, 14, 5);
		GridPane.setConstraints(questionLB, 14, 6);
		GridPane.setConstraints(answerTF, 14, 7);
		GridPane.setConstraints(EnterBT, 14, 8);
		GridPane.setConstraints(ExitBT, 30,0 );
		
		grid.getChildren().addAll(messageLB, questionLB, answerTF, ExitBT, EnterBT); 

		EnterBT.setOnAction(event -> {
			ForgotPasswordFinal forgotpassword = new ForgotPasswordFinal();
			try { 
				forgotpassword.start(primaryStage);
				}
				catch (Exception e) {
					e.printStackTrace(); 
				}
			});
		
		scene = new Scene(grid, 650, 280);
		window.setScene(scene);
		window.show(); 
	}
}
