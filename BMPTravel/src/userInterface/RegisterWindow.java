package userInterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import programBackbone.Customer;
import programBackbone.Method;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterWindow extends Application{

	Label fisstNameLB, lastNameLB, addressLB, zipLB, stateLB, userNameLB, passwordLB, emailLB, ssnLB, secQuestionLB, secAnswerLB;
	
	TextField firstNameTF, lastNameTF, addressTF, zipTF, stateTF, userNameTF, passwordTF, emailTF, ssnTF, secAnswerTF; 
	
	ChoiceBox<String> secQuestionCB;
	
	Button mainMenuBT, registerBT;

	Stage window;
	
	Scene scene;
	
	BorderPane paneB;
	
	FlowPane paneF;
	
	HBox paneH;
	
	Region emptySpace = new Region();
	
	Customer c1;
	
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
		stateLB = new Label("State:");
		userNameLB  = new Label("User Name:");
		passwordLB  = new Label("Password:");
		emailLB = new Label("Email:");
		ssnLB = new Label("SSN:");
		secQuestionLB = new Label("Security Question:");
		secAnswerLB = new Label("Security Answer:");
		
		firstNameTF = new TextField();
		lastNameTF = new TextField();
		addressTF = new TextField();
		zipTF = new TextField();
		stateTF = new TextField();
		userNameTF = new TextField();
		passwordTF = new TextField();
		emailTF = new TextField();
		ssnTF = new TextField();
		secAnswerTF = new TextField();
		
		secQuestionCB = new ChoiceBox<>();
		secQuestionCB.getItems().addAll("Select a Question", "What was the name of your first stuffed animal", 
										"In what city or town did your mother and father meet", "Where were you when you had your first kiss",
										"In what city or town was your first job");
		
		secQuestionCB.setValue("Select a Question");
		
		paneF = new FlowPane(8, 20);
		paneF.getChildren().addAll(fisstNameLB, firstNameTF, lastNameLB, lastNameTF, addressLB,  addressTF, zipLB, zipTF, stateLB, stateTF,
				userNameLB, userNameTF, passwordLB, passwordTF, emailLB, emailTF, ssnLB, ssnTF, secQuestionLB, secQuestionCB, secAnswerLB, 
				secAnswerTF);
		
		paneH = new HBox();
		HBox.setHgrow(emptySpace, Priority.ALWAYS);
		paneH.getChildren().addAll(mainMenuBT, emptySpace, registerBT);
		
		registerBT.setOnAction(e -> {
			
			if (Method.checkRegistry(firstNameTF.getText(), lastNameTF.getText(), userNameTF.getText(), passwordTF.getText(), 
					emailTF.getText(), secQuestionCB.getValue(), secAnswerTF.getText(), addressTF.getText(), stateTF.getText(), 
					zipTF.getText(), ssnTF.getText())) {
				

					c1 = new Customer(firstNameTF.getText(), lastNameTF.getText(), userNameTF.getText(), passwordTF.getText(), 
							emailTF.getText(), secQuestionCB.getValue(), secAnswerTF.getText(), addressTF.getText(), stateTF.getText(), 
							Integer.parseInt(zipTF.getText()), Integer.parseInt(ssnTF.getText()));
					
					Method.registerUser(c1);
			
					HomePage homepage = new HomePage(); 
			
					try {
						homepage.start(primaryStage, c1);
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				
				}
				});
		
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
