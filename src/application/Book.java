package application;

public class Book {
	private String author;
	private String title;
	private int bookId;
	private boolean isBookInStock;
	
	public Book(int id, String author, String title, boolean inStock)
	{
		this.bookId = id;
		this.author = author;
		this.title = title;
		this.isBookInStock = inStock;
	}
	
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	public int getBookId() {
		return bookId;
	}
	
	public void setBookInStock(boolean isInStock) {
		this.isBookInStock = isInStock;
	}
	
	public boolean getBookInStock() {
		return isBookInStock;
	}
}

