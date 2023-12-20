package exercise01;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main extends Application {
	
	private static final String JDBC_URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
    private static final String USERNAME = "COMP228_F23_sy_5";
    private static final String PASSWORD = "password";
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
			
		//text fields and its labels for Player Information data
		Label playerInformationLabel = new Label("Player Information: ");
		playerInformationLabel.setStyle("-fx-font-weight: bold;");
		gridPane.add(playerInformationLabel, 0, 0);
				
		Label firstNameLabel = new Label("First Name: ");
		gridPane.add(firstNameLabel, 0, 1);
		TextField firstNameField = new TextField();
		gridPane.add(firstNameField, 1, 1);
			
		Label lastNameLabel = new Label("Last Name: ");
		gridPane.add(lastNameLabel, 0, 2);
		TextField lastNameField = new TextField();
		gridPane.add(lastNameField, 1, 2);
						
		Label addressLabel = new Label("Address: ");
		gridPane.add(addressLabel, 0, 3);
		TextField addressField = new TextField();
		gridPane.add(addressField, 1, 3);
				
		Label provinceLabel = new Label("Province: ");
		gridPane.add(provinceLabel, 0, 4);
		TextField provinceField = new TextField();
		gridPane.add(provinceField, 1, 4);
				
		Label postCodeLabel = new Label("Post Code: ");
		gridPane.add(postCodeLabel, 0, 5);
		TextField postCodeField = new TextField();
		gridPane.add(postCodeField, 1, 5);
				
		Label phoneLabel = new Label("Phone Number: ");
		gridPane.add(phoneLabel, 0, 6);
		TextField phoneField = new TextField();
		gridPane.add(phoneField, 1, 6);
			
		//text fields and its labels for Player Update by ID
		Label playerIdLabel = new Label("Update Player by ID: ");
		playerIdLabel.setStyle("-fx-font-weight: bold;");
		gridPane.add(playerIdLabel, 3, 1);
		TextField playerIdField = new TextField();
		gridPane.add(playerIdField, 4, 1);
				
		//text fields and its labels for Display Player by ID
		Label displayPlayerIdLabel = new Label("Display Player by ID: ");
		displayPlayerIdLabel.setStyle("-fx-font-weight: bold;");
		gridPane.add(displayPlayerIdLabel, 3, 2);
		TextField displayPlayerIdField = new TextField();
		gridPane.add(displayPlayerIdField, 4, 2);
				
		//text fields and its labels for Game Information
		Label gameInformationLabel = new Label("Game Information: ");
		gameInformationLabel.setStyle("-fx-font-weight: bold;");
		gridPane.add(gameInformationLabel, 3, 3);
				
		Label gameTitleLabel = new Label("Game Title: ");
		gridPane.add(gameTitleLabel, 3, 4);
		TextField gameTitleField = new TextField();
		gridPane.add(gameTitleField, 4, 4);
		Label gameScoreLabel = new Label("Game Score: ");
		gridPane.add(gameScoreLabel, 3,5 );
		TextField gameScoreField = new TextField();
		gridPane.add(gameScoreField, 4, 5);
				
		Label datePlayedLabel = new Label("Date Played: ");
		gridPane.add(datePlayedLabel, 3,6 );
		TextField datePlayedField = new TextField();
		gridPane.add(datePlayedField, 4, 6);
				
		//buttons
		
		//UPDATE
		Button updatePlayerIdButton = new Button ("Update");
		updatePlayerIdButton.setOnAction(e -> {
		int playerId = Integer.parseInt(playerIdField.getText());
		String firstName = firstNameField.getText();
		String lastName = lastNameField.getText();
		String address = addressField.getText();
		String postCode = postCodeField.getText();
		String province = provinceField.getText();
		String phone = phoneField.getText();
					
			try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
				    	
				if (!firstName.isBlank()) {
					PlayerDAO.updateFirstName(connection, firstName, playerId);
				} else { System.out.println("Do Not Update Blank Field");}
			
				if (!lastName.isBlank()) {
					PlayerDAO.updateLastName(connection, lastName, playerId);
				} else { System.out.println("Do Not Update Blank Field");}
			
				if (!address.isBlank()) {
					PlayerDAO.updateAddress(connection, address, playerId);
				} else { System.out.println("Do Not Update Blank Field");}
			
				if (!firstName.isBlank()) {
					PlayerDAO.updatePostCode(connection, postCode, playerId);	    	
				} else { System.out.println("Do Not Update Blank Field");}
			
				if (!province.isBlank()) {
					PlayerDAO.updateProvince(connection, province, playerId);
				} else { System.out.println("Do Not Update Blank Field");}
			
				if (!province.isBlank()) {
					PlayerDAO.updatePhone(connection, phone, playerId);
				} else { System.out.println("Do Not Update Blank Field");}
			
				this.alert("PLAYER AND GAME APPLICATION", "Data Updated!", AlertType.INFORMATION);
            
				firstNameField.setText("");
				lastNameField.setText("");
				addressField.setText("");
				postCodeField.setText("");
				provinceField.setText("");
				phoneField.setText("");
				gameTitleField.setText("");
				datePlayedField.setText("");
				gameScoreField.setText("");
				displayPlayerIdField.setText("");
				playerIdField.setText("");
		    
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});			
		gridPane.add(updatePlayerIdButton, 5, 1);
		
		//DISPLAY BY ID
		Button displayPlayerIdButton = new Button ("Display");
		displayPlayerIdButton.setOnAction(e -> {
			int playerId = Integer.parseInt(displayPlayerIdField.getText());
					
			try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
				List<String[]> PlayerAndGameDataById = PlayerAndGameDAO.getPlayersAndGamesById(connection, playerId);

				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"ID", "NAME", "ADDRESS", "POSTAL CODE", "PROVINCE", "PHONE NUMBER", "GAME TITLE", "DATE PLAYED", "SCORE"});
				        				        
					for (String[] combinedRow : PlayerAndGameDataById) {
				            model.addRow(combinedRow);
				    }
				            
				JTable jTable = new JTable(model);
				JScrollPane scrollPane = new JScrollPane(jTable);

				JFrame frame = new JFrame("Table Display");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				frame.add(scrollPane, BorderLayout.CENTER);
				frame.setSize(800, 600);
				frame.setVisible(true);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}		
		});
		gridPane.add(displayPlayerIdButton, 5, 2);
				
		//CREATE
		Button createButton = new Button ("Create Player");
		createButton.setOnAction(e -> {
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String address = addressField.getText();
			String postCode = postCodeField.getText();
			String province = provinceField.getText();
			String phone = phoneField.getText();
			String gameTitle = gameTitleField.getText();
			String datePlayed = datePlayedField.getText();
			String gameScore = gameScoreField.getText();
						
			if (BLANK.equals(firstName) || BLANK.equals(lastName) || BLANK.equals(address) ||
					BLANK.equals(postCode) || BLANK.equals(province) || BLANK.equals(phone) ||
					BLANK.equals(gameTitle) || BLANK.equals(datePlayed) || BLANK.equals(gameScore)) {
					    	this.alert("PLAYER AND GAME APPLICATION", "Please, fill in all fields", AlertType.ERROR);
			} else {
				// Connecting to database
				try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
					//Creating an instance of PlayerDAO
					PlayerDAO p1 = new PlayerDAO();
								
					//Calling createPlayer method from PlayerDAO class to
					//insert data into table Player 
					p1.createPlayer(connection, firstName, lastName, address, postCode, province, phone);
				                
					//Getting playerId
					int playerId = p1.getPlayerId(connection);
								
					//Creating an instance of GameDAO
					GameDAO g1 = new GameDAO();
				                
					//Verify if game title exists: calling method form GameDAO class
					int gameId = g1.getGameId(connection, gameTitle);
				                
					if (gameId == 0) {
						gameId = g1.insertGame(connection, gameTitle);
				    }
				                
					//Creating an instance of PlayerAndGameDAO
					PlayerAndGameDAO pg1 = new PlayerAndGameDAO();
					//Calling createPlayerAndGame method from PlayerAndGameDAO class
					pg1.createPlayerAndGame(connection, gameId, playerId, datePlayed, gameScore);
				                
					this.alert("PLAYER AND GAME APPLICATION", "Data Inserted!", AlertType.INFORMATION);
				                
					firstNameField.setText("");
					lastNameField.setText("");
					addressField.setText("");
					postCodeField.setText("");
					provinceField.setText("");
					phoneField.setText("");
					gameTitleField.setText("");
					datePlayedField.setText("");
					gameScoreField.setText("");
				                
				                
				} catch (SQLException ex) {
					ex.printStackTrace();
				}				
			}
					    
			
		});
		gridPane.add(createButton, 4, 7);
				
		Button displayButton = new Button ("Display All Players");
		displayButton.setOnAction(e -> {
			try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
				List<String[]> allPlayerAndGameData = PlayerAndGameDAO.getAllPlayersAndGames(connection);

				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[]{"ID", "NAME", "ADDRESS", "POSTAL CODE", "PROVINCE", "PHONE NUMBER", "GAME TITLE", "DATE PLAYED", "SCORE"});
				
				model.setRowCount(0);
				
				for (String[] combinedRow : allPlayerAndGameData) {
					model.addRow(combinedRow);
				}
				            
					
				JTable jTable = new JTable(model);
				JScrollPane scrollPane = new JScrollPane(jTable);

				JFrame frame = new JFrame("Table Display");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				frame.add(scrollPane, BorderLayout.CENTER);
				frame.setSize(800, 600);
				frame.setVisible(true);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		gridPane.add(displayButton, 5, 7);		
				
		//create a scene and place the gridePane in the stage
		Scene scene = new Scene(gridPane);
				
		primaryStage.setTitle("COMP 228 Lab 05");
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
		launch(args);
	}
}
