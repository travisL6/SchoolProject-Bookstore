package application;
import java.util.*;

public class Library {
	private String location;
	private ArrayList<Book> inventory;
	private ArrayList<Customer> registeredCustomers;
	public Customer currentCustomer;
	public Library(String location)
	{
		this.location = location;
		this.inventory = new ArrayList<Book>();
		this.registeredCustomers = new ArrayList<Customer>();
	}
	public String getLocation() {
		return location;
	}
	
	public ArrayList<Customer> getCustomers() {
		return registeredCustomers;
	}
	public ArrayList<Book> getInventory() {
		return inventory;
	}
	public void displayInventory() {
		System.out.println("----TRAVIS' BOOKSTORE INVENTORY, " + this.location + "----");
		System.out.println("Choose a book to checkout!");
		for(Book book : inventory)
		{
			System.out.println(book.getBookId() + ". " + book.getTitle() + " | IN STOCK: " + book.getBookInStock());
		}
	}

	public void addBookToInventory(Book book) {
		inventory.add(book);
	}
	
	public void addCustomer(Customer customer) {
		registeredCustomers.add(customer);
	}
	
	public boolean searchCustomer(String username, int password)
	{
		for(Customer customer : getCustomers())
		{
			if(username.equals(customer.getUserName()) && password == customer.getPassCode())
			{
				return true;
			}
		}
		return false;
	}
	
	public Customer searchCustomer1(String username, int password)
	{
		for(Customer customer : getCustomers())
		{
			if(username.equals(customer.getUserName()) && password == customer.getPassCode())
			{
				return customer;
			}
		}
		return null;
	}
	
	public void setBookInStock(Book book, boolean inStock)
	{
		book.setBookInStock(inStock);
	}
	public boolean isBookInStock(Book book) {
		if(inventory.contains(book))
		{
			if (book.getBookInStock() == true)
			{
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public Book getBook(int id) {
		for(Book book : getInventory())
		{
			if(book.getBookId() == id)
			{
				return book;
			}
		}
		return null;
	}

}
