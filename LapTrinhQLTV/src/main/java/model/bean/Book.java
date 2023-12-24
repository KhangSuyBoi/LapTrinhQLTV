package model.bean;

public class Book {
	private String idBook;
	private String nameBook;
	private String image;
	private String amount;
	private Category Category;
	private Authors Authors;
	private BookShelf BookShelf;
	private String day;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String idBook, String nameBook, String image, String amount, model.bean.Category category,
			model.bean.Authors authors, model.bean.BookShelf bookShelf, String day) {
		super();
		this.idBook = idBook;
		this.nameBook = nameBook;
		this.image = image;
		this.amount = amount;
		Category = category;
		Authors = authors;
		BookShelf = bookShelf;
		this.day = day;
	}
	
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}
	public String getNameBook() {
		return nameBook;
	}
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Category getCategory() {
		return Category;
	}
	public void setCategory(Category category) {
		Category = category;
	}
	public Authors getAuthors() {
		return Authors;
	}
	public void setAuthors(Authors authors) {
		Authors = authors;
	}
	public BookShelf getBookShelf() {
		return BookShelf;
	}
	public void setBookShelf(BookShelf bookShelf) {
		BookShelf = bookShelf;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
}
