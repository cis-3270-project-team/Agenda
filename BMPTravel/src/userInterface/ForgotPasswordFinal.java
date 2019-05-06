package userInterface;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import programBackbone.Method;

public class ForgotPasswordFinal extends MainMenu {

	Label UserNameLB, PasswordLB;

	Button mainMenuBT; 

	Stage window; 

	Scene scene; 

	VBox vBox; 

	BorderPane pane; 
	
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage; 
		window.setTitle("Credencials");

		UserNameLB = new Label("get username"); 
		PasswordLB = new Label("get password"); 

		mainMenuBT = new Button("Main Menu"); 
		 
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8); 
		grid.setHgap(10);

		GridPane.setConstraints(UserNameLB, 5, 3);
		GridPane.setConstraints(PasswordLB, 5, 4);
		GridPane.setConstraints(mainMenuBT, 5, 6);

		grid.getChildren().addAll(UserNameLB, PasswordLB, mainMenuBT); 

		mainMenuBT.setOnAction(event -> Method.mainMenu(window));

		scene = new Scene(grid, 200, 200);
		window.setScene(scene);

		window.show(); 
	}
}
