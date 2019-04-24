package userInterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterWindow extends Application{

	Label fisstNameLB, lastNameLB, addressLB, zipLB, userNameLB, passwordLB, emailLB, ssnLB, secQuestionLB, secAnswerLB;
	
	TextField fisstNameTF, lastNameTF, addressTF, zipTF, userNameTF, passwordTF, emailTF, ssnTF, secAnswerTF; 
	
	ChoiceBox<String> secQuestionCB;
	
	Button mainMenuBT, registerBT;

	Stage window;
	
	Scene scene;
	
	BorderPane paneB;
	
	FlowPane paneF;
	
	HBox paneH;
	
	Region emptySpace = new Region();
	
	public static void main(String[] args) {
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Register for an Account");
		
		mainMenuBT = new Button("Main Menu");
		registerBT = new Button("Register");
		
		fisstNameLB = new Label("First Name:");
		lastNameLB = new Label("Last Name:");
		addressLB = new Label("Address:");
		zipLB = new Label("Zip:");
		userNameLB  = new Label("User Name:");
		passwordLB  = new Label("Password:");
		emailLB = new Label("Email:");
		ssnLB = new Label("SSN:");
		secQuestionLB = new Label("Security Question:");
		secAnswerLB = new Label("Security Answer:");
		
		fisstNameTF = new TextField();
		lastNameTF = new TextField();
		addressTF = new TextField();
		zipTF = new TextField();
		userNameTF = new TextField();
		passwordTF = new TextField();
		emailTF = new TextField();
		ssnTF = new TextField();
		secAnswerTF = new TextField();
		
		secQuestionCB = new ChoiceBox<>();
		secQuestionCB.getItems().addAll("Select a Question", "Option 1", "Option 2", "Option 3");
		secQuestionCB.setValue("Select a Question");
		
		paneF = new FlowPane(8, 20);
		paneF.getChildren().addAll(fisstNameLB, fisstNameTF, lastNameLB, lastNameTF, addressLB,  addressTF, zipLB, zipTF, userNameLB, userNameTF,
								  passwordLB, passwordTF, emailLB, emailTF, ssnLB, ssnTF, secQuestionLB, secQuestionCB, secAnswerLB, secAnswerTF);
		
		paneH = new HBox();
		HBox.setHgrow(emptySpace, Priority.ALWAYS);
		paneH.getChildren().addAll(mainMenuBT, emptySpace, registerBT);
		
		paneB = new BorderPane();
		paneB.setCenter(paneF);
		paneB.setBottom(paneH);
		paneB.setMargin(paneF, new Insets(8, 8, 8, 8));
		paneB.setMargin(paneH, new Insets(10, 10, 10, 10));
		
		scene = new Scene(paneB, 875, 300);
		window.setScene(scene);
		
		window.show();
	}
}
