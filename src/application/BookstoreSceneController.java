package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BookstoreSceneController {
	
	public Customer currentCustomer;
	
	public Library currentLibrary;
	
	@FXML
	private Label welcomeLabel;
	
	@FXML
	public Label currentBookLabel;
	
	@FXML
	public Button returnButton, logOutButton;
	
	@FXML
	private GridPane gridPane;
	
	// called by FXMLLoader to initialize the controller
	   public void initialize() {
			
	   }
	   
	   public void getCustomerInfo(Library library, Customer customer) {
		   currentLibrary = library;
		   currentCustomer = customer;
		  
		   //For each book in the library's inventory/array, create a label and button for each book inside the grid pane.
		   for(Book book : library.getInventory()) {
			   if(book.getBookInStock()) {
				   Label label = new Label();
				   label.setId("bookLabel" + book.getBookId());
				   label.setText(book.getTitle());
				   Button button = new Button();
				   button.setId("bookButton" + book.getBookId());
				   button.setText("Check Out");
				   gridPane.add(label, 0, book.getBookId());
				   gridPane.add(button, 1, book.getBookId());
				   GridPane.setHalignment(label, HPos.CENTER);
				   GridPane.setHalignment(button, HPos.CENTER);
				   button.setDisable(false);
				   
				   //creating action for when user clicks check out on book. 
				   //Makes sure the user doesn't already have a book checked out
				   //Then disables the button and gives the book to the user
				   button.setOnAction(e -> {
					   if(currentCustomer.hasBookCheckedOut()) {
						   Alert alert = new Alert(AlertType.ERROR);
						   alert.setTitle("Error!");
						   alert.setHeaderText("Already have a book checked out!");
						   alert.setContentText("You must return the book you have checked out first before checking another book out!");
						   alert.showAndWait();
					   }
					   else {
						   String id = button.getId();
						   //set book to customers possession
						   currentCustomer.setBookCheckedOut(library.getBook(Integer.parseInt(id.substring(id.length() - 1))));
						   
						   //set book to out of stock
						   library.setBookInStock(library.getBook(Integer.parseInt(id.substring(id.length() - 1))), false);
						   
						   //Disable button to show that it is out of stock.
						   button.setDisable(true);
						   currentBookLabel.setText("Current Book Checked Out: " + currentCustomer.getBookCheckedOut().getTitle());
						   
						   //enable return button for user to be able to return button.
						   returnButton.setDisable(false);
					   }
				   });
			   }
			   else {
				   Label label = new Label();
				   label.setId("bookLabel" + book.getBookId());
				   label.setText(book.getTitle());
				   Button button = new Button();
				   button.setId("bookButton" + book.getBookId());
				   button.setText("Check Out");
				   gridPane.add(label,0,book.getBookId());
				   gridPane.add(button, 1, book.getBookId());
				   GridPane.setHalignment(label, HPos.CENTER);
				   GridPane.setHalignment(button, HPos.CENTER);
				   button.setDisable(true);
			   }
		   }
		   //button for user to return their book
		   //searches for buttons inside gridPane and finds the corresponding buttonID 
		   //that matches with bookID and enables the button again as it is back in stock
		   returnButton.setOnAction(e -> {
			   for(Node button : gridPane.getChildren()) {
				   if(Integer.parseInt(button.getId().substring(button.getId().length() - 1)) 
						   == currentLibrary.currentCustomer.getBookCheckedOut().getBookId()) {
					   
					   button.setDisable(false);
				   }
			   }
			   currentLibrary.currentCustomer.getBookCheckedOut().setBookInStock(true);
			   currentLibrary.currentCustomer.setBookCheckedOut(null);
			   returnButton.setDisable(true);
			   currentBookLabel.setText("Current Book Checked Out: None");
			   
		   });
		   
		   logOutButton.setOnAction(e -> {
			   	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
	  			Parent root;
				try {
					root = loader.load();
					//Get controller to next scene
		  			LoginController loginController = loader.getController();
		  			
		  			Stage stage = new Stage();
		  			stage.setScene(new Scene(root));
		  			stage.setTitle("Welcome to Travis' Bookstore");
		  			stage.show();
		  			Stage previousStage = (Stage) logOutButton.getScene().getWindow();
		  			previousStage.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	  			
	  			
		   });
		   welcomeLabel.setText("Welcome " + currentCustomer.getName());
		   if(currentCustomer.hasBookCheckedOut()) {
			   currentBookLabel.setText("Current Book Checked Out: " + currentCustomer.getBookCheckedOut().getTitle());
			   returnButton.setDisable(false);
		   }
		   else {
			   currentBookLabel.setText("Current Book Checked Out: None");
			   returnButton.setDisable(true);
		   }
		   
	   }

}
