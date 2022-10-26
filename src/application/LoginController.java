package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private Label welcomeLabel;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private TextField usernameTextField;
	
	@FXML
	private TextField passwordTextField;
	
	@FXML
	private Button loginButton;
	
	public Library library;
	
	public Customer customer1;
	
	private Book book1, book2, book3, book4, book5, book6, book7, book8, book9, book10;
	
	// called by FXMLLoader to initialize the controller
	   public void initialize() {
			library = new Library("123 Main St");
			Customer customer1 = new Customer("Travis", "tlambert", 12345);
			library.addCustomer(customer1);
			book1 = new Book(1, "J.K. Rowling", "Harry Potter and the Chamber of Secrets", false);
			book2 = new Book(2, "Suzanne Collins", "The Hunger Games", true);
			book3 = new Book(3, "Harper Lee", "To Kill a Mockingbird", true);
			book4 = new Book(4, "Markus Zusak", "The Book Thief", true);
			book5 = new Book(5, "Stephenie Meyer", "Twilight", true);
			book6 = new Book(6, "George Orwell", "Animal Farm", true);
			book7 = new Book(7, "Douglas Adams", "The Hitchhiker's Guide to the Galaxy", false);
			book8 = new Book(8, "William Shakespeare", "Romeo and Juliet", true);
			book9 = new Book(9, "F. Scott Fitzgerald", "The Great Gatsby", true);
			book10 = new Book(10, "E.B. White", "Charlotte's Web", false);
			library.addBookToInventory(book1);
			library.addBookToInventory(book2);
			library.addBookToInventory(book3);
			library.addBookToInventory(book4);
			library.addBookToInventory(book5);
			library.addBookToInventory(book6);
			library.addBookToInventory(book7);
			library.addBookToInventory(book8);
			library.addBookToInventory(book9);
			library.addBookToInventory(book10);
	   }
	   
	// calculates and displays the tip and total amounts
	   @FXML
	   private void loginButtonPressed(ActionEvent event) throws IOException {
	      try {
	    	  String username = usernameTextField.getText();
	    	  int password = Integer.parseInt(passwordTextField.getText());
	    	  if (library.searchCustomer(username, password))
	  		{
	  			library.currentCustomer = library.searchCustomer1(username, password);
	  			errorLabel.setVisible(false);
	  			FXMLLoader loader = new FXMLLoader(getClass().getResource("/BookstoreScene.fxml"));
	  			Parent root = loader.load();
	  			
	  			//Get controller to next scene
	  			BookstoreSceneController bookstoreController = loader.getController();
	  			
	  			bookstoreController.getCustomerInfo(library,library.currentCustomer);
	  			
	  			Stage stage = new Stage();
	  			stage.setScene(new Scene(root));
	  			stage.setTitle("Welcome to Travis' Bookstore");
	  			stage.show();
	  			Stage previousStage = (Stage) loginButton.getScene().getWindow();
	  			previousStage.close();
	  			
	  		}
	  		else {
	  			//If username or password do not match show an error label. Only shows if both text fields 
	  			//are not empty when clicking sign in.
	  			errorLabel.setVisible(true);
	  			usernameTextField.requestFocus();
	  		}
	    	
	      }
	      catch (NumberFormatException ex) {
	         usernameTextField.selectAll();
	         usernameTextField.requestFocus();
	      }
	   }

}
