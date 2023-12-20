package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Main extends Application {
	
	// Define a constant string for a blank value
	public static final String BLANK = "";
		@Override
	public void start(Stage primaryStage) {
		//create the pane and set its properties
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets (30, 30, 30, 30));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		
		//PLACE NODES IN THE GRIDPANE
		//text fields and its labels for student data
				
		Label nameLabel = new Label("Name: ");
		gridPane.add(nameLabel, 0, 0);
		TextField nameField = new TextField();
		gridPane.add(nameField, 1, 0);
		
		Label addressLabel = new Label("Address: ");
		gridPane.add(addressLabel, 0, 1);
		TextField addressField = new TextField();
		gridPane.add(addressField, 1, 1);
		
		Label provinceLabel = new Label("Province: ");
		gridPane.add(provinceLabel, 0, 2);
		TextField provinceField = new TextField();
		gridPane.add(provinceField, 1, 2);
		
		Label cityLabel = new Label("City: ");
		gridPane.add(cityLabel, 0, 3);
		TextField cityField = new TextField();
		gridPane.add(cityField, 1, 3);
		
		Label postalCodeLabel = new Label("Postal Code: ");
		gridPane.add(postalCodeLabel, 0, 4);
		TextField postalCodeField = new TextField();
		gridPane.add(postalCodeField, 1, 4);
		
		Label phoneNumberLabel = new Label("Phone Number: ");
		gridPane.add(phoneNumberLabel, 0, 5);
		TextField phoneNumberField = new TextField();
		gridPane.add(phoneNumberField, 1, 5);
		
		Label emailLabel = new Label("Email: ");
		gridPane.add(emailLabel, 0, 6);
		TextField emailField = new TextField();
		gridPane.add(emailField, 1, 6);
		
		//student's major: radio buttons
		RadioButton computerRB = new RadioButton("Computer Science");
		RadioButton businessRB = new RadioButton("Business");
		ToggleGroup majorToggle = new ToggleGroup();
		HBox majorBox = new HBox ();
		majorBox.setSpacing(10);
		majorBox.getChildren().addAll(computerRB, businessRB);
		gridPane.add(majorBox, 3,0);
		computerRB.setToggleGroup(majorToggle);
		businessRB.setToggleGroup(majorToggle);
		computerRB.setSelected(true);
		
		//create a combo box to display the list of courses and show the
		//selection in the List View
		String[] coursesComputer = {"Select","Python", "C#", "Java"};
		String[] coursesBusiness = {"Select", "Marketing", "Management", "Finance" };
		ComboBox<String> comboBox = new ComboBox<>();
		ObservableList<String> options = FXCollections.observableArrayList(coursesComputer);
		
		
		comboBox.setItems(options);
		comboBox.getSelectionModel().selectFirst();
		comboBox.setPrefSize(250, 20);
		gridPane.add(comboBox, 3, 1);
		
		ListView<String> coursesView = new ListView();
		coursesView.setPrefSize(250, 30);
		gridPane.add(coursesView, 3, 3, 1, 4);
		
		computerRB.setOnAction(event -> {
		    options.setAll(coursesComputer);
		    comboBox.getSelectionModel().selectFirst();
		    coursesView.getItems().clear();
		    comboBox.getSelectionModel().clearSelection();
		    comboBox.setItems(FXCollections.observableArrayList(coursesComputer));
		    comboBox.getSelectionModel().selectFirst();
		});
		
		businessRB.setOnAction(event -> {
		    options.setAll(coursesBusiness); 
		    coursesView.getItems().clear();
		    comboBox.getSelectionModel().clearSelection();
		    comboBox.setItems(FXCollections.observableArrayList(coursesBusiness));
		    comboBox.getSelectionModel().selectFirst();
		});
		
		comboBox.setOnAction(event -> {
			 String selectedCourse = comboBox.getSelectionModel().getSelectedItem();
			    if (selectedCourse != null && !selectedCourse.equals("Select")) {
			        coursesView.getItems().add(selectedCourse);     
			    }
		});
		
		
		//check box for additional information
		CheckBox councilCB = new CheckBox("Student Council");
		gridPane.add(councilCB, 2, 1);
		
		CheckBox volunteerCB = new CheckBox("Volunteer Work");
		gridPane.add(volunteerCB, 2, 5);
		
		//All information at text area component
		Button display = new Button ("Display");
		gridPane.add(display, 2, 7);
		
		TextArea result = new TextArea();
		gridPane.add(result, 0, 8, 4, 1);
		
		display.setOnAction(actionEvent -> {
		    
			//user inputs box 
			String name = nameField.getText();
			String address = addressField.getText();
			String province = provinceField.getText();
			String city = cityField.getText();
			String postalCode = postalCodeField.getText();
			String phoneNumber = phoneNumberField.getText();
			String email = emailField.getText();
			
			//pop up alert if blanks spaces
			if (BLANK.equals(name) || BLANK.equals(address) || BLANK.equals(province) || BLANK.equals(city) || BLANK.equals(postalCode) || BLANK.equals(phoneNumber) || BLANK.equals(email)) {
				this.alert("Required input missing", "Please provide all inputs", AlertType.ERROR);
			} else {
			 StringBuilder info = new StringBuilder();
			 info.append(name).append(" ");
			 info.append(address).append(" ");
			 info.append(province).append(" ");
			 info.append(city).append(" ");
			 info.append(postalCode).append(" ");
			 info.append(phoneNumber).append(" ");
			 info.append(email).append(" ");
			 info.append("\nCourses:");
			 for (String course: coursesView.getItems()) {
					info.append("\n"+course);
			 }
			 
			 info.append("\nAdditional Info: \nStudent Council Member? " +
					 (councilCB.isSelected()?"Yes":"No") + "\nVolunteer Work? " + 
					 (volunteerCB.isSelected()?"Yes":"No"));
			 
			
			  result.setText(info.toString());
			}
			
			
		});
		
		//create a scene and place it in the stage
		Scene scene = new Scene(gridPane);
		primaryStage.setTitle("COMP 228 Lab 04");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	public void alert(String title, String message, AlertType alertType) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
