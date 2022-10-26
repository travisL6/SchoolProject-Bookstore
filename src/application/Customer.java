package application;
public class Customer {
	private String name;
	private String userName;
	private int passCode;
	private Book bookCheckedOut;
	
	
	public Customer(String name, String username, int passcode)
	{
		this.name = name;
		this.userName = username;
		this.passCode = passcode;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public int getPassCode() {
		return this.passCode;
	}
	public Book getBookCheckedOut() {
		return this.bookCheckedOut;
	}
	public void setBookCheckedOut(Book book) {
		this.bookCheckedOut = book;
	}
	
	public boolean hasBookCheckedOut() {
		if(this.bookCheckedOut != null) {
			return true;
		}
		else {
			return false;
		}
	}
}
